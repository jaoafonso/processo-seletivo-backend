package com.jaoafonso.testebackend.services;

import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.rest.dtos.VendedorDTO;

import java.time.LocalDate;
import java.util.List;

public interface VendedorService {

    VendedorModel salvar(VendedorModel vendedor);
    List<VendedorDTO> listar(LocalDate dataInicial, LocalDate dataFinal);
}
