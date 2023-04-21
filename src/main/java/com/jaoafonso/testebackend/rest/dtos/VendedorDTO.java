package com.jaoafonso.testebackend.rest.dtos;

import com.jaoafonso.testebackend.models.VendedorModel;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendedorDTO that = (VendedorDTO) o;

        if (!Objects.equals(vendedor, that.vendedor)) return false;
        if (!Objects.equals(totalVendas, that.totalVendas)) return false;
        return Objects.equals(mediaVendas, that.mediaVendas);
    }

    @Override
    public int hashCode() {
        int result = vendedor != null ? vendedor.hashCode() : 0;
        result = 31 * result + (totalVendas != null ? totalVendas.hashCode() : 0);
        result = 31 * result + (mediaVendas != null ? mediaVendas.hashCode() : 0);
        return result;
    }
}
