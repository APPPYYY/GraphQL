package com.graphql.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.entities.UserEntity;
import com.graphql.repo.UserRepo;
import com.graphql.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserEntity createUser(UserEntity user) {
		user.setUserId(UUID.randomUUID().toString());
		return userRepo.save(user);
	}

	@Override
	public UserEntity updateUserById(String userId, UserEntity user) {
		UserEntity fetchedUser = userRepo.findById(userId).orElseThrow(()->new RuntimeException("USER NOT FOUND WITH ID = "+userId));
		user.setUserId(userId);
		return userRepo.save(user);
	}

	@Override
	public List<UserEntity> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserEntity findUserByUserId(String userId) {
		return userRepo.findById(userId).orElseThrow(()->new RuntimeException("USER NOT FOUND WITH ID = "+userId));
	}

	@Override
	public boolean deleteUserByUserId(String userId) {
		UserEntity user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("USER NOT FOUND WITH ID = "+userId));
		if (!Objects.isNull(user)) {
			userRepo.delete(user);
			return true;
		}
		return false;
	}

}
