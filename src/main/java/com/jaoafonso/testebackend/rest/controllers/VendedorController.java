package com.jaoafonso.testebackend.rest.controllers;

import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.services.VendedorService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vendedores")
public class VendedorController {

    private final VendedorService service;

    public VendedorController(VendedorService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public VendedorModel salvar(@RequestBody VendedorModel vendedor) {
        return service.salvar(vendedor);
    }
}
