package com.cuchicorral.Departamento.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reserva {

    @Id
    @GeneratedValue
    private Long id;
    private Double puntuacionPrevia;
    private Double senia;
    private Date fechaDesde;
    private Date fechaHasta;
    private Double precio;
    private Boolean concretada;
    private Double puntuacionFinal;
    private String observacion;
    @ManyToMany(mappedBy = "reservas", cascade = CascadeType.ALL)
    private List<Inquilino> inquilinos;
}
