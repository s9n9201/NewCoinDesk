package com.demo.newcoindesk.dao;

import com.demo.newcoindesk.entity.CurrencyEnZh;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyEnZhRespository extends CrudRepository<CurrencyEnZh, String> {

    @Query("select curr from CurrencyEnZh curr where curr.isDelete=0 order by curr.id desc")
    List<CurrencyEnZh> findAll();

    @Query("select curr from CurrencyEnZh curr where curr.uuid=:UUID and curr.isDelete=0")
    CurrencyEnZh findByUuid(String UUID);
}
