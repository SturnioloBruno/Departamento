package com.cuchicorral.Departamento.tenant.service;

import com.cuchicorral.Departamento.booking.entity.Booking;
import com.cuchicorral.Departamento.booking.repository.BookingRepository;
import com.cuchicorral.Departamento.tenant.entity.Tenant;
import com.cuchicorral.Departamento.tenant.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository, BookingRepository bookingRepository) {
        this.tenantRepository = tenantRepository;
        this.bookingRepository = bookingRepository;
    }

    public ResponseEntity<?> saveTenant(Tenant tenant){
        if (tenantRepository.exists(Example.of(tenant)) || tenantRepository.findByDni(tenant.getDni()).isPresent()){
            return ResponseEntity.ok("El inquilino ya existe. Si crees que es un error, revisa que el dni no este repetido");
        }
        return ResponseEntity.ok(tenantRepository.save(tenant));
    }

    public List<Tenant> getTenantDetails(Long tenantId) {
        if (null != tenantId) {
            return tenantRepository.findAllByTenantId(tenantId);
        } else {
            return tenantRepository.findAll();
        }
    }

    public Tenant getTenantByDni(String tenantDni) {
        if (tenantRepository.findByDni(tenantDni).isPresent()){
            return tenantRepository.findByDni(tenantDni).get();
        }else {
            return null;
        }
    }

    public void deleteTenant(Long tenantId){ tenantRepository.deleteById(tenantId); }

    public Tenant assignTenantToBook(Long tenantId, Long bookId) {
        Set<Booking> bookingSet = null;
        Tenant tenant = tenantRepository.findById(tenantId).get();
        Booking booking = bookingRepository.findById(bookId).get();
        bookingSet = tenant.getAssignedBookings();
        bookingSet.add(booking);
        tenant.setAssignedBookings(bookingSet);
        return tenantRepository.save(tenant);
    }
}
