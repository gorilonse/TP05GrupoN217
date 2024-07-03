package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data //nos genera getter y setter 
@AllArgsConstructor //para constructor
@NoArgsConstructor //para constructor
public class AlumnoDto {
	private int id; 
	private String dni;
	private String nombre;
	private String apellido;
	private String LU;

}
