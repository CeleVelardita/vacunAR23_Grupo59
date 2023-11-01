
package Vistas;


import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;//necesario para turnos, cudiado con java.sql.Date
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vacunar23_AccesoADatos.Conexion.CiudadanoData;
import vacunar23_AccesoADatos.Conexion.VacunaData;
import vacunar23_AccesoADatos.Conexion.citaData;
import vacunar23_Entidades.CitaVacunacion;
import vacunar23_Entidades.Ciudadano;
import vacunar23_Entidades.Vacuna;


public class CitaView extends javax.swing.JInternalFrame {

    //declaración de atributos
    private HashMap<Date, Boolean> horariosHabiles;//para control de turnos
    
    //Declaración de atributos
    private DefaultTableModel modeloTabla;//modelo para la tabla
    
    
    private List<Ciudadano> ListaCiudadanos;
    private List<Vacuna> ListaVacunas;
    private List<CitaVacunacion> listaCitas;
    private citaData citaData;
    private VacunaData vacuData;
    private CiudadanoData ciuData;
    private CitaVacunacion citaVac;
    private Vacuna vacuna;

    private Ciudadano ciudadano;
    
    SimpleDateFormat dFormat;
    
    //atributos extras para extraer datos de los eventos
    private int dni;
    private int codRefuerzoCita;
    
    
    
    public CitaView() {
        initComponents();
        modeloTabla = (DefaultTableModel) jTableListado.getModel();//despues de esto cargo el armado de cabecera de tabla
        jCheckBoxVerificacion.setEnabled(false);
        jtNombre.setEnabled(false);
        
        //cargarComboRefuerzo();
       
        dni=00000000;
        ciudadano= new Ciudadano();
        
        vacuna=new Vacuna();
        vacuData= new VacunaData();
        
         ciuData= new CiudadanoData();
         citaVac= new CitaVacunacion();
        
         /*----fecha----*/
         dFormat= new SimpleDateFormat("dd-mm-yyyy");
         // Deshabilita la edición del campo de texto
            JTextFieldDateEditor dateEditor = (JTextFieldDateEditor) jCalendarCita.getDateEditor();
            dateEditor.setEditable(false);
         
         
        ///Necesario para los turnos:
        
        //carga de combobox   
        // turno mañana
        for (int i = 8; i <= 12; i++) {
            jComboBoxHorarios.addItem(i + ":00");
            jComboBoxHorarios.addItem(i + ":15");
            jComboBoxHorarios.addItem(i + ":30");
            jComboBoxHorarios.addItem(i + ":45");
        }

        // turno tarde
        for (int i = 16; i <= 20; i++) {
            jComboBoxHorarios.addItem(i + ":00");
            jComboBoxHorarios.addItem(i + ":15");
            jComboBoxHorarios.addItem(i + ":30");
            jComboBoxHorarios.addItem(i + ":45");
        }
        
        //control de horas y dias disponibles
        horariosHabiles = new HashMap<>();
        horariosHabiles.put(new Date(), true);
        horariosHabiles.put(new Date(new Date().getTime() + 86400000), true);
        horariosHabiles.put(new Date(new Date().getTime() + 172800000), true);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLDNI = new javax.swing.JLabel();
        jLCodigoRefuerzo = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtDNI = new javax.swing.JTextField();
        jComboBoxHorarios = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jBotonGuardarCita = new javax.swing.JButton();
        jComboBoxRefuerzo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListado = new javax.swing.JTable();
        jBotonBuscar = new javax.swing.JButton();
        jLListarXDia = new javax.swing.JLabel();
        jdcListarXDia = new com.toedter.calendar.JDateChooser();
        jLBuscarXDni = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLModificarEstado = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jBotonAplicarEstado = new javax.swing.JButton();
        jBuscarDni = new javax.swing.JButton();
        jCheckBoxVerificacion = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxListaVacunas = new javax.swing.JComboBox<>();
        jCalendarCita = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(1511, 993));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Cita para Vacunación");

        jLNombre.setText("Nombre y Apellido: ");
        jLNombre.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLDNI.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLDNI.setText("DNI del Ciudadano: ");

        jLCodigoRefuerzo.setText("Código de Refuerzo:");

        jtNombre.setEditable(false);

        jLabel10.setText("Seleccione Fecha Para La Cita: ");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel11.setText("Seleccione El Horario: ");

        jBotonGuardarCita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBotonGuardarCita.setText("Guardar Cita");
        jBotonGuardarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonGuardarCitaActionPerformed(evt);
            }
        });

        jTableListado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Cita", "Ciudadano", "DNI", "Patología Base", "Fecha del Turno", "Horario", "Vacuna", "Nro. Serie Vacuna", "Cod. Refuerzo", "Centro Vacunacion", "Estado de Cita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListado.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableListado);
        if (jTableListado.getColumnModel().getColumnCount() > 0) {
            jTableListado.getColumnModel().getColumn(0).setResizable(false);
            jTableListado.getColumnModel().getColumn(1).setResizable(false);
            jTableListado.getColumnModel().getColumn(2).setResizable(false);
            jTableListado.getColumnModel().getColumn(3).setResizable(false);
            jTableListado.getColumnModel().getColumn(4).setResizable(false);
            jTableListado.getColumnModel().getColumn(5).setResizable(false);
            jTableListado.getColumnModel().getColumn(6).setResizable(false);
            jTableListado.getColumnModel().getColumn(7).setResizable(false);
            jTableListado.getColumnModel().getColumn(8).setResizable(false);
            jTableListado.getColumnModel().getColumn(9).setResizable(false);
            jTableListado.getColumnModel().getColumn(10).setResizable(false);
        }

        jBotonBuscar.setText("Buscar ");

        jLListarXDia.setText("Listar Cita según calendario");

        jLBuscarXDni.setText("Buscar Cita por DNI:");

        jLModificarEstado.setText("Modificar Estado De La Cita:");

        jBotonAplicarEstado.setText("Aplicar Estado");

        jBuscarDni.setText("Buscar");
        jBuscarDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarDniActionPerformed(evt);
            }
        });

        jCheckBoxVerificacion.setText("Encontrado");

        jLabel2.setText("Vacuna: ");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jCalendarCita.setToolTipText("dd/MM/yyyy");
        jCalendarCita.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarCitaPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jCalendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 54, Short.MAX_VALUE)
                                .addComponent(jLDNI)
                                .addGap(18, 18, 18)
                                .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBuscarDni)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxVerificacion)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel2)
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLNombre)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNombre)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxListaVacunas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLCodigoRefuerzo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(334, 334, 334)
                        .addComponent(jBotonGuardarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLListarXDia)
                                .addGap(18, 18, 18)
                                .addComponent(jdcListarXDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLBuscarXDni)
                                    .addComponent(jTextField6)
                                    .addComponent(jBotonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addGap(165, 165, 165)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLModificarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBotonAplicarEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(497, 497, 497)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBuscarDni)
                    .addComponent(jCheckBoxVerificacion)
                    .addComponent(jLDNI))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jBotonGuardarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxListaVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLCodigoRefuerzo)
                            .addComponent(jComboBoxRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLNombre))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(159, 159, 159)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcListarXDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLListarXDia)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLBuscarXDni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBotonBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLModificarEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBotonAplicarEstado)))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCalendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    ///boton Guardar Cita
    private void jBotonGuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonGuardarCitaActionPerformed
        try{
           // jCheckBoxVerificacion.setEnabled(false);//para que no sea editable
           
           ///obtengo fecha
           String fechaELegida= dFormat.format(jCalendarCita.getDate());
           // Obtén la fecha seleccionada del componente JDateChooser
            Date fechaSeleccionadaDate = jCalendarCita.getDate();

            // Convierte la fecha a LocalDate
            LocalDate fechaSeleccionada = fechaSeleccionadaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            
            ///-------obtengo la hora:
            
            // Obtener la hora seleccionada del combobox
            String horaSeleccionada = (String) jComboBoxHorarios.getSelectedItem();

            // Dividir la cadena en horas y minutos
            String[] partesHora = horaSeleccionada.split(":");
            int horas = Integer.parseInt(partesHora[0]);
            int minutos = Integer.parseInt(partesHora[1]);

            // Crear un objeto LocalTime
            LocalTime localTime = LocalTime.of(horas, minutos);
            
            System.out.println("hora del combobox"+localTime);
            
            
           
            
            
            // Obtener el número seleccionado del JComboBox
            String numeroSeleccionado = (String) jComboBoxHorarios.getSelectedItem();

            // Convertir el número a int
            codRefuerzoCita = Integer.parseInt((String) jComboBoxRefuerzo.getSelectedItem());
            
            System.out.println("codigo refuerzo: "+codRefuerzoCita);
            
            //obtengo vacuna seleccionada:
            vacuna= (Vacuna) jComboBoxListaVacunas.getSelectedItem();
            
            /*ahora armo la cita y la mando a la BDm por metodo cargar luego imprimo en tabla*/
            /*CitaVacunacion(, Ciudadano ciudadano)*/
            
            citaVac.setFechaHoraCita(fechaSeleccionada);
            citaVac.setCentroVacunacion(ciudadano.getDistrito());
            citaVac.setFechaHoraColoca(localTime);
            citaVac.setVacuna(vacuna);
            citaVac.setCodRefuerzo(codRefuerzoCita);
            citaVac.setCiudadano(ciudadano);
            citaVac.setEstado("Activa");
            
            System.out.println(" cita "+citaVac);
            
            citaData.cargarCita(citaVac);//cargo a la BD
            
            citaVac=citaData.buscarCitaXDNI(dni);//obtengo el codigo que colocó la bd
            
            //ahora la tambla
             borrarFilaDeTabla();
             
             modeloTabla.addRow(new Object[]{citaVac.getCodCita(),citaVac.getCiudadano().getNombreCompleto(),
                                citaVac.getCiudadano().getDni(),citaVac.getCiudadano().getPatologia(),
                                citaVac.getFechaHoraCita(),citaVac.getFechaHoraColoca(),
                                citaVac.getVacuna().getMarca(),citaVac.getVacuna().getNroSerie(),
                                citaVac.getCodRefuerzo(),citaVac.getCiudadano().getDistrito(),
                                citaVac.getEstado()});
             
             
            
            
            
            
           
//           JDateChooser jCalendarCita = new JDateChooser();
//
//            // Obtén la fecha seleccionada del JCalendar
//            Date fechaSeleccionada = jCalendarCita.getDate();
//
//            // Convierte la fecha seleccionada a LocalDate
//            LocalDate fecha = null;
//            if (fechaSeleccionada != null) {
//                fecha = fechaSeleccionada.toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();
//            }
            
//            //hora elegida
//            LocalTime hora=(LocalTime) jComboBoxHorarios.getSelectedItem();
            
            
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Problemas en el DNI "+e.getMessage());
        }
    }//GEN-LAST:event_jBotonGuardarCitaActionPerformed

    private void jBuscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarDniActionPerformed

        try{
            dni=Integer.parseInt(jtDNI.getText());//aplicar controles
            System.out.println("dni ingresado: "+dni);
            
//            String digito=String.valueOf(dni);
//            if(digito.length()<7 || digito.length()>8){
//                System.out.println("ingresó al if (digito.length()<7 || digito.length()>8) ");
//                JOptionPane.showMessageDialog(null,"Ingrese un  DNI válido");
//                return;
//            }



            System.out.println("pasó el if");
            ciudadano=ciuData.buscarCiudadano(dni);
            System.out.println("devolvió el ciudadano");
            System.out.println("nombre ciudadano "+ciudadano.getNombreCompleto());
        if(ciudadano!=null){
            jCheckBoxVerificacion.setSelected(true);
               
                //cargo refuerzo
               
               int codRefuerzo= ciudadano.getCodRefuerzo();
               jtNombre.setText(ciudadano.getNombreCompleto());
               if(codRefuerzo==0){
                   jComboBoxRefuerzo.removeAll();
                   jComboBoxRefuerzo.addItem("1");                   
               }else{
                   if(codRefuerzo==1){
                       jComboBoxRefuerzo.removeAll();
                       jComboBoxRefuerzo.addItem("2");                 
                   }else{
                       if(codRefuerzo==2){
                           jComboBoxRefuerzo.removeAll();
                        jComboBoxRefuerzo.addItem("3");
                       }else{
                           System.out.println("ya tiene los 3 refuerzos");
                           JOptionPane.showMessageDialog(null, "El Ciudadano Ya tiene los 3 Refuerzos");
                       }
                   }                  
               }
               
               
               //cargo vacunas
                   
               ListaVacunas=vacuData.listarVacunasNoAplic();
               jComboBoxListaVacunas.addItem(null);
               for(Vacuna vac: ListaVacunas){
                   System.out.println("vacuna de la lista "+vac);
                   
                   jComboBoxListaVacunas.addItem(vac);
                    
               }
               if(jComboBoxListaVacunas.getSelectedItem()!=null || jComboBoxListaVacunas.getSelectedItem()!="Seleccione vacuna:" ){
                   vacuna= (Vacuna) jComboBoxListaVacunas.getSelectedItem();
               }
               
                //----ya tengo todo, tomo los datos, creo la cita y la cargo en boton evento  guardar
                
                
               
           }else{
               jCheckBoxVerificacion.setSelected(false);
           }
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"DNI no encontrado"+e.getMessage());
        }
    }//GEN-LAST:event_jBuscarDniActionPerformed

    private void jCalendarCitaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarCitaPropertyChange
       /*
        Este código añadirá un escuchador de eventos de propiedad al JCalendar.
        El escuchador de eventos de propiedad se invocará cada vez que
        se cambie una propiedad del JCalendar.
        En este caso, el escuchador de eventos de propiedad comprobará
        si la propiedad date ha cambiado. Si ha cambiado, el código comprobará
        si el horario seleccionado está disponible.
        Si no lo está, el día seleccionado en el calendario se deshabilitará.
        */
//        if (evt.getPropertyName().equals("date")) {
//            String horario = (String) jComboBoxHorarios.getSelectedItem();
//
//            if (!horariosHabiles.get(jCalendarCita.getDate())) {
//                jCalendarCita.setDate(null);
//            }
//        }
    }//GEN-LAST:event_jCalendarCitaPropertyChange

    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonAplicarEstado;
    private javax.swing.JButton jBotonBuscar;
    private javax.swing.JButton jBotonGuardarCita;
    private javax.swing.JButton jBuscarDni;
    private com.toedter.calendar.JDateChooser jCalendarCita;
    private javax.swing.JCheckBox jCheckBoxVerificacion;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBoxHorarios;
    private javax.swing.JComboBox<Vacuna> jComboBoxListaVacunas;
    private javax.swing.JComboBox<String> jComboBoxRefuerzo;
    private javax.swing.JLabel jLBuscarXDni;
    private javax.swing.JLabel jLCodigoRefuerzo;
    private javax.swing.JLabel jLDNI;
    private javax.swing.JLabel jLListarXDia;
    private javax.swing.JLabel jLModificarEstado;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableListado;
    private javax.swing.JTextField jTextField6;
    private com.toedter.calendar.JDateChooser jdcListarXDia;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

//-------------------------------_Métodos_-------------------------------//


  /*-----cabeceras de la tabla-----*/
    /*
    del constructor de citaVacunacion
    public CitaVacunacion(int codCita, LocalDate fechaHoraCita, String centroVacunacion, LocalDate fechaHoraColoca, Vacuna vacuna, int codRefuerzo, Ciudadano ciudadano, String estado) {
        this.codCita = codCita;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.vacuna = vacuna;
        this.codRefuerzo = codRefuerzo;
        this.ciudadano = ciudadano;
        this.estado = estado;
    }
    */
        public void armarCabeceraTabla(){    
                modeloTabla.addColumn("cod. Cita");
                modeloTabla.addColumn("Ciudadano");//nombre completo 
                modeloTabla.addColumn("DNI"); 
                modeloTabla.addColumn("Patología Base");
                modeloTabla.addColumn("fecha Colocación");
                modeloTabla.addColumn("turno");//hora
                modeloTabla.addColumn("vacuna");
                modeloTabla.addColumn("codRefuerzo");//1º 2º 3º
                modeloTabla.addColumn("centroVacunacion");
                modeloTabla.addColumn("Estado de la Cita");//Activa, Cumplida, Cancelada, Vencida
                jTableListado.setModel(modeloTabla);
        }  
    
    //borra/setea la tabla
        private void borrarFilaDeTabla(){
            int indice = modeloTabla.getRowCount() -1;
            for(int i = indice ; i >= 0 ; i--){
                modeloTabla.removeRow(i);           
            }
        } 
    
        
 
}
