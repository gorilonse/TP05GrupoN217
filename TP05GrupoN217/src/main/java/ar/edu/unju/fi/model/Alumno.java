package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component //para poder usar inyecccion de dependencias, para poder instanciar en tiempo de ejecucion la clase Alumno.
@Entity //es para que los datos se guarden en la DB como una tabla.
@Data //nos genera getter y setter 
@AllArgsConstructor //para constructor
@NoArgsConstructor //para constructor
public class Alumno {

	//ATRIBUTOS
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="alu_id")
		private int id; 
		
		@Pattern(regexp = "\\d+", message = "El dni debe ser númerico")
		@Min(10000000)@Max(1000000000)
		private String dni;
		
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
		@Size(min=10, max=12,message="El telefono no puede llevar menos de 10 caracteres y más de 12 caracteres")
		private String telefono;
		
		@Past @NotNull(message="Debe ingresar una fecha de nacimiento")
		private LocalDate fechaNacimineto;
		

		@NotBlank(message="Debe ingresar domicilio")
		@Size(min=5, max=80,message="El domicilio no puede llevar menos de 5 caracteres y más de 80 caracteres")
		private String domicilio;
		
		@NotBlank(message="Debe ingresar LU")
		@Pattern(regexp = "\\d+", message = "El LU debe ser númerico")
		@Size(min=1, max=6,message="El lu no puede llevar menos de 1 caracter y más de 6 caracteres")
		@Min(1)@Max(900000)
		private String LU;
		
		@ManyToOne
		@JoinColumn(name="id_carrera")
		@NotNull
		private Carrera carrera;
		
		
		@ManyToMany(fetch = FetchType.LAZY)
		private List<Materia> materias=new ArrayList<>();
		/*
		 * 
		 * @JoinTable(name="alumno_materia",
				joinColumns = @JoinColumn(name="alumno_id"),
				inverseJoinColumns =@JoinColumn(name="materia_id")
				)
		 */
		
}
