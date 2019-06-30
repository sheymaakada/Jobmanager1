package com.org.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	
	
	
	@Column(unique=true)
	@NotEmpty
	@Size(min=3)
	private String firstname;
	@Column(unique=true)
	@NotEmpty
	@Size(min=3)
	private String lastname;
	@Email
	@Column(unique=true)
	@NotEmpty
	private String email;
	@Column(unique=true)
	@NotEmpty
	@Size(min=4)
	private String password;
	@Column(unique=true)
	@Size(min=10)
	private String description;
	@Column(unique=true)
	@NotEmpty
	@Size(min=3)
	private String username;
	@OneToMany(fetch = FetchType.LAZY,mappedBy ="client_id",cascade = CascadeType.ALL)
	private List<Jobs> lJobs;
	public List<Jobs> getlJobs() {
		return lJobs;
	}
	public void setlJobs(List<Jobs> lJobs) {
		this.lJobs = lJobs;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Client_id;
	
	
	public Integer getClient_id() {
		return Client_id;
	}
	public void setClient_id(Integer client_id) {
		Client_id = client_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Client(String firstname, String lastname, String email,
			String password, String description, String username,Integer id) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.description = description;
		this.username = username;
		this.Client_id= id;
	}
	public Client(){}
	
	
}
