package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
		private int id; 
		private String dni;
		private String nombre;
		private String apellido;
		private String email;
		private String telefono;
		private LocalDate fechaNacimineto;
		private String domicilio;
		private String LU;
		
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="id_carrera")
		private Carrera carrera;
		
}
