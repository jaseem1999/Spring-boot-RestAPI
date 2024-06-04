package com.demo.h2.model.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserDTO implements Serializable {
	@Id
	@GenericGenerator(name = "ref" , strategy = "increment")
	@GeneratedValue(generator = "ref")
	private int id;
	private String name;
	private String email;
	private String pass;
	
	//Constructor for testing 
	public UserDTO() {
		System.out.println(this.getClass().getSimpleName() +" created");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + "]";
	}
	
	
}
