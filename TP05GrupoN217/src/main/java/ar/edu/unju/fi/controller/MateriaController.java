package ar.edu.unju.fi.controller;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import org.hibernate.engine.spi.ManagedEntity;
import org.hibernate.event.internal.PostDeleteEventListenerStandardImpl;
import org.hibernate.sql.ast.tree.from.CorrelatedPluralTableGroup;
import org.springframework.aop.config.AbstractInterceptorDrivenBeanDefinitionDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
import jakarta.validation.Valid;

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
		mov.addObject("listaCarreras",iCarreraServiceIMP.listarCarreras(true));
		mov.addObject("modalidad",Modalidad.values());
		mov.addObject("band", true);
		return mov;	
	} 
	
	@PostMapping("/guardarMateria")
	public ModelAndView guardarMateria(@Valid @ModelAttribute("materiaForm") Materia auxMateria, BindingResult result) {

		
		
		ModelAndView mov;
		if(result.hasErrors()) {
			mov = new ModelAndView("materia-form");
			mov.addObject("band", true);
			mov.addObject("listaDocentes",iDocenteServiceIMP.listarDocentes());
			mov.addObject("listaCarreras",iCarreraServiceIMP.listarCarreras(true));
			mov.addObject("modalidad",Modalidad.values());
		}else {
			materiaServiceIMP.agregarMateria(auxMateria);
			mov = new ModelAndView("redirect:/materia/lista");
		}
		
		
		//AlumnoCollections.agregarObjeto(auxAlumno);
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		//System.out.println(auxAlumno);
		return mov;
	}
	
	@GetMapping("/lista")
	public ModelAndView getListaMateria() {
		ModelAndView mov = new ModelAndView("materia-list");
		//mov.addObject("listaDeMaterias",materiaServiceIMP.listarMaterias());
		mov.addObject("listaDeMaterias",materiaServiceIMP.listarMateriasDto());
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		
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
		mov.addObject("listaCarreras",iCarreraServiceIMP.listarCarreras(true));
		mov.addObject("modalidad",Modalidad.values());
		mov.addObject("band", false);
		return mov;
	}
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@Valid @ModelAttribute("materiaForm") Materia materia,BindingResult result) {
		
		//AlumnoCollections.modificarObjeto(alumno, alumno.getDni());
		
		
		ModelAndView mov;
		if(result.hasErrors()) {
			mov = new ModelAndView("materia-form");
			mov.addObject("listaDocentes",iDocenteServiceIMP.listarDocentes());
			mov.addObject("listaCarreras",iCarreraServiceIMP.listarCarreras(true));
			mov.addObject("modalidad",Modalidad.values());
			mov.addObject("band", false); // TRUE crea un nuevo elemento pero en FALSE permite modificar/Corregir el error, ver el HTML
		}else {
			materiaServiceIMP.modificarMateria(materia, materia.getId());
			mov = new ModelAndView("redirect:/materia/lista");	
		}
		return mov;
	}
}
