
package vacunar23_Entidades;

public class Laboratorio {
    private int idLaboratorio;
    private int cuit;
    private String nomLaboratorio;
    private String pais; 
    private String domComercial;

    public Laboratorio() {
    }

    public Laboratorio(int idLaboratorio, int cuit, String nomLaboratorio, String pais, String domComercial) {
        this.idLaboratorio = idLaboratorio;
        this.cuit = cuit;
        this.nomLaboratorio = nomLaboratorio;
        this.pais = pais;
        this.domComercial = domComercial;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
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

    @Override
    public String toString() {
        return "Laboratorio{" + "idLaboratorio=" + idLaboratorio + ", cuit=" + cuit + ", nomLaboratorio=" + nomLaboratorio + ", pais=" + pais + ", domComercial=" + domComercial + '}';
    }
    
    
    
}
