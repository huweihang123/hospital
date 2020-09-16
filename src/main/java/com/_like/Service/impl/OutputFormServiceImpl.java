package com._like.Service.impl;

import com._like.DAO.IOutputFormDAO;
import com._like.DAO.impl.OutputFormDAOImpl;
import com._like.Domain.Drug;
import com._like.Domain.OutputForm;
import com._like.Service.IOutputFormService;

import java.util.List;

public class OutputFormServiceImpl implements IOutputFormService {
    private IOutputFormDAO outputFormDAO = new OutputFormDAOImpl();

    public void setOutputFormDAO (IOutputFormDAO outputFormDAO) {
        this.outputFormDAO = outputFormDAO;
    }
    public void delete(OutputForm d) {
        outputFormDAO.delete(d);
    }

    public void save(OutputForm d) {
        outputFormDAO.save(d);
    }

    public void update(OutputForm d) {
        outputFormDAO.update(d);
    }

    public OutputForm get(Long id) {
        return outputFormDAO.get(id);
    }

    public List<OutputForm> list() {
        return outputFormDAO.list();
    }

    public String queryCount(){ return outputFormDAO.queryCount(); }

    public List<OutputForm> listPage(int currentPage,int moveValue, int limitSize) {
        return outputFormDAO.listPage(currentPage,moveValue,limitSize);
    }

    public List<OutputForm> mostNew() {
        return outputFormDAO.mostNew();
    }

}
