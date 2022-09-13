package com.demo.newcoindesk.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseCoinDesk {
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private LocalDateTime lastUpdateTime;
    private List<CoinInfo> coinInfoList;
}
