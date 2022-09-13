package com.demo.newcoindesk.controller;

import com.demo.newcoindesk.payload.request.RequestCurrencyEnZh;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyEnZhControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void insert() throws Exception {
        RequestCurrencyEnZh requestCurrencyEnZh = new RequestCurrencyEnZh(null, "VND", "越南盾");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestCurrencyEnZh.toString());

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201));
    }

    @Test
    void update() throws Exception {
        RequestCurrencyEnZh requestCurrencyEnZh = new RequestCurrencyEnZh("5a8be1ad-3a1d-493b-95b3-5dfb20bcb56e", "TWD", "新台幣");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestCurrencyEnZh.toString());

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        System.out.println("Result : "+body);
    }

    @Test
    void getCurrencyEnZhList() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getlist");

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("[0].code", equalTo("EUR")))
                .andExpect(jsonPath("[0].codeZh", equalTo("歐元")))
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        System.out.println("Result : "+body);
    }

    @Test
    void delete() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/delete/{uuid}", "48f8738e-5af3-40c2-8603-44828eea5495");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(204));
    }
}