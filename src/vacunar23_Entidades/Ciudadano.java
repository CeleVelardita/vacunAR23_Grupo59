
package vacunar23_Entidades;

public class Ciudadano {
    private int dni;
    private String nombreCompleto;
    private String email;
    private String celular;
    private String patologia;
    private String ambitoTrabajo;
    
    public Ciudadano(){}
    
    public Ciudadano(int dni, String nombre, String email, String cel, String patologia, String ambTrab){
        this.dni = dni;
        nombreCompleto = nombre;
        this.email = email;
        celular = cel;
       patologia = null;
       ambitoTrabajo = ambTrab;
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

    @Override
    public String toString() {
        return "Ciudadano{" + "dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", email=" + email + ", celular=" + celular + ", patologia=" + patologia + ", ambitoTrabajo=" + ambitoTrabajo + '}';
    }
    
        
}
