package com.joaoqueiroz.crudcarros.controllers.resources;

import com.joaoqueiroz.crudcarros.domain.entities.Veiculo;
import com.joaoqueiroz.crudcarros.services.VeiculoService;
import io.swagger.annotations.*;
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
@Api
public class VeiculoResource {
    @Autowired
    private VeiculoService service;


    @GetMapping
    @ApiOperation("Buscar veiculos")
    @ApiResponses({
        @ApiResponse(code=200, message="Lista de veiculos cadastrados")
    })
    public ResponseEntity<List<Veiculo>> findAll(Veiculo filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Veiculo> example= Example.of(filtro, matcher);
        List<Veiculo> veiculos = service.getAll(example);
        return ResponseEntity.ok(veiculos);
    }

    @PostMapping
    @ApiOperation("Cadastrar um novo Veiculo")
    @ApiResponses({
            @ApiResponse(code=201, message = "Veiculo cadastrado com sucesso"),
            @ApiResponse(code=400, message = "Erro de validação de dados")
    })
    public ResponseEntity<Veiculo> insert(@RequestBody @ApiParam("Dados do veiculo a ser cadastrado") Veiculo veiculo){
        veiculo.setId(null);
        veiculo.setDataCadastro(LocalDateTime.now());
        veiculo = service.insert(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).body(veiculo);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar um veiculo pelo ID")
    @ApiResponses({
            @ApiResponse(code=200, message = "Veiculo encontrado com sucesso"),
            @ApiResponse(code=404, message = "Nenhum veiculo encontrado para o ID informado")
    })
    public ResponseEntity<Veiculo> findById(@PathVariable @ApiParam("ID do veiculo que deseja buscar") Long id){
        Veiculo v = service.getById(id);
        return ResponseEntity.ok(v);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualizar dados de um veiculo")
    @ApiResponses({
            @ApiResponse(code=204, message = "Veiculo atualizado com sucesso"),
            @ApiResponse(code=404, message = "Nenhum veiculo encontrado para o ID informado")
    })
    public ResponseEntity<Void> update(@PathVariable @ApiParam("ID do veiculo que deseja atualizar") Long id, @RequestBody @ApiParam("Dados do veiculo para atualização") Veiculo veiculo){
        service.update(id, veiculo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletar um veiculo pelo ID")
    @ApiResponses({
            @ApiResponse(code=204, message = "Veiculo deletado com sucesso"),
            @ApiResponse(code=404, message = "Nenhum veiculo encontrado para o ID informado")
    })
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
