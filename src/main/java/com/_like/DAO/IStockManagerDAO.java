package com._like.DAO;


import com._like.Domain.StockManager;
import com._like.Domain.Supplier;

import java.util.List;

public interface IStockManagerDAO {


    void delete(StockManager se);

    void save(StockManager se);

    void update(StockManager se);

    StockManager get(Long id);

    List<StockManager> list();

    String queryCount();

    List<StockManager> get(String username);

    List<StockManager> getName(String name);
}
