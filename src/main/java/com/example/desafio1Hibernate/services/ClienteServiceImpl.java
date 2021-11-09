package com.example.desafio1Hibernate.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio1Hibernate.entities.Cliente;
import com.example.desafio1Hibernate.entities.ClienteDaoI;

@Service
public class ClienteServiceImpl implements ClienteServiceI {

	@Autowired
	private ClienteDaoI clienteDao;
	
	@Override
	public Long insertarCliente(Cliente cliente) {
		return clienteDao.insertarCliente(cliente);
	}

	@Override
	public List<Cliente> listarClientes() {
		return clienteDao.listarClientes();
	}

	@Override
	@Transactional
	public void modificarCliente(Cliente cliente) {
		clienteDao.modificarCliente(cliente);
	}

	@Override
	public Cliente buscarPorId(long id) {
		return clienteDao.findById(id);
	}

	@Override
	public Cliente buscarPorNombreApellidos(String nombre, String apellidos1, String apellidos2) {
		return clienteDao.findByNombreYApellidos(nombre, apellidos1, apellidos2);
	}

	@Override
	@Transactional
	public void borrarCliente(Cliente cliente) {
		clienteDao.borrarCliente(cliente);
		
	}

}
