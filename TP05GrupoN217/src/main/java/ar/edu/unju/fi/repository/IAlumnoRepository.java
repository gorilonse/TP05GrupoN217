package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Alumno;
@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer>{

	
}
