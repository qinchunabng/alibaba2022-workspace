package com.qin.service;

import com.qin.entity.Account;

public interface AccountService {
    Account debitAccount(Integer userId, Double amount);
}
