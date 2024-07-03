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
		private String dni;
		private String nombre;
		private String apellido;
		private String email;
		private String telefono;
		private LocalDate fechaNacimineto;
		private String domicilio;
		private String LU;
		
		@ManyToOne
		@JoinColumn(name="id_carrera")
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
