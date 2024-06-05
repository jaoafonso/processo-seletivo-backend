package com.jaoafonso.testebackend.rest.controllers;

import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.rest.dtos.VendedorDTO;
import com.jaoafonso.testebackend.services.VendedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vendedores")
public class VendedorController {

    private final VendedorService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public VendedorModel salvar(@RequestBody @Valid VendedorModel vendedor) {
        return service.salvar(vendedor);
    }

    @GetMapping("/listar")
    @ResponseStatus(OK)
    public List<VendedorDTO> listar(@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
                                    @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return service.listar(dataInicial, dataFinal);
    }
}
