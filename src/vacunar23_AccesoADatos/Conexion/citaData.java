
package vacunar23_AccesoADatos.Conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vacunar23_Entidades.CitaVacunacion;


public class citaData {
    private Connection con = null;//objeto de clase Connection para usar su método getConexion        
    public citaData() {
        con = Conexion.getConexion();//  creamos el méotodo en con
    }
    
    /*
    métodos para esta clase:
        ->anotar una cita
        ->modificar una cita
        ->borrar cita o dar de baja
        ->mostrar lista de citas -- ver a futuro colocar un calendario de citas con botón agenda
        ->buscar cita por dni del ciudadano
        ->buscar cita por fecha    
        ->
        ->
        ->    
    */
    
    
    public void cargarCita(CitaVacunacion citaVacunacion){
        
        try {
            String sql ="INSERT INTO citavacunacion (codCita, idCiudadano, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, idVacuna) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //int,int,int,date,string,date,int
            ps.setInt(0, citaVacunacion.getCodCita());
            ps.setInt(1, citaVacunacion.getCiudadano().getIdCiudadano());
            ps.setInt(2, citaVacunacion.getCodRefuerzo());
            ps.setDate(4, Date.valueOf(citaVacunacion.getFechaHoraCita()));
            ps.setString(5, citaVacunacion.getCentroVacunacion());
            ps.setDate(6, Date.valueOf(citaVacunacion.getFechaHoraColoca()));
            ps.setInt(7, citaVacunacion.getVacuna().getIdVacuna());            
            int columnaAfectada = ps.executeUpdate();//ejecuta la sentencia hacia la tabla
            
            //debemos revisar si el ingreso se realizó correctamente con columnaAfectada
            ResultSet lista = ps.getGeneratedKeys();
            if(lista.next()){
                citaVacunacion.setCodCita(lista.getInt("codCita"));//setea al modelo el codCita que existe en esa fila que rescató el resulset
                JOptionPane.showMessageDialog(null, "Laboratorio Ingresado Correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla citaVacunacion"+ex.getMessage());
        }
        
        
    }
    
}
