
package vacunar23_Entidades;

public class Laboratorio {
    
    private int idLaboratorio;
    private int CUIT;
    private String nomLaboratorio;
    private String pais;
    private String domComercial;
    private boolean estado;
   
    // constructor vacio
    public Laboratorio () {
    }

    
    // constructor con idLaboratorio
    public Laboratorio( int idLaboratorio, int CUIT, String nomLaboratorio, String pais, String domComercial, boolean estado) {
        this.idLaboratorio = idLaboratorio;
        this.CUIT = CUIT;
        this.nomLaboratorio = nomLaboratorio;
        this.pais = pais;
        this.domComercial = domComercial;
        this.estado = estado;
    }
    
    // constructor sin idLaboratorio
     public Laboratorio(int CUIT, String nomLaboratorio, String pais, String domComercial) {
        this.CUIT = CUIT;
        this.nomLaboratorio = nomLaboratorio;
        this.pais = pais;
        this.domComercial = domComercial;
    }
    
     
     
    // getter and setter

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public String getNomLaboratorio() {
        return nomLaboratorio;
    }

    public void setNomLaboratorio(String nomLaboratorio) {
        this.nomLaboratorio = nomLaboratorio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDomComercial() {
        return domComercial;
    }

    public void setDomComercial(String domComercial) {
        this.domComercial = domComercial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

    @Override
    public String toString() {
        return "Laboratorio{" + "CUIT=" + CUIT + ", nomLaboratorio=" + nomLaboratorio + ", pais=" + pais + ", domComercial=" + domComercial + '}';
    }
    
    
    
    
    
}
