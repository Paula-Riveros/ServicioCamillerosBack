package tech.getarrays.serviciocamilleros.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Camillero {
    @Id
    private Integer idCamillero;
    private String nombreCamillero;

    public Camillero() {
    }

    public Camillero(int idCamillero, String nombreCamillero) {
        this.idCamillero = idCamillero;
        this.nombreCamillero = nombreCamillero;
    }

    public Integer getIdCamillero() {
        return idCamillero;
    }

    public void setIdCamillero(Integer idCamillero) {
        this.idCamillero = idCamillero;
    }

    public String getNombreCamillero() {
        return nombreCamillero;
    }

    public void setNombreCamillero(String nombreCamillero) {
        this.nombreCamillero = nombreCamillero;
    }

}
