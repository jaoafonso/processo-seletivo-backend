package com.jaoafonso.testebackend.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaoafonso.testebackend.models.VendedorModel;
import com.jaoafonso.testebackend.services.VendedorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static com.jaoafonso.testebackend.common.VendedorConstants.VENDEDOR1;
import static com.jaoafonso.testebackend.common.VendedorConstants.VENDEDOR_DTO_LIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VendedorController.class)
public class VendedorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private VendedorService vendedorService;

    @Test
    public void salvar_ComDadosValidos_RetornaStatusCreated() throws Exception {
        when(vendedorService.salvar(any())).thenReturn(VENDEDOR1);

        String sut = mockMvc.perform(post("/vendedores").content(objectMapper.writeValueAsString(VENDEDOR1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        assertThat(sut).isEqualTo(objectMapper.writeValueAsString(VENDEDOR1));
    }

    @Test
    public void salvar_ComDadosInvalidos_RetornaStatusBadRequest() throws Exception {
        VendedorModel vendedorInvalido = new VendedorModel();

        mockMvc.perform(post("/vendedores").content(objectMapper.writeValueAsString(vendedorInvalido)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void listar_RetornaStatusOk() throws Exception {
        when(vendedorService.listar(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-07")))
                .thenReturn(VENDEDOR_DTO_LIST);

        mockMvc.perform(get("/vendedores/listar?dataInicial=2023-01-01&dataFinal=2023-01-07"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]").value(VENDEDOR_DTO_LIST.get(0)))
                .andExpect(jsonPath("$[1]").value(VENDEDOR_DTO_LIST.get(1)));
    }
}
