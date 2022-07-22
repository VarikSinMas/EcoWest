package com.example.eco.UsuarioServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eco.models.DAOUsuarios;
import com.example.eco.models.UserImg;
import com.example.eco.repositories.UsuarioImgRepositorio;
import com.example.eco.repositories.UsuarioRepositorio;

@Service
public class ServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	UsuarioImgRepositorio usuarioImgRepositorio;

	@Override
	public List<DAOUsuarios> findAllUsers() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Optional<DAOUsuarios> findbyId(int id) {
		return usuarioRepositorio.findById(id);
	}

	@Override
	public DAOUsuarios saveUsuario(DAOUsuarios usuarioNuevo) {
		if (usuarioNuevo != null) {
			return usuarioRepositorio.save(usuarioNuevo);
		}
		return usuarioNuevo;
	}

	@Override
	public String deleteUsuarios(int id) {
		
		if (usuarioRepositorio.findById(id).isPresent()) {
			usuarioRepositorio.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El usuario no existe";
	}

	@Override
	public void updateUsuarios(DAOUsuarios usuarioCambiado, int id) {
	
			Optional<DAOUsuarios> user = usuarioRepositorio.findById(id);
			
			DAOUsuarios usuariosParaCambiar = user.get();
			
			usuariosParaCambiar.setRegister_date(usuarioCambiado.getRegister_date());
			usuariosParaCambiar.setMail(usuarioCambiado.getMail());
			usuariosParaCambiar.setName(usuarioCambiado.getName());
			usuariosParaCambiar.setNickname(usuarioCambiado.getNickname());
			usuariosParaCambiar.setPassword(usuarioCambiado.getPassword());
			usuariosParaCambiar.setProvince(usuarioCambiado.getProvince());
			usuariosParaCambiar.setSurname(usuarioCambiado.getSurname());
			usuariosParaCambiar.setType(usuarioCambiado.getType());
			
			usuarioRepositorio.save(usuariosParaCambiar);
		
	}

	@Override
	public List<UserImg> findAllUserImg() {
		return usuarioImgRepositorio.findAll();
	}
	
	@Override
	public Optional<UserImg> findUserImgbyId(int id) {
		return usuarioImgRepositorio.findById(id);
	}

}
