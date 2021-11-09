package com.example.desafio1Hibernate.entities;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoDaoImpl implements ContratoDaoI {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Long insertarContrato(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		Long idContrato = (Long) session.save(contrato);
		session.close();
		return idContrato;
	}

	@Override
	public List<Contrato> listarContratos() {
		Session session = entityManager.unwrap(Session.class);
		List<Contrato> listaContratos= (List<Contrato>) session.createQuery("FROM Contrato").getResultList();
		session.close();
		return listaContratos;
	}

	@Override
	public void modificarContratos(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(contrato);
		session.close();
	}

	@Override
	public void borrarContrato(Contrato contrato) {
		entityManager.remove(entityManager.merge(contrato));
	}

	@Override
	public Contrato findByIdCliente(Long idCliente) {
		Session session = entityManager.unwrap(Session.class);
		Contrato contrato = (Contrato) session.createQuery("FROM Contrato where cliente.id= " + idCliente).uniqueResult();
		session.close();
		return contrato;
	}

	@Override
	public Contrato findById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Contrato contrato = (Contrato) session.createQuery("FROM Contrato where id= " + id).uniqueResult();
		session.close();
		return contrato;
	}

}
