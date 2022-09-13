package com.demo.newcoindesk.entity;

import com.demo.newcoindesk.entity.dollar.EUR;
import com.demo.newcoindesk.entity.dollar.GBP;
import com.demo.newcoindesk.entity.dollar.USD;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BPI {
    @JsonProperty("USD")
    USD usd;
    @JsonProperty("GBP")
    GBP gbp;
    @JsonProperty("EUR")
    EUR eur;


}
