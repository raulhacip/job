package com.job.job;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

public class NominaObjetoTest implements Serializable {
	
	private int id;
	private String documento;
	private String nombre;
	private int diastrabajados;
	private int tipotrabajador;
	private double valorpagar;
	private Timestamp fechaRegistro;
	public NominaObjetoTest(String documento, String nombre, int diastrabajados, int tipotrabajador) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.diastrabajados = diastrabajados;
		this.tipotrabajador = tipotrabajador;
		this.fechaRegistro = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	}	
	

}
