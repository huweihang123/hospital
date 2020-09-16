package com._like.DAO;

import com._like.Domain.PurchaseManager;
import com._like.Domain.StockManager;
import com._like.Domain.Supplier;

import java.util.List;

public interface IPurchaseManagerDAO {

    void delete(PurchaseManager pe);

    void save(PurchaseManager pe);

    void update(PurchaseManager pe);

    PurchaseManager get(Long id);

    List<PurchaseManager> list();

    String queryCount();

    List<PurchaseManager> get(String username);

    List<PurchaseManager> getName(String name);

}
