package com.jaoafonso.testebackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TB_VENDEDOR")
public class VendedorModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 8152777232931802857L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendedor_id")
    private Long id;

    @Column(name = "vendedor_nome", nullable = false, length = 100)
    @NotBlank(message = "Informe o nome do vendedor.")
    private String nome;

    @OneToMany(mappedBy = "vendedor")
    @JsonIgnore
    private Set<VendaModel> vendas = new HashSet<>();

    public VendedorModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
