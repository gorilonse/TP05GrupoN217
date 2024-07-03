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
	public ModelAndView guardarCarrera(@ModelAttribute("carreraForm") Carrera auxCarrera, BindingResult result)throws Exception {
		//ModelAndView mov = new ModelAndView("redirect:/carrera/lista"); //aqui va el nombreDelHTML que quiero ver luego de presionarBOTON
        
        ModelAndView mav;
        if(result.hasErrors()) {
        	mav= new ModelAndView("carrera-form");
        }else {
        	carreraServiceIMP.agregarCarrera(auxCarrera);
        	mav= new ModelAndView("redirect:/carrera/lista");
        }
        return mav;
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
	public ModelAndView modificarCarrera(@ModelAttribute("carreraForm") Carrera carrera) {
	
		ModelAndView mov = new ModelAndView("redirect:/carrera/lista");	
		
		carreraServiceIMP.modificarCarrera(carrera);
		//AlumnoCollections.modificarObjeto(alumno, alumno.getDni());
		return mov;
	}
	
}
