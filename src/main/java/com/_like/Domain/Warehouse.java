package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class Warehouse {

    private Long id;
    private String name;
    private String address;
    private Date createDate;
    private Long Maxsize;
    private Long size;
    private BigDecimal drugsCost;
    private Set<OutputDrugs> outputDrugs;
    private Set<Drug> drugs = new HashSet<>();
}
