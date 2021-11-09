package com.example.desafio1Hibernate.entities;

import java.util.List;

public interface ContratoDaoI {
	
	public Long insertarContrato(Contrato contrato);

	public List<Contrato> listarContratos();
	
	public void modificarContratos(Contrato contrato);
	
	public void borrarContrato(Contrato contrato);
	
	public Contrato findByIdCliente(Long idCliente);
	
	public Contrato findById(Long id);

}
