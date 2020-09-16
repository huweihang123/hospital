package com._like.DAO;


import com._like.Domain.Drug;
import com._like.Domain.Supplier;

import java.util.List;

public interface ISupplierDAO {


    void delete(Supplier se);

    void save(Supplier se);

    void update(Supplier se);

    Supplier get(Long id);

    List<Supplier> list();

    String queryCount(String keyfind);

    List<Supplier> listPage(int currentPage, int moveValue, int limitSize, String keyfind);

    List<Supplier> getName(String name);
}
