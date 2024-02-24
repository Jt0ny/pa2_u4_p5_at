package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.service.IPersonaService;

//http://localhost:8080/personas/buscarTosdos
//http://localhost:8080/personas/actualizar

@Controller
@RequestMapping("/personas")//el recurso siempre en plural
public class PersonaController {
	
	@Autowired
	private IPersonaService iPersonaService;
	
	//los metodos tambien deben tener le path
	
	
	//Diferentes tipos de request
	//verbos o metodos HTTP
	
	//GET consulta de recursos
	//POST sirve para crear uno o varios recursos
	//PUT sirve para actualizar uno o varios recursos
	//DELETE sirve para eliminar uno o varios recursos
	//PATCH sirve para actualizar de manera parcial uno o varios recursos
	


	@GetMapping("/buscarTosdos")
	public String buscarTodos(Model modelo) {
		List<Persona> lista=this.iPersonaService.buscarTodos();			
		modelo.addAttribute("personas",lista);
		return"vistaListaPersonas";
	}
	
	//Path
	//GET
	@GetMapping("/buscar")
	public String buscarPorCedula(String cedula) {
		return "";
	}
	
	//PUT
	@PutMapping("/actualizar")
	public String actualizar () {
		return "";
	}
	
	//DELETE
	@DeleteMapping("/borrar")
	public String borrar() {
		return "";
	}
	
	//POST
	@PostMapping("/guardar")
	private String guardar() {
		return "";
	}

}
