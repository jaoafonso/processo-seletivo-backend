package com.jaoafonso.testebackend.common;

import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.rest.dtos.VendedorDTO;

import java.util.ArrayList;
import java.util.List;

public class VendedorConstants {
    public static final VendedorModel VENDEDOR1 = new VendedorModel(1L, "Roberto");
    public static final VendedorModel VENDEDOR2 = new VendedorModel(2L, "Lucas");
    public static final VendedorModel VENDEDOR3 = new VendedorModel(null, "João");
    public static final VendedorModel VENDEDOR4 = new VendedorModel(null, "Antônio");
    public static final VendedorModel VENDEDOR_INVALIDO = new VendedorModel(3L, "");
    public static final VendedorDTO VENDEDOR1_DTO = new VendedorDTO(VENDEDOR1, 7, 1.0);
    public static final VendedorDTO VENDEDOR2_DTO = new VendedorDTO(VENDEDOR2, 5, 0.71);
    public static final List<VendedorDTO> VENDEDOR_DTO_LIST = new ArrayList<>() {
        {
            add(VENDEDOR1_DTO);
            add(VENDEDOR2_DTO);
        }
    };

}
