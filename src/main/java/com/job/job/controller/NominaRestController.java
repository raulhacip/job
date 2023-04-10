package com.job.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.job.model.Nomina;
import com.job.job.response.NominaResponseRest;
import com.job.job.service.INominaService;

@RestController
@RequestMapping("/api/job")
public class NominaRestController {
	
	@Autowired
	INominaService nominaService;
	
	@GetMapping("/nomina")
	public ResponseEntity <NominaResponseRest> searchNomina(){
		ResponseEntity<NominaResponseRest> response = nominaService.search(); 
		return response;
	}
	
	@PostMapping("/nomina")
	public ResponseEntity <NominaResponseRest> save(@RequestBody Nomina nomina){
		ResponseEntity<NominaResponseRest> response = nominaService.save(nomina);
		return response;
	}

	@GetMapping("/nomina/{id}")
	public ResponseEntity <NominaResponseRest> searchNominaById(@PathVariable Long id){
		ResponseEntity<NominaResponseRest> response = nominaService.searchById(id);
		return response;
	}	
	
}
