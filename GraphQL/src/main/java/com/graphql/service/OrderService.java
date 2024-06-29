package com.graphql.service;

import java.util.List;

import com.graphql.entities.OrderEntity;

public interface OrderService {

	OrderEntity createOrder(OrderEntity order);/* create order */
	OrderEntity updateOrderById(String orderId, OrderEntity order);/* update order by orderId */
	List<OrderEntity> findAllOrders();/* fetch all orders */
	OrderEntity findOrderByorderId(String orderId);/* fetch order by orderId */
	boolean deleteOrderByorderId(String orderId);/* delete order by orderId */
}
