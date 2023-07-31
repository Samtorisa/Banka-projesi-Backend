package com.samtorisa.bankB.controller;

import com.samtorisa.bankB.entity.Customer;
import com.samtorisa.bankB.request.CustomerRequest;
import com.samtorisa.bankB.response.AuthResponse;
import com.samtorisa.bankB.service.CustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {



    private CustomerService customerService;

    private PasswordEncoder passwordEncoder;

    public AuthController(
                          CustomerService customerService, PasswordEncoder passwordEncoder) {

        this.customerService = customerService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody CustomerRequest loginRequest){
        Customer existingCustomer = customerService.getOneCustomerByMail(loginRequest.getMail());
        if(existingCustomer ==null || !existingCustomer.getPassword().equals(loginRequest.getPassword())){
            return null;
        }

        AuthResponse authResponse=new AuthResponse();
        authResponse.setCustomerId(existingCustomer.getId());
        return  authResponse;
    }
    @PostMapping("/register")
    public ResponseEntity<CustomerRequest> register(@RequestBody CustomerRequest registerRequest){
        //Customer existingCustomer = customerService.getOneCustomerByMail(registerRequest.getMail());
        if(customerService.getOneCustomerByMail(registerRequest.getMail())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        customerService.createOneCustomer(registerRequest);

        return new ResponseEntity<>(registerRequest,HttpStatus.CREATED);
    }


}

/*
* UsernamePasswordAuthenticationToken authToken  = new UsernamePasswordAuthenticationToken(
                loginRequest.getMail(), loginRequest.getPassword());
        Customer customer =customerService.getOneCustomerByMail(loginRequest.getMail());
        Authentication auth =authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken =jwtTokenProvider.generateJwtToken(auth);
        AuthResponse authResponse=new AuthResponse();
        authResponse.setMessage("Bearer " + jwtToken);
        authResponse.setCustomerId(customer.getId());*/


/*
*    AuthResponse authResponse=new AuthResponse();

        if(customerService.getOneCustomerByMail(registerRequest.getMail()) !=null){
                    authResponse.setMessage("email already exist ");
            return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);

        }
        Customer customer =new Customer();
        customer.setMail(registerRequest.getMail());
        customer.setPassword(registerRequest.getPassword());
        customerService.createOneCustomer(customer);

        authResponse.setMessage("customer succsesfully registered");


        return new ResponseEntity<>(authResponse,HttpStatus.CREATED);
*
* */