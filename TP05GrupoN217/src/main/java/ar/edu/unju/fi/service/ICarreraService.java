package ar.edu.unju.fi.service;
import java.util.List;

import ar.edu.unju.fi.dto.CarreraDto;
import ar.edu.unju.fi.model.Carrera;


public interface ICarreraService {

	public void agregarCarrera(Carrera carrera);
	public List<Carrera> listarCarreras(boolean estado);
	public Carrera buscarCarrera(int id);
	public void modificarCarrera(Carrera carrera);
	public void eliminarCarrera(int id);
	
	public List<CarreraDto> listarCarreraDto(boolean estado);
}
