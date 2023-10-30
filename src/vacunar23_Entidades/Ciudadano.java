
package vacunar23_Entidades;

public class Ciudadano {
    
    private int idCiudadano; // Atributo creado por nos por conveniencia   
    
    private int dni;
    private String nombreCompleto;
    private String email;
    private String celular;
    private String patologia = null;
    private String ambitoTrabajo;
    private String distrito;
    private int codRefuerzo = 0;

    public Ciudadano(){}
    
    public Ciudadano(int idCiudadano, int dni, String nombreCompleto, String email, String celular, String patologia, String ambitoTrabajo, String distrito, int codRefuerzo) {
        this.idCiudadano = idCiudadano;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.celular = celular;
        this.patologia = patologia;
        this.ambitoTrabajo = ambitoTrabajo;
        this.distrito = distrito;
        this.codRefuerzo = codRefuerzo;
    }    
    
    
      public Ciudadano(int dni, String nombreCompleto, String email, String celular, String patologia, String ambitoTrabajo, String distrito, int codRefuerzo) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.celular = celular;
        this.patologia = patologia;
        this.ambitoTrabajo = ambitoTrabajo;
        this.distrito = distrito;
        this.codRefuerzo = codRefuerzo;
    } 
    
    public int getIdCiudadano(){
        return idCiudadano;
    }
    
    public void setIdCiudadano(int id){
        idCiudadano = id;
    }
    
    public int getDni(){
        return dni;
    }
    
    public void setDni(int dni){
        this.dni = dni;
    }
    
    public String getNombreCompleto(){
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombre){
        nombreCompleto = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getAmbitoTrabajo() {
        return ambitoTrabajo;
    }

    public void setAmbitoTrabajo(String ambitoTrabajo) {
        this.ambitoTrabajo = ambitoTrabajo;
    }
    
    public String getDistrito(){
        return distrito;
    }
    
    public void setDistrito(String distrito){
        this.distrito = distrito;
    }
    
    public int getCodRefuerzo(){
        return codRefuerzo;
    }
    
    public void setCodRefuerzo(int codRefuerzo){
        this.codRefuerzo = codRefuerzo;
    }

    @Override
    public String toString() {
        return "Ciudadano{" + "dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", email=" + email + ", celular=" + celular + ", patologia=" + patologia + ", ambitoTrabajo=" + ambitoTrabajo + '}';
    }
    
        
}

//alo alo