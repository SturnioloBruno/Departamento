package com.cuchicorral.Departamento.tenant.controller;

import com.cuchicorral.Departamento.tenant.entity.Tenant;
import com.cuchicorral.Departamento.tenant.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping("/save")
    public ResponseEntity<Tenant> saveTenant(@RequestBody Tenant tenant) {
        tenantService.saveTenant(tenant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getTenants", "/{tenantId}"})
    public List<Tenant> getTenant(@PathVariable(required = false) Long tenantId) {
        return tenantService.getTenantDetails(tenantId);
    }

    @DeleteMapping("delete/{tenantId}")
    public ResponseEntity removeTenant(@PathVariable Long tenantId){
        tenantService.deleteTenant(tenantId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{tenantId}/booking/{bookId}")
    public Tenant assignBookingToTenant(
            @PathVariable Long tenantId,
            @PathVariable Long bookId
    ){
        return tenantService.assignTenantToBook(tenantId, bookId);
    }
}
