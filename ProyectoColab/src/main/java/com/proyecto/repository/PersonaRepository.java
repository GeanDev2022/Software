package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
