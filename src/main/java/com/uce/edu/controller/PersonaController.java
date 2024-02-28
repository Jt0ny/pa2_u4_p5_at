package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//cuando viaja el modelo en el response
	//Path
	//GET
	//http://localhost:8080/personas/buscarPorCedula/1223
	@GetMapping("/buscarPorCedula/{cedulaPersona}")
	public String buscarPorCedula(@PathVariable("cedulaPersona")String cedula,Model modelo) {
		Persona persona=this.iPersonaService.buscarPorCedula(cedula);
		modelo.addAttribute("persona",persona);
		return "vistaPersona";
	}
	
	//PUT
	//cuando viaja el modelo en el request(es decir desde la vista)
	@PutMapping("/actualizar/{cedulaPersona}")
	public String actualizar (@PathVariable("cedulaPersona")String cedula,Persona persona) {
		Persona perAux=this.iPersonaService.buscarPorCedula(cedula);
		perAux.setApellido(persona.getApellido());
		perAux.setCedula(persona.getCedula());
		perAux.setGenero(persona.getGenero());
		perAux.setNombre(persona.getNombre());
		this.iPersonaService.actualizar(perAux);
		return "redirect:/personas/buscarTosdos";
	}
	
	//DELETE
	@DeleteMapping("/borrar/{cedula}")
	public String borrar(@PathVariable("cedula")String cedula) {
		this.iPersonaService.eliminarPorCedula(cedula);
		return "redirect:/personas/buscarTosdos";
	}
	
	//POST
	@PostMapping("/guardar")
	private String guardar(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "redirect:/personas/buscarTosdos";
	}

	//Para poder ver la pagina vacia
	//http://localhost:8080/personas/nuevaPersona
	@GetMapping("/nuevaPersona")
	public String mostrarNuevaPersona(Model modelo) {
		modelo.addAttribute("persona",new Persona());
		return "vistaNuevaPersona";
	}
}
