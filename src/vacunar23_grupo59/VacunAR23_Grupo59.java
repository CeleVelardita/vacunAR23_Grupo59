
package vacunar23_grupo59;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import jdk.nashorn.internal.codegen.CompilerConstants;
import vacunar23_AccesoADatos.Conexion.CiudadanoData;
import vacunar23_AccesoADatos.Conexion.Conexion;
import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_AccesoADatos.Conexion.VacunaData;
import vacunar23_AccesoADatos.Conexion.citaData;
import vacunar23_Entidades.CitaVacunacion;
import vacunar23_Entidades.Ciudadano;
import vacunar23_Entidades.Laboratorio;
import vacunar23_Entidades.Vacuna;

public class VacunAR23_Grupo59 {

    public static void main(String[] args) {
        
        //Connection con = Conexion.getConexion();
        
        Ciudadano persona = new Ciudadano();
        CiudadanoData ciuData = new CiudadanoData();
        Laboratorio laboratorio = new Laboratorio();
        LaboratorioData labData = new LaboratorioData();
        Vacuna vac = new Vacuna();
        VacunaData vacuData = new VacunaData();
        CitaVacunacion citaVacuna = new CitaVacunacion();
        citaData citaData = new citaData();
        
        
                
        /*---------------Cargar Laboratorio--------------*/
        
        /// -> NOTA: Para poder cargar un número de tipo long, primero hay que ingresarlo como un String y luego parsearlo
        String numerito = "12345678923";
        long num = Long.parseLong(numerito);
        
        Laboratorio lab = new Laboratorio(num,"Pirulito" , "Argentina", "Avenida Siempreviva 123", true);
        
        /// Cargamos el laboratorio        
        labData.cargarLaboratorio(lab);        
        
        /// Buscamos por CUIT
        labData.buscarLaboratorioXCUIT(num);
        //System.out.println(lab.getIdLaboratorio());
        //System.out.println(lab.getCuit());
        //System.out.println(lab.getNomLaboratorio());
        
        /// Eliminamos el laboratorio (le damos de baja)
        labData.cambiarEstadoLaboratorio(lab.getCuit());
        
        /// Modificamos el laboratorio
        labData.modificarLaboratorio(lab);
        
        /// Listamos los laboratorios
        labData.listarLaboratorios();
        
        /// Buscamos por ID
        labData.buscarLaboratorioxID(lab.getIdLaboratorio());
        
        /// Buscamos por NOMBRE
        labData.buscarLaboratorioXNombre(lab.getNomLaboratorio());
               
        
        
        /*---------------Cargar Vacuna---------------*/
        
        /// CARGA DE DATOS
        
        /// -> NOTA: Para poder cargar una fecha de tipo LocalDate, primero hay que ingresarla como un String y luego parsearla
        String fecha = "2025-11-20";
        LocalDate fechaCaduca = LocalDate.parse(fecha);
        
        /// Ingreso manualmente el id, simulando ser un comboBox
        int id = 3;
        Laboratorio lab2 = new Laboratorio(id);
              
        Vacuna vacu = new Vacuna(2222, "Pfitzer", 0.3, fechaCaduca, false, lab2);

        
        /// Cargamos la vacuna
        vacuData.cargarVacuna(vacu);

        /// Modificamos la vacuna
        vacuData.modificarVacuna(vacu);
        
        /// Eliminamos una vacuna
        vacuData.eliminarVacuna(2222);
        
        /// Listamos las vacunas
        vacuData.listarVacunas();
        
        /// Buscamos por NroSerie
        vacuData.buscarPorNroSerie(2222);

        /// MODIFICACIÓN DE VACUNA
        
        
        
        /*---------------Cargar Ciudadano---------------*/
        Ciudadano ciu = new Ciudadano(22111555, "Ezequiel Diaz", "programeze@gmail.com", "11002234256", "ninguno", "profesor", "Tres de Febrero", 1);
        /// Guardamos el ciudadano
        ciuData.guardarCiudadano(ciu);
        
        /// Buscamos el ciudadano
        ciuData.buscarCiudadano(22111555);
        
        /// Eliminamos el ciudadano
        ciuData.eliminarCiudadano(22111555);
        
        /// Modificamos un ciudadanos
        ciuData.modificarCiudadano(ciu);
        
        /// Listamos los ciudadanos
        ciuData.listarCiudadanos();
        
        /// Listamos los ciudadanos según ámbito laboral
        ciuData.listarCiudadanosPorTrabajo(ciu.getAmbitoTrabajo());
        
        
        
        /*---------------Cargar Cita---------------*/
        String fecha1 = "2023-11-14";
        LocalDate fechaCita = LocalDate.parse(fecha);
        /*
        LocalDateTime fechaHoraColoca = LocalDateTime.now();
                
        CitaVacunacion cita = new CitaVacunacion(112233, fechaCita, "Tres de Febrero", fechaHoraColoca, idVacu, 2, idCiu, false);
        /// Carga de Cita
        */
        
        
    }
    
}
