package com.desafio.componentes.services;


import com.desafio.componentes.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	ShippingService shippingService;


	public double total(Order order) {
		return (1 - order.getDiscount() / 100) * order.getBasic() + shippingService.shipment(order);
	}
}
