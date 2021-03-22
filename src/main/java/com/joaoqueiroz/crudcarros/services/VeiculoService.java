package com.joaoqueiroz.crudcarros.services;

import com.joaoqueiroz.crudcarros.domain.entities.Veiculo;
import com.joaoqueiroz.crudcarros.repositories.VeiculoRepository;
import com.joaoqueiroz.crudcarros.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.List;

public class VeiculoService {
    @Autowired
    private VeiculoRepository repository;

    public List<Veiculo> getAll(){
        return repository.findAll();
    }

    public List<Veiculo> getAll(Example<Veiculo> filtro){
        return repository.findAll(filtro);
    }

    public  Veiculo getById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum veiculo encontrado para o id:" + id));
    }

    public Veiculo insert(Veiculo veiculo){
        return repository.save(veiculo);
    }

    public void deleteById(Long id){
        Veiculo v = getById(id);
        repository.delete(v);
    }

    public void update(Long id, Veiculo dados){
        Veiculo entity = getById(id);
        updateDados(entity, dados);
        repository.save(entity);
    }

    private void updateDados(Veiculo entity, Veiculo dados){
        entity.setAno(dados.getAno());
        entity.setCor(dados.getCor());
        entity.setMarca(dados.getMarca());
        entity.setModelo(dados.getModelo());
        entity.setPreco(dados.getPreco());
        entity.setTipo(dados.getTipo());
    }


}
