package com.cuchicorral.Departamento.tenant.service;

import com.cuchicorral.Departamento.booking.entity.Booking;
import com.cuchicorral.Departamento.booking.repository.BookingRepository;
import com.cuchicorral.Departamento.tenant.entity.Tenant;
import com.cuchicorral.Departamento.tenant.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public void saveTenant(Tenant tenant){ tenantRepository.save(tenant); }

    public List<Tenant> getTenantDetails(Long tenantId) {
        if (null != tenantId) {
            return tenantRepository.findAllByTenantId(tenantId);
        } else {
            return tenantRepository.findAll();
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
