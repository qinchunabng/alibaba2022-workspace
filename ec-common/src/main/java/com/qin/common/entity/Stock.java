package com.qin.common.entity;

import lombok.Data;

@Data
public class Stock {

    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 库存量
     */
    private Integer total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
