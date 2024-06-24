package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.IDocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;

@Service 
public class DocenteServiceImp implements IDocenteService{

	@Autowired
	IDocenteRepository idocenteRepositorio;
	
	
	@Override
	public void agregarDocente(Docente docente) {
		// TODO Auto-generated method stub
		idocenteRepositorio.save(docente);
		
	}

	@Override
	public List<Docente> listarDocentes() {
		// TODO Auto-generated method stub
		return idocenteRepositorio.findAll();
	}

	@Override
	public Docente buscarDocente(int id) {
		// TODO Auto-generated method stub
		return idocenteRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarDocente(Docente docente, int id) {
		// TODO Auto-generated method stub
		idocenteRepositorio.save(docente);
		
	}

	@Override
	public void eliminarDocente(int id) {
		// TODO Auto-generated method stub
		idocenteRepositorio.delete(buscarDocente(id));
		//Docente auxDocente = new Docente();
		//auxDocente=buscarDocente(id);
		//idocenteRepositorio.delete(auxDocente);
	}

}




