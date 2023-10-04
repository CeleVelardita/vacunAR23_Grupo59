
package vacunar23_AccesoADatos.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String URL = "jbdc:mariadb://localhost:3306/";
    private static final String DB = "vacunar23_grupo59";
    private static final String USUARIO = "root";
    private static String PASSWORD = "";
    
    private static Connection connection;
    
    // Método constructor
    // HAGO UN CONSTRUCTOR PRIVADO PARA CONTROLAR LA CANTIDAD DE INSTANCIAS DE LA CLASE "CONEXION"
    // Al ser privado, no voy a poder instanciar objetos desde afuera de esta clase
    private Conexion(){}
    
    // Creo métodos estáticos para poder implemetar métodos de tipo connection, pero primero se debe crear la conexión a la BD 
    public static Connection getConexion(){
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver"); // Cargo los Driver

                //Creo el objeto connection
                connection = DriverManager.getConnection("jdbc:mariadb://localhost/vacunar23_grupo59", "root", "");
                //JOptionPane.showMessageDialog(null, "Conectado");
                //System.out.println("conexión exitosa");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la BD " + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los Drivers " + e.getMessage());
            }
        }

        return connection;
    }
}
