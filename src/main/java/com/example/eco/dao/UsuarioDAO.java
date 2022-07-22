package com.example.eco.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eco.models.DAOUsuarios;

@Repository
public interface UsuarioDAO extends CrudRepository<DAOUsuarios, Integer> {

	DAOUsuarios findByNickname(String nickname);
	 

}
