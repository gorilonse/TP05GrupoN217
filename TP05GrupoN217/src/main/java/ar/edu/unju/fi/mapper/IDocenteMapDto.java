package ar.edu.unju.fi.mapper;

import java.util.List;

import org.hibernate.type.TrueFalseConverter;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Docente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IDocenteMapDto {

	@Mapping(source = "id",target = "id")
	@Mapping(source = "legajo",target = "legajo")
	@Mapping(source = "nombre",target = "nombre")
	@Mapping(source = "apellido", target ="apellido")
	DocenteDto convertirDocenteAdocenteDto(Docente docente);
	
	@Mapping(target = "email", ignore = true)
	@Mapping(target = "telefono", ignore = true)
	@InheritInverseConfiguration
	Docente convertirDocenteDtoADocente(DocenteDto docenteDto);
	
	List<DocenteDto> convertirListaDocenteAlistaDocenteDto(List<Docente>listaAlumnos);
}
