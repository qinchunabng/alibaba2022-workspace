package com.qin.repository;

import com.qin.entity.GoodsOrder;
import org.springframework.data.repository.CrudRepository;

public interface GoodsOrderRepository extends CrudRepository<GoodsOrder, Integer> {

    GoodsOrder findAccountByUserId(Integer userId);
}
