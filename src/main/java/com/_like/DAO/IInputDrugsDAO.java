package com._like.DAO;

import com._like.Domain.InputDrugs;

import java.util.List;

public interface IInputDrugsDAO {

    void delete(InputDrugs d);

    void save(InputDrugs d);

    void update(InputDrugs d);

    InputDrugs get(Long id);

    List<InputDrugs> list();

    String list(Long id);
}
