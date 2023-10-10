
package vacunar23_Entidades;

import java.time.LocalDate;

public class Vacuna {
    
    private int idVacuna;
    private Laboratorio laboratorio; // Lo voy a necesitar para vincular con los laboratorios
    private int stock;
    
    private int nroSerie;
    private String marca;
    private double medida;
    private LocalDate fechaCaduca;
    private boolean colocada = false;
    
    public Vacuna(){}
    
    public Vacuna(int id, Laboratorio lab, int stock, int nroSerie, String marca, double medida, LocalDate fecha, boolean colocada){
        idVacuna = id;
        laboratorio = lab;
        this.stock = stock;
        this.nroSerie = nroSerie;
        this.marca = marca;
        this.medida = medida;
        fechaCaduca = fecha;
        this.colocada = colocada;
    }
    
    public Vacuna(Laboratorio lab, int stock, int nroSerie, String marca, double medida, LocalDate fecha, boolean colocada){
        laboratorio = lab;
        this.stock = stock;
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
    
    public int getStock(){
        return stock;
    }
    
    public void setStock(int stock){
        this.stock = stock;
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
    public String toString() { // SE PUEDE MEJORAR SEGÚN LO QUE QUIERA MOSTRAR, ESTO ES SOLO UNA PRUEBA
        return marca + " - " + laboratorio + ":\n" + nroSerie + "\n " + medida +"\n " + fechaCaduca;
    }    
    

}
