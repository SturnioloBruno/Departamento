package com.cuchicorral.Departamento.persistence;

import com.cuchicorral.Departamento.entities.Inquilino;

import java.util.List;
import java.util.Optional;

public interface IInquilinoDAO {

    List<Inquilino> findAll();
    Optional<Inquilino> findById(Long id);
    void save(Inquilino inquilino);
    void deleteById(Long id);
}
