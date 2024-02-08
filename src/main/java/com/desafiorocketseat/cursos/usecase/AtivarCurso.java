package com.desafiorocketseat.cursos.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.desafiorocketseat.cursos.entity.Cursos;
import com.desafiorocketseat.cursos.repository.CursosRepository;

import jakarta.transaction.Transactional;

@Service
public class AtivarCurso {

    private final CursosRepository repository;

    public AtivarCurso(CursosRepository cursosRepository) {
        this.repository = cursosRepository;
    }

    @Transactional
    public void execute(UUID id) {
        Cursos curso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        curso.setActive(!curso.isActive()); // Inverte o estado de ativo
        repository.save(curso);
    }

}
