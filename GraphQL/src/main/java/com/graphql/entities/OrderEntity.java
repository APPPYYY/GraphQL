package com.graphql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	private String orderId;
	private String orderDetails;
	private String address;
	private String price;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private UserEntity user;
}
