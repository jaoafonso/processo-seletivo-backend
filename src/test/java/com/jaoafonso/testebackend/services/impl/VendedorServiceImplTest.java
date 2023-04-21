package com.jaoafonso.testebackend.services.impl;

import com.jaoafonso.testebackend.exceptions.RegraNegocioException;
import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.repositories.VendaRepository;
import com.jaoafonso.testebackend.repositories.VendedorRepository;
import com.jaoafonso.testebackend.rest.dtos.VendedorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static com.jaoafonso.testebackend.common.VendedorConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VendedorServiceImplTest {

    @InjectMocks
    private VendedorServiceImpl vendedorService;

    @Mock
    private VendedorRepository vendedorRepository;
    @Mock
    private VendaRepository vendaRepository;

    @Test
    public void salvar_ComDadosValidos_RetornaVendedor() {
        when(vendedorRepository.save(VENDEDOR1)).thenReturn(VENDEDOR1);

        VendedorModel sut = vendedorService.salvar(VENDEDOR1);

        assertThat(sut).isEqualTo(VENDEDOR1);
    }

    @Test
    public void salvar_ComDadosInvalidos_LancaExcecao() {
        assertThatThrownBy(() -> vendedorService.salvar(VENDEDOR_INVALIDO)).isInstanceOf(RegraNegocioException.class);
    }

    @Test
    public void listar_ComDadosValidos_RetornaListaDTO() {
        when(vendedorRepository.findAll()).thenReturn(List.of(VENDEDOR1, VENDEDOR2));
        when(vendaRepository.calcularMediaVendasDiariaPorVendedor(VENDEDOR1.getId(),
                LocalDate.parse("2023-01-01"),
                LocalDate.parse("2023-01-07")))
                .thenReturn(1.0);
        when(vendaRepository.calcularMediaVendasDiariaPorVendedor(VENDEDOR2.getId(),
                LocalDate.parse("2023-01-01"),
                LocalDate.parse("2023-01-07")))
                .thenReturn(0.71);
        when(vendaRepository.calcularTotalVendasPorVendedor(VENDEDOR1.getId(),
                LocalDate.parse("2023-01-01"),
                LocalDate.parse("2023-01-07")))
                .thenReturn(7);
        when(vendaRepository.calcularTotalVendasPorVendedor(VENDEDOR2.getId(),
                LocalDate.parse("2023-01-01"),
                LocalDate.parse("2023-01-07")))
                .thenReturn(5);

        List<VendedorDTO> lista = vendedorService.listar(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-07"));

        assertThat(lista.get(0)).isEqualTo(VENDEDOR1_DTO);
        assertThat(lista.get(1)).isEqualTo(VENDEDOR2_DTO);
    }

    @Test
    public void listar_ComDadosInvalidos_LancaExcecao() {
        assertThatThrownBy(() ->
                vendedorService.listar(
                        LocalDate.parse("2030-01-01"),
                        LocalDate.parse("2030-01-07")))
                .isInstanceOf(RegraNegocioException.class);
    }
}
