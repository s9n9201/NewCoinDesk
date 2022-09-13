package com.demo.newcoindesk.service;

import com.demo.newcoindesk.payload.request.RequestCurrencyEnZh;
import com.demo.newcoindesk.payload.response.ResponseCurrencyEnZh;

import java.util.List;

public interface CurrencyEnZhService {

    Integer insert(RequestCurrencyEnZh requestCurrencyEnZh);

    ResponseCurrencyEnZh update(RequestCurrencyEnZh requestCurrencyEnZh);

    List<ResponseCurrencyEnZh> getCurrencyEnZhList();

    void delete(String uuid);
}
