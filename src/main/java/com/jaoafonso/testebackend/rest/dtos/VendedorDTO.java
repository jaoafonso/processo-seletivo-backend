package com.jaoafonso.testebackend.rest.dtos;

import com.jaoafonso.testebackend.models.VendedorModel;

public class VendedorDTO {

    private VendedorModel vendedor;
    private Integer totalVendas;
    private Double mediaVendas;

    public VendedorDTO() {
    }

    public VendedorDTO(VendedorModel vendedor, Integer totalVendas, Double mediaVendas) {
        this.vendedor = vendedor;
        this.totalVendas = totalVendas;
        this.mediaVendas = mediaVendas;
    }

    public VendedorModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorModel vendedor) {
        this.vendedor = vendedor;
    }

    public Integer getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(Integer totalVendas) {
        this.totalVendas = totalVendas;
    }

    public Double getMediaVendas() {
        return mediaVendas;
    }

    public void setMediaVendas(Double mediaVendas) {
        this.mediaVendas = mediaVendas;
    }
}
