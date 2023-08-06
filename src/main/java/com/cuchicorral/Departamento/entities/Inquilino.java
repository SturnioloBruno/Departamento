package com.cuchicorral.Departamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inquilino")
public class Inquilino {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String nombre;
    private String DNI;
    private Date fechaDeNacimiento;
    private String domicilio;
    private String ciudad;
    private String provincia;
    private String ocupacion;
    private String telefono;
    private String email;
    private Double puntuacionPromedio;
    private StringBuilder observaciones;
    @ManyToMany
    @JoinTable(
            name = "Inquilino_Reserva",
            joinColumns = @JoinColumn(name = "id_inquilino"),
            inverseJoinColumns = @JoinColumn(name = "id_reserva")
    )
    @JsonIgnore
    private List<Reserva> reservas;
}
