package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public interface IAlumnoService {

	public void agregarAlumno(Alumno alumno);
	public List<Alumno> listarAlumnos();
	public Alumno buscarAlumno(int _id);
	public void modificarAlumno(Alumno alumno, int _id);
	public void eliminarAlumno(int _id);
	
	
}
