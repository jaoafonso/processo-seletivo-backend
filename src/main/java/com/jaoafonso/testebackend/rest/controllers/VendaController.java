package com.jaoafonso.testebackend.rest.controllers;

import com.jaoafonso.testebackend.rest.dtos.VendaDTO;
import com.jaoafonso.testebackend.models.VendaModel;
import com.jaoafonso.testebackend.services.VendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public VendaModel salvar(@RequestBody @Valid VendaDTO dto) {
        return service.salvar(dto);
    }
}
