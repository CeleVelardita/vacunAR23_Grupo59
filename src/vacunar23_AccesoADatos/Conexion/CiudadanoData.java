
package vacunar23_AccesoADatos.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ciudadano.getDni());
            ps.setString(2, ciudadano.getNombreCompleto());
            ps.setString(3, ciudadano.getEmail());
            ps.setString(4, ciudadano.getCelular());
            ps.setString(5, ciudadano.getPatologia());
            ps.setString(6, ciudadano.getAmbitoTrabajo());
            
            ps.executeUpdate();
            
            // Luego de preparar, enviar y ejecutar las sentencias, pido la clave generada a cada ciudadano, que correspondería al idCiudadano
            // Recordar que el ResultSet devuelve una tabla, pero en este caso sería de una sola columna (idCiudadano) con tantas filas
            // como ciudadanos haya cargado en la BD
            ResultSet id = ps.getGeneratedKeys();
            
            if(id.next()){
                ciudadano.setIdCiudadano(id.getInt(1)); //No comprendo por qué va el 1
                System.out.println("Paciente cargado exitosamente");
                System.out.println("-------------------------");
                System.out.println("Chequeamos:");
                System.out.println(ciudadano.getDni());
                System.out.println(ciudadano.getNombreCompleto());
                System.out.println(ciudadano.getEmail());
                System.out.println(ciudadano.getCelular());
                System.out.println(ciudadano.getPatologia());
                System.out.println(ciudadano.getAmbitoTrabajo());
                System.out.println("También mostramos el id: "+id);
            }
            
            ps.close();            
            
        } catch (SQLException ex) {
            System.out.println("Error al cargar datos: "+ex.getMessage());
        }        
    }
            
    public void buscarCiudadano(int dni){
        String sql = "SELEC * FROM ciudadano WHERE dni = ?";
        
        // Se setea el ciudadano en null y luego se cargan los datos del ciudadano buscado
        Ciudadano ciudadano = null;
        try {
           PreparedStatement ps = con.prepareStatement(sql);
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
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la Base de Datos 'Ciudadano': "+ex.getMessage());
        } 
    }
    
    
}
