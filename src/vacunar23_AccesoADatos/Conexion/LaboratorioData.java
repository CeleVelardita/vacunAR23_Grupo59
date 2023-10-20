
package vacunar23_AccesoADatos.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import vacunar23_Entidades.Laboratorio;


public class LaboratorioData {
    
// Objeto connection que va a ser utilizado por todos los métodos para poder implementar las funcionalidades CRUD, consultas
    private Connection con = null;

    public LaboratorioData() {
        // Este constructor solo inicializa el objeto connection "con"
        con = Conexion.getConexion();
        // el método .getConexion del objeto con de la clase Connection es el que establece la conexión a la BD
    }

/* Métodos necesarios:

->  para cargar laboratorios
->  para modificar un laboratorio ya guardado en la BD    
->  para eliminar un laboratorio de la tabla de la BD    
->  2 para buscar un laboratorio (uno pasandole el idLaboratorio y otro el cuit),
    tal vez para obtener o ver qué vacunas hay en stock de ese laboratorio 
-> un ArrayList que nos dé una lista de laboratorios inscriptos    

*/    
    public void cargarLaboratorio (Laboratorio laboratorio){
        //creamos el texto sql INSERT para la BD
        String sql = "INSERT INTO laboratorio ( CUIT, nomLaboratorio, pais, domComercial) VALUES (?,?,?,?)";
        
        try{
        // Se genera el objeto prepareStatement el cual va a enviar esa sentencia a la BD
        // con.prepareStatement(sentencia Sql, le pido que devuelva la lista de las claves generadas ID)
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //Se setean los tipos de datos que quiero enviar, porque llegan el método a través del parámetro "laboratorio"
        ps.setLong(1, laboratorio.getCuit());
        ps.setString(2, laboratorio.getNomLaboratorio());
        ps.setString(3, laboratorio.getPais());       
        ps.setString(4, laboratorio.getDomComercial());

        
        // Una vez que se envían todas las sentencias se ejecutan
        ps.executeUpdate();
        
        // Luego se pide la clave generada al alumno
        // Devuelve una tabla, en este caso con una sola columna que es la de ID, con tantas filas
        // como alumnos haya cargado        
        ResultSet claveLaboratorio = ps.getGeneratedKeys();
        
        // En este caso le manda un solo Laboratorio por lo que no es necesario recorrer la lista con un while
        // el next me indica que pasa al siguiente renglón, entonces significa que lo pudo agregar
        if (claveLaboratorio.next()){
            laboratorio.setIdLaboratorio(claveLaboratorio.getInt(1));
            JOptionPane.showMessageDialog(null, "Laboratorio Ingresado Correctamente");
        }
        ps.close();
        // Cierro el método prepareStatement 
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla laboratorio de la BD");
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "ERROR, no se agregó el laboratorio a la BD"+ex.getMessage());
        }    
    }   

    public void modificarLaboratorio (long cuit){
        String sql = "UPDATE laboratorio SET estado = 0 WHERE idLaboratorio = ?";
            try {
               
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, cuit); // le indicamos el cuit que deseamos manipular
                int eliminar = ps.executeUpdate();// realizamos la accion, le da de baja y devuelve un int que guardamos en eliminar
                if (eliminar == 1) {
                    JOptionPane.showMessageDialog(null, "Laboratorio dado de Baja");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al dar de baja el Laboratorio");
            }
    } 

    public void cambiarEstadoLaboratorio (long cuit){
    String sql = "UPDATE laboratorio SET estado = CASE WHEN estado = 0 THEN 1 ELSE 0 END WHERE CUIT = ?";
    /*el sql invierte el estado del cuit que le pase, si estado = 1 lo pasa a 0 y sino al revés*/
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, cuit);
            // Ejecuta el SQL
            int fila = ps.executeUpdate();

            // Cierra la conexión
            ps.close();

            // Verifica si se actualizó el estado
             if (fila == 1) {
                System.out.println("El estado del laboratorio se invirtió correctamente.");
             } else {
                System.out.println("No se pudo invertir el estado del laboratorio.");
            }
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se logró acceder a la tabla laboratorio");
        } 
       
    } 

    public Laboratorio buscarLaboratorioXNombre (String nomLaboratorio){
    // creamos el sql  SELECT para buscar
        String sql = "SELECT  idLaboratorio, CUIT, nomLaboratorio, pais, domComercial WHERE nomLaboratorio = ? AND estado = 1";
        // NOTA: el ID del laboratorio es un parámetro dinámico
        Laboratorio laboratorio = null; // Lo vuelvo null para que "arranque de cero"
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nomLaboratorio);
            ResultSet buscarId = ps.executeQuery();//pregunto y me devuelve una lista (puede estar vacía, controlar en el if siguiente)
            // Como me devuelve una única fila va...
            if (buscarId.next()) { // "Si en el ResultSet hay un elemento, entonces...
                // Voy seteando cada parámetro con los datos del laboratorio correspondientes al id que se ingresó
                // Pero para esto, primero creo un objeto laboratorio de tipo Laboratorio seteado en null (antes del try)
                laboratorio = new Laboratorio(); // inicializamos-definimos
                // Empiezo a setear:
                laboratorio.setIdLaboratorio(buscarId.getInt("IdLaboratorio"));
                laboratorio.setCuit(buscarId.getLong("CUIT"));
                laboratorio.setNomLaboratorio(buscarId.getString("nomLaboratorio"));
                laboratorio.setPais(buscarId.getString("pais"));
                laboratorio.setDomComercial("domComercial");
                laboratorio.setEstado(true);
            } else { // Si en el Result Set no hay un elemento...
                JOptionPane.showMessageDialog(null, "No existe un laboratorio con el ID ingresado");
            }
            // RECORDAR CERRAR EL PREPAREDSTATEMENT!!! 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla laboratorio");
        } 

        return laboratorio;        
    } 

    public Laboratorio buscarLaboratorioXCUIT (long cuit){
        String sql = "SELECT idLaboratorio, CUIT, nomLaboratorio, pais, domComercial, estado FROM laboratorio WHERE CUIT = ?"; 
        // Seteo laboratorio en null, luego le cargo los datos del laboratorio buscado
        Laboratorio laboratorio = null; // Lo vuelvo null para que "arranque de cero"
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, cuit);
            ResultSet buscarCuit = ps.executeQuery(); // Uso el query que significa "CONSULTA" y almaceno la lista que devuelva en resultSet
            if(buscarCuit.next()){
                laboratorio = new Laboratorio();
                laboratorio.setIdLaboratorio(buscarCuit.getInt("idLaboratorio"));
                laboratorio.setCuit(buscarCuit.getLong("CUIT"));
                laboratorio.setNomLaboratorio(buscarCuit.getString("nomLaboratorio"));
                laboratorio.setPais(buscarCuit.getString("pais"));
                laboratorio.setDomComercial(buscarCuit.getString("domComercial"));
                laboratorio.setEstado(buscarCuit.getBoolean("estado"));            
            } else{           
                JOptionPane.showMessageDialog(null, "No existe un laboratorio con el cuit ingresado");
            }
        ps.close();    
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla laboratorio");
            System.out.println(ex.getMessage());
        }
         return laboratorio;    
    }
    
    public List<Laboratorio> listarLaboratorios(){
        String sql = "SELECT idLaboratorio, CUIT, nomLaboratorio, pais, domComercial FROM laboratorio WHERE estado = 1";
      // Otra posibilidad es "SELECT * FROM laboratorio WHERE estado = 1", recordar que el * invoca todos los parámetros
      // Creo una lista de laboratorios porque me va a devolver una lista de TODOS los laboratorios que se encuentren activos
        
        ArrayList<Laboratorio> listaLaboratorios=new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet listaLab = ps.executeQuery();
            // En este caso, a diferencia de los demás,  la lista me devuelve MÁS DE UNA fila, por eso la recorro con un WHILE y NO con un IF
            while (listaLab.next()) {                
                // Mientras haya elementos en esa fila, le digo que se cree un laboratorio vacío
                Laboratorio laboratorio = new Laboratorio();
                // Luego a ese laboratorio, hay que setearle todos los datos
                laboratorio.setIdLaboratorio(listaLab.getInt("idLaboratorio"));
                laboratorio.setCuit(listaLab.getLong("CUIT"));
                laboratorio.setNomLaboratorio(listaLab.getString("nomLaboratorio"));
                laboratorio.setPais(listaLab.getString("pais"));
                laboratorio.setDomComercial(listaLab.getString("domComercial"));
                laboratorio.setEstado(true);
                // Finalmente a la lista "listaLaboratorios" le agrego (add) ese laboratorio
                listaLaboratorios.add(laboratorio);
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla laboratorio");
        }
        return listaLaboratorios; 
        }
    }

