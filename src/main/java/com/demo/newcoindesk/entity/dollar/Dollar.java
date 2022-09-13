package com.demo.newcoindesk.entity.dollar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dollar {
    private String code;
    private String symbol;
    private String rate;
    private String description;
    @JsonProperty("rate_float")
    private Float rateFloat;
}
