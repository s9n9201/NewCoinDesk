package com.demo.newcoindesk.service.impl;

import com.demo.newcoindesk.dao.CurrencyEnZhRespository;
import com.demo.newcoindesk.entity.CurrencyEnZh;
import com.demo.newcoindesk.payload.request.RequestCurrencyEnZh;
import com.demo.newcoindesk.payload.response.ResponseCurrencyEnZh;
import com.demo.newcoindesk.service.CurrencyEnZhService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyEnZhServiceImplTest {

    @Autowired
    private CurrencyEnZhRespository currencyEnZhRespository;

    @Autowired
    private CurrencyEnZhService currencyEnZhService;

    @Test
    void insert() {
        String code = "SGD", codeZh = "新加坡幣";
        RequestCurrencyEnZh reqCurrencyEnZh = new ResponseCurrencyEnZh(null, code, codeZh);
        currencyEnZhService.insert(reqCurrencyEnZh);

        List<ResponseCurrencyEnZh> responseCurrencyEnZhList = currencyEnZhService.getCurrencyEnZhList();

        assertEquals(4, responseCurrencyEnZhList.size());
        assertNotNull(responseCurrencyEnZhList.get(0).getUuid());
        assertEquals(code, responseCurrencyEnZhList.get(0).getCode());
        assertEquals(codeZh, responseCurrencyEnZhList.get(0).getCodeZh());
    }

    @Test
    void update() {
        String UUID = "5a8be1ad-3a1d-493b-95b3-5dfb20bcb56e";
        String code = "TWD", codeZh = "新台幣";
        currencyEnZhService.update(new RequestCurrencyEnZh(UUID, code, codeZh));

        CurrencyEnZh updateCurr = currencyEnZhRespository.findById(UUID)
                .orElseThrow( () -> new RuntimeException("查無更新資料！"));
        assertNotNull(updateCurr);
        assertEquals(UUID, updateCurr.getUuid());
        assertEquals(code, updateCurr.getCode());
        assertEquals(codeZh, updateCurr.getCodeZh());
        assertNotEquals("1911-01-01 00:00:00.0", updateCurr.getUpdateDate());
    }

    @Test
    void getCurrencyEnZhList() {
        String[] codeArr = {"EUR", "GBP", "USD"};
        List<ResponseCurrencyEnZh> responseCurrencyEnZhList = currencyEnZhService.getCurrencyEnZhList();
        assertEquals(codeArr.length, responseCurrencyEnZhList.size());
        for (int i=0; i<responseCurrencyEnZhList.size(); i++) {
            assertEquals(codeArr[i], responseCurrencyEnZhList.get(i).getCode());
        }
    }

    @Test
    void delete() {
        String UUID = "48f8738e-5af3-40c2-8603-44828eea5495";
        currencyEnZhService.delete(UUID);

        CurrencyEnZh updateCurr = currencyEnZhRespository.findByUuid(UUID);
        assertNull(updateCurr);

        List<ResponseCurrencyEnZh> responseCurrencyEnZhList = currencyEnZhService.getCurrencyEnZhList();
        assertEquals(2, responseCurrencyEnZhList.size());
    }
}