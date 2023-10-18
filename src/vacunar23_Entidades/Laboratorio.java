
package vacunar23_Entidades;

public class Laboratorio {
    private int idLaboratorio;
    private long cuit;
    private String nomLaboratorio;
    private String pais; 
    private String domComercial;
    private boolean estado;
    
    
    public Laboratorio() {
    }
   
    
    
    /*--------------------------------------*/
    // Creo un constructor me permita enviar un argumento de tipo Stirng para la vista de Vacuna
    
    public Laboratorio(String nomLaboratorio){
        this.nomLaboratorio = nomLaboratorio;
    }
    /*--------------------------------------*/
    
    
    
    public Laboratorio(int idLaboratorio, long cuit, String nomLaboratorio, String pais, String domComercial, boolean estado) {
        this.idLaboratorio = idLaboratorio;
        this.cuit = cuit;
        this.nomLaboratorio = nomLaboratorio;
        this.pais = pais;
        this.domComercial = domComercial;
        this.estado = estado;
    }

    public Laboratorio(long cuit, String nomLaboratorio, String pais, String domComercial, boolean estado) {
        this.cuit = cuit;
        this.nomLaboratorio = nomLaboratorio;
        this.pais = pais;
        this.domComercial = domComercial;
        this.estado = estado;
    }
    
    
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
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
        return nomLaboratorio;
    }
   
}
