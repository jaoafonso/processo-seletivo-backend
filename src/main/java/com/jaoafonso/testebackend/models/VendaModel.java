package com.jaoafonso.testebackend.models;

import com.jaoafonso.testebackend.rest.dtos.VendaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_VENDA")
public class VendaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 6975616278908281179L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venda_id")
    private Long id;

    @Column(name = "venda_data", nullable = false)
    private LocalDate dataVenda;

    @Column(name = "venda_valor", nullable = false, precision = 20, scale = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private VendedorModel vendedor;

    public static VendaModel of(VendaDTO dto, VendedorModel vendedor) {
        return VendaModel.builder()
            .vendedor(vendedor)
            .valor(dto.getValor())
            .dataVenda(LocalDate.now())
            .build();
    }
}
