package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.IMateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service
public class MateriaServiceImp implements IMateriaService{
	
	@Autowired
	IMateriaRepository imateriaRepositorio;
	
	@Override
	public void agregarMateria(Materia materia) {
		// TODO Auto-generated method stub
		imateriaRepositorio.save(materia);
	}

	@Override
	public List<Materia> listarMaterias() {
		// TODO Auto-generated method stub
		return imateriaRepositorio.findAll();
	}

	@Override
	public Materia buscarMateria(int id) {
		// TODO Auto-generated method stub
		return imateriaRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarMateria(Materia materia, int id) {
		// TODO Auto-generated method stub
		materia.setId(id);
		imateriaRepositorio.save(materia);
		
	}

	@Override
	public void eliminarMateria(int id) {
		// TODO Auto-generated method stub
		Materia auxMateria =new Materia();
		auxMateria=buscarMateria(id);
		imateriaRepositorio.delete(auxMateria);
	}

	
}
