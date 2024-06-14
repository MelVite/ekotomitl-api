package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.Orders;
import com.ekotomitl.repositories.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;
	
	//Get todas las ordenes
	public List<Orders> findAllOrders() {
		return ordersRepository.findAll();
	}

	//Get solo una orden 
	public Optional<Orders> findOrderById(Long id) {
		return ordersRepository.findById(id);
	}
	
	//Post
	public Orders saveOrders(Orders order) {
		return ordersRepository.save(order);
	}
	
	//Put 
	public Orders replaceOrder(Orders newOrder, Long id) {
		return ordersRepository.findById(id)
				.map(order -> {
					order.setOrder_date(newOrder.getOrder_date());
					order.setTotal(newOrder.getTotal());
					order.setStatus(newOrder.getStatus());
					return ordersRepository.save(order);
				})
				.orElseGet(() -> {
					return ordersRepository.save(newOrder);
				});
	}
	
	//Delete una orden
	public void deleteOrderById(Long id) {
		ordersRepository.deleteById(id);
	}
}
