package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OutputDrugs {

    private Long id;
    private String name;
    private Long number;
    private String type;
    private BigDecimal Price;
    private String remarks;
    private OutputForm from;
}
