package com.qin.controller;

import com.qin.entity.Stock;
import com.qin.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stock")
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @PutMapping("/reduce")
    public Stock reduceHandle(@RequestParam Integer goodsId,
                              @RequestParam Integer count){
        return stockService.reduceStock(goodsId, count);
    }
}
