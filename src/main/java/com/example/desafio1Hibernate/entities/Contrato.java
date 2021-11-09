package com.example.desafio1Hibernate.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Contrato")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CONTRATO", nullable=false)
	private Long id;
	
	@DateTimeFormat(pattern="yyy/MM/dd")
	@Column(name="FECHA_VIGENCIA", nullable=false)
	private Date fecha_vigencia;

	@Column(name = "FECHA_CADUCIDAD")
	@DateTimeFormat(pattern="yyy/MM/dd")
	private Date fecha_caducidad;
	
	
	@Column(name = "PRECIO_MENSUAL")
	private Double precio_mensual;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	private Cliente cliente;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_vigencia() {
		return fecha_vigencia;
	}

	public void setFecha_vigencia(Date fecha_vigencia) {
		this.fecha_vigencia = fecha_vigencia;
	}

	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public Double getPrecio_mensual() {
		return precio_mensual;
	}

	public void setPrecio_mensual(Double precio_mensual) {
		this.precio_mensual = precio_mensual;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
