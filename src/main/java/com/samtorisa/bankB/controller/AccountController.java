package com.samtorisa.bankB.controller;

import com.samtorisa.bankB.constant.ACTION;
import com.samtorisa.bankB.entity.Account;
import com.samtorisa.bankB.entity.Customer;
import com.samtorisa.bankB.request.AccountPorccesRequest;
import com.samtorisa.bankB.request.CreateAccountRequest;
import com.samtorisa.bankB.response.AccountResponse;
import com.samtorisa.bankB.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> getAccountByCustomerId(@RequestParam Optional<Long> customerId){
        return
                accountService.getAccountByCustomerId(customerId);
    }
    @GetMapping("/{accountId}")
    public Account getOneAccount(@PathVariable Long accountId){
        return accountService.getOneAccount(accountId);
    }

    @PostMapping
    public Account createOneAccount(@RequestBody CreateAccountRequest account){
        return accountService.createOneAccount(account);
    }




    @PutMapping(value = "/withdraw/{accountId}",  consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public Account withdraw(@Validated @RequestBody AccountPorccesRequest request, @PathVariable Long accountId){

        return accountService.updateAccount(accountId,request, ACTION.WITHDRAW);
    }


    @PutMapping(value = "/deposit/{accountId}",  consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Account deposit(@Validated @RequestBody AccountPorccesRequest request,@PathVariable Long accountId){
        return accountService.updateAccount(accountId,request,ACTION.DEPOSIT);

    }
    @DeleteMapping("/accountId")
    public void delete(Long accountId){
        accountService.deleteAccountById(accountId);
    }

}
