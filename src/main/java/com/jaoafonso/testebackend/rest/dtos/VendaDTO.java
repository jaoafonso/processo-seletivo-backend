package com.jaoafonso.testebackend.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class VendaDTO {

    @NotNull
    private BigDecimal valor;
    @NotNull
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
