package com._like.Service;

import com._like.Domain.Drug;
import com._like.Domain.OutputForm;

import java.util.List;

public interface IOutputFormService {

    void delete(OutputForm d);

    void save(OutputForm d);

    void update(OutputForm d);

    OutputForm get(Long id);

    List<OutputForm> list();

    String queryCount();

    List<OutputForm> listPage(int currentPage,int moveValue,int limitSize);

    List<OutputForm> mostNew();
}
