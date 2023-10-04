
package vacunar23_Entidades;

import java.time.LocalDate;

public class CitaVacunacion {
    private int codCita;
    private int idCiudadano;
    private LocalDate fechaHoraCita;
    private String centroVacunacion; 
    private LocalDate fechaHoraColoca;
    private int idVacuna;
    //private Vacuna vacuna;
    //private Ciudadano ciudadano;

    public CitaVacunacion() {
    }

    public CitaVacunacion(int codCita, int idCiudadano, LocalDate fechaHoraCita, String centroVacunacion, LocalDate fechaHoraColoca, int idVacuna) {
        this.codCita = codCita;
        this.idCiudadano = idCiudadano;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.idVacuna = idVacuna;
    }

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

    public LocalDate getFechaHoraColoca() {
        return fechaHoraColoca;
    }

    public void setFechaHoraColoca(LocalDate fechaHoraColoca) {
        this.fechaHoraColoca = fechaHoraColoca;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    @Override
    public String toString() {
        return "CitaVacunacion{" + "codCita=" + codCita + ", idCiudadano=" + idCiudadano + ", fechaHoraCita=" + fechaHoraCita + ", centroVacunacion=" + centroVacunacion + ", fechaHoraColoca=" + fechaHoraColoca + ", idVacuna=" + idVacuna + '}';
    }
    
    
    
}
