package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Carrera;
import jakarta.transaction.Transactional;

@Repository
public interface ICarreraRepository extends JpaRepository<Carrera, Integer>{
	
	List<Carrera> findCarreraByEstado(boolean estado);
	
	@Modifying
    @Transactional
    @Query("UPDATE Carrera c SET c.estado = :estado, c.cantidadDeAnios = :cantidadDeAnios, c.nombre = :nombre WHERE c.id = :id")
    int updateCarrera(@Param("id") int id,
                      @Param("estado") boolean estado,
                      @Param("cantidadDeAnios") String cantidadDeAnios,
                      @Param("nombre") String nombre);
}
