package com.cuchicorral.Departamento.booking.service;

import com.cuchicorral.Departamento.booking.entity.Booking;
import com.cuchicorral.Departamento.booking.repository.BookingRepository;
import com.cuchicorral.Departamento.tenant.entity.Tenant;
import com.cuchicorral.Departamento.tenant.repository.TenantRepository;
import com.cuchicorral.Departamento.tenant.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final TenantRepository tenantRepository;
    private final TenantService tenantService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, TenantRepository tenantRepository, TenantService tenantService) {
        this.bookingRepository = bookingRepository;
        this.tenantRepository = tenantRepository;
        this.tenantService = tenantService;
    }

    public ResponseEntity<?> saveBooking(Booking booking) {
        // Crear un ExampleMatcher para definir cómo se deben comparar las propiedades
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnorePaths("bookingId"); // Ignorar el campo bookingId

        // Crear un Example utilizando el booking que pasaste como parámetro
        Example<Booking> example = Example.of(booking, matcher);

        // Utilizar el método findAll con el Example y verificar si existe alguna reserva
        List<Booking> existingBookings = bookingRepository.findAll(example);

        if (!existingBookings.isEmpty()) {
            // Ya existe una reserva con esas características
            return ResponseEntity.ok("La reserva con esas características ya existe, si quieres una reserva " +
                    "para la misma fecha, cambia alguna otra propiedad");
        }

        // Si no se encontró, guardar el booking en la base de datos y recuperarlo para setearle los inquilinos:
        Booking bookingConId = bookingRepository.save(booking);
        Set<Tenant> tenantsEnLaReserva = bookingConId.getTenantSet();
        Iterator<Tenant> iterator = tenantsEnLaReserva.iterator();
        while (iterator.hasNext()){
            Tenant tenant = iterator.next();
            assignBookToTenant(tenant.getTenantId(), bookingConId.getBookingId());
            tenantService.assignTenantToBook(tenant.getTenantId(), bookingConId.getBookingId());
        }
        // finalmente actualizo la reserva
        return ResponseEntity.ok(bookingRepository.findById(bookingConId.getBookingId()));

    }

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
