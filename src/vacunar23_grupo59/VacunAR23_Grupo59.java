
package vacunar23_grupo59;

import java.sql.Connection;
import vacunar23_AccesoADatos.Conexion.CiudadanoData;
import vacunar23_AccesoADatos.Conexion.Conexion;
import vacunar23_Entidades.Ciudadano;

public class VacunAR23_Grupo59 {

    public static void main(String[] args) {
        
        //Connection con = Conexion.getConexion();
        
        Ciudadano persona = new Ciudadano(22111555, "Ezequiel Diaz", "programeze@gmail.com", "11-002234256", "ninguno", "profesor");
        CiudadanoData datos = new CiudadanoData();
        datos.guardarCiudadano(persona);
        System.out.println("----------------");
        datos.buscarCiudadano(22111555);
        
        
    }
    
}
