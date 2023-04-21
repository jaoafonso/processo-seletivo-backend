package com.jaoafonso.testebackend.repositories;

import com.jaoafonso.testebackend.models.VendedorModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class VendedorRepositoryTest {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Test
    public void save_ComDadosInvalidos_RetornaExcecao() {
        VendedorModel vendedorVazio = new VendedorModel();
        VendedorModel vendedorInvalido = new VendedorModel(null, "");

        assertThatThrownBy(() -> vendedorRepository.save(vendedorVazio)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> vendedorRepository.save(vendedorInvalido)).isInstanceOf(RuntimeException.class);
    }
}
