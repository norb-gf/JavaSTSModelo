package com.ngf.sp_bkend.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "emailid")
	private String emailId;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;
	
	@Column(name = "dataultalt")
	private Calendar dataUltAlt;
	
	
	
	public User() {

	}
	public User(long id, String firstName, String lastName, String emailId, String login, String senha, Calendar dataUltAlt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.senha = senha;
		this.dataUltAlt = dataUltAlt;
	}

	public User(String firstName, String lastName, String emailId, String login, String senha, Calendar dataUltAlt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.senha = senha;
		this.dataUltAlt = dataUltAlt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.login = senha;
	}

	public Calendar getDataUltAlt() {
		return dataUltAlt;
	}

	public void setDataUltAlt(Calendar dataUltAlt) {
		this.dataUltAlt = dataUltAlt;
	}
}
