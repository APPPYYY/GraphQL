package com.graphql.service;

import java.util.List;

import com.graphql.entities.UserEntity;

public interface UserService {

	UserEntity createUser(UserEntity user);/* create user */
	UserEntity updateUserById(String userId, UserEntity user);/* update user by userId */
	List<UserEntity> findAllUsers();/* fetch all users */
	UserEntity findUserByUserId(String userId);/* fetch user by userId */
	boolean deleteUserByUserId(String userId);/* delete user by userId */
}
