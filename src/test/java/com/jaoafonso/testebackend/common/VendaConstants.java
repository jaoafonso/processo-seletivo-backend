package com.jaoafonso.testebackend.common;

import com.jaoafonso.testebackend.models.VendaModel;
import com.jaoafonso.testebackend.rest.dtos.VendaDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.jaoafonso.testebackend.common.VendedorConstants.*;

public class VendaConstants {
    public static final VendaModel VENDA1 = new VendaModel(null, LocalDate.now(), BigDecimal.valueOf(2900.99), VENDEDOR1);
    public static final VendaModel VENDA2 = new VendaModel(1L, LocalDate.parse("2023-01-01"), BigDecimal.valueOf(299.99), VENDEDOR2);
    public static final VendaModel VENDA3 = new VendaModel(null, LocalDate.parse("2023-04-03"), BigDecimal.valueOf(200.00), VENDEDOR3);
    public static final VendaModel VENDA4 = new VendaModel(null, LocalDate.parse("2023-04-03"), BigDecimal.valueOf(200.00), VENDEDOR4);
    public static final VendaDTO VENDA1_DTO = new VendaDTO(BigDecimal.valueOf(2900.99), VENDEDOR1.getId());
    public static final VendaDTO VENDA2_DTO = new VendaDTO(BigDecimal.valueOf(299.99), VENDEDOR2.getId());
}
