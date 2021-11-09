package com.example.desafio1Hibernate.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio1Hibernate.entities.Contrato;
import com.example.desafio1Hibernate.entities.ContratoDaoI;

@Service
public class ContratoServiceImpl implements ContratoServiceI {
	@Autowired
	private ContratoDaoI contratoDao;
	
	@Transactional
	@Override
	public Long insertarContrato(Contrato contrato) {
		return contratoDao.insertarContrato(contrato);
	}

	@Override
	public List<Contrato> listarContratos() {
		return contratoDao.listarContratos();
	}
	
	@Transactional
	@Override
	public void modificarContratos(Contrato contrato) {
		contratoDao.modificarContratos(contrato);
	}

	@Transactional
	@Override
	public void borrarContrato(Contrato contrato) {
		contratoDao.borrarContrato(contrato);
		
	}

	@Override
	public Contrato findByIdCliente(Long idCliente) {
		return contratoDao.findByIdCliente(idCliente);
	}

	@Override
	public Contrato findById(Long id) {		
		return contratoDao.findById(id);
	}

}
