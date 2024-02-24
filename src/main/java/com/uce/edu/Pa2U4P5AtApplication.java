package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.service.IPersonaService;

@SpringBootApplication
public class Pa2U4P5AtApplication implements CommandLineRunner{

	
	@Autowired
	private IPersonaService iPersonaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U4P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Persona p1= new Persona();
		p1.setCedula("123");
		p1.setApellido("Tipan");
		p1.setNombre("Anthony");
		p1.setGenero("M");
		this.iPersonaService.guardar(p1);
		
		Persona p2= new Persona();
		p2.setCedula("123");
		p2.setApellido("Tipan");
		p2.setNombre("Anthony");
		p2.setGenero("M");
		this.iPersonaService.guardar(p2);
		
	}

}
