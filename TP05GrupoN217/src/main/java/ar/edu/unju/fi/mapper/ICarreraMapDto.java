package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.CarreraDto;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICarreraMapDto {
	
	@Mapping(source = "id",target ="id")
	@Mapping(source = "codigo",target ="codigo")
	@Mapping(source = "nombre",target ="nombre")
	@Mapping(source = "cantidadDeAnios",target ="cantidadDeAnios")
	@Mapping(source = "estado",target ="estado")
	CarreraDto convertirCarreraAcarreraDto(Carrera carrera);
	
	/* @Mapping(target = "id",ignore =true) */
	@InheritInverseConfiguration
	Carrera convertirCarreraDtoAcarrera(CarreraDto carreraDto);
	
	List <CarreraDto> convertirListaCarreraAlistaCarreraDto(List<Carrera>listaCarreras);
}
