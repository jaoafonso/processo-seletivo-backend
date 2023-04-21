package com.jaoafonso.testebackend.repositories;

import com.jaoafonso.testebackend.models.VendaModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.jaoafonso.testebackend.common.VendaConstants.*;
import static com.jaoafonso.testebackend.common.VendedorConstants.VENDEDOR3;
import static com.jaoafonso.testebackend.common.VendedorConstants.VENDEDOR4;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class VendaRepositoryTest {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private VendedorRepository vendedorRepository;

    @Test
    public void calcularMediaVendasDiariaPorVendedor_ComDadosValidos_RetornaMediaVendas() {
        vendedorRepository.save(VENDEDOR3);
        vendaRepository.save(VENDA3);

        Double sut = vendaRepository.calcularMediaVendasDiariaPorVendedor(VENDEDOR3.getId(),
                LocalDate.parse("2023-04-01"), LocalDate.parse("2023-04-03"));

        assertThat(sut).isEqualTo(0.33);
    }

    @Test
    public void calcularTotalVendasPorVendedor_ComDadosValidos_RetornaTotalVendas() {
        vendedorRepository.save(VENDEDOR4);
        vendaRepository.save(VENDA4);

        Integer sut = vendaRepository.calcularTotalVendasPorVendedor(VENDEDOR4.getId(),
                LocalDate.parse("2023-04-01"), LocalDate.parse("2023-04-03"));

        assertThat(sut).isEqualTo(1);
    }

    @Test
    public void save_ComDadosInvalidos_RetornaExcecao() {
        VendaModel vendaVazia = new VendaModel();
        VendaModel vendaSemVendedor = new VendaModel(null, LocalDate.parse("2023-01-01"), BigDecimal.valueOf(200.99), null);

        assertThatThrownBy(() -> vendaRepository.save(vendaVazia)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> vendaRepository.save(vendaSemVendedor)).isInstanceOf(RuntimeException.class);
    }
}
