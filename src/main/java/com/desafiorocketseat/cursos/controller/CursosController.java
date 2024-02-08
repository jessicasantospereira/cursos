package com.desafiorocketseat.cursos.controller;

import org.springframework.web.bind.annotation.RestController;

import com.desafiorocketseat.cursos.usecase.ListarCursos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    private final ListarCursos listarCursos;

    public CursosController(ListarCursos listarCursos) {
        this.listarCursos = listarCursos;
    }

    @GetMapping
    public ResponseEntity<?> listarCursos() {
        var lista = listarCursos.execute();
        return ResponseEntity.ok(lista);
    }

}
