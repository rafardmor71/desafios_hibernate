package com.example.desafio1Hibernate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio1Hibernate.entities.Cliente;
import com.example.desafio1Hibernate.entities.Contrato;
import com.example.desafio1Hibernate.services.ClienteServiceI;
import com.example.desafio1Hibernate.services.ContratoServiceI;

@SpringBootApplication
public class Desafio1HibernateApplication implements CommandLineRunner {

	@Autowired
	private ClienteServiceI clienteService;

	@Autowired
	private ContratoServiceI contratoService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creacion clientes
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

		// Creacion Contratos
		// Fechas
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(new Date());
		Date dateCaducidad = format.parse("2021-12-01");
		Date dateVigencia = format.parse(dateString);

		Contrato contrato1 = new Contrato();
		contrato1.setPrecio_mensual(2155.4);
		contrato1.setFecha_caducidad(dateCaducidad);
		contrato1.setFecha_vigencia(dateVigencia);
		contrato1.setCliente(cliente1);

		Contrato contrato2 = new Contrato();
		contrato2.setPrecio_mensual(1250.5);
		contrato2.setFecha_caducidad(dateCaducidad);
		contrato2.setFecha_vigencia(dateVigencia);
		contrato2.setCliente(cliente2);

		// Creacion de la lista, Adicion a la lista y Asignacion al Cliente
		List<Contrato> listaContratos = new ArrayList<>();
		listaContratos.add(contrato1);
		listaContratos.add(contrato2);
		cliente1.setListaContratos(listaContratos);
		cliente2.setListaContratos(listaContratos);
		// Insertar Clientes
		clienteService.insertarCliente(cliente1);
		Long id2 = clienteService.insertarCliente(cliente2);

		// Insercion Contratos
		contratoService.insertarContrato(contrato1);
		Long id2_contrato = contratoService.insertarContrato(contrato2);

		// Listar Clientes
		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes = clienteService.listarClientes();
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getNombre());
		}

		// Modificar -- Dejo de funcionar cuando se le añadio el campo contrato
		// Cliente cliente_modificar = clienteService.buscarPorId(id2);
		// cliente_modificar.setNombre("Rafael");
		// clienteService.modificarCliente(cliente_modificar);

		// Buscar por Apellidos y Nombre
		Cliente clientePorApellidosYNombre = clienteService.buscarPorNombreApellidos(cliente1.getNombre(),
				cliente1.getPrimer_apellido(), cliente1.getSegundo_apellido());

		System.out.println(clientePorApellidosYNombre.getNombre());

		// Borrar Cliente
		// clienteService.borrarCliente(cliente2);

		//Buscar por IdContrato
		Contrato contratoPorId = contratoService.findById(id2_contrato);
		System.out.println(contratoPorId.getFecha_caducidad());
		
		// Listar Contratos
				List<Contrato> listContratos = new ArrayList<>();
				listContratos = contratoService.listarContratos();
				for (int i = 0; i < listContratos.size(); i++) {
					System.out.println(listContratos.get(i).getId());
				}
				
		//Actualizar Contrato --No funciona 
			/*
			Date dateCaducidadModificar = format.parse("2021-11-10");
			Contrato contrato_modificar = contratoService.findById(id2_contrato);
			contrato_modificar.setFecha_caducidad(dateCaducidadModificar);
			contratoService.modificarContratos(contrato_modificar);
			*/
			
			//Buscar por id Cliente
			Contrato contrato_cliente = contratoService.findByIdCliente(cliente2.getId());
			System.out.println(contrato_cliente.getFecha_caducidad());
			
			//Borrar Contrato
			//contratoService.borrarContrato(contrato2);
			
	}

}
