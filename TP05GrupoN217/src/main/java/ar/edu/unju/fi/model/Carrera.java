package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {

	//ATRIBUTO
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String codigo;
	private String nombre;
	private String cantidadDeAnios;
	private boolean estado;
	
}
