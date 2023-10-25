
package vacunar23_Entidades;

import java.util.Objects;

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
    // Creo un constructor me permita enviar un argumento de tipo int para la vista de Vacuna
    
    public Laboratorio(int idLab){
        idLaboratorio = idLab;
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
        //La línea de abajo me la sigirió el mismo método y la dejé
        final Laboratorio otroLab = (Laboratorio) obj;

        return Objects.equals(nomLaboratorio, otroLab.getNomLaboratorio());
    }
    
   /*------------------------------------------------------------------------------------
                              EXPLICACIÓN DEL MÉTODO EQUALS()
    
    Primero: Para comparar el contenido de dos objetos debe implementarse el método .equals(),
    si se comparan dos objetos usando el operador "==", lo que se hace en realidad es comparar 
    sus referencias pero no lo que contienen. Si estos objetos a comprar tienen diferentes 
    instancias pero el mismo contenido, de todas maneras NO funcionará.
    
    
    Segundo: Paso a paso según chatGPT
    
    1) Sobrescribe el método equals() en la clase del objeto. Asegúrate de que el método equals()
    reciba un argumento de tipo Object y devuelva un valor booleano (true si los objetos son 
    iguales y false si no lo son). 
    
    2) El método equals() debe comparar los campos o atributos relevantes de los objetos para 
    determinar si son iguales. En el método equals(), verifica si el objeto pasado como argumento 
    es una instancia de la misma clase que estás comparando. Si no lo es, devuelve false.
    
    3)Realiza las comparaciones necesarias para determinar si los campos de los objetos son 
    iguales y devuelve true si son iguales, false en caso contrario.
    
    (chatGpt)
    "En el método equals(Object obj) de la clase que deseas comparar, el parámetro se declara 
    como tipo Object por convención. Esto es parte de la firma estándar del método equals 
    definido en la clase Object de Java. La razón para esto es que Java permite comparar 
    cualquier objeto con otro objeto, independientemente de su tipo, utilizando el método equals.
    Esto proporciona flexibilidad en la comparación de objetos.
    Dentro del método equals, generalmente deberías realizar algunas comprobaciones, como 
    verificar si el objeto obj es una instancia de la misma clase antes de intentar compararlo. 
    Esto es para evitar errores de tiempo de ejecución. Luego, puedes realizar la comparación 
    específica de los atributos relevantes de tu clase para determinar si los objetos son iguales."
   
    -------------------------------------------------------------------------------------*/
   
}
