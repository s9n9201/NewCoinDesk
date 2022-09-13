package com.demo.newcoindesk.service.impl;

import com.demo.newcoindesk.entity.CoinDesk;
import com.demo.newcoindesk.entity.dollar.Dollar;
import com.demo.newcoindesk.payload.response.CoinInfo;
import com.demo.newcoindesk.payload.response.ResponseCoinDesk;
import com.demo.newcoindesk.payload.response.ResponseCurrencyEnZh;
import com.demo.newcoindesk.service.CallCoinDeskService;
import com.demo.newcoindesk.service.CurrencyEnZhService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class CallCoinDeskServiceImpl implements CallCoinDeskService {

    private final CurrencyEnZhService currencyEnZhService;
    @Override
    public ResponseCoinDesk formatData(CoinDesk coinDesk) {
        try {
            LocalDateTime lastUpdateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Taipei"));
            ObjectMapper objMap = new ObjectMapper();
            List<CoinInfo> coinInfos = new ArrayList<>();
            List<ResponseCurrencyEnZh> responseCurrencyEnZhList = currencyEnZhService.getCurrencyEnZhList();
            if (responseCurrencyEnZhList.size() > 0 && coinDesk != null) {

                String bpiStr = objMap.writeValueAsString(coinDesk.getBpi());
                Map<String, Dollar> dollarMap = objMap.readValue(bpiStr, new TypeReference<HashMap<String, Dollar>>() {});

                for (ResponseCurrencyEnZh responseCurrencyEnZh : responseCurrencyEnZhList) {
                    String code=responseCurrencyEnZh.getCode();
                    String codeZh=responseCurrencyEnZh.getCodeZh();
                    if (dollarMap.containsKey(code)) {
                        coinInfos.add(new CoinInfo(code, codeZh, dollarMap.get(code).getRateFloat()));
                    }
                }
            }
            return new ResponseCoinDesk(lastUpdateTime, coinInfos);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
