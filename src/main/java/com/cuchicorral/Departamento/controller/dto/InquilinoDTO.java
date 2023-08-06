package com.cuchicorral.Departamento.controller.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquilinoDTO {

    private Long id;
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
}
