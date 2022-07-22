package com.example.eco.models;

import javax.persistence.*;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class DAOUsuarios {
	public DAOUsuarios() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id_user;
	@Column(name = "nickname")
	private String nickname;
	@Column(name = "password",length = 3000)
	@JsonIgnore
	private String password;
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
	private int province;
	
	
}
