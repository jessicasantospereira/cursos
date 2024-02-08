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

    public List<Cursos> execute(String name, String category) {
        if (name != null && category != null)
            return repository.findByNameAndCategory(name, category);
        else if (name != null)
            return repository.findByName(name);
        else if (category != null)
            return repository.findByCategory(category);
        else
            return repository.findAll();
    }
}
