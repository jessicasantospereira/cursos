package com.desafiorocketseat.cursos.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiorocketseat.cursos.entity.Cursos;
import com.desafiorocketseat.cursos.repository.CursosRepository;

@Service
public class ListarCursos {

    private final CursosRepository repository;

    public ListarCursos(CursosRepository cursosRepository) {
        this.repository = cursosRepository;
    }

    public List<Cursos> execute() {
        return repository.findAll();
    }
}
