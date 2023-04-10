package com.job.job.service;

import org.springframework.http.ResponseEntity;

import com.job.job.model.Nomina;
import com.job.job.response.NominaResponseRest;

public interface INominaService {

	
	public ResponseEntity<NominaResponseRest> search();
	public ResponseEntity<NominaResponseRest> searchById(Long id);
	public ResponseEntity<NominaResponseRest> save(Nomina nomina);
	public ResponseEntity<NominaResponseRest> update(Nomina nomina,Long id);
	public ResponseEntity<NominaResponseRest> deleteById(Long id);
	
	
}
