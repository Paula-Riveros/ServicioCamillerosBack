package tech.getarrays.serviciocamilleros.Controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.serviciocamilleros.Dto.Mensaje;
import tech.getarrays.serviciocamilleros.Dto.PacienteDto;
import tech.getarrays.serviciocamilleros.Dto.ServicioDto;
import tech.getarrays.serviciocamilleros.Model.Camillero;
import tech.getarrays.serviciocamilleros.Model.Paciente;
import tech.getarrays.serviciocamilleros.Repo.CamilleroRepo;
import tech.getarrays.serviciocamilleros.Repo.PacienteRepo;
import tech.getarrays.serviciocamilleros.Service.PacienteService;
import tech.getarrays.serviciocamilleros.Service.ServicioService;
import tech.getarrays.serviciocamilleros.Model.Servicio;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicio")
public class ServicioController {
    private final ServicioService servicioService;
    private final PacienteService pacienteService;
    private PacienteRepo pacienteRepo;
    private CamilleroRepo camilleroRepo;

    public ServicioController(ServicioService servicioService, PacienteService pacienteService,
                              PacienteRepo pacienteRepo, CamilleroRepo camilleroRepo) {
        this.servicioService = servicioService;
        this.pacienteService = pacienteService;
        this.pacienteRepo = pacienteRepo;
        this.camilleroRepo = camilleroRepo;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Servicio>> getAllServicios() {
        List<Servicio> servicios = servicioService.list();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

/*    @PostMapping("/add")
    public ResponseEntity<Servicio> addServicio(@RequestBody Servicio servicio) {
        Servicio newServicio = servicioService.addServicio(servicio);
        return new ResponseEntity<>(newServicio, HttpStatus.CREATED);
    }*/

    @GetMapping("/read/{id}")
    public ResponseEntity<Servicio> getById(@PathVariable("id") Long id) {
        if (!servicioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Servicio servicio = servicioService.getOne(id).get();
        return new ResponseEntity<>(servicio, HttpStatus.OK);
    }

 /*   @GetMapping("/detailfecha/{fecha}")
    public ResponseEntity<Servicio> getByFecha(@PathVariable("fecha") String fecha) {
        if(!servicioService.existsByFecha(fecha))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Servicio servicio = servicioService.getByFecha(fecha).get();
        return new ResponseEntity<>(servicio, HttpStatus.OK);
    }*/

   @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ServicioDto servicioDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Mensaje("Campos mal puestos o inválidos"), HttpStatus.BAD_REQUEST);
       Optional<Paciente> paciente = pacienteRepo.findById(servicioDto.getIdPaciente());
       Optional<Camillero> camillero = camilleroRepo.findById(servicioDto.getIdCamillero());
       if(paciente.isPresent()) {
           Servicio servicio = new Servicio(servicioDto.getFecha(), servicioDto.getServicioSolicitado(), servicioDto.getDestinoServicio(),
                   servicioDto.getSolicitante(), servicioDto.getTransporte(), servicioDto.getInsumo(), servicioDto.getFamiliar(),
                   servicioDto.getAislamiento(), servicioDto.getObservaciones(), paciente.get(), camillero.get());
           servicioService.save(servicio);
           return new ResponseEntity<>(new Mensaje("Servicio guardado"), HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ServicioDto servicioDto) {
        if(!servicioService.existsById(id))
            return new ResponseEntity<>(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(servicioDto.getFecha()))
            return new ResponseEntity<>(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        Optional<Camillero> camillero = camilleroRepo.findById(servicioDto.getIdCamillero());
        Servicio servicio = servicioService.getOne(id).get();
        servicio.setServicioSolicitado(servicioDto.getServicioSolicitado());
        servicio.setCamillero(camillero.get());
        servicioService.save(servicio);
        return new ResponseEntity<>(new Mensaje("Servicio actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Servicio> delete(@PathVariable Long id){
        if(servicioService.delete(id)) {
            return new ResponseEntity(new Mensaje("Servicio eliminado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
