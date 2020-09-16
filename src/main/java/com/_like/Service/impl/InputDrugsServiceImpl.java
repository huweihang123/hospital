package com._like.Service.impl;


import com._like.DAO.IInputDrugsDAO;
import com._like.DAO.impl.InputDrugsDAOImpl;
import com._like.Domain.InputDrugs;
import com._like.Service.IInputDrugsService;

import java.util.List;


public class InputDrugsServiceImpl implements IInputDrugsService {
    private IInputDrugsDAO inputDrugsDAO = new InputDrugsDAOImpl();

    public void setInputDrugsDAO(IInputDrugsDAO inputDrugsDAO) {
        this.inputDrugsDAO = inputDrugsDAO;
    }
    public void delete(InputDrugs d) {
        inputDrugsDAO.delete(d);
    }

    public void save(InputDrugs d) {
        inputDrugsDAO.save(d);
    }

    public void update(InputDrugs d) {
        inputDrugsDAO.update(d);
    }

    public InputDrugs get(Long id) {
        return inputDrugsDAO.get(id);
    }

    public List<InputDrugs> list() {
        return inputDrugsDAO.list();
    }

    public String list(Long id){
        return inputDrugsDAO.list(id);
    }
}
