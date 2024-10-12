package com.qin.service;

import com.qin.entity.Account;
import com.qin.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account debitAccount(Integer userId, Double amount) {
        Account account = accountRepository.findAccountByUserId(userId);
        if(account == null || account.getBalance() < amount){
            return null;
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
        return account;
    }
}
