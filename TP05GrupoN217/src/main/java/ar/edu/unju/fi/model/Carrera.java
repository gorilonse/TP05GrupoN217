package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
