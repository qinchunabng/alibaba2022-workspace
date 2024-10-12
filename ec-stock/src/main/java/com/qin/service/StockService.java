package com.qin.service;

import com.qin.entity.Stock;

public interface StockService {
    Stock reduceStock(Integer goodsId, Integer count);
}
