package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Setter
@Getter
public class Drug {

    private Long id;
    private String name;
    private Long number;
    private BigDecimal sellPrice;
    private BigDecimal costPrice;
    private Date productionDate;
    private Date lifeDate;
    private String type;
    private boolean state;
    private boolean especial;
    private Supplier suppliers;
    private Warehouse warehouses;
}
