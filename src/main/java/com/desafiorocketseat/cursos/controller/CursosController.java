package com.desafiorocketseat.cursos.controller;

import org.springframework.web.bind.annotation.RestController;

import com.desafiorocketseat.cursos.dto.CursosDTO;
import com.desafiorocketseat.cursos.usecase.AtivarCurso;
import com.desafiorocketseat.cursos.usecase.CadastrarCurso;
import com.desafiorocketseat.cursos.usecase.ListarCursos;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    private final ListarCursos listarCursos;
    private final CadastrarCurso cadastrarCurso;
    private final AtivarCurso ativarCurso;

    public CursosController(ListarCursos listarCursos, CadastrarCurso cadastrarCurso, AtivarCurso ativarCurso) {
        this.listarCursos = listarCursos;
        this.cadastrarCurso = cadastrarCurso;
        this.ativarCurso = ativarCurso;
    }

    // TODO: filtro de cursos por nome e categoria
    @GetMapping
    public ResponseEntity<?> listarCursos() {
        var lista = listarCursos.execute();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CursosDTO cursosDTO) {
        // TODO: process POST request
        var curso = cadastrarCurso.execute(cursosDTO);
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable UUID id, @RequestBody CursosDTO cursosDTO) {
        // TODO: process PUT request

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable UUID id) {

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<?> ativar(@PathVariable UUID id) {
        ativarCurso.execute(id);
        return ResponseEntity.ok().build();
    }

}
