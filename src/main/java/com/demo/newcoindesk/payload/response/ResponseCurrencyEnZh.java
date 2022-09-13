package com.demo.newcoindesk.payload.response;

import com.demo.newcoindesk.payload.request.RequestCurrencyEnZh;
import lombok.RequiredArgsConstructor;


public class ResponseCurrencyEnZh extends RequestCurrencyEnZh {
    public ResponseCurrencyEnZh(String uuid, String code, String codeZh) {
        super(uuid, code, codeZh);
    }
}
