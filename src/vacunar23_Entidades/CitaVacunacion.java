
package vacunar23_Entidades;

import java.sql.Time;
import java.time.LocalDate;


public class CitaVacunacion {
  //Declaración de atributos
  private int codCita;
  private int idCiudadano;
  private int codRefuerzo;
  private LocalDate fechaHoraCita;
  private String centroVacunacion;
  private Time fechaHoraColoca;
  private int idVacuna;
  
  //Constructores

  public CitaVacunacion() {
  }

  public CitaVacunacion(int codCita, int idCiudadano, int codRefuerzo, LocalDate fechaHoraCita, String centroVacunacion, Time fechaHoraColoca, int idVacuna) {
        this.codCita = codCita;
        this.idCiudadano = idCiudadano;
        this.codRefuerzo = codRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.idVacuna = idVacuna;
    }
  
  //Getters y Setters

    public int getCodCita() {
        return codCita;
    }

    public void setCodCita(int codCita) {
        this.codCita = codCita;
    }

    public int getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(int idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public int getCodRefuerzo() {
        return codRefuerzo;
    }

    public void setCodRefuerzo(int codRefuerzo) {
        this.codRefuerzo = codRefuerzo;
    }

    public LocalDate getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(LocalDate fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public String getCentroVacunacion() {
        return centroVacunacion;
    }

    public void setCentroVacunacion(String centroVacunacion) {
        this.centroVacunacion = centroVacunacion;
    }

    public Time getFechaHoraColoca() {
        return fechaHoraColoca;
    }

    public void setFechaHoraColoca(Time fechaHoraColoca) {
        this.fechaHoraColoca = fechaHoraColoca;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }
  
    
    //el toString

    @Override
    public String toString() {
        return "CitaVacunacion{" + "codCita=" + this.codCita + ", idCiudadano=" + this.idCiudadano + ", codRefuerzo=" + this.codRefuerzo + ", fechaHoraCita=" + this.fechaHoraCita + ", centroVacunacion=" + this.centroVacunacion + ", fechaHoraColoca=" + this.fechaHoraColoca + ", idVacuna=" + this.idVacuna + '}';
    }
    
    
  
}
