package com.example.eco.models;

import lombok.Data;

@Data
public class PartCheck {
	int id_event;
	int id_user;
	String inscription_date;
	String nickname;
	String name;
	String surname;
	String mail;
	String image;
	Boolean attendace;
	
}
