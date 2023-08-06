package com.cuchicorral.Departamento.controller;

import com.cuchicorral.Departamento.controller.dto.InquilinoDTO;
import com.cuchicorral.Departamento.entities.Inquilino;
import com.cuchicorral.Departamento.service.IInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inquilino")
public class InquilinoController {

    @Autowired
    private IInquilinoService inquilinoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Inquilino> inquilinoOptional = inquilinoService.findById(id);

        if (inquilinoOptional.isPresent()){
            Inquilino inquilino = inquilinoOptional.get();
            InquilinoDTO inquilinoDTO = InquilinoDTO.builder()
                    .id(inquilino.getId())
                    .nombre(inquilino.getNombre())
                    .DNI(inquilino.getDNI())
                    .fechaDeNacimiento(inquilino.getFechaDeNacimiento())
                    .domicilio(inquilino.getDomicilio())
                    .ciudad(inquilino.getCiudad())
                    .provincia(inquilino.getProvincia())
                    .ocupacion(inquilino.getOcupacion())
                    .telefono(inquilino.getTelefono())
                    .email(inquilino.getEmail())
                    .puntuacionPromedio(inquilino.getPuntuacionPromedio())
                    .observaciones(inquilino.getObservaciones())
                    .build();
            return ResponseEntity.ok(inquilinoDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<InquilinoDTO> inquilinoList = inquilinoService.findAll()
                .stream()
                .map(inquilino -> InquilinoDTO.builder()
                        .id(inquilino.getId())
                        .nombre(inquilino.getNombre())
                        .DNI(inquilino.getDNI())
                        .fechaDeNacimiento(inquilino.getFechaDeNacimiento())
                        .domicilio(inquilino.getDomicilio())
                        .ciudad(inquilino.getCiudad())
                        .provincia(inquilino.getProvincia())
                        .ocupacion(inquilino.getOcupacion())
                        .telefono(inquilino.getTelefono())
                        .email(inquilino.getEmail())
                        .puntuacionPromedio(inquilino.getPuntuacionPromedio())
                        .observaciones(inquilino.getObservaciones())
                        .build())
                .toList();
        return ResponseEntity.ok(inquilinoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody InquilinoDTO inquilinoDTO) throws URISyntaxException {
        if (inquilinoDTO.getNombre().isBlank() || inquilinoDTO.getDNI().isBlank() || inquilinoDTO.getTelefono().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        Inquilino inquilino = Inquilino.builder()
                .id(inquilinoDTO.getId())
                .nombre(inquilinoDTO.getNombre())
                .DNI(inquilinoDTO.getDNI())
                .fechaDeNacimiento(inquilinoDTO.getFechaDeNacimiento())
                .domicilio(inquilinoDTO.getDomicilio())
                .ciudad(inquilinoDTO.getCiudad())
                .provincia(inquilinoDTO.getProvincia())
                .ocupacion(inquilinoDTO.getOcupacion())
                .telefono(inquilinoDTO.getOcupacion())
                .email(inquilinoDTO.getEmail())
                .puntuacionPromedio(inquilinoDTO.getPuntuacionPromedio())
                .observaciones(inquilinoDTO.getObservaciones())
                .build();

        inquilinoService.save(inquilino);
        return ResponseEntity.created(new URI("/api/v1/inquilino/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody InquilinoDTO inquilinoDTO) {
        Optional<Inquilino> inquilinoOptional = inquilinoService.findById(id);

        if (inquilinoOptional.isPresent()) {
            Inquilino inquilino = inquilinoOptional.get();
            inquilino.setNombre(inquilinoDTO.getNombre());
            inquilino.setDNI(inquilinoDTO.getDNI());
            inquilino.setFechaDeNacimiento(inquilinoDTO.getFechaDeNacimiento());
            inquilino.setDomicilio(inquilinoDTO.getDomicilio());
            inquilino.setCiudad(inquilinoDTO.getCiudad());
            inquilino.setProvincia(inquilinoDTO.getProvincia());
            inquilino.setOcupacion(inquilinoDTO.getOcupacion());
            inquilino.setTelefono(inquilinoDTO.getTelefono());
            inquilino.setEmail(inquilinoDTO.getEmail());
            inquilino.setPuntuacionPromedio(inquilinoDTO.getPuntuacionPromedio());
            inquilino.setObservaciones(inquilinoDTO.getObservaciones());

            inquilinoService.save(inquilino);

            return ResponseEntity.ok("Registro Actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            inquilinoService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}
