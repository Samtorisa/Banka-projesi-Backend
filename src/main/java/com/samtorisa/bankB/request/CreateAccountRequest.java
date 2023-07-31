package com.samtorisa.bankB.request;

import lombok.Data;

@Data
public class CreateAccountRequest {

    String name;
    Long balance;
    Long customerId;

}
