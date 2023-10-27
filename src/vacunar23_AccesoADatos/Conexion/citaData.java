
package vacunar23_AccesoADatos.Conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vacunar23_Entidades.CitaVacunacion;
import vacunar23_Entidades.Ciudadano;
import vacunar23_Entidades.Vacuna;


public class citaData {
    //declaraciones
    private Connection con = null;//objeto de clase Connection para usar su método getConexion      
    private CitaVacunacion cita;
    private List<CitaVacunacion> listaCitas;
    private Ciudadano ciudadano;
    private Vacuna vacuna;
    
    //-----Constructor
    public citaData() {
        //inicializamos
        con = Conexion.getConexion();//  creamos el méotodo en con
        cita=null;
        listaCitas= null;
        ciudadano=null;
        vacuna=null;
        
    }
    
    
    
    
    /*
    métodos para esta clase:
        ->anotar una cita
        ->modificar una cita
        ->borrar cita o dar de baja
        ->mostrar lista de citas -- ver a futuro colocar un calendario de citas con botón agenda
        ->buscar cita por dni del ciudadano
        ->buscar cita por fecha    
        ->uno que esté vigilando la caducidad de la cita en la BD y la cancele o dé de baja
        ->
        ->    
    */
    
    
    public void cargarCita(CitaVacunacion citaVacunacion){
        
        try {
            String sql ="INSERT INTO citavacunacion (codCita, idCiudadano, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, idVacuna, estado) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //int,int,int,date,string,date,int
            ps.setInt(0, citaVacunacion.getCodCita());
            ps.setInt(1, citaVacunacion.getCiudadano().getIdCiudadano());
            ps.setInt(2, citaVacunacion.getCodRefuerzo());
            ps.setDate(4, Date.valueOf(citaVacunacion.getFechaHoraCita()));
            ps.setString(5, citaVacunacion.getCentroVacunacion());
            ps.setDate(6, Date.valueOf(citaVacunacion.getFechaHoraColoca()));
            ps.setInt(7, citaVacunacion.getVacuna().getIdVacuna());   
            ps.setString(8, citaVacunacion.getEstado());
            int columnaAfectada = ps.executeUpdate();//ejecuta la sentencia hacia la tabla
            
            //debemos revisar si el ingreso se realizó correctamente con columnaAfectada
            ResultSet lista = ps.getGeneratedKeys();
            if(lista.next()){
                citaVacunacion.setCodCita(lista.getInt("codCita"));//setea al modelo el codCita que existe en esa fila que rescató el resulset
                JOptionPane.showMessageDialog(null, "Laboratorio Ingresado Correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla citaVacunacion"+ex.getMessage());
        }
        
        
    }
    
    public void modificarCita(CitaVacunacion citaVacunacion){
        try{
            //formulamos la petición
            String sql ="UPDATE citavacunacion SET idCiudadano= ?, codRefuerzo= ?, fechaHoraCita= ?, centroVacunacion= ? ,fechaHoraColoca= ?, estado= ? WHERE codCita= ? ";
            //conectamos con la tabla y le mandamos la petición sql
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //seteamos el contenido deseado siguiendo el orden de la consulta en sql 0,1,2,3....
            ps.setInt(0, citaVacunacion.getCiudadano().getIdCiudadano());
            ps.setInt(1, citaVacunacion.getCodRefuerzo());
            ps.setDate(2, Date.valueOf(citaVacunacion.getFechaHoraCita()));
            ps.setString(3, citaVacunacion.getCentroVacunacion());
            ps.setDate(4, Date.valueOf(citaVacunacion.getFechaHoraColoca()));            
            ps.setInt(5, citaVacunacion.getVacuna().getIdVacuna()); 
            ps.setString(6,citaVacunacion.getEstado()); 
            //por ultimo luego del where pide el código de la cita
            ps.setInt(7, citaVacunacion.getCodCita());
            /*
            debemos ejecutar la petición y nos devolverá un número con el que 
            confirmaremos si se realizó correctamente la modificación
            */
            int valorDevuelto = ps.executeUpdate();

            if (valorDevuelto > 0) {
                    System.out.println("¡Modificación exitosa!");
                    JOptionPane.showMessageDialog(null, "¡Modificación exitosa!");
            }else{
                System.out.println("error al querer modificar la cita");
            }
            
        }catch (SQLException ex) {
            System.out.println("SQLException");
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla CitaVacunacions" + ex.getMessage());
        }catch (NumberFormatException ex) {
            System.out.println("NullPointerException" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar la cita"+ ex.getMessage());
        }
    }
    
    public void estadoCita(CitaVacunacion citaVacunacion){
        String sql = "UPDATE citaVacunacion SET estado = ? WHERE codCita = ?";
        try{
            //conectamos con la tabla y le mandamos la petición sql
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //seteamos el contenido deseado siguiendo el orden de la consulta en sql 0,1,2,3....
            
            ps.setString(0,citaVacunacion.getEstado()); 
            //por ultimo luego del where pide el código de la cita
            ps.setInt(1, citaVacunacion.getCodCita());
            /*
            debemos ejecutar la petición y nos devolverá un número con el que 
            confirmaremos si se realizó correctamente la modificación
            */
            int valorDevuelto = ps.executeUpdate();

            if (valorDevuelto > 0) {
                ResultSet lista = ps.getGeneratedKeys();
                if (lista.next()) {
                    System.out.println("¡Modificación exitosa!");
                    //JOptionPane.showMessageDialog(null, "¡Modificación exitosa!");
                }
                
            }else{
                System.out.println("error al querer modificar la cita");
            }
            
        }catch (SQLException ex) {
            System.out.println("SQLException");
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla CitaVacunacions" + ex.getMessage());
        }catch (NumberFormatException ex) {
            System.out.println("NullPointerException" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar Estado de la cita"+ ex.getMessage());
        }
    }
    
    public List<CitaVacunacion> listarCitas(){
     String sql = "SELECT *\n"
                + "FROM citaVacunacion AS cv, ciudadano, vacuna\n"
                + "JOIN vacuna AS v and ciudadano AS c\n"               
                + "ON cv.idVacuna=v.idVacuna and cv.idCiudadano=c.idCiudadano"; 
     
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet RSetcitas = ps.executeQuery();

            while (RSetcitas.next()) {
                ///seteo los objetos de entidades
                //objteo: cita -> clase CitaVacunacion
                //objteo: vacuna -> clase Vacuna
                //objteo: ciudadano -> clase Ciudadano
                
                //vacuna
                vacuna.setIdVacuna(RSetcitas.getInt("idVacuna"));
                vacuna.setNroSerie(RSetcitas.getInt("nroSerieDosis"));
                vacuna.setMarca(RSetcitas.getString("marca"));
                vacuna.setMedida(RSetcitas.getDouble("medida"));
                vacuna.setFechaCaduca(RSetcitas.getDate("fechaCaduca").toLocalDate()); // NO OLVIDAR "toLocalDate" PARA PARSEAR
                vacuna.setColocada(RSetcitas.getBoolean("colocada"));

                //ciudadano
                /*
                private int dni;
                private String nombreCompleto;
                private String email;
                private String celular;
                private String patologia = null;
                private String ambitoTrabajo;
                */
                ciudadano.setDni(RSetcitas.getInt("dni"));
                ciudadano.setNombreCompleto(RSetcitas.getString("nombreCompleto"));
                ciudadano.setEmail(RSetcitas.getString("email"));
                ciudadano.setCelular(RSetcitas.getString("celular"));
                ciudadano.setPatologia(RSetcitas.getString("patologia"));
                ciudadano.setAmbitoTrabajo(RSetcitas.getString("ambitoTrabajo"));
                
                /*
                private int codCita;
                private LocalDate fechaHoraCita;
                private String centroVacunacion; 
                private LocalDate fechaHoraColoca;
                private Vacuna vacuna;
                private int codRefuerzo;
                private Ciudadano ciudadano;       
                private String estado;
                */
                cita.setCodCita(RSetcitas.getInt("codCita"));
                cita.setFechaHoraCita(RSetcitas.getDate("fechaHoraCita").toLocalDate());
                cita.setCentroVacunacion(RSetcitas.getString("email"));
                cita.setFechaHoraColoca(RSetcitas.getDate("fechaHoraColoca").toLocalDate());
                cita.setCodRefuerzo(RSetcitas.getInt("codRefuerzo"));
                cita.setEstado(RSetcitas.getString("estado"));
                
                //seteo a citas los objetos ya con sus datos cargados
                cita.setCiudadano(ciudadano); 
                cita.setVacuna(vacuna);
                
                //cargo la cita a la lista a devolver
                listaCitas.add(cita);
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("falló el acceso a alguna de las tablas citaVacunacion, ciudadano o vacuna");
            JOptionPane.showMessageDialog(null, "falló el acceso a alguna de las tablas citaVacunacion, ciudadano o vacuna");              
        }
        
     return listaCitas;   
    }

    public CitaVacunacion buscarCItaXDNI(int dni){
             String sql = "SELECT * FROM citaVacunacion AS cv " +
                 "JOIN ciudadano AS c ON cv.idCiudadano = c.idCiudadano " +
                 "JOIN vacuna AS v ON cv.idVacuna = v.idVacuna " +
                 "WHERE c.dni = ?";
     
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet RSetcitas = ps.executeQuery();

            while (RSetcitas.next()) {
                ///seteo los objetos de entidades
                //objteo: cita -> clase CitaVacunacion
                //objteo: vacuna -> clase Vacuna
                //objteo: ciudadano -> clase Ciudadano
                
                
                //vacuna
                /*
                private int idVacuna;
                private Laboratorio laboratorio; 
                private int nroSerie;
                private String marca;
                private double medida;
                private LocalDate fechaCaduca;
                private boolean colocada = false;
                */
                vacuna.setIdVacuna(RSetcitas.getInt("idVacuna"));
                vacuna.setNroSerie(RSetcitas.getInt("nroSerieDosis"));
                vacuna.setMarca(RSetcitas.getString("marca"));
                vacuna.setMedida(RSetcitas.getDouble("medida"));
                vacuna.setFechaCaduca(RSetcitas.getDate("fechaCaduca").toLocalDate()); // NO OLVIDAR "toLocalDate" PARA PARSEAR
                vacuna.setColocada(RSetcitas.getBoolean("colocada"));

                //ciudadano
                /*
                private int dni;
                private String nombreCompleto;
                private String email;
                private String celular;
                private String patologia = null;
                private String ambitoTrabajo;
                */
                ciudadano.setDni(RSetcitas.getInt("dni"));
                ciudadano.setNombreCompleto(RSetcitas.getString("nombreCompleto"));
                ciudadano.setEmail(RSetcitas.getString("email"));
                ciudadano.setCelular(RSetcitas.getString("celular"));
                ciudadano.setPatologia(RSetcitas.getString("patologia"));
                ciudadano.setAmbitoTrabajo(RSetcitas.getString("ambitoTrabajo"));
                
                /*
                private int codCita;
                private LocalDate fechaHoraCita;
                private String centroVacunacion; 
                private LocalDate fechaHoraColoca;
                private Vacuna vacuna;
                private int codRefuerzo;
                private Ciudadano ciudadano;       
                private String estado;
                */
                cita.setCodCita(RSetcitas.getInt("codCita"));
                cita.setFechaHoraCita(RSetcitas.getDate("fechaHoraCita").toLocalDate());
                cita.setCentroVacunacion(RSetcitas.getString("email"));
                cita.setFechaHoraColoca(RSetcitas.getDate("fechaHoraColoca").toLocalDate());
                cita.setCodRefuerzo(RSetcitas.getInt("codRefuerzo"));
                cita.setEstado(RSetcitas.getString("estado"));
                
                //seteo a citas los objetos ya con sus datos cargados
                cita.setCiudadano(ciudadano); 
                cita.setVacuna(vacuna);
                
                //cargo la cita a la lista a devolver
                listaCitas.add(cita);
            }
        ps.close();    
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "falló el acceso a alguna de las tablas citaVacunacion, ciudadano o vacuna");
            System.out.println(ex.getMessage());
        }
         return cita;
    }
    
    public CitaVacunacion buscarCitaXFecha(LocalDate fecha){
        String sql = "SELECT * FROM citaVacunacion AS cv " +
                 "JOIN ciudadano AS c ON cv.idCiudadano = c.idCiudadano " +
                 "JOIN vacuna AS v ON cv.idVacuna = v.idVacuna " +
                 "WHERE cv.fechaHoraCita = ?";
     
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(fecha));//debo parsear fecha es LocalDate y debo pasarle al sql un tipo Date
            ResultSet RSetcitas = ps.executeQuery();

            while (RSetcitas.next()) {
                ///seteo los objetos de entidades
                //objteo: cita -> clase CitaVacunacion
                //objteo: vacuna -> clase Vacuna
                //objteo: ciudadano -> clase Ciudadano
                
                
                //vacuna
                /*
                private int idVacuna;
                private Laboratorio laboratorio; 
                private int nroSerie;
                private String marca;
                private double medida;
                private LocalDate fechaCaduca;
                private boolean colocada = false;
                */
                vacuna.setIdVacuna(RSetcitas.getInt("idVacuna"));
                vacuna.setNroSerie(RSetcitas.getInt("nroSerieDosis"));
                vacuna.setMarca(RSetcitas.getString("marca"));
                vacuna.setMedida(RSetcitas.getDouble("medida"));
                vacuna.setFechaCaduca(RSetcitas.getDate("fechaCaduca").toLocalDate()); // NO OLVIDAR "toLocalDate" PARA PARSEAR
                vacuna.setColocada(RSetcitas.getBoolean("colocada"));

                //ciudadano
                /*
                private int dni;
                private String nombreCompleto;
                private String email;
                private String celular;
                private String patologia = null;
                private String ambitoTrabajo;
                */
                ciudadano.setDni(RSetcitas.getInt("dni"));
                ciudadano.setNombreCompleto(RSetcitas.getString("nombreCompleto"));
                ciudadano.setEmail(RSetcitas.getString("email"));
                ciudadano.setCelular(RSetcitas.getString("celular"));
                ciudadano.setPatologia(RSetcitas.getString("patologia"));
                ciudadano.setAmbitoTrabajo(RSetcitas.getString("ambitoTrabajo"));
                
                /*
                private int codCita;
                private LocalDate fechaHoraCita;
                private String centroVacunacion; 
                private LocalDate fechaHoraColoca;
                private Vacuna vacuna;
                private int codRefuerzo;
                private Ciudadano ciudadano;       
                private String estado;
                */
                cita.setCodCita(RSetcitas.getInt("codCita"));
                cita.setFechaHoraCita(RSetcitas.getDate("fechaHoraCita").toLocalDate());
                cita.setCentroVacunacion(RSetcitas.getString("email"));
                cita.setFechaHoraColoca(RSetcitas.getDate("fechaHoraColoca").toLocalDate());
                cita.setCodRefuerzo(RSetcitas.getInt("codRefuerzo"));
                cita.setEstado(RSetcitas.getString("estado"));
                
                //seteo a citas los objetos ya con sus datos cargados
                cita.setCiudadano(ciudadano); 
                cita.setVacuna(vacuna);
                
                //cargo la cita a la lista a devolver
                listaCitas.add(cita);
            }
        ps.close();    
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "falló el acceso a alguna de las tablas citaVacunacion, ciudadano o vacuna");
            System.out.println(ex.getMessage());
        }
         return cita;
    }
    
    
}
