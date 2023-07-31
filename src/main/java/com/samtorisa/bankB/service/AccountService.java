package com.samtorisa.bankB.service;

import com.samtorisa.bankB.constant.ACTION;
import com.samtorisa.bankB.entity.Account;
import com.samtorisa.bankB.entity.Customer;
import com.samtorisa.bankB.repository.AccountRepository;
import com.samtorisa.bankB.request.AccountPorccesRequest;
import com.samtorisa.bankB.request.CreateAccountRequest;
import com.samtorisa.bankB.response.AccountResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AccountService {

    private AccountRepository accountRepository;

    private CustomerService customerService;

    public AccountService(AccountRepository accountRepository,CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService=customerService;
    }

    public List<AccountResponse> getAccountByCustomerId(Optional<Long> customerId) {
        List <Account> list;
        if(customerId.isPresent()){

            list=accountRepository.findByCustomerId(customerId.get());


        }else {
            list =accountRepository.findAll();

        }
            return list.stream().map(accounts->new AccountResponse(accounts)).collect(Collectors.toList());


    }

    public void deleteAccountById(Long accountId) {
     accountRepository.deleteById(accountId);
    }

    public Account updateAccount(Long accountId,AccountPorccesRequest request, ACTION action) {
 Account account=new Account();


        Optional<Account> accnt =accountRepository.findById(accountId);
        if(accnt.isPresent() && request.getAmount() !=null
        ){
            Account toUpdate= accnt.get();
            if (action == ACTION.WITHDRAW) {

                toUpdate.setBalance((accnt.get().getBalance()) - request.getAmount());
            } else if (action == ACTION.DEPOSIT) {
                toUpdate.setBalance((accnt.get().getBalance()) + request.getAmount());
            }
            return accountRepository.save(toUpdate);
        } else return null;



    }


    public Account getOneAccount(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public Account createOneAccount(CreateAccountRequest request) {
        Customer customer=customerService.getOneUser(request.getCustomerId());
        if(customer==null){
            return  null;
        }
        Account accountSave=new Account();
        accountSave.setBalance(request.getBalance());
        accountSave.setName(request.getName());
        accountSave.setCustomer(customer);
        return accountRepository.save(accountSave);

    }
}
