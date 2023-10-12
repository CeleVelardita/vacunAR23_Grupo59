
package vacunar23_AccesoADatos.Conexion;

import com.sun.org.apache.xpath.internal.compiler.PsuedoNames;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vacunar23_Entidades.Laboratorio;
import vacunar23_Entidades.Vacuna;

public class VacunaData {
    
    private Connection con = null;
    private Laboratorio laboratorio;
    private LaboratorioData labData;
    
    public VacunaData(){
        con = Conexion.getConexion();
    }
    
    /* Necesito los siguientes métodos:
    - Cargar vacuna
    - Modificar vacuna
    - Eliminar vacuna    
    - Listar vacunas
    
    - Buscar vacuna por id... mmm no sé
    - Buscar vacuna por laboratorio
    - Buscar vacuna por marca
    
    */
    
    
    // El método cargarVacuna ingresa en la BD la vacuna que se va a colocar el paciente
    public void cargarVacuna(Vacuna vacuna){
        String sql = "INSERT INTO vacuna (nroSerieDosis, marca, medida, fechaCaduca, coloca, stock, idLaboratorio)"
                + "+ VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, vacuna.getNroSerie());
            ps.setString(2, vacuna.getMarca());
            ps.setDouble(3, vacuna.getMedida());
            ps.setDate(4, Date.valueOf(vacuna.getFechaCaduca()));
            ps.setBoolean(5, vacuna.isColocada());
            ps.setInt(6, vacuna.getStock());
            
            ps.setInt(8, vacuna.getLaboratorio().getIdLaboratorio());
            
            int columnaAfectada = ps.executeUpdate();
            
            if(columnaAfectada > 0){
                ResultSet id = ps.getGeneratedKeys();
                if(id.next()){
                    System.out.println("La vacuna fue cargada exitosamente");
                    
                } else{
                    System.out.println("No se ha cargado ninguna vacuna");
                }
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla de vacunas: "+ex.getMessage());
        }
    }
     
    public void modificarVacuna(Vacuna vacuna){ // Le mando como parámetro una vacuna de tipo vacuna porque selecciona una fila de la tabla para modificar
        String sql = "UPDATE vacuna SET nroSerieDosis = ?, marca = ?, medida = ?, fechaCaduda = ?, coloca = ?, stock = ? WHERE idVacuna = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, vacuna.getNroSerie());
            ps.setString(2, vacuna.getMarca());
            ps.setDouble(3, vacuna.getMedida());
            ps.setDate(4, Date.valueOf(vacuna.getFechaCaduca()));
            ps.setBoolean(5, vacuna.isColocada());
            ps.setInt(6, vacuna.getStock());
            
            int filaAfectada = ps.executeUpdate();
            
            if (filaAfectada > 0) {                
                ResultSet id = ps.getGeneratedKeys();
                if (id.next()) {
                    System.out.println("¡Modificación exitosa!");
                }
                
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido ingresar a la tabla de Vacunas");
        }
    }
        
    // El método eliminarVacuna va a eliminar la vacuna según el número de serie... o la marca?
    public void eliminarVacuna(int id){ // No me cierra eliminar por id, quiero que se elimine al seleccionar una fila de la tabla
        String sql = "DELETE FROM vacuna WHERE idVacuna = ?";        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, id);
            
            int filaAfectada = ps.executeUpdate();
            
            if(filaAfectada == 1){
                System.out.println("Vacuna eliminada");
            }else{
                System.out.println("No se ha indicado la vacuna a eliminar");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar a la tabla Vacunas");
        }        
    }
        
    public List<Vacuna> listarVacunas(){        
        ArrayList<Vacuna> listarVacunas = new ArrayList<>();       
        String sql = "SELECT * FROM vacuna";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet RSetVacunas = ps.executeQuery();
            
            while(RSetVacunas.next()) {
                Vacuna vacuna = new Vacuna();
                
                vacuna.setIdVacuna(RSetVacunas.getInt("idVacuna"));
                vacuna.setNroSerie(RSetVacunas.getInt("nroSerieDosis"));
                vacuna.setMarca(RSetVacunas.getString("marca"));
                vacuna.setMedida(RSetVacunas.getDouble("medida"));
                vacuna.setFechaCaduca(RSetVacunas.getDate("fechaCaduca").toLocalDate()); // NO OLVIDAR "toLocalDate" PARA PARSEAR
                vacuna.setColocada(RSetVacunas.getBoolean("colocada"));
                vacuna.setStock(RSetVacunas.getInt("nroSerieDosis"));
                
                // Necesito buscar el idLaboratorio, para eso vamos a labData.buscarLaboratorioXid
                // Luego el RSetVacunas.getInt("idLaboratorio") obtiene el id y se lo pasa al método de labData
                // Laboratorio laboratorio (carpeta entidades) almacena el id obtenido
                Laboratorio laboratorio = labData.buscarLaboratorioXid(RSetVacunas.getInt("idLaboratorio"));
                // Luego se debe setear el id en la tabla "vacuna"
                vacuna.setLaboratorio(laboratorio);
                
                System.out.println("Chequeamos la última línea del idLaboratorio: "+laboratorio.getIdLaboratorio());
                
                // Y finalmente armo la tabla con esos datos
                listarVacunas.add(vacuna);                
            }
            
            ps.close();
            
        } catch (SQLException e) {
            System.out.println("Error al acceder a la lista de vacunas");
        }
                
        return listarVacunas;
    }
    
    
}
