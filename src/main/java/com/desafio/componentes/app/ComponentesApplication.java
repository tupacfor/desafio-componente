package com.desafio.componentes.app;

import com.desafio.componentes.entities.Order;
import com.desafio.componentes.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.desafio.componentes"})
public class ComponentesApplication implements CommandLineRunner {
	@Autowired
	OrderService orderService;



	public static void main(String[] args) {
		SpringApplication.run(ComponentesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite codigo, preco e desconto!");
		Integer codigo = sc.nextInt();
		Double preco  = sc.nextDouble();
		Double desconto = sc.nextDouble();
		Order order = new Order(codigo, preco, desconto);
		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f", orderService.total(order));
		sc.close();
	}
}
