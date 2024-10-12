package com.qin.service;

import com.qin.entity.Stock;
import com.qin.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock reduceStock(Integer goodsId, Integer count) {
        Stock stock = stockRepository.findStockByGoodsId(goodsId);
        if(stock == null || stock.getTotal() < count){
            return null;
        }
        stock.setTotal(stock.getTotal() - count);
        stockRepository.save(stock);
        return stock;
    }
}
