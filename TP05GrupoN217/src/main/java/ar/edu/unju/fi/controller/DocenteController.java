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
import ar.edu.unju.fi.service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {

	@Autowired
	IDocenteService docenteServiceIMP;
	
	@GetMapping("/nuevo")
	public ModelAndView getFormDocente() {        //aqui el nombre del html
		ModelAndView mov = new ModelAndView("docente-form");
		mov.addObject("docenteForm", new Docente());
		mov.addObject("band", true);
		return mov;	
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView guardarDocente(@ModelAttribute("docenteForm") Docente auxDocente) {
		ModelAndView mov = new ModelAndView("redirect:/docente/lista"); //aqui va el nombreDelHTML que quiero ver luego de presionarBOTON
		docenteServiceIMP.agregarDocente(auxDocente);
		//AlumnoCollections.agregarObjeto(auxAlumno);
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		//System.out.println(auxAlumno);
		return mov;
	}
	
	@GetMapping("/lista")
	public ModelAndView getListaDocente() {
		ModelAndView mov = new ModelAndView("docente-list");
		//mov.addObject("listaDeDocentes",docenteServiceIMP.listarDocentes());
		mov.addObject("listaDeDocentes",docenteServiceIMP.listarDocenteDto());
		//mov.addObject("listaDeAlumnos", AlumnoCollections.listarObjetos());
		return mov;
	}
	

	@GetMapping("/eliminar/{id}")
	public ModelAndView eliminarDocente(@PathVariable("id")int _id) {
		ModelAndView mov = new ModelAndView("redirect:/docente/lista");
		docenteServiceIMP.eliminarDocente(_id);
		//AlumnoCollections.eliminarObjeto(dni);
		return mov;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarDocente(@PathVariable("id")int id) {
		ModelAndView mov = new ModelAndView("docente-form");
		mov.addObject("docenteForm",docenteServiceIMP.buscarDocente(id));
		mov.addObject("band", false);
		return mov;
	}
	@PostMapping("/modificarDocente")
	public ModelAndView modificarDocente(@ModelAttribute("docenteForm") Docente docente) {
		ModelAndView mov = new ModelAndView("redirect:/docente/lista");	
		System.out.println("id docente mod");
		System.out.println(docente);
		docenteServiceIMP.modificarDocente(docente, docente.getId());
		//AlumnoCollections.modificarObjeto(alumno, alumno.getDni());
		return mov;
	}
	
	
	
}
