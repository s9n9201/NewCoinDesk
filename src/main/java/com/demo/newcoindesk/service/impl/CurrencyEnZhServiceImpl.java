package com.demo.newcoindesk.service.impl;

import com.demo.newcoindesk.dao.CurrencyEnZhRespository;
import com.demo.newcoindesk.entity.CurrencyEnZh;
import com.demo.newcoindesk.payload.request.RequestCurrencyEnZh;
import com.demo.newcoindesk.payload.response.ResponseCurrencyEnZh;
import com.demo.newcoindesk.service.CurrencyEnZhService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class CurrencyEnZhServiceImpl implements CurrencyEnZhService {

    private final CurrencyEnZhRespository currencyEnZhRespository;

    @Override
    public Integer insert(RequestCurrencyEnZh requestCurrencyEnZh) {
        CurrencyEnZh currencyEnZh = new CurrencyEnZh();
        BeanUtils.copyProperties(requestCurrencyEnZh, currencyEnZh);
        currencyEnZh.setUuid(java.util.UUID.randomUUID().toString());
        currencyEnZh.setRecDate(new Date());
        currencyEnZhRespository.save(currencyEnZh);
        return 1;
    }

    @Override
    public ResponseCurrencyEnZh update(RequestCurrencyEnZh requestCurrencyEnZh) {
        CurrencyEnZh currencyEnZh = new CurrencyEnZh();
        BeanUtils.copyProperties(requestCurrencyEnZh, currencyEnZh);
        currencyEnZh.setIsDelete(0);
        currencyEnZh.setUpdateDate(new Date());
        currencyEnZhRespository.save(currencyEnZh);

        CurrencyEnZh newCurr = currencyEnZhRespository.findByUuid(currencyEnZh.getUuid());

        return new ResponseCurrencyEnZh(newCurr.getUuid(), newCurr.getCode(), newCurr.getCodeZh());
    }

    @Override
    public List<ResponseCurrencyEnZh> getCurrencyEnZhList() {
        List<CurrencyEnZh> currencyEnZhList = currencyEnZhRespository.findAll();
        List<ResponseCurrencyEnZh> list = new ArrayList<>();
        if (currencyEnZhList.size() > 0) {
            for (CurrencyEnZh tmp : currencyEnZhList) {
                list.add(new ResponseCurrencyEnZh(tmp.getUuid(), tmp.getCode(), tmp.getCodeZh()));
            }
        }
        return list;
    }

    @Override
    public void delete(String uuid) {
        Date now = new Date();
        CurrencyEnZh oldCurrencyEnZh = currencyEnZhRespository.findById(uuid)
                .orElseThrow( () -> new RuntimeException("刪除資料異常"));
        CurrencyEnZh currencyEnZh = new CurrencyEnZh();
        BeanUtils.copyProperties(oldCurrencyEnZh, currencyEnZh);
        currencyEnZh.setIsDelete(1);
        currencyEnZh.setDeleteDate(now);
        currencyEnZhRespository.save(currencyEnZh);
    }
}
