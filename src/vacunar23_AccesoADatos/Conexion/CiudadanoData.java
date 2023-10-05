
package vacunar23_AccesoADatos.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import vacunar23_Entidades.Ciudadano;

public class CiudadanoData {
    
    // Creamos un atributo de tipo Connection para poder conectar cada método con la base de datos (BD)
    private Connection con = null;
    
    public CiudadanoData(){
        // Establecemos la conexión con la BD
        con = Conexion.getConexion();
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
                }
            }
            
            ps.close();            
            
        } catch (SQLException ex) {
            System.out.println("Error al cargar datos: "+ex.getMessage());
        }        
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
    
    // Hacer método para listar ciudadanos, evaluar si va un List o un TreeSet o algo así
    
    
    
}
