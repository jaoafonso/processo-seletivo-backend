package com.jaoafonso.testebackend.rest.dtos;

import com.jaoafonso.testebackend.models.VendedorModel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendedorDTO {

    private VendedorModel vendedor;
    private Integer totalVendas;
    private Double mediaVendas;
}
