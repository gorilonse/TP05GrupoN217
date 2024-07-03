package ar.edu.unju.fi.service;
import java.util.List;

import ar.edu.unju.fi.dto.MateriaDto;
import ar.edu.unju.fi.model.Materia;


public interface IMateriaService {

	public void agregarMateria(Materia materia);
	public List<Materia> listarMaterias();
	public Materia buscarMateria(int id);
	public void modificarMateria(Materia materia, int id);
	public void eliminarMateria(int id);
	
	public List<Materia>listarMateriasPorCarrera(int carreraId);
	
	public List<MateriaDto> listarMateriasDto();
	public List<MateriaDto>listarMateriasPorCarreraDto(int carreraId);
}
