package com.jaoafonso.testebackend.services.impl;

import com.jaoafonso.testebackend.exceptions.RegraNegocioException;
import com.jaoafonso.testebackend.rest.dtos.VendaDTO;
import com.jaoafonso.testebackend.models.VendaModel;
import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.repositories.VendaRepository;
import com.jaoafonso.testebackend.repositories.VendedorRepository;
import com.jaoafonso.testebackend.services.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendaServiceImpl implements VendaService {

    private final VendaRepository vendaRepository;
    private final VendedorRepository vendedorRepository;

    @Override
    public VendaModel salvar(VendaDTO dto) {
        return vendaRepository.save(VendaModel.of(dto, getVendedorById(dto.getVendedor())));
    }

    private VendedorModel getVendedorById(Long id) {
        return vendedorRepository.findById(id)
            .orElseThrow(() -> new RegraNegocioException("Codigo de vendedor inválido."));
    }
}
