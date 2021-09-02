package tech.getarrays.serviciocamilleros.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Camillero {
    @Id
    private int idCamillero;
    private String nombreCamillero;

    public Camillero() {
    }

    public Camillero(int idCamillero, String nombreCamillero) {
        this.idCamillero = idCamillero;
        this.nombreCamillero = nombreCamillero;
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

}
