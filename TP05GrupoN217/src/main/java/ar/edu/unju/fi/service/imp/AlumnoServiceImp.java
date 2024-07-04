package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDto;
import ar.edu.unju.fi.mapper.IAlumnoMapDto;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.IAlumnoRepository;
import ar.edu.unju.fi.repository.IMateriaRepository;
import ar.edu.unju.fi.service.IAlumnoService;


@Service //indicamos que funciona como servicio.
public class AlumnoServiceImp implements IAlumnoService {

	public final static Log LOGGER = LogFactory.getLog("AlumnoServiceImp");
	
	
	@Autowired  //esto indica q se usa inyeccion de dependencia.
	IAlumnoRepository ialumnoRepositorio;
	@Autowired
	IAlumnoMapDto iAlumnoMapDto;
	
	@Autowired
	IMateriaRepository materiaRepository;
	
	@Override
	public void agregarAlumno(Alumno alumno) {
		ialumnoRepositorio.save(alumno);
		LOGGER.info("alumno guardado "+alumno);
	}

	@Override
	public List<Alumno> listarAlumnos() {
		LOGGER.info("alumnos listados "+ialumnoRepositorio.findAll());
		return ialumnoRepositorio.findAll();
	}

	@Override
	public Alumno buscarAlumno(int id) {

		LOGGER.info("alumno buscado "+ialumnoRepositorio.findById(id).orElse(null));
		return ialumnoRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarAlumno(Alumno alumno, int id) {
		alumno.setId(id);
		LOGGER.info("alumno a modificar "+alumno);
		ialumnoRepositorio.save(alumno);
		LOGGER.info("alumno modificado "+ialumnoRepositorio.findById(id).orElse(null));

	}

	@Override
	public void eliminarAlumno(int id) {
		Alumno auxAlumno = new Alumno();
		auxAlumno=buscarAlumno(id);
		System.out.println(auxAlumno);
		LOGGER.info("alumno eliminar "+ialumnoRepositorio.findById(id).orElse(null));
		ialumnoRepositorio.delete(auxAlumno);
	}

	//LO NUEVO DE DTO abajo
	@Override
	public List<AlumnoDto> listarAlumnoDto() {
		LOGGER.info("alumnos listados "+iAlumnoMapDto.convertirListaAlumnoAlistaAlumnoDtos(listarAlumnos()));
		return iAlumnoMapDto.convertirListaAlumnoAlistaAlumnoDtos(listarAlumnos());
	}

	@Override
	public void inscribirAlumnoAMateria(int alumnoId, int materiaId) {
		Alumno alumno = ialumnoRepositorio.findById(alumnoId).orElse(null);
	    Materia materia = materiaRepository.findById(materiaId).orElse(null);

		LOGGER.info("alumno "+ialumnoRepositorio.findById(alumnoId).orElse(null));
		LOGGER.info("materia "+materiaRepository.findById(materiaId).orElse(null));
	    alumno.getMaterias().add(materia);
	    ialumnoRepositorio.save(alumno);
	}

	@Override
	public List<Alumno> listarAlumnosPorCarrera(int carreraId) {
		LOGGER.info("alumnos listados "+ialumnoRepositorio.findByCarreraId(carreraId));
		return ialumnoRepositorio.findByCarreraId(carreraId);
	}

	@Override
	public List<Alumno> listarAlumnosPorMateria(int materiaId) {
		LOGGER.info("alumnos listados "+ialumnoRepositorio.findByMateriaId(materiaId));
		return ialumnoRepositorio.findByMateriaId(materiaId);
	}

	@Override
	public List<AlumnoDto> listarAlumnosPorCarreraDto(int carreraId) {
		LOGGER.info("alumnos listados "+iAlumnoMapDto.convertirListaAlumnoAlistaAlumnoDtos(listarAlumnosPorCarrera(carreraId)));
		return iAlumnoMapDto.convertirListaAlumnoAlistaAlumnoDtos(listarAlumnosPorCarrera(carreraId));
	}

	@Override
	public List<AlumnoDto> listarAlumnosPorMateriaDto(int materiaId) {
		LOGGER.info("alumnos listados "+iAlumnoMapDto.convertirListaAlumnoAlistaAlumnoDtos(listarAlumnosPorCarrera(materiaId)));
		return  iAlumnoMapDto.convertirListaAlumnoAlistaAlumnoDtos(listarAlumnosPorCarrera(materiaId));
	}

}
