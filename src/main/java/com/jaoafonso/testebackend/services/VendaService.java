package com.jaoafonso.testebackend.services;

import com.jaoafonso.testebackend.rest.dtos.VendaDTO;
import com.jaoafonso.testebackend.models.VendaModel;

public interface VendaService {

    VendaModel salvar(VendaDTO dto);
}
