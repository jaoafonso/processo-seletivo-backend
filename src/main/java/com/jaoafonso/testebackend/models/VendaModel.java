package com.jaoafonso.testebackend.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TB_VENDA")
public class VendaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 6975616278908281179L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venda_id")
    private Long id;
    @Column(name = "venda_data")
    private LocalDate dataVenda;
    @Column(name = "venda_valor", precision = 20, scale = 2)
    private BigDecimal valor;
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private VendedorModel vendedor;

    public VendaModel() {
    }

    public VendaModel(Long id, LocalDate dataVenda, BigDecimal valor, VendedorModel vendedor) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valor = valor;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public VendedorModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorModel vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendaModel venda = (VendaModel) o;

        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
