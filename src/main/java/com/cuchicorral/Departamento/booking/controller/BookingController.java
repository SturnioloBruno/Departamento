package com.cuchicorral.Departamento.booking.controller;

import com.cuchicorral.Departamento.booking.entity.Booking;
import com.cuchicorral.Departamento.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/save")
    public ResponseEntity createBooking(@RequestBody Booking booking) {
        bookingService.saveBooking(booking);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getBookings", "/{bookingId}"})
    public List<Booking> getBookings(@PathVariable(required = false) Long bookingId) {
        return bookingService.getBookingDetails(bookingId);
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity removeBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
