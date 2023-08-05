package com.cuchicorral.Departamento.booking.entity;

import com.cuchicorral.Departamento.tenant.entity.Tenant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Booking {
    @Id
    @GeneratedValue
    private Long bookingId;
    private Double previousScore;
    private Double reservationSign;
    private Date dateFrom;
    private Date dateTo;
    private Double price;
    private Boolean confirmed;
    private Double finalScore;
    private String observations;
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedBookings")
    private Set<Tenant> tenants;
}
