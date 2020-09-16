package com._like.Service.impl;

import com._like.DAO.IInputFormDAO;
import com._like.DAO.impl.InputFormDAOImpl;
import com._like.Domain.InputForm;
import com._like.Service.IIntputFormService;

import java.util.List;

public class InputFormServiceImpl implements IIntputFormService {
    private IInputFormDAO inputFormDAO = new InputFormDAOImpl();

    public void setInputDrugsDAO (IInputFormDAO inputFormDAO) {
        this.inputFormDAO = inputFormDAO;
    }
    public void delete(InputForm d) {
        inputFormDAO.delete(d);
    }

    public void save(InputForm d) {
        inputFormDAO.save(d);
    }

    public void update(InputForm d) {
        inputFormDAO.update(d);
    }

    public InputForm get(Long id) {
        return inputFormDAO.get(id);
    }

    public List<InputForm> list() {
        return inputFormDAO.list();
    }

    public String queryCount(){ return inputFormDAO.queryCount(); }

    public List<InputForm> listPage(int currentPage,int moveValue, int limitSize) {
        return inputFormDAO.listPage(currentPage,moveValue,limitSize);
    }

    public List<InputForm> mostNew() {
        return inputFormDAO.mostNew();
    }

}
