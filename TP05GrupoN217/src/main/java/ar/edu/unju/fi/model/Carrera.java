package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(targetEntity = Alumno.class, fetch = FetchType.LAZY, mappedBy = "carrera", cascade=CascadeType.ALL)
	private List<Alumno> alumnos;
	
	@OneToMany(targetEntity = Materia.class, fetch = FetchType.LAZY, mappedBy = "carrera", cascade=CascadeType.ALL)
	private List<Materia> materias;

	

	//@OneToOne(mappedBy = "carrera",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//private Materia materia;
}
