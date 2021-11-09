package com.example.desafio1Hibernate.services;

import java.util.List;

import com.example.desafio1Hibernate.entities.Cliente;

public interface ClienteServiceI {
	
	public Long insertarCliente(Cliente cliente);
	public List<Cliente> listarClientes();
	public void modificarCliente(Cliente cliente);
	public Cliente buscarPorId(long id);
	public Cliente buscarPorNombreApellidos(String nombre, String apellidos1, String apellidos2);
	public void borrarCliente(Cliente cliente);
}
