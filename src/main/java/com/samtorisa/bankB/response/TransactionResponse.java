package com.samtorisa.bankB.response;

import com.samtorisa.bankB.entity.TransactionHistory;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionResponse {
    Long id;
    Long transactionAmount;
    String transactionType;
    Date dateTransaction;
    Long accountId;
    public TransactionResponse(TransactionHistory entity){

        this.id=entity.getId();
        this.transactionAmount=entity.getTransactionAmount();
        this.transactionType=entity.getTransactionType();
        this.dateTransaction= entity.getDateTransaction();
        this.accountId=entity.getAccount().getId();
    }

}
