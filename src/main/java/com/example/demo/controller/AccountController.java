package com.example.demo.controller;

import com.example.demo.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AccountController {

    @PostMapping("/saveAccount")
    public Object printAccount(@RequestBody @Valid Account account){
        System.out.println(account.toString());
        return "牛逼";
    }

    @GetMapping("/getHello")
    public String printHello(){
        return "Hello world!";
    }

    @GetMapping("/haha")
    public Object printAccount(){
        System.out.println("haha");
        return "haha";
    }
}
