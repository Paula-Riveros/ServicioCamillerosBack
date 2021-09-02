package tech.getarrays.serviciocamilleros.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.serviciocamilleros.Model.Paciente;
import tech.getarrays.serviciocamilleros.Repo.ServicioRepo;
import tech.getarrays.serviciocamilleros.Model.Servicio;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicioService {
    @Autowired
    ServicioRepo servicioRepo;

    public Servicio addServicio(Servicio servicio) {
        return servicioRepo.save(servicio);
    }

    public List<Servicio> list() {
        return servicioRepo.findAll();
    }

    public Optional<Servicio> getOne(Long id) {
        return servicioRepo.findById(id);
    }

    public Optional<Servicio> getByFecha(String fecha) {
        return servicioRepo.findByFecha(fecha);
    }

    public void save(Servicio servicio) {
        servicioRepo.save(servicio);
    }

//    public void delete(Long id) {
//        servicioRepo.deleteById(id);
//    }

    public boolean existsByFecha(String fecha) {
        return servicioRepo.existsByFecha(fecha);
    }

    public boolean existsById(Long id) {
        return servicioRepo.existsById(id);
    }

    public boolean delete(long id) {
        if (getOne(id).isPresent()) {
            servicioRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
