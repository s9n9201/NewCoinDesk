package com.demo.newcoindesk.service;

import com.demo.newcoindesk.entity.CoinDesk;
import com.demo.newcoindesk.payload.response.ResponseCoinDesk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public interface CallCoinDeskService {
    ResponseCoinDesk formatData(CoinDesk coinDesk) throws InvocationTargetException, IllegalAccessException, IOException, ParseException;
}
