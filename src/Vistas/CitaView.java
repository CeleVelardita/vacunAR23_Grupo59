
package Vistas;


import java.util.Date;//necesario para turnos, cudiado con java.sql.Date
import java.util.HashMap;


public class CitaView extends javax.swing.JInternalFrame {

    //declaración de atributos
    private HashMap<Date, Boolean> horariosHabiles;
    
    public CitaView() {
        initComponents();
        
        
        
        
        
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
        jLApellido = new javax.swing.JLabel();
        jLDNI = new javax.swing.JLabel();
        jLDistricto = new javax.swing.JLabel();
        jLAmbitoLaboral = new javax.swing.JLabel();
        jLPatologia = new javax.swing.JLabel();
        jLCodigoRefuerzo = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLFechaNac = new javax.swing.JLabel();
        jComboBoxHorarios = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jCalendarCita = new com.toedter.calendar.JCalendar();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jBotonGuardarCita = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListado = new javax.swing.JTable();
        jBotonBuscar = new javax.swing.JButton();
        jLListarXDia = new javax.swing.JLabel();
        jdcListarXDia = new com.toedter.calendar.JDateChooser();
        jComboBoxAmbito = new javax.swing.JComboBox<>();
        jLBuscarXDni = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLModificarEstado = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jBotonAplicarEstado = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cita para Vacunación");

        jLNombre.setText("Nombre: ");

        jLApellido.setText("Apellido: ");

        jLDNI.setText("DNI: ");

        jLDistricto.setText("Districto: ");

        jLAmbitoLaboral.setText("Ámbito Laboral:");

        jLPatologia.setText(" Patología de Base:");

        jLCodigoRefuerzo.setText("Código de Refuerzo");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jLFechaNac.setText("Fecha de Nacimiento");

        jComboBoxHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Seleccione Fecha Para La Cita: ");

        jCalendarCita.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarCitaPropertyChange(evt);
            }
        });

        jLabel11.setText("Seleccione El Horario: ");

        jBotonGuardarCita.setText("Guardar Cita");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jComboBoxAmbito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLBuscarXDni.setText("Buscar Cita por DNI:");

        jTextField6.setText("jTextField6");

        jLModificarEstado.setText("Modificar Estado De La Cita:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBotonAplicarEstado.setText("Aplicar Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLFechaNac)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLNombre)
                                        .addGap(65, 65, 65))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLDNI)
                                            .addComponent(jLDistricto)
                                            .addComponent(jLApellido))
                                        .addGap(63, 63, 63)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLCodigoRefuerzo)
                                    .addComponent(jLPatologia)
                                    .addComponent(jLAmbitoLaboral))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxAmbito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCalendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBotonGuardarCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157))))))
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
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLNombre)
                                .addGap(28, 28, 28)
                                .addComponent(jLApellido)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLDNI)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLDistricto)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLAmbitoLaboral)
                                    .addComponent(jComboBoxAmbito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPatologia)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCodigoRefuerzo)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBotonGuardarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jCalendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLFechaNac)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    
    
    private void jBuscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarDniActionPerformed
        
        /// Necestido los datos del ciudadano 
        
        //datos ciudadano
        int dni=Integer.parseInt(jtDNI.getText());//aplicar controles
        ciudadano=ciuData.buscarCiudadano(dni);
        
        //si obtengo un ciudadano (lo encuentra en la BD):
        if(ciudadano!=null){
               jCheckBoxVerificacion.setSelected(true);//activo tilde checkbox
               int codRefuerzo= ciudadano.getCodRefuerzo();//recupero el código de refuerzo del ciudadano para verificar cuál le toca
               jtNombre.setText(ciudadano.getNombreCompleto());//seteo el textfield del nombre en la vista
               //seteamos combobox segun la dosis que tenga colocada:
               if(codRefuerzo==0){
                   //si no tiene dosis aplicada
                   jComboBoxRefuerzo.removeAll();//limpia combobox
                   jComboBoxRefuerzo.addItem("1");
                   jComboBoxRefuerzo.addItem("2");
                   jComboBoxRefuerzo.addItem("3");
               }else{
                   //si tiene la 1er dosis
                   if(codRefuerzo==1){
                       jComboBoxRefuerzo.removeAll();
                       jComboBoxRefuerzo.addItem("2");                 
                   }else{
                       //si tiene la 2da dosis
                       jComboBoxRefuerzo.removeAll();
                       jComboBoxRefuerzo.addItem("3");
                   }                   
               }
           }else{
                //si el ciudadano no está en la BD el checkbox queda SIN tilde
               jCheckBoxVerificacion.setSelected(false);
           }
        
        
        
    }//GEN-LAST:event_jBuscarDniActionPerformed

    private void jBotonGuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonGuardarCitaActionPerformed
        //controlar campos vacios
        try{            
           if(ciudadano!=null && jComboBoxRefuerzo.getSelectedItem()!=null && jCalendarCita.getDate()!= null && jComboBoxHorarios.getSelectedItem()!=null){
               //datos vacuna desde vacunaData
                vacuna=(Vacuna) jComboBoxVacuna.getSelectedItem();//ver si es correcto


                //recupero el refuerzo elegido en el checkbox
                int dosisRefuerzo= Integer.parseInt((String) jComboBoxRefuerzo.getSelectedItem());//ver si es correcto



                ///obtengo la fecha elegida para el turno
                // Para obtener la fecha seleccionada del JCalendar y almacenarla en fechaElegida
                Date selectedDate = jCalendarCita.getDate(); // Obtiene la fecha seleccionada como objeto Date
                // Convierte el objeto Date a LocalDate 
                Instant instant = selectedDate.toInstant();
                ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
                LocalDate fechaElegida = zonedDateTime.toLocalDate();

                ///rescato el horario elegido
                LocalTime horaTurno=(LocalTime) jComboBoxHorarios.getSelectedItem(); //// capaz deba dar formato a la hora!!!!!!!!!!!!

                //tengo todos los datos, debo dárselos a mi objeto citaVac (clase CitaVacunacion) por medio de su constructor
                //luego usar mi citaData para acceder al método de cargar la cita, lé envío citaVac para cargarla a la BD
                citaVac= new CitaVacunacion( fechaElegida, horaTurno, vacuna, dosisRefuerzo, ciudadano, "PorColocar");

                //ya tengo la cita, debo mandarla por el método de citaData para almacenarla en la BD
                citaData.cargarCita(citaVac);
                //seteo campos
                setearCampos();
               
           }else{
               if(ciudadano!=null){
                   JOptionPane.showMessageDialog(null, "No se permiten campos vacíos");
               }
           }
           setearCampos();
        }catch(){
            
        }

    }//GEN-LAST:event_jBotonGuardarCitaActionPerformed
///buscar cita por dni
    private void jBotonBuscarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonBuscarCitaActionPerformed
        
        int dni=Integer.parseInt(jTBuscarCita.getText());
        if(dni>5000000){
            citaVac=citaData.buscarCitaXDNI(dni);
            if(citaVac!=null){
                //limpio la tabla
                borrarFilaDeTabla();

                //imprimo en tabla 
                 modeloTabla.addRow(new Object []{citaVac.getCodCita(), citaVac.getCiudadano()
                , citaVac.getCiudadano().getDni(), citaVac.getCiudadano().getPatologia()
                , citaVac.getFechaHoraCita(), citaVac.getHorarioTurno()
                , citaVac.getVacuna().getMarca(),citaVac.getVacuna().getNroSerie()
                , citaVac.getCodRefuerzo(), citaVac.getCentroVacunacion()
                , citaVac.getEstado()});
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese dni correctamente y no deje campos vacíos");
        }
    }//GEN-LAST:event_jBotonBuscarCitaActionPerformed

    private void jdcListarXDiaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcListarXDiaPropertyChange
        Date fechaSeleccionadaDate = jdcListarXDia.getDate();
        
        if (fechaSeleccionadaDate != null) {
            // Convierte Date a LocalDate
            Instant instant = fechaSeleccionadaDate.toInstant();
            LocalDate fechaSeleccionada = instant.atZone(ZoneId.systemDefault()).toLocalDate();

            // Ahora puedes trabajar con la fecha en formato LocalDate
            System.out.println("Fecha seleccionada: " + fechaSeleccionada);
            
            
            //debo mandar la fecha a citaData y que el método me devuelva la lista de citas de esa fecha
            listaCitas=citaData.buscarCitaXFecha(fechaSeleccionada);
            
            if(listaCitas!=null){
                //limpio la tabla
                borrarFilaDeTabla();
                for(CitaVacunacion cita: listaCitas){
                    //imprimo en tabla 
                        modeloTabla.addRow(new Object []{cita.getCodCita(), cita.getCiudadano()
                        , cita.getCiudadano().getDni(), cita.getCiudadano().getPatologia()
                        , cita.getFechaHoraCita(), cita.getHorarioTurno()
                        , cita.getVacuna().getMarca(),cita.getVacuna().getNroSerie()
                        , cita.getCodRefuerzo(), cita.getCentroVacunacion()
                        , cita.getEstado()});
                }
            }
            
        } else {
            // El usuario no ha seleccionado una fecha
            System.out.println("Por favor, seleccione una fecha");
        }
        
        
    }//GEN-LAST:event_jdcListarXDiaPropertyChange

    private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoMouseClicked
        selectedRow = jTableListado.getSelectedRow();//tomo fila seleccionada
        if (selectedRow >= 0) {
            // Habilita el JComboBoxEstado y configura las opciones
            jComboBoxEstado.setEnabled(true);
            jComboBoxEstado.removeAllItems();
            jComboBoxEstado.addItem("Activa");
            jComboBoxEstado.addItem("Cumplida");
            jComboBoxEstado.addItem("Cancelada");
            jComboBoxEstado.addItem("Vencida");
            valorCelda = jTableListado.getValueAt(selectedRow, 10);
            
            
        } 
    }//GEN-LAST:event_jTableListadoMouseClicked

    private void jBotonAplicarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonAplicarEstadoActionPerformed
        // Puedes establecer el valor seleccionado en función de la columna 10 en la fila seleccionada
            // valorCelda es la celda del Estado de la fila seleccionada en la tabla
            if (valorCelda instanceof String) {
                String estadoCita = (String) valorCelda;
                String EstadoSeleccionado= (String) jComboBoxEstado.getSelectedItem();
                citaData.estadoCita(codigoCIta, EstadoSeleccionado);
                jComboBoxEstado.setEnabled(false);
            }
    }//GEN-LAST:event_jBotonAplicarEstadoActionPerformed

    

    
>>>>>>> parent of ae424a6 (lab)
>>>>>>> parent of 403ed7e (cita)

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonAplicarEstado;
    private javax.swing.JButton jBotonBuscar;
    private javax.swing.JButton jBotonGuardarCita;
    private com.toedter.calendar.JCalendar jCalendarCita;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBoxAmbito;
    private javax.swing.JComboBox<String> jComboBoxHorarios;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLAmbitoLaboral;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLBuscarXDni;
    private javax.swing.JLabel jLCodigoRefuerzo;
    private javax.swing.JLabel jLDNI;
    private javax.swing.JLabel jLDistricto;
    private javax.swing.JLabel jLFechaNac;
    private javax.swing.JLabel jLListarXDia;
    private javax.swing.JLabel jLModificarEstado;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLPatologia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableListado;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private com.toedter.calendar.JDateChooser jdcListarXDia;
    // End of variables declaration//GEN-END:variables

//-------------------------------_Métodos_-------------------------------//

///cargar combobox horarios
    

}
