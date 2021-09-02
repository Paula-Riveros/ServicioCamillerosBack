package tech.getarrays.serviciocamilleros.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.serviciocamilleros.Repo.PacienteRepo;
import tech.getarrays.serviciocamilleros.Model.Paciente;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {

    @Autowired
    PacienteRepo pacienteRepo;

    public Paciente addPaciente(Paciente paciente) {
        return pacienteRepo.save(paciente);
    }

    public List<Paciente> list() {
        return pacienteRepo.findAll();
    }

    public Optional<Paciente> getOne(int id) {
        return pacienteRepo.findById(id);
    }

    public Optional<Paciente> getByNombre(String nombre) {
        return pacienteRepo.findByNombre(nombre);
    }

    public void save(Paciente paciente){
        pacienteRepo.save(paciente);
    }

    public void delete(int id) {
        pacienteRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return pacienteRepo.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return pacienteRepo.existsByNombre(nombre);
    }
}

