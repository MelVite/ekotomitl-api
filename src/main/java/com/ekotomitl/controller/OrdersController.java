package com.ekotomitl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekotomitl.models.Orders;
import com.ekotomitl.services.OrdersService;

@RestController
@RequestMapping("/orders/")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	//Get all
	@GetMapping
	public List<Orders> getAllCategory() {
		return ordersService.findAllOrders();
	}
	
	//Get regresa un JSON valido
	@GetMapping("{id}") //Solicita una id para filtrar
	public ResponseEntity<Orders> getOrderById (@PathVariable Long id) {
		return ordersService.findOrderById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Post
	@PostMapping
	public Orders createCategory(@RequestBody Orders order) {
		return ordersService.saveOrders(order);
	}
	
	//Put
	@PutMapping("{id}")
	public Orders updateOrder(@RequestBody Orders newOrder, @PathVariable Long id) {
		return ordersService.replaceOrder(newOrder, id);
	}

	//Delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
		return ordersService.findOrderById(id)
				.map(order -> {
					ordersService.deleteOrderById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
