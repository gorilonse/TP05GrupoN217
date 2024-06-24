package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.AlumnoDto;
import ar.edu.unju.fi.model.Alumno;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IAlumnoMapDto {
	
	@Mapping(source = "id",target = "id")
	@Mapping(source = "dni",target = "dni")
	@Mapping(source = "nombre",target = "nombre")
	@Mapping(source = "apellido",target = "apellido")
	@Mapping(source = "LU",target = "LU")
	AlumnoDto convertirAlumnoAalumnoDto(Alumno alumno);

	
	@Mapping(target = "domicilio", ignore = true)
	@Mapping(target = "email", ignore = true)
	@Mapping(target = "fechaNacimineto", ignore = true)
	@Mapping(target = "telefono", ignore = true)
	@InheritInverseConfiguration
	Alumno convertirAlumnoDtoAalumno(AlumnoDto alumnoDto);
	
	List<AlumnoDto> convertirListaAlumnoAlistaAlumnoDtos (List<Alumno>listaAlumnos);
}
