package com.example.desafio1Hibernate.services;

import java.util.List;

import com.example.desafio1Hibernate.entities.Contrato;

public interface ContratoServiceI {

	public Long insertarContrato(Contrato contrato);

	public List<Contrato> listarContratos();
	
	public void modificarContratos(Contrato contrato);
	
	public void borrarContrato(Contrato contrato);
	
	public Contrato findByIdCliente(Long idCliente);
	
	public Contrato findById(Long id);
	
}
