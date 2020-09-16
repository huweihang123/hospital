package com._like.DAO;

import com._like.Domain.Drug;
import com._like.Domain.Warehouse;

import java.util.List;

public interface IWarehouseDAO {

    void delete(Warehouse se);

    void save(Warehouse se);

    void update(Warehouse se);

    Warehouse get(Long id);

    List<Warehouse> list();

    List<Warehouse> get(String name);

    String queryCount(String keyfind);

    List<Warehouse> listPage(int currentPage, int moveValue, int limitSize, String keyfind);
}
