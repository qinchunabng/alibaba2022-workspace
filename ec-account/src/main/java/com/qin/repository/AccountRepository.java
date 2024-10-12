package com.qin.repository;

import com.qin.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findAccountByUserId(Integer userId);
}
