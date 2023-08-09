package com.cuchicorral.Departamento.booking.entity;

import com.cuchicorral.Departamento.tenant.entity.Tenant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Double previousScore;
    private Double reservationSign;
    private Date dateFrom;
    private Date dateTo;
    private Double price;
    private Boolean confirmed;
    private Double finalScore;
    private String observations;
    @ManyToMany(mappedBy = "assignedBookings")
    @Setter
    @Getter
    private Set<Tenant> tenantSet = new HashSet<>();
}
