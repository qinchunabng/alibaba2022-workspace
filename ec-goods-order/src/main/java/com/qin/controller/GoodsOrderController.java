package com.qin.controller;

import com.qin.common.entity.Account;
import com.qin.common.service.AccountService;
import com.qin.entity.GoodsOrder;
import com.qin.service.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/goodsOrder")
@RestController
public class GoodsOrderController {

    @Autowired
    private GoodsOrderService goodsService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public GoodsOrder reduceHandle(@RequestBody GoodsOrder goodsOrder){
        //根据userId查询其账户余额，判断是否满足本次购买
        //计算总消费额
        double total = goodsOrder.getGoodsPrice() * goodsOrder.getCount();
        Account account = accountService.debitAccount(goodsOrder.getUserId(), total);
        if(account == null){
            //账户余额不足返回null
            return null;
        }
        return goodsService.createGoodsOrder(goodsOrder);
    }
}
