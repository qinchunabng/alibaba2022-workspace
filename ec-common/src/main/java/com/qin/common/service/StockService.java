package com.qin.common.service;


import com.qin.common.entity.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ec-stock")
public interface StockService {

    @PutMapping("/stock/reduce")
    Stock reduceStock(@RequestParam("goodsId") Integer goodsId, @RequestParam("count") Integer count);
}
