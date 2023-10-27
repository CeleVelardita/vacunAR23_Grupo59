
package Vistas;


import java.util.ArrayList;
import java.util.Date;//necesario para turnos, cudiado con java.sql.Date
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import vacunar23_AccesoADatos.Conexion.CiudadanoData;
import vacunar23_AccesoADatos.Conexion.citaData;
import vacunar23_Entidades.Ciudadano;
import vacunar23_Entidades.Vacuna;


public class CitaView extends javax.swing.JInternalFrame {

    //declaración de atributos
    private HashMap<Date, Boolean> horariosHabiles;//para control de turnos
    
    //Declaración de atributos
    private DefaultTableModel modeloTabla;//modelo para la tabla
    
    private ArrayList<Ciudadano> ListaCiudadanos;
    private ArrayList<Vacuna> ListaVacunas;
    private citaData citaData;
    private Ciudadano ciudadano;
    private CiudadanoData ciuData;
    private Vacuna vacuna;
    
    
    
    
    public CitaView() {
        initComponents();
        modeloTabla = (DefaultTableModel) jTableListado.getModel();//despues de esto cargo el armado de cabecera de tabla
        jCheckBoxVerificacion.setEnabled(false);
        jtNombre.setEnabled(false);
        cargarComboRefuerzo();
        
        
        
        
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
        jCalendarCita = new com.toedter.calendar.JCalendar();
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
        jSeparator2 = new javax.swing.JSeparator();
        jLModificarEstado = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jBotonAplicarEstado = new javax.swing.JButton();
        jBuscarDni = new javax.swing.JButton();
        jCheckBoxVerificacion = new javax.swing.JCheckBox();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cita para Vacunación");

        jLNombre.setText("Nombre y Apellido: ");

        jLDNI.setText("DNI del Ciudadano: ");

        jLCodigoRefuerzo.setText("Código de Refuerzo");

        jtNombre.setText("jTextField1");

        jtDNI.setText("jTextField3");

        jComboBoxHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Seleccione Fecha Para La Cita: ");

        jCalendarCita.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarCitaPropertyChange(evt);
            }
        });

        jLabel11.setText("Seleccione El Horario: ");

        jBotonGuardarCita.setText("Guardar Cita");
        jBotonGuardarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonGuardarCitaActionPerformed(evt);
            }
        });

        jComboBoxRefuerzo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTableListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableListado);

        jBotonBuscar.setText("Buscar ");

        jLListarXDia.setText("Listar Cita según calendario");

        jLBuscarXDni.setText("Buscar Cita por DNI:");

        jTextField6.setText("jTextField6");

        jLModificarEstado.setText("Modificar Estado De La Cita:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBotonAplicarEstado.setText("Aplicar Estado");

        jBuscarDni.setText("Buscar");
        jBuscarDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarDniActionPerformed(evt);
            }
        });

        jCheckBoxVerificacion.setText("jCheckBox1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLListarXDia)
                        .addGap(18, 18, 18)
                        .addComponent(jdcListarXDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBotonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLBuscarXDni)
                            .addComponent(jTextField6)
                            .addComponent(jSeparator2)
                            .addComponent(jLModificarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBotonAplicarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNombre)
                            .addComponent(jLCodigoRefuerzo))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtNombre)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLDNI)
                        .addGap(31, 31, 31)
                        .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBuscarDni)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxVerificacion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jCalendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBotonGuardarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(358, 358, 358))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLDNI)
                                    .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBuscarDni))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxVerificacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLNombre)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCodigoRefuerzo)
                            .addComponent(jBotonGuardarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jComboBoxRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jCalendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcListarXDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLListarXDia))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLBuscarXDni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBotonBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLModificarEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBotonAplicarEstado))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    ///control del candelario de turnos
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
        if (evt.getPropertyName().equals("date")) {
            String horario = (String) jComboBoxHorarios.getSelectedItem();

            if (!horariosHabiles.get(jCalendarCita.getDate())) {
                jCalendarCita.setDate(null);
            }
        }    
    }//GEN-LAST:event_jCalendarCitaPropertyChange

    
    
    ///boton Guardar Cita
    private void jBotonGuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonGuardarCitaActionPerformed
        try{
            jCheckBoxVerificacion.setEnabled(false);//para que no sea editable
           if(ciudadano!=null){
               jCheckBoxVerificacion.setSelected(true);
               
           }else{
               jCheckBoxVerificacion.setSelected(false);
           }
      
        }catch(){
            
        }
    }//GEN-LAST:event_jBotonGuardarCitaActionPerformed

    private void jBuscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarDniActionPerformed
        
        int dni=Integer.parseInt(jtDNI.getText());//aplicar controles
        ciudadano=ciuData.buscarCiudadano(dni);
        if(ciudadano!=null){
               jCheckBoxVerificacion.setSelected(true);
               int codRefuerzo= Integer.parseInt(ciudadano.codRefuerzo);
               jtNombre.setText(ciudadano.nombreCompleto);
               if(codRefuerzo==0){
                   jComboBoxRefuerzo.removeAll();
                   jComboBoxRefuerzo.addItem("1");
                   jComboBoxRefuerzo.addItem("2");
                   jComboBoxRefuerzo.addItem("3");
               }else{
                   if(codRefuerzo==1){
                       jComboBoxRefuerzo.removeAll();
                       jComboBoxRefuerzo.addItem("2");                 
                   }else{
                       jComboBoxRefuerzo.removeAll();
                       jComboBoxRefuerzo.addItem("3");
                   }                   
               }
           }else{
               jCheckBoxVerificacion.setSelected(false);
           }
    }//GEN-LAST:event_jBuscarDniActionPerformed

    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonAplicarEstado;
    private javax.swing.JButton jBotonBuscar;
    private javax.swing.JButton jBotonGuardarCita;
    private javax.swing.JButton jBuscarDni;
    private com.toedter.calendar.JCalendar jCalendarCita;
    private javax.swing.JCheckBox jCheckBoxVerificacion;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBoxHorarios;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
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
    
        
//    private void cargarComboLaboral() {
//        jComboBoxAmbito.addItem(" ");
//        jComboBoxAmbito.addItem("Arte y entretenimiento");
//        jComboBoxAmbito.addItem("Educación");
//        jComboBoxAmbito.addItem("Desempleado");
//        jComboBoxAmbito.addItem("Finanzas y Contabilidad");
//        jComboBoxAmbito.addItem("Gobierno y Sector Público");
//        jComboBoxAmbito.addItem("Jubilado");
//        jComboBoxAmbito.addItem("Salud y Medicina");
//        jComboBoxAmbito.addItem("Seguridad");
//        jComboBoxAmbito.addItem("Recursos Humanos");
//        jComboBoxAmbito.addItem("Turismo");
//        jComboBoxAmbito.addItem("Tecnología e Informática");
//        jComboBoxAmbito.addItem("Transporte");
//        jComboBoxAmbito.addItem("Turismo");
//        jComboBoxAmbito.addItem("Otros");    
//    }    
}
