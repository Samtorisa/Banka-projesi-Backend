package com.samtorisa.bankB.request;

import com.samtorisa.bankB.entity.Account;
import com.samtorisa.bankB.entity.Customer;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionHistoryCreate {
 Long transactionAmount;
 String transactionType;
 Date dateTransaction;
 Long accountId;





}
