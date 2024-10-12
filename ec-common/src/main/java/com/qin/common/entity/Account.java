package com.qin.common.entity;

import lombok.Data;

@Data
public class Account {

    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 账户余额
     */
    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
