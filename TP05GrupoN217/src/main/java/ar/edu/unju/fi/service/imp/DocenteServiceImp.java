package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.mapper.IDocenteMapDto;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.IDocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;

@Service 
public class DocenteServiceImp implements IDocenteService{

	public final static Log LOGGER = LogFactory.getLog("DocenteServiceImp");
	@Autowired
	IDocenteRepository idocenteRepositorio;
	
	@Autowired
	IDocenteMapDto iDocenteMapDto;
	
	@Override
	public void agregarDocente(Docente docente) {
		LOGGER.info("docente guardado "+docente);
		idocenteRepositorio.save(docente);
		
	}

	@Override
	public List<Docente> listarDocentes() {
		LOGGER.info("listado de docentes "+idocenteRepositorio.findAll());
		return idocenteRepositorio.findAll();
	}

	@Override
	public Docente buscarDocente(int id) {
		LOGGER.info("docente encontrado "+idocenteRepositorio.findById(id).orElse(null));
		return idocenteRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarDocente(Docente docente, int id) {
		// TODO Auto-generated method stub
		LOGGER.info("docente a modificar "+docente);
		idocenteRepositorio.save(docente);
		LOGGER.info("docente modificado "+idocenteRepositorio.findById(id).orElse(null));
		
	}

	@Override
	public void eliminarDocente(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("docente a eliminar "+idocenteRepositorio.findById(id).orElse(null));
		idocenteRepositorio.delete(buscarDocente(id));
		//Docente auxDocente = new Docente();
		//auxDocente=buscarDocente(id);
		//idocenteRepositorio.delete(auxDocente);
	}

	
	@Override
	public List<DocenteDto> listarDocenteDto() {
		// TODO Auto-generated method stub
		LOGGER.info("listado de docentes "+iDocenteMapDto.convertirListaDocenteAlistaDocenteDto(listarDocentes()));
		return iDocenteMapDto.convertirListaDocenteAlistaDocenteDto(listarDocentes());
	}

}




