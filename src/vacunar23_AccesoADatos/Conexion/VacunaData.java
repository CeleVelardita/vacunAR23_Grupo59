
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
import vacunar23_Entidades.Vacuna;

public class VacunaData {
    
    private Connection con = null;
    private LaboratorioData lab;
    
    public VacunaData(){
        con = Conexion.getConexion();
    }
    
    // El método cargarVacuna ingresa en la BD la vacuna que se va a colocar el paciente
    public void cargarVacuna(Vacuna vacuna){
        String sql = "INSERT INTO vacuna (nroSerieDosis, marca, medida, fechaCaduca, coloca)"
                + "+ VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
            
            ps.setInt(1, vacuna.getNroSerie());
            ps.setString(2, vacuna.getMarca());
            ps.setDouble(3, vacuna.getMedida());
            ps.setDate(4, Date.valueOf(vacuna.getFechaCaduca()));
            ps.setBoolean(5, vacuna.isColocada());
            
            int columnaAfectada = ps.executeUpdate();
            
            if(columnaAfectada > 0){
                ResultSet id = ps.getGeneratedKeys();
                if(id.next()){
                    System.out.println("La vacuna fue cargada exitosamente");
                    
                } else{
                    System.out.println("No de ha cargado ninguna vacuna");
                }
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla de vacunas: "+ex.getMessage());
        }
    }
    
    
    // El método eliminarVacuna va a eliminar la vacuna según el número de serie... o la marca?
    public void eliminarVacuna(){
        
    }
    
    public List<Vacuna> listarVacunas(){
        
        ArrayList<Vacuna> listarVacunas = new ArrayList<>();
        
        return listarVacunas;
    }
    
    
}
