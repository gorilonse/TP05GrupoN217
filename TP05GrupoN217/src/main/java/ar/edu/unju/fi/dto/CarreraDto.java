package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraDto {
	
	private int id;
	private String codigo;
	private String nombre;
	private String cantidadDeAnios;
	
	//@Column(name = "estado", columnDefinition = "TINYINT(1) DEFAULT 1")
	private boolean estado = true;
}
