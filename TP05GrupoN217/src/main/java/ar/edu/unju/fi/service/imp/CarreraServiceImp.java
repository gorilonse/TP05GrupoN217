package ar.edu.unju.fi.service.imp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDto;
import ar.edu.unju.fi.mapper.ICarreraMapDto;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.ICarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;


@Service 
public class CarreraServiceImp implements ICarreraService{

	public final static Log LOGGER = LogFactory.getLog("CarreraServiceImp");
	
	
	@Autowired
	ICarreraRepository iCarreraRepositorio;

	@Autowired
	ICarreraMapDto iCarreraMapDto;
	
	@Override
	public void agregarCarrera(Carrera carrera) {
		LOGGER.debug("Guardando carrera");
		iCarreraRepositorio.save(carrera);
		LOGGER.info("carrera guardada "+carrera);
	}

	@Override
	public List<Carrera> listarCarreras(boolean estado) {
		// TODO Auto-generated method stub
		LOGGER.debug("Listar carreras habilitadas");
		LOGGER.info("carreras listadas "+iCarreraRepositorio.findCarreraByEstado(estado).toString());
		return iCarreraRepositorio.findCarreraByEstado(estado);
	}

	@Override
	public Carrera buscarCarrera(int id) {
		LOGGER.debug("Buscar carrera");
		// TODO Auto-generated method stub
		LOGGER.info("carrera "+iCarreraRepositorio.findById(id).orElse(null));
		return iCarreraRepositorio.findById(id).orElse(null);
	}

	@Override
	public void modificarCarrera(Carrera carrera) {

		LOGGER.debug("Modificar carrera");
		LOGGER.info("carrera a modificar"+iCarreraRepositorio.findById(carrera.getId()).orElse(null));
		iCarreraRepositorio.updateCarrera(carrera.getId(),carrera.getCodigo(), carrera.isEstado(), carrera.getCantidadDeAnios(), carrera.getNombre());

		LOGGER.info("carrera a modificada"+iCarreraRepositorio.findById(carrera.getId()).orElse(null));
		
		//iCarreraRepositorio.save(carrera);
	}

	@Override
	public void eliminarCarrera(int id) {

		LOGGER.debug("Eliminar carrera");
		LOGGER.info("carrera a eliminar "+iCarreraRepositorio.findById(id).orElse(null));
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
		LOGGER.debug("listar carrera DTO");
		LOGGER.info("carreras "+iCarreraMapDto.convertirListaCarreraAlistaCarreraDto(listarCarreras(estado)));
		return iCarreraMapDto.convertirListaCarreraAlistaCarreraDto(listarCarreras(estado));
	}
	
	
}
