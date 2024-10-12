package com.qin.repository;

import com.qin.entity.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Integer> {

    Stock findStockByGoodsId(Integer goodsId);
}
