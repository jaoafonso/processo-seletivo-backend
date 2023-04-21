package com.jaoafonso.testebackend.common;

import com.jaoafonso.testebackend.models.VendaModel;
import com.jaoafonso.testebackend.rest.dtos.VendaDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.jaoafonso.testebackend.common.VendedorConstants.VENDEDOR1;

public class VendaConstants {
    public static final VendaModel VENDA1 = new VendaModel(null, LocalDate.now(), BigDecimal.valueOf(2900.99), VENDEDOR1);
    public static final VendaDTO VENDA1_DTO = new VendaDTO(BigDecimal.valueOf(2900.99), VENDEDOR1.getId());
}
