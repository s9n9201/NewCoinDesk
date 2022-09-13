package com.demo.newcoindesk.payload.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class RequestCurrencyEnZh {
    private String uuid;
    private String code;
    private String codeZh;

    @Override
    public String toString() {
        return "{ "
                +"\"uuid\" : \""+this.uuid+"\", "
                +"\"code\" : \""+this.code+"\", "
                +"\"codeZh\" : \""+this.codeZh+"\" "
                +"} ";
    }
}
