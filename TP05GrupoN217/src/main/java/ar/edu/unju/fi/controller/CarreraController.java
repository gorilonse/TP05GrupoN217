package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.CarreraDto;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.service.ICarreraService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	ICarreraService carreraServiceIMP;
	@Autowired
	CarreraDto carreraDto;
	
	@GetMapping("/nuevo")
	public ModelAndView getFormCarrera() {        //aqui el nombre del html
		ModelAndView mov = new ModelAndView("carrera-form");
		mov.addObject("carreraForm", carreraDto);
		mov.addObject("band", true);
		return mov;	
	}
	
	@PostMapping("/guardarCarrera")      
	public ModelAndView guardarCarrera(@Valid @ModelAttribute("carreraForm") Carrera auxCarrera, BindingResult result){
		//ModelAndView mov = new ModelAndView("redirect:/carrera/lista"); //aqui va el nombreDelHTML que quiero ver luego de presionarBOTON
        
        ModelAndView mov;
        if(result.hasErrors()) {
        	System.out.println("Se encontraron errores");
    		mov= new ModelAndView("carrera-form");
    		mov.addObject("band", true);
        }else {
        	System.out.println("Sin errores");
        	carreraServiceIMP.agregarCarrera(auxCarrera);
        	mov= new ModelAndView("redirect:/carrera/lista");
        }
        return mov;
	}
	
	@GetMapping("/lista")
	public ModelAndView getListaCarrera() {
		ModelAndView mov = new ModelAndView("carrera-list");
		//mov.addObject("listaCarreras",carreraServiceIMP.listarCarreras());
		             //"listaCarreras" se vincula a la vista "HTML"
		mov.addObject("listaCarreras",carreraServiceIMP.listarCarreraDto(true));
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		return mov;
	}
	
	@GetMapping("/listarInactivas")
    public ModelAndView listarCarrerasInactivas() {
       
        ModelAndView mov = new ModelAndView("carrera-list");
        mov.addObject("listaCarreras", carreraServiceIMP.listarCarreraDto(false));
        return mov;
    }

	

	@GetMapping("/eliminar/{id}")
	public ModelAndView eliminarCarrera(@PathVariable("id")int _id) {
		ModelAndView mov = new ModelAndView("redirect:/carrera/lista");
		carreraServiceIMP.eliminarCarrera(_id);
		//AlumnoCollections.eliminarObjeto(dni);
		return mov;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarCarrera(@PathVariable("id")int id) {
		ModelAndView mov = new ModelAndView("carrera-form");
		mov.addObject("carreraForm",carreraServiceIMP.buscarCarrera(id));
		mov.addObject("band", false);
		return mov;
	}
	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarrera(@Valid @ModelAttribute("carreraForm") Carrera carrera, BindingResult result) {
	
		
		
		ModelAndView mov;
        if(result.hasErrors()) {
    		mov= new ModelAndView("carrera-form");
    		mov.addObject("band", false);
        }else {
    		carreraServiceIMP.modificarCarrera(carrera);
        	mov=new ModelAndView("redirect:/carrera/lista");	
        }
		
		
		//AlumnoCollections.modificarObjeto(alumno, alumno.getDni());
		return mov;
	}
	
}
