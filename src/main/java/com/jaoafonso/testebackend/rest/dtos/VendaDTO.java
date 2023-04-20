package com.jaoafonso.testebackend.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class VendaDTO {

    @NotNull(message = "Informe o valor da venda.")
    private BigDecimal valor;
    @NotNull(message = "Informe o ID do vendedor.")
    private Long vendedor;

    public VendaDTO() {
    }

    public VendaDTO(BigDecimal valor, Long vendedor) {
        this.valor = valor;
        this.vendedor = vendedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getVendedor() {
        return vendedor;
    }

    public void setVendedor(Long vendedor) {
        this.vendedor = vendedor;
    }
}
