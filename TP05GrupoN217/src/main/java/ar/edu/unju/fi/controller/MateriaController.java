package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.numerado.Modalidad;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping ("/materia")
public class MateriaController {
	@Autowired
	IMateriaService materiaServiceIMP;
	@Autowired
	IDocenteService iDocenteServiceIMP;
	@Autowired
	ICarreraService iCarreraServiceIMP;
	
	@GetMapping("/nuevo")
	public ModelAndView getFormMateria() {        //aqui el nombre del html
		ModelAndView mov = new ModelAndView("materia-form");
		mov.addObject("materiaForm", new Materia());
		mov.addObject("listaDocentes",iDocenteServiceIMP.listarDocentes());
		mov.addObject("listaCarreras",iCarreraServiceIMP.listarCarreras());
		mov.addObject("modalidad",Modalidad.values());
		mov.addObject("band", true);
		return mov;	
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView guardarMateria(@ModelAttribute("materiaForm") Materia auxMateria) {
		ModelAndView mov = new ModelAndView("redirect:/materia/lista"); //aqui va el nombreDelHTML que quiero ver luego de presionarBOTON
		materiaServiceIMP.agregarMateria(auxMateria);
		//AlumnoCollections.agregarObjeto(auxAlumno);
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		//System.out.println(auxAlumno);
		return mov;
	}
	
	@GetMapping("/lista")
	public ModelAndView getListaMateria() {
		ModelAndView mov = new ModelAndView("materia-list");
		mov.addObject("listaDeMaterias",materiaServiceIMP.listarMaterias());
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		System.out.println(materiaServiceIMP.listarMaterias());
		return mov;
	}
	

	@GetMapping("/eliminar/{id}")
	public ModelAndView eliminarDocente(@PathVariable("id")int _id) {
		ModelAndView mov = new ModelAndView("redirect:/materia/lista");
		materiaServiceIMP.eliminarMateria(_id);
		//AlumnoCollections.eliminarObjeto(dni);
		return mov;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarMateria(@PathVariable("id")int id) {
		ModelAndView mov = new ModelAndView("materia-form");
		mov.addObject("materiaForm",materiaServiceIMP.buscarMateria(id));
		mov.addObject("listaDocentes",iDocenteServiceIMP.listarDocentes());
		mov.addObject("listaCarreras",iCarreraServiceIMP.listarCarreras());
		mov.addObject("modalidad",Modalidad.values());
		mov.addObject("band", false);
		return mov;
	}
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@ModelAttribute("materiaForm") Materia materia) {
		ModelAndView mov = new ModelAndView("redirect:/materia/lista");	
		System.out.println("id materia mod");
		System.out.println(materia);
		materiaServiceIMP.modificarMateria(materia, materia.getId());
		//AlumnoCollections.modificarObjeto(alumno, alumno.getDni());
		return mov;
	}
}
