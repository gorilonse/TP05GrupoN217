package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.numerado.Modalidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDto {
	 
	
	private int id;
	private String codigo;
	private String nombre;
	private String curso;
	private String cantidadDeHora;   
	private Modalidad modalidadDeHoraString;  //ENUMERADO
	private Docente docente;
	private Carrera carrera;
}
