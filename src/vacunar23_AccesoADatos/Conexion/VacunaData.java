
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
import javax.swing.JOptionPane;
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
    
    - Agregar un método que me permita comparar el idLaboratorio ingresado y compararlo con los id de la tabla de vacunas
    
    
    - Buscar vacuna por id... mmm no sé
    - Buscar vacuna por laboratorio
    - Buscar vacuna por marca
    
    */
    
    
    // El método cargarVacuna ingresa en la BD la vacuna que se va a colocar el paciente
    public void cargarVacuna(Vacuna vacuna){        

            String sql = "INSERT INTO vacuna (nroSerieDosis, marca, medida, fechaCaduca, colocada, nombreLab, idLaboratorio)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setInt(1, vacuna.getNroSerie());
                ps.setString(2, vacuna.getMarca());
                ps.setDouble(3, vacuna.getMedida());
                ps.setDate(4, Date.valueOf(vacuna.getFechaCaduca()));
                ps.setBoolean(5, vacuna.isColocada());
                ps.setString(6, vacuna.getNombreLab());
                ps.setInt(7, vacuna.getLaboratorio().getIdLaboratorio());

                int columnaAfectada = ps.executeUpdate();

                if (columnaAfectada > 0) {
                    ResultSet id = ps.getGeneratedKeys();
                    if (id.next()) {
                        System.out.println("La vacuna fue cargada exitosamente");

                    } else {
                        System.out.println("No se ha cargado ninguna vacuna");
                    }
                }

                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, "Error al acceder a la tabla de vacunas");
                System.out.println("Error al acceder a la tabla de vacunas: " + ex.getMessage());
            } catch (NullPointerException ex) {
                System.out.println(ex.getStackTrace());
                System.out.println("NullPointerException " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error al guardar la vacuna");
            }
    }
     
    public void modificarVacuna(Vacuna vacuna){ // Le mando como parámetro una vacuna de tipo vacuna porque selecciona una fila de la tabla para modificar
        String sql = "UPDATE vacuna SET marca = ?, medida = ?, fechaCaduda = ?, coloca = ?, idLaboratorio = ? WHERE nroSerieDosis = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, vacuna.getMarca());
            ps.setDouble(2, vacuna.getMedida());
            ps.setDate(3, Date.valueOf(vacuna.getFechaCaduca()));
            ps.setBoolean(4, vacuna.isColocada());
            
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
    public void eliminarVacuna(int nroSerieDosis){ // No me cierra eliminar por id, quiero que se elimine al seleccionar una fila de la tabla
        String sql = "DELETE FROM vacuna WHERE nroSerieDosis = ?";        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, nroSerieDosis);
            
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
                
                // Necesito buscar el idLaboratorio, para eso vamos a labData.buscarLaboratorioXid
                // Luego el RSetVacunas.getInt("idLaboratorio") obtiene el id y se lo pasa al método de labData
                // Laboratorio laboratorio (carpeta entidades) almacena el id obtenido
                Laboratorio laboratorio = labData.buscarLaboratorioXCUIT(RSetVacunas.getInt("CUIT"));
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
    
    
    
    
    /*------- Necesito un método que me permita obtener solamente el nombre del Laboratorio correspondiente del id seleccionado--------*/
    
    public String nombreLab(int id){
            
        String sql = "SELECT nomLaboratorio FROM laboratorio WHERE idLaboratorio = ?"; 
        // Seteo laboratorio en null, luego le cargo los datos del laboratorio buscado
        Laboratorio laboratorio = null; 
        
        String nombreLab = null; // Declaro esta variable de retorno acá para poder usarla dentro del try/catch y el if
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet buscarId = ps.executeQuery(); // Uso el query que significa "CONSULTA" y almaceno la lista que devuelva en resultSet
            
            if(buscarId.next()){
                laboratorio = new Laboratorio();                
                nombreLab = buscarId.getString("nomLaboratorio");              
            } else{     
                nombreLab = null;
                JOptionPane.showMessageDialog(null, "No existe un laboratorio con el id ingresado");
            }
            
        ps.close();    
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla laboratorio");
            System.out.println(ex.getMessage());
        } catch(NullPointerException ex){
            nombreLab = null;
            JOptionPane.showConfirmDialog(null, "No se pudo acceder a la tabla laboratorio");
            System.out.println("No existe un laboratorio con el id ingresado");
        }
        
        //System.out.println("Chequeando qué nombre se guardó ---> "+nombreLab);
        
        return nombreLab;        

    }
    
    /* El método de abajo fue una de las primeras tentativas para obtener el nombre del laboratorio a partir del id ingresado
    public void otroMetodo(){
        String sql = "SELECT nomLaboratorio FROM laboratorio JOIN vacuna ON laboratorio.idLaboratorio = vacuna.idLaboratorio WHERE laboratorio.idLaboratorio = ?";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet buscaId = ps.executeQuery();
            
            if (buscaId.next()) {
                
                Vacuna vacuna = new Vacuna();              
                vacuna.setNombreLab(buscaId.getString("nomLaboratorio"));
                
            } else{
                System.out.println("No existe en la BD el laboratorio indicado");
            }
             
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error al acceder al nombre del Laboratorio");
        }
    }
    */
}
