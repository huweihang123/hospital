package com._like.Service;

import com._like.Domain.Drug;
import com._like.Domain.Warehouse;

import java.util.List;

public interface IWarehouseService {

    void delete(Warehouse se);

    void save(Warehouse se);

    void update(Warehouse se);

    Warehouse get(Long id);

    List<Warehouse> list();

    String queryCount(String keyfind);

    List<Warehouse> listPage(int currentPage, int moveValue, int limitSize, String keyfind);


    List<Warehouse> get(String name);
}
