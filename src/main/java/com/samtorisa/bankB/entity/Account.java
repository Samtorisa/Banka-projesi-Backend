package com.samtorisa.bankB.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name ="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Customer customer;

    Long balance;






}
