package com.demo.newcoindesk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="Currency_en_zh")
public class CurrencyEnZh {

    @Column(name = "id", insertable=false, updatable=false)
    private Integer id;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "code")
    private String code;

    @Column(name = "code_zh")
    private String codeZh;

    @Column(name = "is_delete", insertable=false)
    private Integer isDelete;

    @Column(name = "rec_date", updatable=false)
    private Date recDate;

    @Column(name = "update_date", insertable=false)
    private Date updateDate;

    @Column(name = "delete_date", insertable=false)
    private Date deleteDate;
}
