package tech.getarrays.serviciocamilleros.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @JsonIgnore
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servicioSolicitado", referencedColumnName = "oid")
    private Genareser genareser;

    private String destinoServicio;

 //   @ManyToOne(fetch = FetchType.EAGER)
 //   @JoinColumn(name = "destinoServicio", referencedColumnName = "oid")
 //   private Genareser genareserDestino;

    private String solicitante;
    private String transporte;
    private String insumo;
    private String familiar;
    private Boolean aislamiento;
    private String observaciones;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oidGenpacien", referencedColumnName = "oid")
    private Genpacien genpacien;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCamillero", referencedColumnName = "idCamillero")
    private Camillero camillero;

    private LocalTime horaEnvio;
    private LocalTime horaAsignacion;
    private LocalTime horaEjecucion;
    private LocalTime horaFinalizacion;

    private Boolean cancelado;
    private String motivoCancelado;

    public Servicio() {
    }

    // String servicioSolicitado,
    public Servicio(LocalDate fecha, Genareser genareser, String destinoServicio, String solicitante,
                    String transporte, String insumo, String familiar, Boolean aislamiento, String observaciones,
                    Genpacien genpacien, Camillero camillero, LocalTime horaEnvio, LocalTime horaAsignacion,
                    LocalTime horaEjecucion, LocalTime horaFinalizacion, Boolean cancelado, String motivoCancelado) {
        this.fecha = fecha;
     //   this.servicioSolicitado = servicioSolicitado;
     //
        this.genareser = genareser;
        this.destinoServicio = destinoServicio;
    //    this.genareserDestino = genareserDestino;
        this.solicitante = solicitante;
        this.transporte = transporte;
        this.insumo = insumo;
        this.familiar = familiar;
        this.aislamiento = aislamiento;
        this.observaciones = observaciones;
        this.genpacien = genpacien;
        this.camillero = camillero;
        this.horaEnvio = horaEnvio;
        this.horaAsignacion = horaAsignacion;
        this.horaEjecucion = horaEjecucion;
        this.horaFinalizacion = horaFinalizacion;
        this.cancelado = cancelado;
        this.motivoCancelado = motivoCancelado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Genareser getGenareser() {
        return genareser;
    }

    public void setGenareser(Genareser genareser) {
        this.genareser = genareser;
    }

    public String getDestinoServicio() {
        return destinoServicio;
    }

    public void setDestinoServicio(String destinoServicio) {
        this.destinoServicio = destinoServicio;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public String getFamiliar() {
        return familiar;
    }

    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }

    public Boolean getAislamiento() {
        return aislamiento;
    }

    public void setAislamiento(Boolean aislamiento) {
        this.aislamiento = aislamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Genpacien getGenpacien() {
        return genpacien;
    }

    public void setGenpacien(Genpacien genpacien) {
        this.genpacien = genpacien;
    }

    public Camillero getCamillero() {
        return camillero;
    }

    public void setCamillero(Camillero camillero) {
        this.camillero = camillero;
    }

    public LocalTime getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(LocalTime horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public LocalTime getHoraAsignacion() {
        return horaAsignacion;
    }

    public void setHoraAsignacion(LocalTime horaAsignacion) {
        this.horaAsignacion = horaAsignacion;
    }

    public LocalTime getHoraEjecucion() {
        return horaEjecucion;
    }

    public void setHoraEjecucion(LocalTime horaEjecucion) {
        this.horaEjecucion = horaEjecucion;
    }

    public LocalTime getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public void setHoraFinalizacion(LocalTime horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public String getMotivoCancelado() {
        return motivoCancelado;
    }

    public void setMotivoCancelado(String motivoCancelado) {
        this.motivoCancelado = motivoCancelado;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", genareser=" + genareser +
                ", destinoServicio=" + destinoServicio +
                ", solicitante='" + solicitante + '\'' +
                ", transporte='" + transporte + '\'' +
                ", insumo='" + insumo + '\'' +
                ", familiar='" + familiar + '\'' +
                ", aislamiento=" + aislamiento +
                ", observaciones='" + observaciones + '\'' +
                ", genpacien=" + genpacien +
                ", camillero=" + camillero +
                ", horaEnvio=" + horaEnvio +
                ", horaAsignacion=" + horaAsignacion +
                ", horaEjecucion=" + horaEjecucion +
                ", horaFinalizacion=" + horaFinalizacion +
                ", cancelado=" + cancelado +
                ", motivoCancelado='" + motivoCancelado + '\'' +
                '}';
    }
}
