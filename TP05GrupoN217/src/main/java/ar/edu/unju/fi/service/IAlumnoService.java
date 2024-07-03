package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDto;
import ar.edu.unju.fi.model.Alumno;

public interface IAlumnoService {

	public void agregarAlumno(Alumno alumno);
	public List<Alumno> listarAlumnos();
	public Alumno buscarAlumno(int _id);
	public void modificarAlumno(Alumno alumno, int _id);
	public void eliminarAlumno(int _id);
	public void inscribirAlumnoAMateria(int alumnoId, int materiaId);
	public List<AlumnoDto> listarAlumnoDto(); //aqui modifico cuando ago el DTO
	
	

	public List<Alumno> listarAlumnosPorCarrera(int carreraId);
	public List<Alumno> listarAlumnosPorMateria(int materiaId);
	
	public List<AlumnoDto> listarAlumnosPorCarreraDto(int carreraId);
	public List<AlumnoDto> listarAlumnosPorMateriaDto(int materiaId);
}
