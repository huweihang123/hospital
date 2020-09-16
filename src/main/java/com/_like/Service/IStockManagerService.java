package com._like.Service;


import com._like.Domain.StockManager;
import com._like.Domain.Supplier;
import com._like.Domain.Warehouse;

import java.util.List;

public interface IStockManagerService {


    void delete(StockManager se);

    void save(StockManager se);

    void update(StockManager se);

    StockManager get(Long id);

    List<StockManager> list();

    String queryCount();

    List<StockManager> get(String username);

    List<StockManager> getName(String name);

}
