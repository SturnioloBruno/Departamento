package com.cuchicorral.Departamento.booking.repository;

import com.cuchicorral.Departamento.booking.entity.Booking;
import com.cuchicorral.Departamento.tenant.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByBookingId(Long bookId);
}
