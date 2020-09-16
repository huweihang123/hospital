package com._like.Service.impl;


import com._like.DAO.IOutputDrugsDAO;
import com._like.DAO.impl.OutputDrugsDAOImpl;
import com._like.Domain.OutputDrugs;
import com._like.Domain.Supplier;
import com._like.Service.IOutputDrugsService;

import java.util.List;


public class OutputDrugsServiceImpl implements IOutputDrugsService {
    private IOutputDrugsDAO outputDrugsDAO = new OutputDrugsDAOImpl();

    public void setOutputDrugsDAO(IOutputDrugsDAO outputDrugs) {
        this.outputDrugsDAO = outputDrugs;
    }
    public void delete(OutputDrugs d) {
        outputDrugsDAO.delete(d);
    }

    public void save(OutputDrugs d) {
        outputDrugsDAO.save(d);
    }

    public void update(OutputDrugs d) {
        outputDrugsDAO.update(d);
    }

    public OutputDrugs get(Long id) {
        return outputDrugsDAO.get(id);
    }

    public List<OutputDrugs> list() {
        return outputDrugsDAO.list();
    }

    public String list(Long id){
        return outputDrugsDAO.list(id);
    }

}
