package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDto;
import ar.edu.unju.fi.mapper.IMateriaMapDto;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.IMateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service
public class MateriaServiceImp implements IMateriaService{

	//public final static Log //LOGGER = LogFactory.getLog("MateriaServiceImp");
	@Autowired
	IMateriaRepository imateriaRepositorio;
	
	@Autowired
	IMateriaMapDto iMateriaMapDto;
	
	@Override
	public void agregarMateria(Materia materia) {
		// TODO Auto-generated method stub
		//LOGGER.info("materia guardada "+materia);
		imateriaRepositorio.save(materia);
	}

	@Override
	public List<Materia> listarMaterias() {
		// TODO Auto-generated method stub
		//LOGGER.info("lista de materias "+imateriaRepositorio.findAll());
		return imateriaRepositorio.findAll();
	}

	@Override
	public Materia buscarMateria(int id) {
		// TODO Auto-generated method stub
		//LOGGER.info("materia encontrada "+imateriaRepositorio.findById(id).orElse(null));
		return imateriaRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarMateria(Materia materia, int id) {
		// TODO Auto-generated method stub
		materia.setId(id);
		//LOGGER.info("materia a modificar "+materia);
		imateriaRepositorio.save(materia);
		//LOGGER.info("materia modificada "+imateriaRepositorio.findById(id).orElse(null));
		
	}

	@Override
	public void eliminarMateria(int id) {
		// TODO Auto-generated method stub
		Materia auxMateria =new Materia();
		auxMateria=buscarMateria(id);
		//LOGGER.info("materia a eliminar "+imateriaRepositorio.findById(id).orElse(null));
		imateriaRepositorio.delete(auxMateria);
	}

	//LO NUEVO DE DTO abajo
	@Override
	public List<MateriaDto> listarMateriasDto() {
		// TODO Auto-generated method stub
		//LOGGER.info("lista de materias dto "+iMateriaMapDto.convertirListaMateriaAlistaMateriaDto(listarMaterias()));
		return iMateriaMapDto.convertirListaMateriaAlistaMateriaDto(listarMaterias());
	}

	@Override
	public List<Materia> listarMateriasPorCarrera(int carreraId) {
		// TODO Auto-generated method stub
		//LOGGER.info("lista de materia segun carrera "+imateriaRepositorio.findByCarrera(carreraId));
		return imateriaRepositorio.findByCarrera(carreraId);
	}

	@Override
	public List<MateriaDto> listarMateriasPorCarreraDto(int carreraId) {
		// TODO Auto-generated method stub
		//LOGGER.info("lista de materias por carrera (dto) "+iMateriaMapDto.convertirListaMateriaAlistaMateriaDto(listarMateriasPorCarrera(carreraId)));
		return  iMateriaMapDto.convertirListaMateriaAlistaMateriaDto(listarMateriasPorCarrera(carreraId));
	}
	
	
	
	
	
}
