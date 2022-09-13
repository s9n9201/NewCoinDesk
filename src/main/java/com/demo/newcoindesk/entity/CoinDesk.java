package com.demo.newcoindesk.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoinDesk {
    Time time;
    String disclaimer;
    String chartName;
    BPI bpi;
}
