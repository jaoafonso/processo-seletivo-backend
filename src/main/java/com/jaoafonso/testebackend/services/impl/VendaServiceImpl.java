package com.jaoafonso.testebackend.services.impl;

import com.jaoafonso.testebackend.exceptions.RegraNegocioException;
import com.jaoafonso.testebackend.rest.dtos.VendaDTO;
import com.jaoafonso.testebackend.models.VendaModel;
import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.repositories.VendaRepository;
import com.jaoafonso.testebackend.repositories.VendedorRepository;
import com.jaoafonso.testebackend.services.VendaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VendaServiceImpl implements VendaService {

    private final VendaRepository vendaRepository;
    private final VendedorRepository vendedorRepository;

    public VendaServiceImpl(VendaRepository vendaRepository, VendedorRepository vendedorRepository) {
        this.vendaRepository = vendaRepository;
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public VendaModel salvar(VendaDTO dto) {
        Long idVendedor = dto.getVendedor();
        VendedorModel vendedor = vendedorRepository
                .findById(idVendedor)
                .orElseThrow(() -> new RegraNegocioException("Codigo de vendedor inválido."));

        VendaModel venda = new VendaModel();
        venda.setVendedor(vendedor);
        venda.setValor(dto.getValor());
        venda.setDataVenda(LocalDate.now());

        return vendaRepository.save(venda);
    }
}
