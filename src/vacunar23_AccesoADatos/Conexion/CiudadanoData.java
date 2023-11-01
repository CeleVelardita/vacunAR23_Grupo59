
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
    
    - Listar por ámbito de trabajo
    - Buscar por dni
        
    ----------------------------------------------*/
    
    public CiudadanoData(){
        // Establecemos la conexión con la BD
        con = Conexion.getConexion();
        
        listaCiudadanos = new ArrayList<>();
        listaCiudadanosTrabajo = new ArrayList<>();
    }    
    
    public void guardarCiudadano(Ciudadano ciudadano){
        String sql = "INSERT INTO ciudadano (dni, nombreCompleto, email, celular, patologia, ambitoTrabajo, distrito, codRefuerzo)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            String dni = String.valueOf(ciudadano.getDni());
            
            if(dni.length() > 8){
                System.out.println("Ha excedido el límite de dígitos para el DNI");
            }
            
            String nombre = ciudadano.getNombreCompleto();
            
            if(nombre.length() > 30){
                System.out.println("Ha excedido el límite de carácteres para nombre y apellido");
            }
            
            String email = ciudadano.getEmail();
            
            if(email.length() > 30){
                System.out.println("Ha excedido el límite de carácteres para el email");
            }
            
            String celular = ciudadano.getCelular();
            
            if(celular.length() > 18){
                System.out.println("Ha excedido el límite de dígitos para el celular. Ingrese: nro de área sin 0 + número sin 15");
            }
            
            String patologia = ciudadano.getPatologia();
            
            if(patologia.length() > 30){
                System.out.println("Ha excedido el límite de carácteres para nombre y apellido");
            }
            
            String ambito = ciudadano.getAmbitoTrabajo();
            
            if(ambito.length() > 40){
                System.out.println("Ha excedido el límite de carácteres para el ámbito laboral");
            }
            
            String distrito = ciudadano.getDistrito();
            
            if(distrito.length() > 50){
                System.out.println("Ha excedido el límite de carácteres para el distrito");
            }
            String refuerzo = String.valueOf(ciudadano.getCodRefuerzo());
            
            if(refuerzo.length() > 1){
                System.out.println("El código de refuerzo solo puede 1, 2 o 3.");
            }
            
            if((dni.length() < 9) && (nombre.length() < 31) && (email.length() < 31) && (celular.length() < 19) && (patologia.length() < 31) && (ambito.length() < 41) && (distrito.length() < 51) && (refuerzo.length() == 1)){
                
            ps.setInt(1, ciudadano.getDni());
            ps.setString(2, ciudadano.getNombreCompleto());
            ps.setString(3, ciudadano.getEmail());
            ps.setString(4, ciudadano.getCelular());
            ps.setString(5, ciudadano.getPatologia());
            ps.setString(6, ciudadano.getAmbitoTrabajo());
            ps.setString(7, ciudadano.getDistrito());
            ps.setInt(8, ciudadano.getCodRefuerzo());            
            
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
            
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al cargar datos: "+ex.getMessage());
        }        
    }
    
    public void modificarCiudadano(Ciudadano ciudadano){
        try {
            String sql ="UPDATE ciudadano SET dni = ?, nombreCompleto = ?, email = ?, celular = ?, patologia = ?, ambitoTrabajo = ?, distrito = ?, codRefuerzo = ? WHERE dni = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            String dni = String.valueOf(ciudadano.getDni());
            
            if(dni.length() > 8){
                System.out.println("Ha excedido el límite de dígitos para el DNI");
            }
            
            String nombre = ciudadano.getNombreCompleto();
            
            if(nombre.length() > 30){
                System.out.println("Ha excedido el límite de carácteres para nombre y apellido");
            }
            
            String email = ciudadano.getEmail();
            
            if(email.length() > 30){
                System.out.println("Ha excedido el límite de carácteres para el email");
            }
            
            String celular = ciudadano.getCelular();
            
            if(celular.length() > 18){
                System.out.println("Ha excedido el límite de dígitos para el celular. Ingrese: nro de área sin 0 + número sin 15");
            }
            
            String patologia = ciudadano.getPatologia();
            
            if(patologia.length() > 30){
                System.out.println("Ha excedido el límite de carácteres para nombre y apellido");
            }
            
            String ambito = ciudadano.getAmbitoTrabajo();
            
            if(ambito.length() > 40){
                System.out.println("Ha excedido el límite de carácteres para el ámbito laboral");
            }
            
            String distrito = ciudadano.getDistrito();
            
            if(distrito.length() > 50){
                System.out.println("Ha excedido el límite de carácteres para el distrito");
            }
            String refuerzo = String.valueOf(ciudadano.getCodRefuerzo());
            
            if(refuerzo.length() > 1){
                System.out.println("El código de refuerzo solo puede 1, 2 o 3.");
            }

            if ((dni.length() < 9) && (nombre.length() < 31) && (email.length() < 31) && (celular.length() < 19) && (patologia.length() < 31) && (ambito.length() < 41) && (distrito.length() < 51) && (refuerzo.length() == 1)) {

                ps.setInt(1, ciudadano.getDni());
                ps.setString(2, ciudadano.getNombreCompleto());
                ps.setString(3, ciudadano.getEmail());
                ps.setString(4, ciudadano.getCelular());
                ps.setString(5, ciudadano.getPatologia());
                ps.setString(6, ciudadano.getAmbitoTrabajo());
                ps.setString(7, ciudadano.getDistrito());
                ps.setInt(8, ciudadano.getCodRefuerzo());

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
                ciudadano.setDistrito(listaCiu.getString("distrito"));
                ciudadano.setCodRefuerzo(listaCiu.getInt("codRefuerzo"));
                
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
            
            while (ciuPorTrab.next()) {                
                Ciudadano ciudadano = new Ciudadano();
                
                ciudadano.setIdCiudadano(ciuPorTrab.getInt("idCiudadano"));
                ciudadano.setNombreCompleto(ciuPorTrab.getString("nombreCompleto"));
                ciudadano.setDni(ciuPorTrab.getInt("dni"));
                ciudadano.setEmail(ciuPorTrab.getString("email"));
                ciudadano.setPatologia(ciuPorTrab.getString("patologia"));
                ciudadano.setCelular(ciuPorTrab.getString("celular"));
                ciudadano.setAmbitoTrabajo(ciuPorTrab.getString("ambitoTrabajo"));
                ciudadano.setDistrito(ciuPorTrab.getString("distrito"));
                ciudadano.setCodRefuerzo(ciuPorTrab.getInt("codRefuerzo"));
                
                listaCiudadanos.add(ciudadano);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla de ciudadano");
        }
        return listaCiudadanosTrabajo;
    }

    public void eliminarCiudadano(int dni) {
        String sql = "DELETE FROM Ciudadano WHERE dni = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, dni);

            int filaAfectada = ps.executeUpdate();

            if (filaAfectada == 1) {
                System.out.println("Ciudadano eliminado");
                JOptionPane.showMessageDialog(null, "Ciudadano eliminado");
            } else {
                System.out.println("No se ha indicado el ciudadano a eliminar");
                JOptionPane.showMessageDialog(null, "No se ha indicado el ciudadano a eliminar");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar a la tabla ciudadano");
        }
    }

//    public Ciudadano buscarCiudadano(int dni){
//        String sql = "SELECT * FROM ciudadano WHERE dni = ?";
//        
//        // Se setea el ciudadano en null y luego se cargan los datos del ciudadano buscado
//        Ciudadano ciudadano = null;
//        try {
//           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//           ps.setInt(1, dni);
//           
//           //En este caso (diferente al insert), se utiliza un executeQuery para la ejecución de la consulta
//           ResultSet buscarDni = ps.executeQuery();
//           
//           //Ahora, si encuentra un ciudadano con ese dni, mostrará los datos
//            if (buscarDni.next()) {
//                System.out.println("Se ha encontrado en la Base de Datos un ciudadano cuyo DNI es "+buscarDni.getInt("dni"));
//                
//                ciudadano = new Ciudadano();
//                
//                ciudadano.setDni(buscarDni.getInt("dni"));
//                ciudadano.setNombreCompleto(buscarDni.getString("nombreCompleto"));
//                ciudadano.setEmail(buscarDni.getString("email"));
//                ciudadano.setCelular(buscarDni.getString("celular"));
//                ciudadano.setPatologia(buscarDni.getString("patologia"));
//                ciudadano.setAmbitoTrabajo(buscarDni.getString("ambitoTrabajo"));
//                ciudadano.setDistrito(buscarDni.getString("distrito"));
//                ciudadano.setCodRefuerzo(buscarDni.getInt("codRefuerzo"));
//            } else{
//                System.out.println("No se ha encontrado el DNI ingresado en la Base de Datos");
//            }
//            
//            ps.close();
//            
//        } catch (SQLException ex) {
//            System.out.println("Error al acceder a la Base de Datos 'Ciudadano': "+ex.getMessage());
//        }
//        
//        return ciudadano;
//    }
    
    public Ciudadano buscarCiudadano(int dni) {
        String sql = "SELECT * FROM ciudadano WHERE dni = ?";
        System.out.println("entró al método");
//        Ciudadano ciudadano = null; // Inicializamos a null
        Ciudadano ciudadano = new Ciudadano();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni); // Asignamos el valor al marcador de posición
            System.out.println("entró al try");
            ResultSet buscarDni = ps.executeQuery();

            if (buscarDni.next()) {
                // Crear una instancia de Ciudadano solo si se encuentra en la base de datos
//                ciudadano = new Ciudadano();
                ciudadano.setDni(buscarDni.getInt("dni"));
                ciudadano.setNombreCompleto(buscarDni.getString("nombreCompleto"));
                ciudadano.setEmail(buscarDni.getString("email"));
                ciudadano.setCelular(buscarDni.getString("celular"));
                ciudadano.setPatologia(buscarDni.getString("patologia"));
                ciudadano.setAmbitoTrabajo(buscarDni.getString("ambitoTrabajo"));
                ciudadano.setDistrito(buscarDni.getString("distrito"));
                ciudadano.setCodRefuerzo(buscarDni.getInt("codRefuerzo"));
            } else {
                System.out.println("No se ha encontrado el DNI ingresado en la Base de Datos");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la Base de Datos 'Ciudadano': " + ex.getMessage());
        }

        return ciudadano; // Devuelve el ciudadano encontrado o null si no se encuentra.
    }

    
}

    
  
    