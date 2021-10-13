package tech.getarrays.serviciocamilleros.Dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalTime;

public class ServicioDto implements Serializable {
    
    @NotBlank
    private String fecha;
    private int servicioSolicitado;
    private String destinoServicio;
    private String solicitante;
    private String transporte;
    private String insumo;
    private String familiar;
    private boolean aislamiento;
    private String observaciones;

    @NotNull
    private String docPaciente;

    private Integer idCamillero;

    private String horaEnvio;
    private String horaAsignacion;
    private String horaEjecucion;
    private String horaFinalizacion;

    private boolean cancelado;
    private String motivoCancelado;

    public ServicioDto() {
    }

   // String servicioSolicitado, String destinoServicio,
    public ServicioDto(String fecha, int servicioSolicitado, String destinoServicio,  String solicitante,
                       String transporte, String insumo, String familiar, boolean aislamiento, String observaciones,
                       String docPaciente, Integer idCamillero, String horaEnvio, String horaAsignacion,
                       String horaEjecucion, String horaFinalizacion, boolean cancelado, String motivoCancelado) {
        this.fecha = fecha;
   //     this.servicioSolicitado = servicioSolicitado;
   //     this.destinoServicio = destinoServicio;
        this.servicioSolicitado = servicioSolicitado;
        this.destinoServicio = destinoServicio;
        this.solicitante = solicitante;
        this.transporte = transporte;
        this.insumo = insumo;
        this.familiar = familiar;
        this.aislamiento = aislamiento;
        this.observaciones = observaciones;
        this.docPaciente = docPaciente;
        this.idCamillero = idCamillero;
        this.horaEnvio = horaEnvio;
        this.horaAsignacion = horaAsignacion;
        this.horaEjecucion = horaEjecucion;
        this.horaFinalizacion = horaFinalizacion;
        this.cancelado = cancelado;
        this.motivoCancelado = motivoCancelado;
    }

    /*public ServicioDto(String fecha, String servicioSolicitado, String destinoServicio, String solicitante,
                       String transporte, String insumo, String familiar, String aislamiento,
                       String observaciones, int idPaciente, int idCamillero) {
        this.fecha = fecha;
        this.servicioSolicitado = servicioSolicitado;
        this.destinoServicio = destinoServicio;
        this.solicitante = solicitante;
        this.transporte = transporte;
        this.insumo = insumo;
        this.familiar = familiar;
        this.aislamiento = aislamiento;
        this.observaciones = observaciones;
        this.idPaciente = idPaciente;
        this.idCamillero = idCamillero;
    }*/

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getServicioSolicitado() {
        return servicioSolicitado;
    }

    public void setServicioSolicitado(int servicioSolicitado) {
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

    public String getDocPaciente() {
        return docPaciente;
    }

    public void setDocPaciente(String docPaciente) {
        this.docPaciente = docPaciente;
    }

    public Integer getIdCamillero() {
        return idCamillero;
    }

    public void setIdCamillero(Integer idCamillero) {
        this.idCamillero = idCamillero;
    }

    public String getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(String horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public String getHoraAsignacion() {
        return horaAsignacion;
    }

    public void setHoraAsignacion(String horaAsignacion) {
        this.horaAsignacion = horaAsignacion;
    }

    public String getHoraEjecucion() {
        return horaEjecucion;
    }

    public void setHoraEjecucion(String horaEjecucion) {
        this.horaEjecucion = horaEjecucion;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public void setHoraFinalizacion(String horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public String getMotivoCancelado() {
        return motivoCancelado;
    }

    public void setMotivoCancelado(String motivoCancelado) {
        this.motivoCancelado = motivoCancelado;
    }
}
