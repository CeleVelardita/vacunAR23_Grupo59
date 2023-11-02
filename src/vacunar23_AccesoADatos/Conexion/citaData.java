
package vacunar23_AccesoADatos.Conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JOptionPane;

import vacunar23_Entidades.CitaVacunacion;
import vacunar23_Entidades.Ciudadano;
import vacunar23_Entidades.Vacuna;


public class citaData {
    //declaraciones
    private Connection con;//objeto de clase Connection para usar su método getConexion      
    private CitaVacunacion cita;
    private List<CitaVacunacion> listaCitas;
    private Ciudadano ciudadano;
    private Vacuna vacuna;
    
    //-----Constructor
    public citaData() {
        //inicializamos
        con = Conexion.getConexion();//  creamos el méotodo en con
        cita=new CitaVacunacion();
        listaCitas= null;
        ciudadano=new Ciudadano();
        vacuna=new Vacuna();
        
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
    
   public void cargarCita(CitaVacunacion citaVacunacion) {
    try {
        String sql = "INSERT INTO citavacunacion ( idCiudadano, codRefuerzo, " +
                     "fechaHoraCita, centroVacunacion, horarioTurno, idVacuna, " +
                     "estado) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        System.out.println("idCiudadano:  "+citaVacunacion.getCiudadano().getIdCiudadano());
        System.out.println("idVacuna:  "+citaVacunacion.getVacuna().getIdVacuna());
        
        ps.setInt(1, citaVacunacion.getCiudadano().getIdCiudadano()); // Aquí, toma el id del ciudadano asociado a la cita.
        ps.setInt(2, citaVacunacion.getCodRefuerzo());
        ps.setDate(3, Date.valueOf(citaVacunacion.getFechaHoraCita()));
        ps.setString(4, citaVacunacion.getCentroVacunacion());

        // Aquí estableces la hora en la columna horarioTurno como Time
        LocalTime localTime = citaVacunacion.getFechaHoraColoca();
        Time time = Time.valueOf(localTime);
        ps.setTime(5, time);

        ps.setInt(6, citaVacunacion.getVacuna().getIdVacuna()); // Aquí, toma el id de la vacuna asociada a la cita.
        ps.setString(7, citaVacunacion.getEstado());

        int columnaAfectada = ps.executeUpdate(); // Ejecuta la sentencia hacia la tabla.

        // Debes revisar si la inserción se realizó correctamente.
        if (columnaAfectada > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idCitaGenerado = generatedKeys.getInt(1); // Obtener el valor generado para idCita, si es necesario.
                JOptionPane.showMessageDialog(null, "Cita de vacunación ingresada correctamente con idCita: " + idCitaGenerado);
            }
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla citaVacunacion: " + ex.getLocalizedMessage());
    }
}

    public void modificarCita(CitaVacunacion citaVacunacion){
        try{
            //formulamos la petición
            String sql ="UPDATE citavacunacion SET idCiudadano= ?, codRefuerzo= ?, fechaHoraCita= ?, centroVacunacion= ? ,horarioTurno= ?, estado= ? WHERE codCita= ? ";
            //conectamos con la tabla y le mandamos la petición sql
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //seteamos el contenido deseado siguiendo el orden de la consulta en sql 0,1,2,3....
            // Establece los valores de los parámetros en el orden correcto
            ps.setInt(1, citaVacunacion.getCiudadano().getIdCiudadano());
            ps.setInt(2, citaVacunacion.getCodRefuerzo());
            ps.setDate(3, Date.valueOf(citaVacunacion.getFechaHoraCita()));
            ps.setString(4, citaVacunacion.getCentroVacunacion());

            // Aquí establecemos la hora en la columna horarioTurno como Time
            LocalTime localTime = citaVacunacion.getFechaHoraColoca();
            Time time = Time.valueOf(localTime);
            ps.setTime(5, time);

            ps.setString(6, citaVacunacion.getEstado());
            // Establece el valor para el WHERE (codCita)
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
    
     
    public List<CitaVacunacion> listarCitas() {
        String sql = "SELECT DISTINCT * " +
             "FROM citaVacunacion AS cv " +
             "JOIN ciudadano AS c ON cv.idCiudadano = c.idCiudadano " +
             "JOIN vacuna AS v ON cv.idVacuna = v.idVacuna";

//    String sql = "SELECT * " +
//                    "FROM citaVacunacion AS cv " +
//                    "JOIN ciudadano AS c ON cv.idCiudadano = c.idCiudadano " +
//                    "JOIN vacuna AS v ON cv.idVacuna = v.idVacuna";

    List<CitaVacunacion> listaCitas = new ArrayList<>();

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet RSetcitas = ps.executeQuery();

        while (RSetcitas.next()) {
            // Crear nuevas instancias en cada iteración
            CitaVacunacion cita = new CitaVacunacion();
            Vacuna vacuna = new Vacuna();
            Ciudadano ciudadano = new Ciudadano();


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
                vacuna.setIdLaboratorio(RSetcitas.getInt("idLaboratorio"));
//                vacuna.getLaboratorio().setIdLaboratorio(RSetcitas.getInt("idLaboratorio"));
                //ciudadano
                /*
                private int dni;
                private String nombreCompleto;
                private String email;
                private String celular;
                private String patologia = null;
                private String ambitoTrabajo;
                */
                ciudadano.setIdCiudadano(RSetcitas.getInt("idCiudadano"));
                ciudadano.setDni(RSetcitas.getInt("dni"));
                ciudadano.setNombreCompleto(RSetcitas.getString("nombreCompleto"));
                ciudadano.setEmail(RSetcitas.getString("email"));
                ciudadano.setCelular(RSetcitas.getString("celular"));
                ciudadano.setPatologia(RSetcitas.getString("patologia"));
                ciudadano.setAmbitoTrabajo(RSetcitas.getString("ambitoTrabajo"));
                ciudadano.setDistrito(RSetcitas.getString("distrito"));
                ciudadano.setCodRefuerzo(RSetcitas.getInt("codRefuerzo"));
                
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
                cita.setCentroVacunacion(RSetcitas.getString("centroVacunacion"));
                cita.setFechaHoraColoca(RSetcitas.getTime("horarioTurno").toLocalTime());
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

    
    public CitaVacunacion buscarCitaXDNI(int dni){
             String sql = "SELECT * FROM citaVacunacion AS cv " +
                 "JOIN ciudadano AS c ON cv.idCiudadano = c.idCiudadano " +
                 "JOIN vacuna AS v ON cv.idVacuna = v.idVacuna " +
                 "WHERE c.dni = ?";
     
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet RSetcitas = ps.executeQuery();

            if (RSetcitas.next()) {
            // Crear nuevas instancias en la primera iteración
            CitaVacunacion cita = new CitaVacunacion();
            Vacuna vacuna = new Vacuna();
            Ciudadano ciudadano = new Ciudadano();

            
            // Mueve la creación de instancias fuera del bucle
            do {
              
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
                vacuna.setIdLaboratorio(RSetcitas.getInt("idLaboratorio"));
//                vacuna.getLaboratorio().setIdLaboratorio(RSetcitas.getInt("idLaboratorio"));
                //ciudadano
                /*
                private int dni;
                private String nombreCompleto;
                private String email;
                private String celular;
                private String patologia = null;
                private String ambitoTrabajo;
                */
                ciudadano.setIdCiudadano(RSetcitas.getInt("idCiudadano"));
                ciudadano.setDni(RSetcitas.getInt("dni"));
                ciudadano.setNombreCompleto(RSetcitas.getString("nombreCompleto"));
                ciudadano.setEmail(RSetcitas.getString("email"));
                ciudadano.setCelular(RSetcitas.getString("celular"));
                ciudadano.setPatologia(RSetcitas.getString("patologia"));
                ciudadano.setAmbitoTrabajo(RSetcitas.getString("ambitoTrabajo"));
                ciudadano.setDistrito(RSetcitas.getString("distrito"));
                ciudadano.setCodRefuerzo(RSetcitas.getInt("codRefuerzo"));
                
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
                cita.setCentroVacunacion(RSetcitas.getString("centroVacunacion"));
                cita.setFechaHoraColoca(RSetcitas.getTime("horarioTurno").toLocalTime());
                cita.setCodRefuerzo(RSetcitas.getInt("codRefuerzo"));
                cita.setEstado(RSetcitas.getString("estado"));
                
                //seteo a citas los objetos ya con sus datos cargados
                cita.setCiudadano(ciudadano); 
                cita.setVacuna(vacuna);
                } while (RSetcitas.next());

                // Cerrar la conexión aquí, ya que estamos fuera del bucle
                ps.close();

                // Devolver la cita
                return cita;
            } else {
                // Si no se encontró una cita, devolver null
                ps.close();
                return null;
            }
                
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "falló el acceso a alguna de las tablas citaVacunacion, ciudadano o vacuna");
        System.out.println(ex.getMessage());
        return null;
        }
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
                vacuna.getLaboratorio().setIdLaboratorio(RSetcitas.getInt("idLaboratorio"));
                vacuna.setIdLaboratorio(RSetcitas.getInt("idLaboratorio"));

                //ciudadano
                /*
                private int dni;
                private String nombreCompleto;
                private String email;
                private String celular;
                private String patologia = null;
                private String ambitoTrabajo;
                */
                ciudadano.setIdCiudadano(RSetcitas.getInt("idCiudadano"));
                ciudadano.setDni(RSetcitas.getInt("dni"));
                ciudadano.setNombreCompleto(RSetcitas.getString("nombreCompleto"));
                ciudadano.setEmail(RSetcitas.getString("email"));
                ciudadano.setCelular(RSetcitas.getString("celular"));
                ciudadano.setPatologia(RSetcitas.getString("patologia"));
                ciudadano.setAmbitoTrabajo(RSetcitas.getString("ambitoTrabajo"));
                ciudadano.setDistrito(RSetcitas.getString("distrito"));
                ciudadano.setCodRefuerzo(RSetcitas.getInt("codRefuerzo"));
                
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
                cita.setFechaHoraColoca(RSetcitas.getTime("fechaHoraColoca").toLocalTime());

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
    
    public List<CitaVacunacion> listarCitasXDia(LocalDate fecha){
     String sql = "SELECT *\n"
                + "FROM citaVacunacion AS cv, ciudadano, vacuna\n"
                + "JOIN vacuna AS v and ciudadano AS c\n"               
                + "ON cv.idVacuna=v.idVacuna and cv.idCiudadano=c.idCiudadano"
                + "WHERE cv.fechaHoraCita = ?";    
     
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(fecha));//debo parsear fecha es LocalDate y debo pasarle al sql un tipo Date
            ResultSet RSetcitas = ps.executeQuery();
            while (RSetcitas.next()) {
            // Crear nuevas instancias en cada iteración
            CitaVacunacion cita = new CitaVacunacion();
            Vacuna vacuna = new Vacuna();
            Ciudadano ciudadano = new Ciudadano();


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
                vacuna.setIdLaboratorio(RSetcitas.getInt("idLaboratorio"));
//                vacuna.getLaboratorio().setIdLaboratorio(RSetcitas.getInt("idLaboratorio"));
                //ciudadano
                /*
                private int dni;
                private String nombreCompleto;
                private String email;
                private String celular;
                private String patologia = null;
                private String ambitoTrabajo;
                */
                ciudadano.setIdCiudadano(RSetcitas.getInt("idCiudadano"));
                ciudadano.setDni(RSetcitas.getInt("dni"));
                ciudadano.setNombreCompleto(RSetcitas.getString("nombreCompleto"));
                ciudadano.setEmail(RSetcitas.getString("email"));
                ciudadano.setCelular(RSetcitas.getString("celular"));
                ciudadano.setPatologia(RSetcitas.getString("patologia"));
                ciudadano.setAmbitoTrabajo(RSetcitas.getString("ambitoTrabajo"));
                ciudadano.setDistrito(RSetcitas.getString("distrito"));
                ciudadano.setCodRefuerzo(RSetcitas.getInt("codRefuerzo"));
                
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
                cita.setCentroVacunacion(RSetcitas.getString("centroVacunacion"));
                cita.setFechaHoraColoca(RSetcitas.getTime("horarioTurno").toLocalTime());
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

    
    
}
