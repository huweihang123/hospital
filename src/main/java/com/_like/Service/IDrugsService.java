package com._like.Service;

import com._like.Domain.Drug;

import java.util.List;

public interface IDrugsService {


    void delete(Drug d);

    void save(Drug d);

    void update(Drug d);

    Drug get(Long id);

    List<Drug> list();

    String queryCount(String keyfind);

    List<Drug> listPage(int currentPage,int moveValue,int limitSize,String keyfind);

    List<Drug> getName(String name);
}
