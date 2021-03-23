package com.joaoqueiroz.crudcarros;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoqueiroz.crudcarros.domain.entities.Veiculo;
import com.joaoqueiroz.crudcarros.domain.enums.TipoVeiculo;
import com.joaoqueiroz.crudcarros.services.VeiculoService;
import com.joaoqueiroz.crudcarros.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CrudCarrosApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VeiculoService service;


    @Test
    void contextLoads() {
    }

    @Test
    void postVeiculo() throws Exception{
        Veiculo v = new Veiculo("JUnit Car", "JUnit", "preto", 2020, TipoVeiculo.TERRESTRE, new BigDecimal("20000.00"));

        MvcResult result = mockMvc
            .perform(
                post("/veiculos")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(v)))
            .andExpect(status().isCreated())
            .andReturn();
        String location = result.getResponse().getHeader("Location");
        Assertions.assertNotNull(location);
    }

    @Test
    void getVeiculo() throws Exception {
        long id = 1;
        if (service.hasVeiculoById(id)){
           mockMvc.perform(get("/veiculos/" + id)).andExpect(status().isOk());
        } else{
           mockMvc.perform(get("/veiculos/" + id)).andExpect(status().isNotFound());
        }
    }

    @Test
    void deleteVeiculo() throws Exception {
        Veiculo v = new Veiculo("bmw", "mercedes", "branca", 2020, TipoVeiculo.TERRESTRE, new BigDecimal("1000.0"));

        v = service.insert(v);

        long id = v.getId();

        if (service.hasVeiculoById(id)){
            mockMvc
                .perform(delete("/veiculos/" + id))
                .andExpect(status().isNoContent());
            Assertions.assertFalse(service.hasVeiculoById(id));
        }else{
            mockMvc
                .perform(delete("/veiculos/" + id))
                .andExpect(status().isNotFound());
        }
    }

    @Test
    void putVeiculo() throws Exception {
        Veiculo v = new Veiculo("ferrari", "ferrari", "vermelha", 2020, TipoVeiculo.TERRESTRE, new BigDecimal("100"));

        v = service.insert(v);

        long id = v.getId();

        if (service.hasVeiculoById(id)){
            v = new Veiculo("bmw", "mercedes", "preto", 2020, TipoVeiculo.TERRESTRE, new BigDecimal("100000.00"));
            mockMvc.perform(put("/veiculos/" + id)
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(v)))
                    .andExpect(status().isNoContent());
            v = service.getById(id);
            Assertions.assertEquals(v.getAno(), 2020);
            Assertions.assertEquals(v.getCor(), "preto");
            Assertions.assertEquals(v.getMarca(), "mercedes");
            Assertions.assertEquals(v.getModelo(), "bmw");
            Assertions.assertEquals(v.getTipo(), TipoVeiculo.TERRESTRE);
            Assertions.assertEquals(v.getPreco(), new BigDecimal("100000.00"));

        }else {
            mockMvc.perform(put("/veiculos/" + id)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(v)))
                .andExpect(status().isNotFound());
        }

    }


}
