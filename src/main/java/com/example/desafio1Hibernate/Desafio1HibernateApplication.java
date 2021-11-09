package com.example.desafio1Hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio1Hibernate.entities.Cliente;
import com.example.desafio1Hibernate.services.ClienteServiceI;

@SpringBootApplication
public class Desafio1HibernateApplication implements CommandLineRunner{

	@Autowired
	private ClienteServiceI clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Desafio1HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Creacion clientes
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Pepito");
		cliente1.setPrimer_apellido("Perez");
		cliente1.setSegundo_apellido("Gutierrez");
		cliente1.setDNI("77588967F");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("JUAN");
		cliente2.setPrimer_apellido("GALAN");
		cliente2.setSegundo_apellido("TORRES");
		cliente2.setDNI("12345678E");
		
		
		//Insertar Clientes
		clienteService.insertarCliente(cliente1);
		Long id2 = clienteService.insertarCliente(cliente2);
		
		
		//Listar
		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes = clienteService.listarClientes();
		for (int i = 0; i < listaClientes.size(); i++) {
		     System.out.println(listaClientes.get(i).getNombre());
		}
		
		//Modificar
		Cliente cliente_modificar = clienteService.buscarPorId(id2);
		cliente_modificar.setNombre("Rafael");
		clienteService.modificarCliente(cliente_modificar);
		
		//Buscar por Apellidos y Nombre
		Cliente clientePorApellidosYNombre = clienteService.buscarPorNombreApellidos(cliente1.getNombre(), cliente1.getPrimer_apellido(), cliente1.getSegundo_apellido());
		
		System.out.println(clientePorApellidosYNombre.getNombre());
		
		
		//Borrar Cliente
		clienteService.borrarCliente(cliente2);
		
		
		
	}

}
