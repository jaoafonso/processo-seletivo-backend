package com.jaoafonso.testebackend.rest.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {

    @NotNull(message = "Informe o valor da venda.")
    private BigDecimal valor;
    @NotNull(message = "Informe o ID do vendedor.")
    private Long vendedor;
}
