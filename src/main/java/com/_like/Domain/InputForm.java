package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class InputForm {
    private Long id;
    private PurchaseManager manager;
    private Date time;
    private Warehouse warehouse;
}
