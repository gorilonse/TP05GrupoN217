package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component  //gracias a esto funciona el AUTOWIRED EN alguna otra clase dentro de otro paquete que depende del mismo proyecto.
@Entity
@Data //es para LOMBOK
@AllArgsConstructor //es para LOMBOK
@NoArgsConstructor //es para LOMBOK
public class Docente {
	//ATRIBUTOS
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="doc_id")
	private int id;
	
	@NotBlank(message="Debe ingresar legajo")
	@Size(min=1, max=20,message="El legajo no puede llevar menos de 1 caracter y más de 20 caracteres")
	private String legajo;
	

	@NotBlank(message="Debe ingresar nombre")
	@Size(min=2, max=40,message="El nombre no puede llevar menos de 2 caracteres y más de 30 caracteres")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	private String nombre;
		
	@NotBlank(message="Debe ingresar apellido")
	@Size(min=2, max=40,message="El apellido no puede llevar menos de 2 caracteres y más de 30 caracteres")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	private String apellido;
	

	@Email @NotBlank(message="Debe ingresar email")
	@Size(min=15, max=50,message="El email no puede llevar menos de 15 caracteres y más de 50 caracteres")
	private String email;
	

	@Pattern(regexp = "\\d+", message = "El telefono debe ser númerico")
	@Size(min=7, max=15,message="El telefono puede llevar entre 7 y 15 caracteres")
	private String telefono;
	//@OneToOne(mappedBy = "docente",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//private Materia materia;
	
}
