package com.job.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.job.model.Nomina;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc

public class NominaTestMokito {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;	
	
    @Test
    public void addNomina() throws Exception {

        MvcResult resultadoAddNomina = mvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new NominaObjetoTest("88", "juan", 30,1))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists())
                .andReturn();

        //ResultadoPrestarTest resultadoPrestamo = 
        		objectMapper.readValue(resultadoAddNomina.getResponse().getContentAsString(), NominaObjetoTest.class);




    }	
	
}
