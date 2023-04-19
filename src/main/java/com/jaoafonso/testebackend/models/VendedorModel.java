package com.jaoafonso.testebackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_VENDEDOR")
public class VendedorModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 8152777232931802857L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendedor_id")
    private Long id;
    @Column(name = "vendedor_nome")
    private String nome;
    @OneToMany(mappedBy = "vendedor")
    @JsonIgnore
    private Set<VendaModel> vendas = new HashSet<>();

    public VendedorModel() {
    }

    public VendedorModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<VendaModel> getVendas() {
        return vendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendedorModel vendedor = (VendedorModel) o;

        return Objects.equals(id, vendedor.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
