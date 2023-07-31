package com.samtorisa.bankB.response;

import com.samtorisa.bankB.entity.Account;
import lombok.Data;

@Data
public class AccountResponse {
    Long id;
    String name;
    Long balance;

    public AccountResponse(Account entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.balance=entity.getBalance();

    }
}
