package com.poc.crud.establecimiento;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EstablecimientoRepositoryTest {
    @Autowired
    private EstablecimientoRepository repository;

    @Test
    void shouldFindEstablecimientoByCodigo() {
        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setCodigo("COD123");
        establecimiento.setNombre("Hospital Central");
        establecimiento.setDistrito("Distrito 1");
        establecimiento.setActivo(true);

        repository.save(establecimiento);

        Optional<Establecimiento> found = repository.findByCodigo("COD123");
        assertThat(found).isPresent();
        assertThat(found.get().getNombre()).isEqualTo("Hospital Central");
    }

    @Test
    void shouldReturnFalseForNonExistingCodigo() {
        boolean exists = repository.existsByCodigo("COD999");
        assertThat(exists).isFalse();
    }
}
