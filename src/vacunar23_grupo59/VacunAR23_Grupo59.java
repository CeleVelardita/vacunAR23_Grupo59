
package vacunar23_grupo59;

import java.sql.Connection;
import java.time.LocalDate;
import jdk.nashorn.internal.codegen.CompilerConstants;
import vacunar23_AccesoADatos.Conexion.CiudadanoData;
import vacunar23_AccesoADatos.Conexion.Conexion;
import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_AccesoADatos.Conexion.VacunaData;
import vacunar23_Entidades.Ciudadano;
import vacunar23_Entidades.Laboratorio;
import vacunar23_Entidades.Vacuna;

public class VacunAR23_Grupo59 {

    public static void main(String[] args) {
        
        //Connection con = Conexion.getConexion();
        /*
        Ciudadano persona = new Ciudadano(22111555, "Ezequiel Diaz", "programeze@gmail.com", "11-002234256", "ninguno", "profesor");
        CiudadanoData datos = new CiudadanoData();
        datos.guardarCiudadano(persona);
        System.out.println("----------------");
        datos.buscarCiudadano(22111555);
        */
        
        
        Laboratorio lab = new Laboratorio(301112223,"Pirulito" , "Argentina", "Avenida Siempreviva 123", true);
        
        
        
        String fecha = "2030-07-20";
        LocalDate fechaCaduca = LocalDate.parse(fecha);
        
        Laboratorio datos = new Laboratorio();
        long cuit = datos.getCuit();
                
        Vacuna pichicata = new Vacuna(112233,"Sputnik V" ,0.5 , fechaCaduca, false, cuit);
                
        VacunaData vacunas = new VacunaData();
        vacunas.cargarVacuna(pichicata);
        
    }
    
}
