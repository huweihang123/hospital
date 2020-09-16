package com._like.Service;

import com._like.Domain.InputDrugs;
import com._like.Domain.OutputDrugs;

import java.util.List;

public interface IInputDrugsService {

    void delete(InputDrugs d);

    void save(InputDrugs d);

    void update(InputDrugs d);

    InputDrugs get(Long id);

    List<InputDrugs> list();

    String list(Long id);
}
