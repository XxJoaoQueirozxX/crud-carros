package com.joaoqueiroz.crudcarros.controllers.resources;

import com.joaoqueiroz.crudcarros.domain.entities.Veiculo;
import com.joaoqueiroz.crudcarros.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {
    @Autowired
    private VeiculoService service;


    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll(Veiculo filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Veiculo> example= Example.of(filtro, matcher);
        List<Veiculo> veiculos = service.getAll(example);
        return ResponseEntity.ok(veiculos);
    }

    @PostMapping
    public ResponseEntity<Veiculo> insert(@RequestBody Veiculo veiculo){
        veiculo.setId(null);
        veiculo.setDataCadastro(LocalDateTime.now());
        veiculo = service.insert(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).body(veiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Long id){
        Veiculo v = service.getById(id);
        return ResponseEntity.ok(v);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Veiculo veiculo){
        service.update(id, veiculo);
        return ResponseEntity.noContent().build();
    }
}
