package com.cuchicorral.Departamento.repository;

import com.cuchicorral.Departamento.entities.Inquilino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinoRepository extends CrudRepository<Inquilino, Long> {
}
