package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoConrtoller {
	@Autowired
	IAlumnoService alumnoServiceIMP;
	
	@GetMapping("/nuevo")
	public ModelAndView getFormAlumno() {        //aqui el nombre del html
		ModelAndView mov = new ModelAndView("alumno");
		mov.addObject("alumnoForm", new Alumno());
		mov.addObject("band", true);
		return mov;	
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoForm") Alumno auxAlumno) {
		ModelAndView mov = new ModelAndView("redirect:/alumno/lista"); //aqui va el nombreDelHTML que quiero ver luego de presionarBOTON
		alumnoServiceIMP.agregarAlumno(auxAlumno);
		//AlumnoCollections.agregarObjeto(auxAlumno);
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		//System.out.println(auxAlumno);
		return mov;
	}
	
	@GetMapping("/lista")
	public ModelAndView getListaAlumnos() {
		ModelAndView mov = new ModelAndView("alumno-list");
		//mov.addObject("listaDeAlumnos",alumnoServiceIMP.listarAlumnos());
		mov.addObject("listaDeAlumnos",alumnoServiceIMP.listarAlumnoDto());
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		return mov;
	}
	

	@GetMapping("/eliminar/{id}")
	public ModelAndView eliminarAlumno(@PathVariable("id")int _id) {
		ModelAndView mov = new ModelAndView("redirect:/alumno/lista");
		alumnoServiceIMP.eliminarAlumno(_id);
		//AlumnoCollections.eliminarObjeto(dni);
		return mov;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarrAlumno(@PathVariable("id")int id) {
		ModelAndView mov = new ModelAndView("alumno");
		mov.addObject("alumnoForm",alumnoServiceIMP.buscarAlumno(id));
		mov.addObject("band", false);
		return mov;
	}
	@PostMapping("/modificarAlumno")
	public ModelAndView modificarAlumno(@ModelAttribute("alumnoForm") Alumno alumno) {
		ModelAndView mov = new ModelAndView("redirect:/alumno/lista");
		System.out.println("id alumno mod");
		System.out.println(alumno);
		alumnoServiceIMP.modificarAlumno(alumno, alumno.getId());
		//AlumnoCollections.modificarObjeto(alumno, alumno.getDni());
		return mov;
	}
	

}
