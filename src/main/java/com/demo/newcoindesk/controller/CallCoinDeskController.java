package com.demo.newcoindesk.controller;

import com.demo.newcoindesk.entity.CoinDesk;
import com.demo.newcoindesk.payload.response.ResponseCoinDesk;
import com.demo.newcoindesk.service.CallCoinDeskService;
import com.demo.newcoindesk.util.JavaScriptMessageConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CallCoinDeskController {

    private final CallCoinDeskService callCoinDeskService;
    @Value("${call.url}")
    private String url;

    @GetMapping("/callCoinDesk")
    public ResponseEntity<CoinDesk> callCoinDesk() {
        return ResponseEntity.ok(this.callAPI());
    }

    @GetMapping("/getNewCoinDesk")
    public ResponseEntity<ResponseCoinDesk> getNewCoinDesk() throws Exception {
        CoinDesk coinDesk = this.callAPI();
        ResponseCoinDesk responseCoinDesk = callCoinDeskService.formatData(coinDesk);
        return ResponseEntity.ok(responseCoinDesk);
    }

    @GetMapping("/123")
    public String getOneTwoThree() {
        return "1 2 3 4 5 6";
    }

    private CoinDesk callAPI() {
        RestTemplate restTemplate = new RestTemplate(List.of(new JavaScriptMessageConverter()));
        return restTemplate.getForObject(url, CoinDesk.class);
    }
}
