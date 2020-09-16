package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
public class InputDrugs {

    private Long id;
    private String name;
    private Long number;
    private String type;
    private BigDecimal Price;
    private String remarks;
    private Supplier supplier;
    private InputForm from;
    private Date productionDate;
    private Date lifeDate;
}
