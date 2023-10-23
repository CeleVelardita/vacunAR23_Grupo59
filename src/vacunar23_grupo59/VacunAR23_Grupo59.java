
package vacunar23_grupo59;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
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
        
        Ciudadano persona = new Ciudadano();
        CiudadanoData ciuData = new CiudadanoData();
        Laboratorio lab = new Laboratorio();
        LaboratorioData labData = new LaboratorioData();
        Vacuna vac = new Vacuna();
        VacunaData vacuData = new VacunaData();
        
        
        
        /*---------------Cargar Ciudadano---------------*/
        //Ciudadano persona = new Ciudadano(22111555, "Ezequiel Diaz", "programeze@gmail.com", "11-002234256", "ninguno", "profesor");
        
        // Guardamos el ciudadano
        //ciuData.guardarCiudadano(persona);
        
        // Buscamos el ciudadano
        //ciuData.buscarCiudadano(22111555);
        
        
        
        
        
        
        /*---------------Cargar Laboratorio--------------*/
        
        /// -> NOTA: Para poder cargar un número de tipo long, primero hay que ingresarlo como un String y luego parsearlo
        //String numerito = "12345678923";
        //long num = Long.parseLong(numerito);
        
        //Laboratorio lab = new Laboratorio(num,"Pirulito" , "Argentina", "Avenida Siempreviva 123", true);
        
        /// Cargamos el laboratorio        
        //labData.cargarLaboratorio(lab);        
        
        /// Buscamos por CUIT
        //labData.buscarLaboratorioXCUIT(num);
        //System.out.println(lab.getIdLaboratorio());
        //System.out.println(lab.getCuit());
        //System.out.println(lab.getNomLaboratorio());
        
        
        
        
        
        
        /*---------------Cargar Vacuna---------------*/
        
        /// CARGA DE VACUNA
        
        /// -> NOTA: Para poder cargar una fecha de tipo LocalDate, primero hay que ingresarla como un String y luego parsearla
        //String fecha = "2025-11-20";
        //LocalDate fechaCaduca = LocalDate.parse(fecha);
        
        /// Ingreso manualmente el id, simulando ser un comboBox
        //int id = 3;
        //Laboratorio laboratorio = new Laboratorio(id);
           
        //String nombre = vacuData.nombreLab(id); //Guardo el nombre del Laboratorio
        /*
        if (nombre != null) {
            Vacuna vacuna = new Vacuna(2222,"Pfitzer" ,0.3 , fechaCaduca, false, nombre, laboratorio);
           
            // Cargamos la vacuna
            vacuData.cargarVacuna(vacuna);
            System.out.println("El nombre del laboratorio correspondiente es "+ vacuna.getNombreLab());
            
        }else{
            System.out.println("No se ha encontrado ningún laboratorio");
        }
        */
        
        
        /// MODIFICACIÓN DE VACUNA
        
        
        ArrayList<Vacuna> listaVacuna = new ArrayList();
        listaVacuna = (ArrayList<Vacuna>) vacuData.listarVacunas();
        listaVacuna.forEach(vacuna ->System.out.println(vacuna.toString()));
        
        //vacuData.listarVacunas();
        
    }
    
}
