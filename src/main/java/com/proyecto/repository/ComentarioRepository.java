package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
