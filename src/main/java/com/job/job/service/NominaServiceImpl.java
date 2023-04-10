package com.job.job.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.job.job.dao.INominaDao;
import com.job.job.model.Nomina;
import com.job.job.response.NominaResponseRest;
import com.job.job.util.Constantes;

@Service
public class NominaServiceImpl implements INominaService {

	@Autowired 
	INominaDao nominaDao;
	
	
	Constantes constantes = new Constantes();
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<NominaResponseRest> search() {
		
		NominaResponseRest response = new NominaResponseRest();
		
		try {
			
			List <Nomina> nomina = (List<Nomina>)nominaDao.findAll();
			response.getNominaResponse().setNomina(nomina);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		
			
		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<NominaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		return new ResponseEntity<NominaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<NominaResponseRest> searchById(Long id) {
		NominaResponseRest response = new NominaResponseRest();
		List <Nomina> lista = new ArrayList<>();
		try {
			
			Optional<Nomina> nomina = nominaDao.findById(id);
			if (nomina.isPresent()) {
				lista.add(nomina.get());
				response.getNominaResponse().setNomina(lista);
				response.setMetadata("Respuesta ok", "00", "registro encontrado");				
			}else {
				response.setMetadata("Respuesta nok", "-1", "No encontrado");
				return new ResponseEntity<NominaResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		
			
		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<NominaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		return new ResponseEntity<NominaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<NominaResponseRest> save(Nomina nomina) {
		NominaResponseRest response = new NominaResponseRest();
		List<Nomina> list = new ArrayList<>();
		try {
			double valorDia = constantes.salarioMinimo / 30;
			double calculoDia = 0;
			if (nomina.getTipotrabajador() == constantes.DESARROLLADOR) {
				calculoDia = valorDia * 5;
			}else if (nomina.getTipotrabajador() == constantes.SUPERVISOR) {
				calculoDia = valorDia * 8;
			}else if (nomina.getTipotrabajador() == constantes.GERENTE) {
				calculoDia = valorDia * 12;
			}
			double operacion = nomina.getDiastrabajados() * calculoDia;
			nomina.setValorpagar(operacion);
			nomina.setFechaRegistro( new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()) );
			
			nomina.toString();
			
			Nomina nominaguardar = nominaDao.save(nomina);
			if (nominaguardar != null) {
				list.add(nominaguardar);
				response.getNominaResponse().setNomina(list);
				response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");				
			}else {
				response.setMetadata("Respuesta ok", "-1", "Error guardando");
				return new ResponseEntity<NominaResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
			

		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<NominaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		return new ResponseEntity<NominaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<NominaResponseRest> update(Nomina nomina, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<NominaResponseRest> deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
