package com.job.job;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.job.job.dao.INominaDao;
import com.job.job.model.Nomina;

@DataJpaTest
public class NominaTest {

	@Autowired 
	INominaDao nominaDao;
	
	@Test
	public void testSaveNomina() {
		Nomina nomina = new Nomina();
		nomina.setDiastrabajados(30);
		nomina.setDocumento("456700");
		nomina.setNombre("CAMILO GOMEZ");
		nomina.setTipotrabajador(1);
		nomina.setFechaRegistro( new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()) );
		nominaDao.save(nomina);
	}
	
}
