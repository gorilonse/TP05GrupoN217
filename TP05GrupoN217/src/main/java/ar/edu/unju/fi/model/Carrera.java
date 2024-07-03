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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
	@NotBlank(message="Debe ingresar el Codigo")
	@Size(min=3,max=8, message="El código debe poseer como minimo 3 digitos y como maximo 8 dígitos")
	private String codigo;
	@NotBlank(message="Debe ingresar nombre")
	@Size(min=2, max=40,message="El nombre no puede llevar menos de 2 caracteres y más de 30 caracteres")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	private String nombre;
	
	@Min(value=3,message="El mínimo es 3")@Max(value=8, message="El máximo es 8")
	private int cantidadDeAnios;
	private boolean estado;
	
	@OneToMany(targetEntity = Alumno.class, fetch = FetchType.LAZY, mappedBy = "carrera")
	private List<Alumno> alumnos;
	
	@OneToMany(targetEntity = Materia.class, fetch = FetchType.LAZY, mappedBy = "carrera")
	private List<Materia> materias;

	

	//@OneToOne(mappedBy = "carrera",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//private Materia materia;
}
