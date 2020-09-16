package com._like.DAO;

import com._like.Domain.OutputDrugs;

import java.util.List;

public interface IOutputDrugsDAO {

    void delete(OutputDrugs d);

    void save(OutputDrugs d);

    void update(OutputDrugs d);

    OutputDrugs get(Long id);

    List<OutputDrugs> list();

    String list(Long id);
}
