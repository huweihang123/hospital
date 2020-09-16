package com._like.Service;

import com._like.Domain.InputDrugs;
import com._like.Domain.InputForm;

import java.util.List;

public interface IIntputFormService {

    void delete(InputForm d);

    void save(InputForm d);

    void update(InputForm d);

    InputForm get(Long id);

    List<InputForm> list();

    String queryCount();

    List<InputForm> listPage(int currentPage,int moveValue,int limitSize);

    List<InputForm> mostNew();
}
