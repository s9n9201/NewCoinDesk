package com.demo.newcoindesk.controller;

import com.demo.newcoindesk.payload.request.RequestCurrencyEnZh;
import com.demo.newcoindesk.payload.response.ResponseCurrencyEnZh;
import com.demo.newcoindesk.service.CurrencyEnZhService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CurrencyEnZhController {

    private final CurrencyEnZhService currencyEnZhService;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody RequestCurrencyEnZh requestCurrencyEnZh) {
        currencyEnZhService.insert(requestCurrencyEnZh);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created ! ");
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseCurrencyEnZh> update(@RequestBody RequestCurrencyEnZh requestCurrencyEnZh) {
        ResponseCurrencyEnZh responseCurrencyEnZh = currencyEnZhService.update(requestCurrencyEnZh);
        return ResponseEntity.ok(responseCurrencyEnZh);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<?>> getCurrencyEnZhList() {
        List<ResponseCurrencyEnZh> responseCurrencyEnZhList = currencyEnZhService.getCurrencyEnZhList();
        return ResponseEntity.ok(responseCurrencyEnZhList);
    }

    @GetMapping("/456")
    public String getFourFiveSix() {
        return "4 5 6";
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        currencyEnZhService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}
