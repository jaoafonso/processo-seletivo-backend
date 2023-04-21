package com.jaoafonso.testebackend.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaoafonso.testebackend.rest.dtos.VendaDTO;
import com.jaoafonso.testebackend.services.VendaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.jaoafonso.testebackend.common.VendaConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VendaController.class)
public class VendaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private VendaService vendaService;

    @Test
    public void salvar_ComDadosValidos_RetornaStatusCreated() throws Exception {
        when(vendaService.salvar(any())).thenReturn(VENDA2);

        String sut = mockMvc.perform(post("/vendas").content(objectMapper.writeValueAsString(VENDA2_DTO)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        assertThat(sut).isEqualTo(objectMapper.writeValueAsString(VENDA2));
    }

    @Test
    public void salvar_ComDadosInvalidos_RetornaStatusBadRequest() throws Exception {
        VendaDTO vendaInvalida = new VendaDTO();

        mockMvc.perform(post("/vendas").content(objectMapper.writeValueAsString(vendaInvalida)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
