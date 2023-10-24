
package vacunar23_AccesoADatos.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vacunar23_Entidades.Ciudadano;


public class CiudadanoData {
    
    // Creamos un atributo de tipo Connection para poder conectar cada método con la base de datos (BD)
    private Connection con = null;
    
    private List<Ciudadano> listaCiudadanos;
    private List<Ciudadano> listaCiudadanosTrabajo;
    
    /*------------ MÉTODOS NECESARIOS -----------
    
    - Agregar ciudadano
    - Modificar ciudadano
    - Borrar ciudadano
    - Listar ciudadano (todos)
    
    - Buscar por dni
    - Listar por ámbito de trabajo
        
    ----------------------------------------------*/
    
    public CiudadanoData(){
        // Establecemos la conexión con la BD
        con = Conexion.getConexion();
        
        listaCiudadanos = new ArrayList<>();
        listaCiudadanosTrabajo = new ArrayList<>();
    }    
    
    public void guardarCiudadano(Ciudadano ciudadano){
        String sql = "INSERT INTO ciudadano (dni, nombreCompleto, email, celular, patologia, ambitoTrabajo)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, ciudadano.getDni());
            ps.setString(2, ciudadano.getNombreCompleto());
            ps.setString(3, ciudadano.getEmail());
            ps.setString(4, ciudadano.getCelular());
            ps.setString(5, ciudadano.getPatologia());
            ps.setString(6, ciudadano.getAmbitoTrabajo());
            
            // El executeUpdate devuelve un entero
            int columnaAfectada = ps.executeUpdate();
                        
            if (columnaAfectada > 0) {
                // Luego de preparar, enviar y ejecutar las sentencias, pido la clave generada a cada ciudadano, que correspondería al idCiudadano
                // Recordar que el ResultSet devuelve una tabla, pero en este caso sería de una sola columna (idCiudadano) con tantas filas
                // como ciudadanos haya cargado en la BD
                ResultSet id = ps.getGeneratedKeys();
                System.out.println(id);
                if (id.next()) {
                    ciudadano.setIdCiudadano(id.getInt("idCiudadano")); //Va el 1 porque le indico la columna que quiero utilizar, también podría ir el nombre
                    // de la columna entre "" tal cual está en la BD
                    
                    
                    /*-----------------------------*/
                    // Para probar en el main
                    System.out.println("Paciente cargado exitosamente");
                    System.out.println("-------------------------");
                    System.out.println("Chequeamos:");
                    System.out.println(ciudadano.getDni());
                    System.out.println(ciudadano.getNombreCompleto());
                    System.out.println(ciudadano.getEmail());
                    System.out.println(ciudadano.getCelular());
                    System.out.println(ciudadano.getPatologia());
                    System.out.println(ciudadano.getAmbitoTrabajo());
                    System.out.println("También mostramos el id: " + ciudadano.getIdCiudadano());
                    /*------------------------------*/
                    
                    
                    JOptionPane.showMessageDialog(null, "Paciente cargado exitosamente");
                }
            }
            
            ps.close();            
            
        } catch (SQLException ex) {
            System.out.println("Error al cargar datos: "+ex.getMessage());
        }        
    }
    
    public void modificarCiudadano(Ciudadano ciudadano){
        try {
            String sql ="UPDATE ciudadano SET dni = ?, nombreCompleto = ?, email = ?, celular = ?, patologia = ?, ambitoTrabajo = ? WHERE dni = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ciudadano.getDni());
            ps.setString(2, ciudadano.getNombreCompleto());
            ps.setString(3, ciudadano.getEmail());
            ps.setString(4, ciudadano.getCelular());
            ps.setString(5, ciudadano.getPatologia());
            ps.setString(6, ciudadano.getAmbitoTrabajo());
            
            /// EJECUCIÓN DE LA SENTENCIA:
            /// ps.executeUpdate(); ---> Se utiliza en INSERT, UPDATE, DELETE
            /// ps.executeQuery(); ----> Se utiliza en SELECT
            
            int filaAfectada = ps.executeUpdate();
            
            if (filaAfectada > 0) {
                ResultSet lista = ps.getGeneratedKeys();
                if (lista.next()) {
                    JOptionPane.showMessageDialog(null, "¡Modificación Exitosa!");
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla 'Ciudadano'" + ex.getMessage());
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Error en el formato de los campos ingresados. ");
        }
        
    }
    
    public List<Ciudadano> listarCiudadanos(){
        try {
            String sql = "SELECT * FROM ciudadano";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet listaCiu = ps.executeQuery();
            
            while (listaCiu.next()) {                
                Ciudadano ciudadano = new Ciudadano();
                
                ciudadano.setIdCiudadano(listaCiu.getInt("idCiudadano"));
                ciudadano.setNombreCompleto(listaCiu.getString("nombreCompleto"));
                ciudadano.setDni(listaCiu.getInt("dni"));
                ciudadano.setEmail(listaCiu.getString("email"));
                ciudadano.setPatologia(listaCiu.getString("patologia"));
                ciudadano.setCelular(listaCiu.getString("celular"));
                ciudadano.setAmbitoTrabajo(listaCiu.getString("ambitoTrabajo"));
                
                listaCiudadanos.add(ciudadano);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla de ciudadano");
        }
        return listaCiudadanos;
    }
    
    public List<Ciudadano> listarCiudadanosPorTrabajo(String ambTrab){
        try {
            String sql = "SELECT * FROM ciudadano WHERE ambitoTrabajo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet ciuPorTrab = ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(CiudadanoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCiudadanosTrabajo;
    }
     
    public void borrarCiudadano(int dni){
        
    }
    
    public Ciudadano buscarCiudadano(int dni){
        String sql = "SELECT * FROM ciudadano WHERE dni = ?";
        
        // Se setea el ciudadano en null y luego se cargan los datos del ciudadano buscado
        Ciudadano ciudadano = null;
        try {
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, dni);
           
           //En este caso (diferente al insert), se utiliza un executeQuery para la ejecución de la consulta
           ResultSet buscarDni = ps.executeQuery();
           
           //Ahora, si encuentra un ciudadano con ese dni, mostrará los datos
            if (buscarDni.next()) {
                System.out.println("Se ha encontrado en la Base de Datos un ciudadano cuyo DNI es "+buscarDni.getInt("dni"));
                
                ciudadano = new Ciudadano();
                
                ciudadano.setDni(buscarDni.getInt("dni"));
                ciudadano.setNombreCompleto(buscarDni.getString("nombreCompleto"));
                ciudadano.setEmail(buscarDni.getString("email"));
                ciudadano.setCelular(buscarDni.getString("celular"));
                ciudadano.setPatologia(buscarDni.getString("patologia"));
                ciudadano.setAmbitoTrabajo(buscarDni.getString("ambitoTrabajo"));
            } else{
                System.out.println("No se ha encontrado el DNI ingresado en la Base de Datos");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la Base de Datos 'Ciudadano': "+ex.getMessage());
        }
        
        return ciudadano;
    }
    
    
    
    
    
}
// alo 