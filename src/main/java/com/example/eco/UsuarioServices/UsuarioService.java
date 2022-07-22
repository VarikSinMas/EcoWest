package com.example.eco.UsuarioServices;

import java.util.List;
import java.util.Optional;

import com.example.eco.models.DAOUsuarios;
import com.example.eco.models.UserImg;

public interface UsuarioService {

	
	public List<DAOUsuarios> findAllUsers();
	
	public List<UserImg> findAllUserImg();

	public Optional<DAOUsuarios> findbyId(int id);

	public DAOUsuarios saveUsuario(DAOUsuarios usuarioNuevo);

	public String deleteUsuarios(int id);

	public void updateUsuarios(DAOUsuarios UsuarioNuevo, int id);

	public Optional<UserImg> findUserImgbyId(int id);

}
