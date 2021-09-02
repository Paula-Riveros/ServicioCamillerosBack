package tech.getarrays.serviciocamilleros.Controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.serviciocamilleros.Dto.Mensaje;
import tech.getarrays.serviciocamilleros.Dto.PacienteDto;
import tech.getarrays.serviciocamilleros.Service.PacienteService;
import tech.getarrays.serviciocamilleros.Model.Paciente;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/lista")
    public ResponseEntity<List<Paciente>> lista() {
        List<Paciente> list = pacienteService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

/*    @PostMapping("/add")
    public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
        Paciente newPaciente = pacienteService.addPaciente(paciente);
        return new ResponseEntity(newPaciente, HttpStatus.CREATED);
    }*/

    @GetMapping("/detail/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable("id") int id) {
        if(!pacienteService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Paciente paciente = pacienteService.getOne(id).get();
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PacienteDto pacienteDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Mensaje("Campos mal puestos o inválidos"), HttpStatus.BAD_REQUEST);
        /*if (StringUtils.isBlank(pacienteDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);*/
        if(pacienteService.existsById(pacienteDto.getId()))
            return new ResponseEntity<>(new Mensaje("Ya existe un paciente con ese número de documento"), HttpStatus.BAD_REQUEST);
        Paciente paciente = new Paciente(pacienteDto.getId(), pacienteDto.getNombre(), pacienteDto.getEdad(),
                pacienteDto.getDireccion(), pacienteDto.getTelefono());
        pacienteService.save(paciente);
        return new ResponseEntity<>(new Mensaje("Paciente guardado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PacienteDto pacienteDto) {
        if(!pacienteService.existsById(id))
            return new ResponseEntity<>(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(pacienteService.existsById(pacienteDto.getId()))
            return new ResponseEntity<>(new Mensaje("Ya existe un paciente con ese número de documento"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(pacienteDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Paciente paciente = pacienteService.getOne(id).get();
        paciente.setNombre(pacienteDto.getNombre());
        paciente.setEdad(pacienteDto.getEdad());
        paciente.setDireccion(pacienteDto.getDireccion());
        paciente.setTelefono(pacienteDto.getTelefono());
        pacienteService.save(paciente);
        return new ResponseEntity<>(new Mensaje("Paciente actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!pacienteService.existsById(id))
            return new ResponseEntity<>(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        pacienteService.delete(id);
        return new ResponseEntity<>(new Mensaje("Paciente eliminado"), HttpStatus.OK);
    }

}
