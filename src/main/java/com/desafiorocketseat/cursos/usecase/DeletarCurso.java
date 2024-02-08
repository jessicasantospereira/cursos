package com.desafiorocketseat.cursos.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.desafiorocketseat.cursos.entity.Cursos;
import com.desafiorocketseat.cursos.repository.CursosRepository;

@Service
public class DeletarCurso {

    private final CursosRepository repository;

    public DeletarCurso(CursosRepository cursosRepository) {
        this.repository = cursosRepository;
    }

    public void execute(UUID id) {
        Cursos curso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        repository.delete(curso);
    }
}
