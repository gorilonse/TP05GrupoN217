package ar.edu.unju.fi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import ar.edu.unju.fi.numerado.Modalidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {

	//ATRIBUTOS
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Id
		@Column(name="mat_id")
		private int id;
		
		@NotBlank(message="Debe ingresar el Codigo")
		@Size(min=2,max=10, message="El código debe poseer como minimo 2 digitos y como maximo 10 dígitos")
		private String codigo;
		
		@NotBlank(message="Debe ingresar nombre de la materia")
		@Size(min=2, max=40,message="El nombre no puede llevar menos de 2 caracteres y más de 30 caracteres")
		@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
		private String nombre;
		
		@NotBlank(message="Debe ingresar el curso")
		@Size(min=2, max=40,message="El curso no puede llevar menos de 2 caracteres y más de 40 caracteres")
		private String curso;
		
		@Pattern(regexp = "\\d+", message = "La cantidad de horas debe ser numerico")
		@Min(10)@Max(100)
		private String cantidadDeHora;   
		
		@NotNull(message="Debe seleccionar una modalidad")
		private Modalidad modalidadDeHoraString;  //ENUMERADO
		
		@ManyToOne(targetEntity = Carrera.class)
		@JoinColumn(name="id_car")
		@NotNull(message="Debe seleccionar una carrera")
		private Carrera carrera;
		
		@OneToOne()
		@JoinColumn(name = "doc_id",unique = true)
		@NotNull(message="Debe seleccionar una materia")
		private Docente docente; //del tipo Docente
		
				
		@ManyToMany(mappedBy = "materias")
		private List<Alumno> alumnos=new ArrayList<>();
}
