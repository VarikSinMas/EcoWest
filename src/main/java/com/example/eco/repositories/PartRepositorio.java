package com.example.eco.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eco.models.Participante;

@Repository
public interface PartRepositorio extends JpaRepository<Participante, Integer> {
	

	void save(Optional<Participante> partOptional);

}