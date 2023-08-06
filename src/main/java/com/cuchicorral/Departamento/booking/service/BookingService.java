package com.cuchicorral.Departamento.booking.service;

import com.cuchicorral.Departamento.booking.entity.Booking;
import com.cuchicorral.Departamento.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void saveBooking(Booking booking) { bookingRepository.save(booking); }

    public List<Booking> getBookingDetails(Long bookId) {
        if (null != bookId) {
            return bookingRepository.findAllByBookingId(bookId);
        } else {
            return bookingRepository.findAll();
        }
    }

    public void deleteBooking(Long bookId) { bookingRepository.deleteById(bookId); }
}
