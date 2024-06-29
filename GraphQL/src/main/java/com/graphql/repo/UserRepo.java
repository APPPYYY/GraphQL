package com.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, String> {

}
