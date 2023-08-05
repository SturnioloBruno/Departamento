package com.cuchicorral.Departamento.tenant.entity;

import com.cuchicorral.Departamento.booking.entity.Reserva;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Tenant {
    @Id
    @GeneratedValue
    private Long tenantId;
    private String name;
    private String dni;
    private Date birthday;
    private String address;
    private String city;
    private String province;
    private String occupation;
    private String telephone;
    private String email;
    private Double averageScore;
    private StringBuilder observations;
    @ManyToMany
    @JoinTable(
            name = "tenant_booking",
            joinColumns = @JoinColumn(name = "tenant_id"),
            inverseJoinColumns = @JoinColumn(name = "booking_id")
    )
    private Set<Reserva> assignedBookings = new HashSet<>();
}
