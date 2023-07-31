package com.samtorisa.bankB.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name ="customer")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String mail;
    String password;



}
