package com.qin.service;

import com.qin.entity.GoodsOrder;
import com.qin.repository.GoodsOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsOrderOrderServiceImpl implements GoodsOrderService {

    @Autowired
    private GoodsOrderRepository goodsOrderRepository;


    @Override
    public GoodsOrder createGoodsOrder(GoodsOrder goodsOrder) {
        return goodsOrderRepository.save(goodsOrder);
    }
}
