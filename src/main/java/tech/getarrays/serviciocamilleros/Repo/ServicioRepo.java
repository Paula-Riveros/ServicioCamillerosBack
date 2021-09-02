package tech.getarrays.serviciocamilleros.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.serviciocamilleros.Model.Paciente;
import tech.getarrays.serviciocamilleros.Model.Servicio;

import java.util.Optional;

public interface ServicioRepo extends JpaRepository<Servicio, Long> {
    Optional<Servicio> findByFecha(String fecha);
    boolean existsByFecha(String fecha);
}
