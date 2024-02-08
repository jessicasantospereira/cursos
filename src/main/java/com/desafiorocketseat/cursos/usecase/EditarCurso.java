package com.desafiorocketseat.cursos.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.desafiorocketseat.cursos.dto.CursosDTO;
import com.desafiorocketseat.cursos.entity.Cursos;
import com.desafiorocketseat.cursos.repository.CursosRepository;

@Service
public class EditarCurso {

    private final CursosRepository repository;

    public EditarCurso(CursosRepository cursosRepository) {
        this.repository = cursosRepository;
    }

    public Cursos execute(UUID id, CursosDTO cursosDTO) {
        var curso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        if (cursosDTO.name() != null) {
            curso.setName(cursosDTO.name());
        }
        if (cursosDTO.category() != null) {
            curso.setCategory(cursosDTO.category());
        }
        repository.save(curso);

        return curso;
    }

}
