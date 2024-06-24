package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.numerado.Modalidad;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
		private int id;
		private String codigo;
		private String nombre;
		private String curso;
		private String cantidadDeHora;   
		private Modalidad modalidadDeHoraString;  //ENUMERADO
		@OneToOne(cascade = CascadeType.ALL) 
		@JoinColumn(name = "doc_id")
		private Docente docente; //del tipo Docente
		@OneToOne(cascade = CascadeType.ALL) 
		@JoinColumn(name = "car_id")
		private Carrera carrera; //del tipo Carrera
}
