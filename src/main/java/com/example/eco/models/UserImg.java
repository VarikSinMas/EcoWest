package com.example.eco.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "mostrar_usuarios")
public class UserImg {
	public UserImg() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id_user;
	@Column(name = "nickname")
	private String nickname;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "mail")
	private String mail;
	@Column(name = "type")
	private int type;
	@Column(name = "register_date")
	private String register_date;
	@Column(name = "province")
	private String province;
	@Column(name ="image")
	private String image;

	
}
