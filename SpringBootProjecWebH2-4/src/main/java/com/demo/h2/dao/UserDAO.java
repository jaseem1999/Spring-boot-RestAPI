package com.demo.h2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.h2.model.dto.UserDTO;

public interface UserDAO extends CrudRepository<UserDTO, Integer> {

	List<UserDTO> getByName(String name);
	List<UserDTO> getByEmail(String email);
	
	@Query("SELECT u FROM UserDTO u WHERE u.email = :email AND u.pass = :pass")
	List<UserDTO> login(@Param("email") String email, @Param("pass") String pass);
}
