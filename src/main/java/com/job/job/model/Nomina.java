package com.job.job.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="nomina" , schema = "job")
public class Nomina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7176940607314306539L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nomi_id", nullable = false)
	private int id;
	
	@Column(name = "nomi_documento", nullable = false)
	private String documento;
	
	@Column(name = "nomi_nombre", nullable = false)
	private String nombre;
	
	@Column(name = "nomi_diastrabajados", nullable = false)
	private int diastrabajados;
	
	@Column(name = "nomi_tipotrabajador", nullable = false)
	private int tipotrabajador;
	
	@Column(name = "nomi_valorpagar", nullable = false)
	private double valorpagar;

	@Column(name = "nomi_fecharegistro", nullable = false)
	private Timestamp fechaRegistro;

	@Override
	public String toString() {
		return "Nomina [id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", diastrabajados="
				+ diastrabajados + ", tipotrabajador=" + tipotrabajador + ", valorpagar=" + valorpagar
				+ ", fechaRegistro=" + fechaRegistro + "]";
	}
	
	
	
}
