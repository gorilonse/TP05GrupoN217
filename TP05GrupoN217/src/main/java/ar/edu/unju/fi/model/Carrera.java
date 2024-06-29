package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {

	//ATRIBUTO
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "car_id")
	private int id;
	private String codigo;
	private String nombre;
	private String cantidadDeAnios;
	private boolean estado;
	

	

	//@OneToOne(mappedBy = "carrera",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//private Materia materia;
}
