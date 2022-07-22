package com.example.eco.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.eco.models.UserImg;

@Repository
public interface UsuarioImgRepositorio extends JpaRepository<UserImg, Integer> {
	

	void save(Optional<UserImg> partOptional);


}