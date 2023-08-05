package com.cuchicorral.Departamento.tenant.repository;

import com.cuchicorral.Departamento.tenant.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    List<Tenant> findAllByTenantId(Long tenantId);
}
