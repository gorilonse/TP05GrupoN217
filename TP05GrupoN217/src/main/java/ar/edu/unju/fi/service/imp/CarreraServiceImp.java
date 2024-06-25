package ar.edu.unju.fi.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDto;
import ar.edu.unju.fi.mapper.ICarreraMapDto;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.ICarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;


@Service 
public class CarreraServiceImp implements ICarreraService{
	
	@Autowired
	ICarreraRepository iCarreraRepositorio;

	@Autowired
	ICarreraMapDto iCarreraMapDto;
	
	@Override
	public void agregarCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		iCarreraRepositorio.save(carrera);
	}

	@Override
	public List<Carrera> listarCarreras() {
		// TODO Auto-generated method stub
		return iCarreraRepositorio.findAll();
	}

	@Override
	public Carrera buscarCarrera(int id) {
		// TODO Auto-generated method stub
		return iCarreraRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarCarrera(Carrera carrera, int id) {
		// TODO Auto-generated method stub
		iCarreraRepositorio.save(carrera);
	}

	@Override
	public void eliminarCarrera(int id) {
		// TODO Auto-generated method stub
		Carrera auxCarrera = new Carrera();
		auxCarrera=buscarCarrera(id);
		System.out.println(auxCarrera);
		iCarreraRepositorio.delete(auxCarrera);
		
	}

	@Override
	public List<CarreraDto> listarCarreraDto() {
		// TODO Auto-generated method stub
		return iCarreraMapDto.convertirListaCarreraAlistaCarreraDto(listarCarreras());
	}
	
	
}
