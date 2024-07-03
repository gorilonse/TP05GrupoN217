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
		
		iCarreraRepositorio.save(carrera);
	}

	@Override
	public List<Carrera> listarCarreras(boolean estado) {
		// TODO Auto-generated method stub
		return iCarreraRepositorio.findCarreraByEstado(estado);
	}

	@Override
	public Carrera buscarCarrera(int id) {
		// TODO Auto-generated method stub
		return iCarreraRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarCarrera(Carrera carrera) {
		
		iCarreraRepositorio.updateCarrera(carrera.getId(),carrera.getCodigo(), carrera.isEstado(), carrera.getCantidadDeAnios(), carrera.getNombre());
		//iCarreraRepositorio.save(carrera);
	}

	@Override
	public void eliminarCarrera(int id) {
		
//		Carrera auxCarrera = new Carrera();
//		auxCarrera=buscarCarrera(id);
//		System.out.println(auxCarrera);
//		iCarreraRepositorio.delete(auxCarrera);
		
		Carrera carrera = iCarreraRepositorio.findById(id).orElse(null);
		System.out.println(carrera.getNombre());
		if (carrera != null) {
			carrera.setEstado(false); 
			iCarreraRepositorio.save(carrera);
		}
		
	}

	@Override
	public List<CarreraDto> listarCarreraDto(boolean estado) {
		// TODO Auto-generated method stub
		return iCarreraMapDto.convertirListaCarreraAlistaCarreraDto(listarCarreras(estado));
	}
	
	
}
