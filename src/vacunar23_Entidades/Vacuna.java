
package vacunar23_Entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Vacuna {
    
    private int idVacuna;
    private Laboratorio laboratorio; // Lo voy a necesitar para vincular con los laboratorios
        
    private int nroSerie;
    private String marca;
    private double medida;
    private LocalDate fechaCaduca;
    private boolean colocada = false;
    
    private int idLaboratorio;
        
    public Vacuna(){}
    
    public Vacuna(int id, int nroSerie, String marca, double medida, LocalDate fecha, boolean colocada, Laboratorio lab ){
        idVacuna = id;
        laboratorio = lab;
        this.nroSerie = nroSerie;
        this.marca = marca;
        this.medida = medida;
        fechaCaduca = fecha;
        this.colocada = colocada;
    }
    
    public Vacuna(int nroSerie, String marca, double medida, LocalDate fecha, boolean colocada, Laboratorio lab){
        this.nroSerie = nroSerie;
        this.marca = marca;
        this.medida = medida;
        fechaCaduca = fecha;
        this.colocada = colocada;
        laboratorio = lab;
    }
    
    /*--------------------------------------------*/
    public Vacuna(int id, int nroSerie, String marca, double medida, LocalDate fecha, boolean colocada, int idLaboratorio ){
        this.idVacuna = idVacuna;
        this.idLaboratorio = idLaboratorio;
        this.nroSerie = nroSerie;
        this.marca = marca;
        this.medida = medida;
        fechaCaduca = fechaCaduca;
        this.colocada = colocada;
    }
    /*---------------------------------------------*/

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public Laboratorio getLaboratorio(){
        return laboratorio;
    }
    
    public void setLaboratorio(Laboratorio laboratorio){
        this.laboratorio = laboratorio;
    }
        
    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public int getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(int nroSerie) {
        this.nroSerie = nroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public LocalDate getFechaCaduca() {
        return fechaCaduca;
    }

    public void setFechaCaduca(LocalDate fechaCaduca) {
        this.fechaCaduca = fechaCaduca;
    }

    public boolean isColocada() {
        return colocada;
    }

    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "idVacuna=" + idVacuna + ", laboratorio=" + laboratorio + ", nroSerie=" + nroSerie + ", marca=" + marca + ", medida=" + medida + ", fechaCaduca=" + fechaCaduca + ", colocada=" + colocada + ", idLaboratorio=" + idLaboratorio + '}';
    }

    
    
     

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        final Vacuna otraVac = (Vacuna) obj;
        
        return Objects.equals(nroSerie, otraVac.getNroSerie());
    }
    

}
