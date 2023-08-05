package com.cuchicorral.Departamento.booking.repository;

import com.cuchicorral.Departamento.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
