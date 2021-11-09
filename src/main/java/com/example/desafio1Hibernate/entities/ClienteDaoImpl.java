package com.example.desafio1Hibernate.entities;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDaoI {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Long insertarCliente(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		Long id = (Long) session.save(cliente);
		session.close();
		return id;
	}

	@Override
	public List<Cliente> listarClientes() {
		Session session = entityManager.unwrap(Session.class);
		List<Cliente> listaClientes = (List<Cliente>) session.createQuery("FROM Cliente").getResultList();
		session.close();
		return listaClientes;
	}

	@Override
	public void modificarCliente(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(cliente);
		session.close();
	}

	@Override
	public void borrarCliente(Cliente cliente) {
		entityManager.remove(entityManager.merge(cliente));
	}

	@Override
	public Cliente findById(Long idCliente) {
		Session session = entityManager.unwrap(Session.class);
		Cliente cliente = (Cliente) session.createQuery("FROM Cliente where id= " + idCliente).uniqueResult();
		session.close();
		return cliente;
	}

	@Override
	public Cliente findByNombreYApellidos(String nombre, String apellido1, String apellido2) {
		Session session = entityManager.unwrap(Session.class);
		Cliente cliente = (Cliente) session.createQuery("FROM Cliente c where c.nombre= '" + nombre + "' and c.primer_apellido='" + apellido1 + 
				"' and c.segundo_apellido='" + apellido2 + "'").uniqueResult();
		session.close();
		return cliente;
		
	}

}
