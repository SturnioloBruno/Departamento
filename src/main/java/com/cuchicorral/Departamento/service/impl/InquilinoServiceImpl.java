package com.cuchicorral.Departamento.service.impl;

import com.cuchicorral.Departamento.entities.Inquilino;
import com.cuchicorral.Departamento.persistence.IInquilinoDAO;
import com.cuchicorral.Departamento.service.IInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquilinoServiceImpl implements IInquilinoService {

    @Autowired
    private IInquilinoDAO inquilinoDAO;
    @Override
    public List<Inquilino> findAll() {
        return inquilinoDAO.findAll();
    }

    @Override
    public Optional<Inquilino> findById(Long id) {
        return inquilinoDAO.findById(id);
    }

    @Override
    public void save(Inquilino inquilino) {
        inquilinoDAO.save(inquilino);
    }

    @Override
    public void deleteById(Long id) {
        inquilinoDAO.deleteById(id);
    }
}
