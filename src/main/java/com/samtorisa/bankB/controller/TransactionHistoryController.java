package com.samtorisa.bankB.controller;

import com.samtorisa.bankB.entity.TransactionHistory;
import com.samtorisa.bankB.request.TransactionHistoryCreate;
import com.samtorisa.bankB.response.TransactionResponse;
import com.samtorisa.bankB.service.TransactionService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transactions")
public class TransactionHistoryController {

    private TransactionService transactionService;

    public TransactionHistoryController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionResponse> getAllTransaction(
                                                       @RequestParam Optional<Long> accountId){
        return transactionService.getAllTransaction(accountId);
    }

    @PostMapping
    public TransactionHistory createTransactionHistory(@RequestBody TransactionHistoryCreate transactionCreate){
        return transactionService.createTransactionHistory(transactionCreate);

    }

   /* @PostMapping("/{accountId}")
    public TransactionHistory createTransactionHistoryByAccountId(@PathVariable Long accountId,@RequestBody TransactionHistoryCreate transactionCreate)
    return transactionService.createTransactionHistoryByAccountId(accountId,)
*/
}
