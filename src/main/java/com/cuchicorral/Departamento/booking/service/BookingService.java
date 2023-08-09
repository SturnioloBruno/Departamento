package com.cuchicorral.Departamento.booking.service;

import com.cuchicorral.Departamento.booking.entity.Booking;
import com.cuchicorral.Departamento.booking.repository.BookingRepository;
import com.cuchicorral.Departamento.tenant.entity.Tenant;
import com.cuchicorral.Departamento.tenant.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TenantRepository tenantRepository;

    public void saveBooking(Booking booking) { bookingRepository.save(booking); }

    public List<Booking> getBookingDetails(Long bookId) {
        if (null != bookId) {
            return bookingRepository.findAllByBookingId(bookId);
        } else {
            return bookingRepository.findAll();
        }
    }

    public void deleteBooking(Long bookId) { bookingRepository.deleteById(bookId); }

    public Booking assignBookToTenant(Long tenantId, Long bookId) {
        Set<Tenant> tenantSet = null;
        Tenant tenant = tenantRepository.findById(tenantId).get();
        Booking booking = bookingRepository.findById(bookId).get();
        tenantSet = booking.getTenantSet();
        tenantSet.add(tenant);
        booking.setTenantSet(tenantSet);
        return bookingRepository.save(booking);
    }
}
