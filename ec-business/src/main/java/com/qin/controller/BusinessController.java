package com.qin.controller;

import com.qin.common.entity.GoodsOrder;
import com.qin.common.entity.Stock;
import com.qin.common.service.GoodsOrderService;
import com.qin.common.service.StockService;
import io.seata.spring.annotation.GlobalTransactional;
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
}
