package tech.getarrays.serviciocamilleros.Model;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    // @JsonIgnore
    private LocalDate fecha;
    private String servicioSolicitado;
    private String destinoServicio;
    private String solicitante;
    private String transporte;
    private String insumo;
    private String familiar;
    private boolean aislamiento;
    private String observaciones;

  /*  @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    private Paciente paciente;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oidGenpacien", referencedColumnName = "oid")
    private Genpacien genpacien;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCamillero", referencedColumnName = "idCamillero")
    private Camillero camillero;



    public Servicio() {
    }

    public Servicio(LocalDate fecha, String servicioSolicitado, String destinoServicio, String solicitante,
                    String transporte, String insumo, String familiar, boolean aislamiento, String observaciones,
                    Genpacien genpacien, Camillero camillero) {
        this.fecha = fecha;
        this.servicioSolicitado = servicioSolicitado;
        this.destinoServicio = destinoServicio;
        this.solicitante = solicitante;
        this.transporte = transporte;
        this.insumo = insumo;
        this.familiar = familiar;
        this.aislamiento = aislamiento;
        this.observaciones = observaciones;
        this.genpacien = genpacien;
        this.camillero = camillero;
    }

    /*public Servicio(LocalDate fecha, String servicioSolicitado, String destinoServicio, String solicitante,
                    String transporte, String insumo, String familiar, boolean aislamiento, String observaciones,
                    Paciente paciente, Camillero camillero) {
        this.fecha = fecha;
        this.servicioSolicitado = servicioSolicitado;
        this.destinoServicio = destinoServicio;
        this.solicitante = solicitante;
        this.transporte = transporte;
        this.insumo = insumo;
        this.familiar = familiar;
        this.aislamiento = aislamiento;
        this.observaciones = observaciones;
        this.paciente = paciente;
        this.camillero = camillero;
    }*/


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

    public String getServicioSolicitado() {
        return servicioSolicitado;
    }

    public void setServicioSolicitado(String servicioSolicitado) {
        this.servicioSolicitado = servicioSolicitado;
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

    public boolean isAislamiento() {
        return aislamiento;
    }

    public void setAislamiento(boolean aislamiento) {
        this.aislamiento = aislamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

   /* public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }*/

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

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", servicioSolicitado='" + servicioSolicitado + '\'' +
                ", destinoServicio='" + destinoServicio + '\'' +
                ", solicitante='" + solicitante + '\'' +
                ", transporte='" + transporte + '\'' +
                ", insumo='" + insumo + '\'' +
                ", familiar='" + familiar + '\'' +
                ", aislamiento='" + aislamiento + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", genpacien=" + genpacien +
                ", camillero=" + camillero +
                '}';
    }
}
