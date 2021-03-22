package com.joaoqueiroz.crudcarros.config;

import com.joaoqueiroz.crudcarros.domain.entities.Veiculo;
import com.joaoqueiroz.crudcarros.domain.enums.TipoVeiculo;
import com.joaoqueiroz.crudcarros.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private VeiculoRepository veiculoRepository;



    @Override
    public void run(String... args) throws Exception {

        Veiculo v1 = new Veiculo(null, "Carro de testes", "Ford", "preto", 2010, TipoVeiculo.TERRESTRE, new BigDecimal("17000"), LocalDateTime.now());
        Veiculo v2 = new Veiculo(null, "Carro de testes 2" , "Ferrari", "branco", 2017, TipoVeiculo.TERRESTRE, new BigDecimal("17000") , LocalDateTime.now());

        veiculoRepository.saveAll(Arrays.asList(v1, v2));

    }
}
