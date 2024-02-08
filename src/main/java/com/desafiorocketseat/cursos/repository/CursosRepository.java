package com.desafiorocketseat.cursos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiorocketseat.cursos.entity.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, UUID> {

}
