package com._like.Service;

import com._like.Domain.PurchaseManager;
import com._like.Domain.SystemManager;

import java.util.List;

public interface ISystemManagerService {

    void delete(SystemManager pe);

    void save(SystemManager pe);

    void update(SystemManager pe);

    SystemManager get(Long id);

    List<SystemManager> list();

    String queryCount();

    List<SystemManager> get(String username);

    List<SystemManager> getName(String name);
}
