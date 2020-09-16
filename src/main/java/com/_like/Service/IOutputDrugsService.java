package com._like.Service;

import com._like.Domain.Drug;
import com._like.Domain.OutputDrugs;
import com._like.Domain.Supplier;

import java.util.List;

public interface IOutputDrugsService {

    void delete(OutputDrugs d);

    void save(OutputDrugs d);

    void update(OutputDrugs d);

    OutputDrugs get(Long id);

    List<OutputDrugs> list();

    String list(Long id);

}
