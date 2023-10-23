
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

            String sql = "INSERT INTO vacuna (nroSerieDosis, marca, medida, fechaCaduca, colocada, idLaboratorio)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setInt(1, vacuna.getNroSerie());
                ps.setString(2, vacuna.getMarca());
                ps.setDouble(3, vacuna.getMedida());
                ps.setDate(4, Date.valueOf(vacuna.getFechaCaduca()));
                ps.setBoolean(5, vacuna.isColocada());
                ps.setInt(6, vacuna.getLaboratorio().getIdLaboratorio());

                int columnaAfectada = ps.executeUpdate();

                if (columnaAfectada > 0) {
                    ResultSet id = ps.getGeneratedKeys();
                    if (id.next()) {
                        System.out.println("La vacuna fue cargada exitosamente");
                        JOptionPane.showMessageDialog(null, "La vacuna fue cargada exitosamente");
                    } else {
                        System.out.println("No se ha cargado ninguna vacuna"); 
                    JOptionPane.showMessageDialog(null, "No se ha cargado ninguna vacuna");}
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
        String sql = "UPDATE vacuna SET nroSerieDosis = ?, marca = ?, medida = ?, fechaCaduda = ?, colocada = ?, idLaboratorio = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, vacuna.getNroSerie());
            ps.setString(2, vacuna.getMarca());
            ps.setDouble(3, vacuna.getMedida());
            ps.setDate(4, Date.valueOf(vacuna.getFechaCaduca()));
            ps.setBoolean(5, vacuna.isColocada());
            ps.setInt(6, vacuna.getLaboratorio().getIdLaboratorio());
            
            int filaAfectada = ps.executeUpdate();
            
            if (filaAfectada > 0) {                
                ResultSet id = ps.getGeneratedKeys();
                if (id.next()) {
                    System.out.println("¡Modificación exitosa!");
                    JOptionPane.showMessageDialog(null,"¡Modificación exitosa!");
                }
                
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido ingresar a la tabla de Vacunas");
            JOptionPane.showMessageDialog(null, "No se ha podido ingresar a la tabla de Vacunas");
        } catch (NumberFormatException ex){
             System.out.println("NullPointerException " + ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al modificar la vacuna");
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
        String sql = "SELECT idVacuna, nroSerieDosis, marca, medida, fechaCaduca, colocada, v.idLaboratorio, CUIT, nomLaboratorio, pais, domComercial, estado\n"
                + "FROM vacuna AS v\n"
                + "JOIN laboratorio AS l\n"
                + "ON v.idLaboratorio=l.idLaboratorio";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet RSetVacunas = ps.executeQuery();
            
            while(RSetVacunas.next()) {
                Vacuna vacuna = new Vacuna();
                
                Laboratorio laboratorio = new Laboratorio();
                
                vacuna.setIdVacuna(RSetVacunas.getInt("idVacuna"));
                vacuna.setNroSerie(RSetVacunas.getInt("nroSerieDosis"));
                vacuna.setMarca(RSetVacunas.getString("marca"));
                vacuna.setMedida(RSetVacunas.getDouble("medida"));
                vacuna.setFechaCaduca(RSetVacunas.getDate("fechaCaduca").toLocalDate()); // NO OLVIDAR "toLocalDate" PARA PARSEAR
                vacuna.setColocada(RSetVacunas.getBoolean("colocada"));
                
                //Necesito setear un laboratorio para enviarselo a la tabla de vacunas y de ahí obtener los datos que necesito
                laboratorio.setIdLaboratorio(RSetVacunas.getInt("idLaboratorio")); // Hace referencia a la sentencia sql, pero también puede ser IdLaboratorio
                laboratorio.setCuit(RSetVacunas.getLong("CUIT"));
                laboratorio.setNomLaboratorio(RSetVacunas.getString("nomLaboratorio"));
                laboratorio.setPais(RSetVacunas.getString("pais"));
                laboratorio.setDomComercial(RSetVacunas.getString("domComercial"));
                laboratorio.setEstado(RSetVacunas.getBoolean("estado"));
                
                vacuna.setLaboratorio(laboratorio); // Creo que el laboratorio con todos sus datos y se lo paso a la vacuna, de ahí puedo obtener el nombre y el idLaboratorio
                
                System.out.println(vacuna.getLaboratorio().getNomLaboratorio()); // Me devuelve el nombre del Laboratorio
                
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
    
    /*---------------------------------------------------------------------------------------------------------------------------------*/
    
    
    
}
