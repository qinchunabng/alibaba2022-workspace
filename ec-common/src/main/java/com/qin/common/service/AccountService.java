package com.qin.common.service;


import com.qin.common.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ec-account")
public interface AccountService {

    @PutMapping("/account/debit")
    Account debitAccount(@RequestParam("userId") Integer userId, @RequestParam("amount") Double amount);
}
