package com._like.DAO;

import com._like.Domain.PurchaseManager;
import com._like.Domain.SystemManager;

import java.util.List;

public interface ISystemManagerDAO {

    void delete(SystemManager pe);

    void save(SystemManager pe);

    void update(SystemManager pe);

    SystemManager get(Long id);

    List<SystemManager> list();

    String queryCount();

    List<SystemManager> get(String username);

    List<SystemManager> getName(String name);


}
