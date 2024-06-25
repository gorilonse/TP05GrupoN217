package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDto {

	private int id;
	private String legajo;
	private String nombre;
	private String apellido;
	
	
	/*private int id;
	private String legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono; */
}
