package com.example.eco.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	private int id_user;
	private String nickname;
	private String password;
	private String name;
	private String surname;
	private String mail;
	private int type;
	private String register_date;
	private int province;

}
