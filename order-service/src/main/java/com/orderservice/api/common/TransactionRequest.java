package com.orderservice.api.common;

import com.orderservice.api.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
	
	private Order order;
	private Payment payment;
}
