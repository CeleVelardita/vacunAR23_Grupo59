
package vacunar23_Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaVacunacion {
    private int codCita;
    private LocalDate fechaHoraCita;//fecha
    private String centroVacunacion; 
    private LocalTime horarioTurno;//horario
    private Vacuna vacuna;
    private int codRefuerzo;
    private Ciudadano ciudadano;       
    private String estado;

    public CitaVacunacion() {
    }

    public CitaVacunacion(int codCita, LocalDate fechaHoraCita, String centroVacunacion, LocalTime horarioTurno, Vacuna vacuna, int codRefuerzo, Ciudadano ciudadano, String estado) {
        this.codCita = codCita;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.horarioTurno = horarioTurno;
        this.vacuna = vacuna;
        this.codRefuerzo = codRefuerzo;
        this.ciudadano = ciudadano;
        this.estado = estado;
    }
    public CitaVacunacion(LocalDate fechaHoraCita, LocalTime horarioTurno, Vacuna vacuna, int codRefuerzo, Ciudadano ciudadano, String estado) {       
        this.fechaHoraCita = fechaHoraCita;
        this.horarioTurno = horarioTurno;
        this.vacuna = vacuna;
        this.codRefuerzo = codRefuerzo;
        this.ciudadano = ciudadano;
        this.estado = estado;
    }
    
    
    
    public int getCodCita() {
        return codCita;
    }

    public void setCodCita(int codCita) {
        this.codCita = codCita;
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

    public LocalTime getHorarioTurno() {
        return horarioTurno;
    }

    public void setHorarioTurno(LocalTime horarioTurno) {
        this.horarioTurno = horarioTurno;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public int getCodRefuerzo() {
        return codRefuerzo;
    }

    public void setCodRefuerzo(int codRefuerzo) {
        this.codRefuerzo = codRefuerzo;
    }

    
    
    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        return "CitaVacunacion{" + "codCita=" + codCita + ", fechaHoraCita=" + fechaHoraCita + ", centroVacunacion=" + centroVacunacion + ", fechaHoraColoca=" + horarioTurno + ", vacuna=" + vacuna + ", ciudadano=" + ciudadano + '}';
    }

   
    
    
}
