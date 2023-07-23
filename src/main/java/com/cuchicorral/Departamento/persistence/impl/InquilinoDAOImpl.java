package com.cuchicorral.Departamento.persistence.impl;

import com.cuchicorral.Departamento.entities.Inquilino;
import com.cuchicorral.Departamento.persistence.IInquilinoDAO;
import com.cuchicorral.Departamento.repository.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InquilinoDAOImpl implements IInquilinoDAO {

    @Autowired
    private InquilinoRepository inquilinoRepository;
    @Override
    public List<Inquilino> findAll() {
        return (List<Inquilino>) inquilinoRepository.findAll();
    }

    @Override
    public Optional<Inquilino> findById(Long id) {
        return inquilinoRepository.findById(id);
    }

    @Override
    public void save(Inquilino inquilino) {
        inquilinoRepository.save(inquilino);
    }

    @Override
    public void deleteById(Long id) {
        inquilinoRepository.deleteById(id);
    }
}
