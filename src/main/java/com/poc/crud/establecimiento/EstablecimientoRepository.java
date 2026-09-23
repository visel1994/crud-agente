package com.poc.crud.establecimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {
    @Query("SELECT e FROM Establecimiento e WHERE e.codigo = :codigo")
    Optional<Establecimiento> findByCodigo(@Param("codigo") String codigo);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Establecimiento e WHERE e.codigo = :codigo")
    boolean existsByCodigo(@Param("codigo") String codigo);
}
