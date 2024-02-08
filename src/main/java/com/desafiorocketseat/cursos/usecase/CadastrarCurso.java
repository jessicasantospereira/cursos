package com.desafiorocketseat.cursos.usecase;

import org.springframework.stereotype.Service;

import com.desafiorocketseat.cursos.dto.CursosDTO;
import com.desafiorocketseat.cursos.entity.Cursos;
import com.desafiorocketseat.cursos.repository.CursosRepository;

@Service
public class CadastrarCurso {

    private final CursosRepository repository;

    public CadastrarCurso(CursosRepository cursosRepository) {
        this.repository = cursosRepository;
    }

    public Cursos execute(CursosDTO cursosDTO) {
        var curso = repository.save(Cursos.builder().name(cursosDTO.name()).category(cursosDTO.category())
                .build());
        return curso;
    }

}
