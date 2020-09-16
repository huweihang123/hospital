package com._like.DAO;

import com._like.Domain.InputForm;
import com._like.Domain.OutputForm;

import java.util.List;

public interface IInputFormDAO {

    void delete(InputForm d);

    void save(InputForm d);

    void update(InputForm d);

    InputForm get(Long id);

    List<InputForm> list();

    String queryCount();

    List<InputForm> listPage(int currentPage,int moveValue,int limitSize);

    List<InputForm> mostNew();
}
