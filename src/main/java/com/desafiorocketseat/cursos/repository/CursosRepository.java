package com.desafiorocketseat.cursos.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafiorocketseat.cursos.entity.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, UUID> {

    @Query("SELECT c FROM Cursos c WHERE c.name LIKE %:name% AND c.category LIKE %:category%")
    List<Cursos> findByNameAndCategory(String name, String category);

    @Query("SELECT c FROM Cursos c WHERE c.name LIKE %:name%")
    List<Cursos> findByName(String name);

    @Query("SELECT c FROM Cursos c WHERE c.category LIKE %:category%")
    List<Cursos> findByCategory(String category);

}
