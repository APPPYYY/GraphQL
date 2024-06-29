package com.graphql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.entities.UserEntity;
import com.graphql.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@MutationMapping
	public UserEntity createUser(
			@Argument String name,
			@Argument String phone,
			@Argument String email,
			@Argument String password
			) {
		UserEntity user = UserEntity.builder().name(name).phone(phone).email(email).password(password).build();
		return userService.createUser(user);
	}
	@QueryMapping
	public List<UserEntity> findAllUsers(){
		return userService.findAllUsers();
	}
	@QueryMapping
	public UserEntity findUserByUserId(@Argument String userId) {
		return userService.findUserByUserId(userId);
	}
	@SchemaMapping(typeName = "Mutation",field = "deleteUserByUserId")
	//@MutationMapping
	public boolean  deleteUserByUserId(@Argument String userId) {
		return userService.deleteUserByUserId(userId);
	}
}
