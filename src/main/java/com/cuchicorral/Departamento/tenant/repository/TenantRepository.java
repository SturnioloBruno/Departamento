package com.cuchicorral.Departamento.tenant.repository;

import com.cuchicorral.Departamento.tenant.entity.Tenant;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    List<Tenant> findAllByTenantId(Long tenantId);
    Optional<Tenant> findByDni(String tenantDni);
}
//