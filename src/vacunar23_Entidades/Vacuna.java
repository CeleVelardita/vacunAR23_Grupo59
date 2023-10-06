
package vacunar23_Entidades;

import java.time.LocalDate;

public class Vacuna {
    
    private int idVacuna;
    private Laboratorio laboratorio; // Lo voy a necesitar para vincular con los laboratorios
    
    private int nroSerie;
    private String marca;
    private double medida;
    private LocalDate fechaCaduca;
    private boolean colocada = false;
    
    public Vacuna(){}
    
    public Vacuna(int id, Laboratorio lab, int nroSerie, String marca, double medida, LocalDate fecha, boolean colocada){
        idVacuna = id;
        laboratorio = lab;
        this.nroSerie = nroSerie;
        this.marca = marca;
        this.medida = medida;
        fechaCaduca = fecha;
        this.colocada = colocada;
    }
    
    public Vacuna(Laboratorio lab, int nroSerie, String marca, double medida, LocalDate fecha, boolean colocada){
        laboratorio = lab;
        this.nroSerie = nroSerie;
        this.marca = marca;
        this.medida = medida;
        fechaCaduca = fecha;
        this.colocada = colocada;
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
        return "Vacuna{" + "idVacuna=" + idVacuna + ", nroSerie=" + nroSerie + ", marca=" + marca + ", medida=" + medida + ", fechaCaduca=" + fechaCaduca + ", colocada=" + colocada + '}';
    }    
    

}
