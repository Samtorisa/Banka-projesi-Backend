package com.samtorisa.bankB.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Entity
@Table(name ="transaction")
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(nullable = false)
    Long transactionAmount;
    String transactionType;
    Date dateTransaction;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Account account;



}
