package edu.poly.asm_spring.service;

import edu.poly.asm_spring.model.Order;
import edu.poly.asm_spring.model.ShoppingCart;

import java.util.List;

public interface OrderService {
	Order save(ShoppingCart shoppingCart);
	
	List<Order> findAll(String username);
	
	List<Order> findALlOrders();
	
	Order acceptOrder(Long id);
	
	void cancelOrder(Long id);
}
