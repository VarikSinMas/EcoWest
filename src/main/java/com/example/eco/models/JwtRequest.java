package com.example.eco.models;

import java.io.Serializable;

public class JwtRequest implements Serializable{
private static final long serialVersionUID = 5926468583005150707L;
	
	private String nickname;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String nickname, String password) {
		this.setNickname(nickname);
		this.setPassword(password);
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
