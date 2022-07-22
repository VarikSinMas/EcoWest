package com.example.eco.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "eventos_participantes")
public class Participante{
	
	public Participante() {
	}
	
	@Id
	@Column(name = "id_event")
	private int id_event;
	@Column(name = "id_user")
	private int id_user;
	@Column(name = "inscription_date")
	private String inscription_date;
	@Column(name = "attendance")
	private boolean attendance;

}
