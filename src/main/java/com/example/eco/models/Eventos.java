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
@Table(name = "eventos")
public class Eventos {
	public Eventos() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_event")
	private int id_event;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "type")
	private String type;
	@Column(name = "created_by_user")
	private int created_by_user;
	@Column(name = "event_date")
	private String event_date;
	@Column(name = "duration")
	private String duration;
	@Column(name = "number_of_participants")
	private int number_of_participants;
	@Column(name = "maps_location")
	private String maps_location;
	@Column(name = "province")
	private int province;
	@Column(name = "creation_date")
	private String creation_date;

}
