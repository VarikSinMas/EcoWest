package com.example.eco.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eco.models.DAOUsuarios;

@Repository
public interface UsuarioRepositorio extends JpaRepository<DAOUsuarios, Integer> {

	
	/*
	 * void registrar(Usuarios usuario); List<Usuarios> getUsuarios(); void
	 * eliminar(Long id); List<Usuarios> findbyId();
	 * 
	 */
}
