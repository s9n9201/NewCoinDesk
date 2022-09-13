package com.demo.newcoindesk.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoinInfo {
    private String code;
    private String codeZh;
    private Float rate;
}
