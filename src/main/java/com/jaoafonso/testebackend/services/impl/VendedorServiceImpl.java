package com.jaoafonso.testebackend.services.impl;

import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.repositories.VendedorRepository;
import com.jaoafonso.testebackend.services.VendedorService;
import org.springframework.stereotype.Service;

@Service
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorServiceImpl(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public VendedorModel salvar(VendedorModel vendedor) {
        return vendedorRepository.save(vendedor);
    }
}
