package tech.getarrays.serviciocamilleros.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CamilleroDto implements Serializable {

    @NotNull
    @Min(1)
    private int idCamillero;

    @NotBlank
    private String nombreCamillero;

    private String estadoCamillero;

    public CamilleroDto() {
    }

    public CamilleroDto(int idCamillero, String nombreCamillero, String estadoCamillero) {
        this.idCamillero = idCamillero;
        this.nombreCamillero = nombreCamillero;
        this.estadoCamillero = estadoCamillero;
    }

    public int getIdCamillero() {
        return idCamillero;
    }

    public void setIdCamillero(int idCamillero) {
        this.idCamillero = idCamillero;
    }

    public String getNombreCamillero() {
        return nombreCamillero;
    }

    public void setNombreCamillero(String nombreCamillero) {
        this.nombreCamillero = nombreCamillero;
    }

    public String getEstadoCamillero() {
        return estadoCamillero;
    }

    public void setEstadoCamillero(String estadoCamillero) {
        this.estadoCamillero = estadoCamillero;
    }
}
