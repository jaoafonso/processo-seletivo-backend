package com.jaoafonso.testebackend.services.impl;

import com.jaoafonso.testebackend.exceptions.RegraNegocioException;
import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.repositories.VendaRepository;
import com.jaoafonso.testebackend.repositories.VendedorRepository;
import com.jaoafonso.testebackend.rest.dtos.VendedorDTO;
import com.jaoafonso.testebackend.services.VendedorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;
    private final VendaRepository vendaRepository;

    public VendedorServiceImpl(VendedorRepository vendedorRepository, VendaRepository vendaRepository) {
        this.vendedorRepository = vendedorRepository;
        this.vendaRepository = vendaRepository;
    }

    @Override
    public VendedorModel salvar(VendedorModel vendedor) {
        if (vendedor.getNome().isBlank()) {
            throw new RegraNegocioException("O nome do vendedor não pode estar vazio.");
        }

        return vendedorRepository.save(vendedor);
    }

    @Override
    public List<VendedorDTO> listar(LocalDate dataInicial, LocalDate dataFinal) {
        if (dataFinal.isAfter(LocalDate.now()) || dataInicial.isAfter(LocalDate.now())) {
            throw new RegraNegocioException("Data inválida, não insira datas futuras.");
        } else if (dataInicial.isAfter(dataFinal)) {
            throw new RegraNegocioException("Data inválida, a data inicial não pode ser superior à data final.");
        }

        List<VendedorDTO> dtoList = new ArrayList<>();
        List<VendedorModel> list = vendedorRepository.findAll();
        for (VendedorModel v : list) {
            VendedorDTO dto = new VendedorDTO(v,
                    vendaRepository.calcularTotalVendasPorVendedor(v.getId(), dataInicial, dataFinal),
                    vendaRepository.calcularMediaVendasDiariaPorVendedor(v.getId(), dataInicial, dataFinal));

            dtoList.add(dto);
        }

        return dtoList;
    }
}
