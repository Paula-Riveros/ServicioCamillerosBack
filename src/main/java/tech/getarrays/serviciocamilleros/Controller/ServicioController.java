package tech.getarrays.serviciocamilleros.Controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.serviciocamilleros.Dto.Mensaje;
import tech.getarrays.serviciocamilleros.Dto.PacienteDto;
import tech.getarrays.serviciocamilleros.Dto.ServicioDto;
import tech.getarrays.serviciocamilleros.Model.Camillero;
import tech.getarrays.serviciocamilleros.Model.Genpacien;
import tech.getarrays.serviciocamilleros.Model.Paciente;
import tech.getarrays.serviciocamilleros.Repo.CamilleroRepo;
import tech.getarrays.serviciocamilleros.Repo.GenpacienRepo;
import tech.getarrays.serviciocamilleros.Repo.PacienteRepo;
import tech.getarrays.serviciocamilleros.Service.GenpacienService;
import tech.getarrays.serviciocamilleros.Service.PacienteService;
import tech.getarrays.serviciocamilleros.Service.ServicioService;
import tech.getarrays.serviciocamilleros.Model.Servicio;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicio")
@CrossOrigin(origins = "*")
public class ServicioController {
    private final ServicioService servicioService;
    private final PacienteService pacienteService;
    private final GenpacienService genpacienService;
    private PacienteRepo pacienteRepo;
    private CamilleroRepo camilleroRepo;
    private GenpacienRepo genpacienRepo;

    public ServicioController(ServicioService servicioService, PacienteService pacienteService, GenpacienService genpacienService,
                              PacienteRepo pacienteRepo, CamilleroRepo camilleroRepo, GenpacienRepo genpacienRepo) {
        this.servicioService = servicioService;
        this.pacienteService = pacienteService;
        this.genpacienService = genpacienService;
        this.pacienteRepo = pacienteRepo;
        this.camilleroRepo = camilleroRepo;
        this.genpacienRepo = genpacienRepo;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Servicio>> getAllServicios() {
        List<Servicio> servicios = servicioService.list();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    /*@GetMapping("/lista")
    public ResponseEntity<Page<Servicio>> getAllServicios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(defaultValue = "id") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ) {
        Page<Servicio> servicios = servicioService.list(
                PageRequest.of(page, size, Sort.by(order)));
        if (!asc)
            servicios = servicioService.list(
                    PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }*/

/*    @PostMapping("/add")
    public ResponseEntity<Servicio> addServicio(@RequestBody Servicio servicio) {
        Servicio newServicio = servicioService.addServicio(servicio);
        return new ResponseEntity<>(newServicio, HttpStatus.CREATED);
    }*/

    @GetMapping("/detail/{id}")
    public ResponseEntity<Servicio> getById(@PathVariable("id") Long id) {
        if (!servicioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Servicio servicio = servicioService.getOne(id).get();
        return new ResponseEntity<>(servicio, HttpStatus.OK);
    }

  /*  @GetMapping("/listafecha/{fecha}")
    public ResponseEntity<List<Servicio>> getByFecha(@PathVariable("fecha") LocalDate fecha) {
        if(!servicioService.existsByFecha(fecha))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        List<Servicio> servicios = servicioService.getByFecha(fecha).get();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }*/

    @GetMapping("/listafecha")
    public ResponseEntity<List<Servicio>> getByFecha(@RequestBody ServicioDto servicioDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(servicioDto.getFecha(), formatter);
        if(!servicioService.existsByFecha(date))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        List<Servicio> servicios = servicioService.getByFecha(date);
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

   /*@PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ServicioDto servicioDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Mensaje("Campos mal puestos o inválidos"), HttpStatus.BAD_REQUEST);
       Optional<Paciente> paciente = pacienteRepo.findById(servicioDto.getIdPaciente());
//       Optional<Camillero> camillero = camilleroRepo.findById(servicioDto.getIdCamillero());
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate date = LocalDate.parse(servicioDto.getFecha(), formatter);
       boolean aislamiento = Boolean.parseBoolean(servicioDto.getAislamiento());
       if(paciente.isPresent()) {
           Servicio servicio = new Servicio(date, servicioDto.getServicioSolicitado(), servicioDto.getDestinoServicio(),
                   servicioDto.getSolicitante(), servicioDto.getTransporte(), servicioDto.getInsumo(), servicioDto.getFamiliar(),
                   aislamiento, servicioDto.getObservaciones(), paciente.get(), null);
           servicioService.save(servicio);
           return new ResponseEntity<>(new Mensaje("Servicio guardado"), HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }*/

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ServicioDto servicioDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Mensaje("Campos mal puestos o inválidos"), HttpStatus.BAD_REQUEST);
        Optional<Genpacien> genpacien = genpacienRepo.findByPacnumdoc(servicioDto.getDocPaciente());
//       Optional<Camillero> camillero = camilleroRepo.findById(servicioDto.getIdCamillero());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(servicioDto.getFecha(), formatter);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm:ss");
        LocalTime horaEnvio = LocalTime.parse(servicioDto.getHoraEnvio(), dtf);
        LocalTime horaAsignacion = LocalTime.parse(servicioDto.getHoraAsignacion(), dtf);
        LocalTime horaEjecucion = LocalTime.parse(servicioDto.getHoraEjecucion(), dtf);
        LocalTime horaFinalizacion = LocalTime.parse(servicioDto.getHoraFinalizacion(), dtf);

        boolean aislamiento = Boolean.parseBoolean(servicioDto.getAislamiento());

        if(genpacien.isPresent()) {
            Servicio servicio = new Servicio(date, servicioDto.getServicioSolicitado(), servicioDto.getDestinoServicio(),
                    servicioDto.getSolicitante(), servicioDto.getTransporte(), servicioDto.getInsumo(), servicioDto.getFamiliar(),
                    aislamiento, servicioDto.getObservaciones(), genpacien.get(), null, horaEnvio,
                    horaAsignacion, horaEjecucion, horaFinalizacion);
            servicioService.save(servicio);
            return new ResponseEntity<>(new Mensaje("Servicio guardado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ServicioDto servicioDto) {
        if(!servicioService.existsById(id))
            return new ResponseEntity<>(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(servicioDto.getFecha()))
            return new ResponseEntity<>(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);

        Optional<Camillero> camillero = camilleroRepo.findById(servicioDto.getIdCamillero());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm:ss");
        LocalTime horaAsignacion = LocalTime.parse(servicioDto.getHoraAsignacion(), dtf);
        LocalTime horaEjecucion = LocalTime.parse(servicioDto.getHoraEjecucion(), dtf);
        LocalTime horaFinalizacion = LocalTime.parse(servicioDto.getHoraFinalizacion(), dtf);

        Servicio servicio = servicioService.getOne(id).get();
        servicio.setCamillero(camillero.get());
        servicio.setHoraAsignacion(horaAsignacion);
        servicio.setHoraEjecucion(horaEjecucion);
        servicio.setHoraFinalizacion(horaFinalizacion);
        servicioService.save(servicio);
        return new ResponseEntity<>(new Mensaje("Servicio actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Servicio> delete(@PathVariable Long id){
        if(servicioService.delete(id)) {
            return new ResponseEntity(new Mensaje("Servicio eliminado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
