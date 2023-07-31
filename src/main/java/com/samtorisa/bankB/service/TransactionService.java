package com.samtorisa.bankB.service;

import com.samtorisa.bankB.entity.Account;
import com.samtorisa.bankB.entity.TransactionHistory;
import com.samtorisa.bankB.repository.AccountRepository;
import com.samtorisa.bankB.repository.CustomerRepository;
import com.samtorisa.bankB.repository.TransactionHistoryRepository;
import com.samtorisa.bankB.request.TransactionHistoryCreate;
import com.samtorisa.bankB.response.TransactionResponse;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private TransactionHistoryRepository transactionRepo;

    private AccountService accountService;
    private CustomerService customerService;

    public TransactionService(TransactionHistoryRepository transactionRepo, AccountService accountService, CustomerService customerService) {
        this.transactionRepo = transactionRepo;
        this.accountService = accountService;
        this.customerService = customerService;
    }

    public List<TransactionResponse> getAllTransaction( Optional<Long> accountId) {
        List<TransactionHistory> list;
        if(accountId.isPresent()){
            list =transactionRepo.findTop5ByAccountIdOrderByDateTransactionDesc(accountId.get());
        }else{
            list=transactionRepo.findAll();
        }
        return list.stream().map(trans->new TransactionResponse(trans)).collect(Collectors.toList());


    }

    public TransactionHistory createTransactionHistory(TransactionHistoryCreate transactionCreate) {
        Account account=accountService.getOneAccount(transactionCreate.getAccountId());
        if(account !=null){
            TransactionHistory transaction=new TransactionHistory();
            transaction.setDateTransaction(transactionCreate.getDateTransaction());
            transaction.setTransactionAmount(transactionCreate.getTransactionAmount());
            transaction.setTransactionType(transactionCreate.getTransactionType());
            transaction.setAccount(account);
            return transactionRepo.save(transaction);
        }
        return null;
    }
}
