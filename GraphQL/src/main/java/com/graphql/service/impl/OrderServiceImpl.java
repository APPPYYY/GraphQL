package com.graphql.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.entities.OrderEntity;
import com.graphql.entities.UserEntity;
import com.graphql.repo.OrderRepo;
import com.graphql.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public OrderEntity createOrder(OrderEntity order) {
		order.setOrderId(UUID.randomUUID().toString());
		return orderRepo.save(order);
	}

	@Override
	public OrderEntity updateOrderById(String orderId, OrderEntity order) {
		OrderEntity fetchedOrder = orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("ORDER NOT FOUND WITH ID = "+orderId));
		order.setOrderId(orderId);
		return orderRepo.save(order);
	}

	@Override
	public List<OrderEntity> findAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public OrderEntity findOrderByorderId(String orderId) {
		return orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("ORDER NOT FOUND WITH ID = "+orderId));
	}

	@Override
	public boolean deleteOrderByorderId(String orderId) {
		OrderEntity fetchedOrder = orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("ORDER NOT FOUND WITH ID = "+orderId));
		if (!Objects.isNull(fetchedOrder)) {
			orderRepo.delete(fetchedOrder);
			return true;
		}
		return false;
	}

}
