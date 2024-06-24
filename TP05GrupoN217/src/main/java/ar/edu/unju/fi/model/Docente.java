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
	private String legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	//@OneToOne(mappedBy = "docente",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//private Materia materia;
	
}
