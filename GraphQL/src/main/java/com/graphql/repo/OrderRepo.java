package com.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.entities.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity	, String> {

}
