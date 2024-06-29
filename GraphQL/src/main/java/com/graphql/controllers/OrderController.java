package com.graphql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.entities.OrderEntity;
import com.graphql.entities.UserEntity;
import com.graphql.service.OrderService;
import com.graphql.service.UserService;

@RestController
public class OrderController {

	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	
	@MutationMapping
	public OrderEntity createOrder(
			@Argument String orderDetails,
			@Argument String address,
			@Argument String price,
			@Argument String userId
			) {
		UserEntity user = userService.findUserByUserId(userId);
		OrderEntity order = OrderEntity.builder().orderDetails(orderDetails).address(address).price(price).user(user).build();
		return orderService.createOrder(order);
	}
	@QueryMapping
	public List<OrderEntity> findAllOrders(){
		return orderService.findAllOrders();
	}
	@QueryMapping
	public OrderEntity findOrderByorderId(@Argument String orderId) {
		return orderService.findOrderByorderId(orderId);
	}
	@MutationMapping
	public boolean deleteOrderByorderId(@Argument String orderId) {
		return orderService.deleteOrderByorderId(orderId);
	}
}
