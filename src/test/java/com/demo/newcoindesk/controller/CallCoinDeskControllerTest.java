package com.demo.newcoindesk.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CallCoinDeskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void callCoinDesk() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/callCoinDesk");

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        System.out.println(" Result : "+body);
    }

    @Test
    void getNewCoinDesk() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getNewCoinDesk");

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        System.out.println(" Result : "+body);
    }
}