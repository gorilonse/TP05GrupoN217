package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDto;
import ar.edu.unju.fi.mapper.IAlumnoMapDto;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.IAlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;


@Service //indicamos que funciona como servicio.
public class AlumnoServiceImp implements IAlumnoService {
	
	@Autowired  //esto indica q se usa inyeccion de dependencia.
	IAlumnoRepository ialumnoRepositorio;
	@Autowired
	IAlumnoMapDto iAlumnoMapDto;
	
	@Override
	public void agregarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		ialumnoRepositorio.save(alumno);
		
	}

	@Override
	public List<Alumno> listarAlumnos() {
		// TODO Auto-generated method stub
		return ialumnoRepositorio.findAll();
	}

	@Override
	public Alumno buscarAlumno(int id) {
		// TODO Auto-generated method stub
		return ialumnoRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarAlumno(Alumno alumno, int id) {
		// TODO Auto-generated method stub
		alumno.setId(id);
		System.out.println(alumno);
		ialumnoRepositorio.save(alumno);

	}

	@Override
	public void eliminarAlumno(int id) {
		// TODO Auto-generated method stub
		Alumno auxAlumno = new Alumno();
		auxAlumno=buscarAlumno(id);
		System.out.println(auxAlumno);
		ialumnoRepositorio.delete(auxAlumno);
	}

	//LO NUEVO DE DTO abajo
	@Override
	public List<AlumnoDto> listarAlumnoDto() {
		// TODO Auto-generated method stub
		return iAlumnoMapDto.convertirListaAlumnoAlistaAlumnoDtos(listarAlumnos());
	}

}
