package com.qin.common.service;


import com.qin.common.entity.GoodsOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "ec-goods-order")
public interface GoodsOrderService {

    @PostMapping("/goodsOrder/create")
    GoodsOrder createGoodsOrder(@RequestBody GoodsOrder goodsOrder);
}
