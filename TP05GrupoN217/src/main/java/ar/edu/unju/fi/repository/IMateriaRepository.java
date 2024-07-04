package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Materia;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia, Integer>{

	@Query("SELECT m FROM Materia m WHERE m.carrera.id = :carreraId")
    List<Materia> findByCarrera(@Param("carreraId") int carreraId);

}
