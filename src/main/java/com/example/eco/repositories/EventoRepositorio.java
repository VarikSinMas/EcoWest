package com.example.eco.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eco.models.Eventos;

@Repository
public interface EventoRepositorio extends JpaRepository<Eventos, Integer> {

	void save(Optional<Eventos> EventoToUpdate);
	/*
	 * void registrar(Usuarios usuario); List<Usuarios> getUsuarios(); void
	 * eliminar(Long id); List<Usuarios> findbyId();
	 * 
	 */
}