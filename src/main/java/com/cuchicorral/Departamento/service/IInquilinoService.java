package com.cuchicorral.Departamento.service;

import com.cuchicorral.Departamento.entities.Inquilino;

import java.util.List;
import java.util.Optional;

public interface IInquilinoService {

    List<Inquilino> findAll();
    Optional<Inquilino> findById(Long id);
    void save(Inquilino inquilino);
    void deleteById(Long id);
}
