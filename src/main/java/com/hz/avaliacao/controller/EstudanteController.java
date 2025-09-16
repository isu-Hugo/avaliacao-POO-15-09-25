package com.hz.avaliacao.controller;

import com.hz.avaliacao.entity.EstudanteModel;
import com.hz.avaliacao.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService service;

    @PostMapping
    public ResponseEntity<EstudanteModel> criar(@RequestBody EstudanteModel estudante){
        return this.service.criar(estudante);
    }

    @GetMapping
    public ResponseEntity<List<EstudanteModel>> listarTodos(){
        return this.service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteModel> getById(@PathVariable("id") Long id){
        return this.service.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstudanteModel> delete(@PathVariable("id") Long id){
        return this.service.deletar(id);
    }

}
