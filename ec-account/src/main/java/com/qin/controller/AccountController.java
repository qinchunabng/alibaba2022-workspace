package com.qin.controller;

import com.qin.entity.Account;
import com.qin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping("/debit")
    public Account reduceHandle(@RequestParam Integer userId,
                                @RequestParam Double amount){
        return accountService.debitAccount(userId, amount);
    }
}
