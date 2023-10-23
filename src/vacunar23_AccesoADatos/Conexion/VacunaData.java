
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
                    + " VALUES (?, ?, ?, ?, ?, ?)";

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
        String sql = "UPDATE vacuna SET marca = ?, medida = ?, fechaCaduda = ?, colocada = ?, idLaboratorio = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, vacuna.getMarca());
            ps.setDouble(2, vacuna.getMedida());
            ps.setDate(3, Date.valueOf(vacuna.getFechaCaduca()));
            ps.setBoolean(4, vacuna.isColocada());
            ps.setInt(5, vacuna.getLaboratorio().getIdLaboratorio());
            
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
                laboratorio.setIdLaboratorio(RSetVacunas.getInt("idLaboratorio")); 
                laboratorio.setCuit(RSetVacunas.getLong("CUIT"));
                laboratorio.setNomLaboratorio(RSetVacunas.getString("nomLaboratorio"));
                laboratorio.setPais(RSetVacunas.getString("pais"));
                laboratorio.setDomComercial(RSetVacunas.getString("domComercial"));
                laboratorio.setEstado(RSetVacunas.getBoolean("estado"));
                
                vacuna.setLaboratorio(laboratorio); // Creo que el laboratorio con todos sus datos y se lo paso a la vacuna, de ahí puedo obtener el nombre y el idLaboratorio
                
                //System.out.println(vacuna.getLaboratorio().getNomLaboratorio()); // Me devuelve el nombre del Laboratorio
                
                listarVacunas.add(vacuna);                
            }
            
            ps.close();
            
        } catch (SQLException e) {
            System.out.println("Error al acceder a la lista de vacunas");
        }
                
        return listarVacunas;
    }
    
    public Vacuna buscarPorNroSerie(int nroSerie){
        Vacuna vacuna = null;
        try{
        String sql = "SELECT idVacuna, nroSerieDosis, marca, medida, fechaCaduca, colocada,\n"
                + "vacuna.idLaboratorio, CUIT, nomLaboratorio, pais, domComercial, estado\n"
                + "FROM vacuna\n"
                + "JOIN laboratorio\n"
                + "ON vacuna.idLaboratorio=laboratorio.idLaboratorio\n"
                + "WHERE nroSerieDosis = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, nroSerie);
            System.out.println("a ver si pasa por acá");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                vacuna = new Vacuna();
                Laboratorio laboratorio = new Laboratorio();
                
                vacuna.setIdVacuna(rs.getInt("idVacuna"));
                vacuna.setNroSerie(rs.getInt("nroSerieDosis"));
                vacuna.setMarca(rs.getString("marca"));
                vacuna.setMedida(rs.getDouble("medida"));
                vacuna.setFechaCaduca(rs.getDate("fechaCaduca").toLocalDate());
                vacuna.setColocada(rs.getBoolean("colocada"));
                
                laboratorio.setIdLaboratorio(rs.getInt("idLaboratorio"));
                laboratorio.setCuit(rs.getLong("CUIT"));
                laboratorio.setNomLaboratorio(rs.getString("nomLaboratorio"));
                laboratorio.setPais(rs.getString("pais"));
                laboratorio.setDomComercial(rs.getString("domComercial"));
                laboratorio.setEstado(rs.getBoolean("estado"));
                
                vacuna.setLaboratorio(laboratorio);
                
            }
        } catch (SQLException ex) {
            
        }
        return vacuna;
    }
        
    
}
