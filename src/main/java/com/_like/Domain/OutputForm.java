package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class OutputForm {
    private Long id;
    private StockManager manager;
    private Date time;
    private Warehouse warehouse;
}
