package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.MateriaDto;
import ar.edu.unju.fi.model.Materia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IMateriaMapDto {
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "codigo", target = "codigo")
	@Mapping(source = "nombre", target = "nombre")
	@Mapping(source = "curso", target = "curso")
	@Mapping(source = "cantidadDeHora", target = "cantidadDeHora")
	@Mapping(source = "modalidadDeHoraString", target = "modalidadDeHoraString")
	@Mapping(source = "docente", target = "docente")
	@Mapping(source = "carrera", target = "carrera")
	MateriaDto convertirMateriaAmateriaDto(Materia materia);

	
	//@Mapping(target = "domicilio", ignore = true)  // en este caso no lo uso porque muestro todos los atributos.
	Materia convertirMateriaDtoAmateria(MateriaDto materiaDto);
	
	List <MateriaDto> convertirListaMateriaAlistaMateriaDto(List<Materia>listaMaterias);
	
}
