package com.jaoafonso.testebackend.services.impl;

import com.jaoafonso.testebackend.exceptions.RegraNegocioException;
import com.jaoafonso.testebackend.models.VendaModel;
import com.jaoafonso.testebackend.repositories.VendaRepository;
import com.jaoafonso.testebackend.repositories.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.jaoafonso.testebackend.common.VendaConstants.VENDA1;
import static com.jaoafonso.testebackend.common.VendaConstants.VENDA1_DTO;
import static com.jaoafonso.testebackend.common.VendedorConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VendaServiceImplTest {

    @InjectMocks
    private VendaServiceImpl vendaService;

    @Mock
    private VendaRepository vendaRepository;
    @Mock
    private VendedorRepository vendedorRepository;

    @Test
    public void salvar_ComDadosValidos_RetornaVenda() {
        when(vendaRepository.save(VENDA1)).thenReturn(VENDA1);
        when(vendedorRepository.findById(VENDA1_DTO.getVendedor())).thenReturn(Optional.of(VENDEDOR1));

        VendaModel sut = vendaService.salvar(VENDA1_DTO);

        assertThat(sut).isEqualTo(VENDA1);
    }

    @Test
    public void salvar_ComDadosInvalidos_LancaExcecao() {
        when(vendedorRepository.findById(VENDA1_DTO.getVendedor())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> vendaService.salvar(VENDA1_DTO)).isInstanceOf(RegraNegocioException.class);
    }
}
