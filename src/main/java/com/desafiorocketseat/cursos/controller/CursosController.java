package com.desafiorocketseat.cursos.controller;

import org.springframework.web.bind.annotation.RestController;

import com.desafiorocketseat.cursos.dto.CursosDTO;
import com.desafiorocketseat.cursos.usecase.AtivarCurso;
import com.desafiorocketseat.cursos.usecase.CadastrarCurso;
import com.desafiorocketseat.cursos.usecase.DeletarCurso;
import com.desafiorocketseat.cursos.usecase.EditarCurso;
import com.desafiorocketseat.cursos.usecase.ListarCursos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private final DeletarCurso deletarCurso;
    private final EditarCurso editarCurso;

    public CursosController(ListarCursos listarCursos, CadastrarCurso cadastrarCurso, AtivarCurso ativarCurso,
            DeletarCurso deletarCurso, EditarCurso editarCurso) {
        this.listarCursos = listarCursos;
        this.cadastrarCurso = cadastrarCurso;
        this.ativarCurso = ativarCurso;
        this.deletarCurso = deletarCurso;
        this.editarCurso = editarCurso;
    }

    // TODO: filtro de cursos por nome e categoria
    @GetMapping
    public ResponseEntity<?> listarCursos(@RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {
        var lista = listarCursos.execute(name, category);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CursosDTO cursosDTO) {
        var curso = cadastrarCurso.execute(cursosDTO);
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable UUID id, @RequestBody CursosDTO cursosDTO) {
        var curso = editarCurso.execute(id, cursosDTO);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable UUID id) {
        deletarCurso.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<?> ativar(@PathVariable UUID id) {
        ativarCurso.execute(id);
        return ResponseEntity.ok().build();
    }

}
