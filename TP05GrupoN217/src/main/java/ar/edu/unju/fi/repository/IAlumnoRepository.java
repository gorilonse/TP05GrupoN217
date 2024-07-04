package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Alumno;
@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer>{

	 @Query("SELECT a FROM Alumno a WHERE a.carrera.id = :carreraId")
	    List<Alumno> findByCarreraId(@Param("carreraId") int carreraId);
	 @Query("SELECT a FROM Alumno a JOIN a.materias m WHERE m.id = :materiaId")
	    List<Alumno> findByMateriaId(@Param("materiaId") int materiaId);
}
