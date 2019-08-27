package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.utils.ValidationUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.ValidationUtils;

import java.awt.*;
import java.io.IOException;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTests {

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new AccountController()).build();
    }

    @Test
    public void saveAccountTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/getHello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello world!")));
    }

    @Test
    public void test1() throws IOException {
        Account account = new Account();
        account.setAlias("aasdf");
        //account.setUserName("asdf");
        //account.setPassWord("密码");
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(account);
        if (validResult.hasErrors()){
            String errors = validResult.getErrors();
            System.out.println(errors);
        }

    }

}


