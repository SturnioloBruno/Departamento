package com.cuchicorral.Departamento.tenant.entity;

import com.cuchicorral.Departamento.booking.entity.Booking;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tenant_booking",
            joinColumns = @JoinColumn(name = "tenant_id"),
            inverseJoinColumns = @JoinColumn(name = "booking_id")
    )
    private Set<Booking> assignedBookings = new HashSet<>();

    public Set<Booking> getAssignedBookings() {
        return assignedBookings;
    }

    public void setAssignedBookings(Set<Booking> assignedBookings) {
        this.assignedBookings = assignedBookings;
    }
}
