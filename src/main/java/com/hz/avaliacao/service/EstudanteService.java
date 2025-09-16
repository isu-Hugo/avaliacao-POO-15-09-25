package com.hz.avaliacao.service;

import com.hz.avaliacao.entity.EstudanteModel;
import com.hz.avaliacao.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;


    public ResponseEntity<EstudanteModel> criar(EstudanteModel estudante){
        EstudanteModel salvado = this.repository.save(estudante);
        return new ResponseEntity<>(salvado, HttpStatus.CREATED);
    }

    public ResponseEntity<List<EstudanteModel>> listarTodos(){
        List<EstudanteModel> resposta = this.repository.findAll();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    public ResponseEntity<EstudanteModel> getById(Long id){
        return this.repository.findById(id)
                .map(estudante -> new ResponseEntity<>(estudante, HttpStatus.OK) )
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<EstudanteModel> deletar(Long id){
//        if (this.repository.existsById(id)){
//            EstudanteModel resposta = this.repository.findById(id).orElse(null);
//            this.repository.deleteById(id);
//            return new ResponseEntity<>(resposta, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return this.repository.findById(id)
                .map(self -> {
                    this.repository.deleteById(id);
                    return new ResponseEntity<>(self, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
