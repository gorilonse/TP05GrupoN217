package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping("/alumno")
public class AlumnoConrtoller {
	@Autowired
	IAlumnoService alumnoServiceIMP;
	@Autowired
	ICarreraService iCarreraServiceIMP;
	@Autowired
	IMateriaService materiaServiceIMP;
	
	@GetMapping("/nuevo")
	public ModelAndView getFormAlumno() {        //aqui el nombre del html
		ModelAndView mov = new ModelAndView("alumno");
		mov.addObject("alumnoForm", new Alumno());
		mov.addObject("listaCarreras",iCarreraServiceIMP.listarCarreras(true));
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
		mov.addObject("listaCarreras",iCarreraServiceIMP.listarCarreras(true));
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
	
	
	@GetMapping("/inscribir/{id}")
	public ModelAndView inscribirAlumno(@PathVariable("id")int id) {
		ModelAndView mov = new ModelAndView("inscripcion-list");
		Alumno alumno = alumnoServiceIMP.buscarAlumno(id);
		// Obtener los IDs de las materias a las que el alumno ya está inscrito
	    
		/*List<Integer> materiasInscritasIds = alumno.getMaterias().stream()
	                                              .map(Materia::getId)
	                                              .collect(Collectors.toList());
	    */
	    List<Integer> materiasInscritasIds = new ArrayList<Integer>();
	    for (Materia materia : alumno.getMaterias()) {
	    	materiasInscritasIds.add(materia.getId());
		}
	    
	    
	    
	    mov.addObject("materiasInscritasIds", materiasInscritasIds); 
		mov.addObject("alumnoForm",alumno);
		mov.addObject("listaDeMaterias",materiaServiceIMP.listarMateriasPorCarreraDto(alumno.getCarrera().getId()));
		
		return mov;
	}
	
	@GetMapping("/inscribirAlumno/{alu_id}/{mat_id}")
	public ModelAndView inscribirAlumno(@PathVariable("alu_id") int aluId, @PathVariable("mat_id") int matId) {
		ModelAndView mov = new ModelAndView("redirect:/alumno/inscribir/" + aluId);
		alumnoServiceIMP.inscribirAlumnoAMateria(aluId, matId);
		return mov;
	}
	
	
	@GetMapping("/carrera/{id}")
	public ModelAndView listarAlumnosPorCarrera(@PathVariable("id") int carreraId) {
	    ModelAndView mov = new ModelAndView("alumno-list");
	    List<Alumno> alumnosPorCarrera = alumnoServiceIMP.listarAlumnosPorCarrera(carreraId);
	    mov.addObject("listaDeAlumnos", alumnosPorCarrera);
	    return mov;
	}
	
	@GetMapping("/materia/{id}")
	public ModelAndView listarAlumnosPorMateria(@PathVariable("id") int materiaId) {
	    ModelAndView mov = new ModelAndView("alumno-list");
	    List<Alumno> alumnosPorMateria = alumnoServiceIMP.listarAlumnosPorMateria(materiaId);
	    mov.addObject("listaDeAlumnos", alumnosPorMateria);
	    return mov;
	}
		
}
