package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
public class PurchaseManager extends BaseManager {


    private Date lastPurchase;
    private Warehouse warehouse;
}
