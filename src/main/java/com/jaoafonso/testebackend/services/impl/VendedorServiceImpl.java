package com.jaoafonso.testebackend.services.impl;

import com.jaoafonso.testebackend.exceptions.RegraNegocioException;
import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.repositories.VendaRepository;
import com.jaoafonso.testebackend.repositories.VendedorRepository;
import com.jaoafonso.testebackend.rest.dtos.VendedorDTO;
import com.jaoafonso.testebackend.services.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;
    private final VendaRepository vendaRepository;

    @Override
    public VendedorModel salvar(VendedorModel vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public List<VendedorDTO> listar(LocalDate dataInicial, LocalDate dataFinal) {
        validarPeriodo(dataInicial, dataFinal);

        return vendedorRepository.findAll().stream()
            .map(vendedor -> new VendedorDTO(vendedor,
                vendaRepository.calcularTotalVendasPorVendedor(vendedor.getId(), dataInicial, dataFinal),
                vendaRepository.calcularMediaVendasDiariaPorVendedor(vendedor.getId(), dataInicial, dataFinal)))
            .toList();
    }

    private void validarPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        if (dataFinal.isAfter(LocalDate.now()) || dataInicial.isAfter(LocalDate.now())) {
            throw new RegraNegocioException("Data inválida, não insira datas futuras.");
        }
        if (dataInicial.isAfter(dataFinal)) {
            throw new RegraNegocioException("Data inválida, a data inicial não pode ser superior à data final.");
        }
    }
}
