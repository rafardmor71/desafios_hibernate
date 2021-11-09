package com.example.desafio1Hibernate.entities;

import java.util.List;

public interface ClienteDaoI {
	public Long insertarCliente(Cliente cliente);
	
	public List<Cliente> listarClientes();
	
	public void modificarCliente(Cliente cliente);
	
	public void borrarCliente(Cliente cliente);
	
	public Cliente findByNombreYApellidos(String nombre, String apellido1, String apellido2);
	
	public Cliente findById(Long id);
}
