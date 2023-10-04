
package vacunar23_grupo59;

import java.sql.Connection;
import vacunar23_AccesoADatos.Conexion.CiudadanoData;
import vacunar23_AccesoADatos.Conexion.Conexion;
import vacunar23_Entidades.Ciudadano;

public class VacunAR23_Grupo59 {

    public static void main(String[] args) {
        
        //Connection con = Conexion.getConexion();
        
        Ciudadano persona = new Ciudadano(22333444, "Fua Sandra", "fuasandra@gmail.com", "2901-192134", "diabetes", "salud");
        CiudadanoData datos = new CiudadanoData();
        datos.guardarCiudadano(persona);
        
        
    }
    
}
