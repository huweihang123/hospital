package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

public class StockManager extends BaseManager {

    @Setter
    @Getter
    private Warehouse warehouse;
}
