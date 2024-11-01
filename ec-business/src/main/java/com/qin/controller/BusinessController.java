package com.qin.controller;

import com.qin.common.entity.GoodsOrder;
import com.qin.common.entity.Stock;
import com.qin.common.service.GoodsOrderService;
import com.qin.common.service.StockService;
import com.qin.service.BusinessLocalService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/business")
@RestController
public class BusinessController {

    @Autowired
    private GoodsOrderService goodsService;

    @Autowired
    private StockService stockService;

    @GlobalTransactional
    @PostMapping("/purchase")
    public String reduceHandle(@RequestBody GoodsOrder goodsOrder){
        String traceId = TraceContext.traceId();
        System.out.println("traceId ======> " + traceId);
        long businessTime = System.currentTimeMillis();
        System.out.println("businessTime ====> " + businessTime);
        TraceContext.putCorrelation("businessTime", String.valueOf(businessTime));

        new BusinessLocalService().info();
        //扣减库存
        Stock stock = stockService.reduceStock(goodsOrder.getGoodsId(), goodsOrder.getCount());
        if(stock == null){
            return "库存不足下单失败";
        }

        //生成订单
        GoodsOrder order = goodsService.createGoodsOrder(goodsOrder);
        if(order == null){
            return "余额不足，下单失败";
        }
        return "下单成功";
    }

    @PostMapping("/alarm")
    public String alarmHandle(@RequestBody Object alarmMsg){
        System.out.println("alarm message: " + alarmMsg);
        return "ok";
    }
}
