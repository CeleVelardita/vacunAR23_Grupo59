package Vistas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CiudadanoView extends javax.swing.JFrame {

    private DefaultTableModel tablaCiu;

    public CiudadanoView() {
        initComponents();

        tablaCiu = (DefaultTableModel) jtTablaCiudadano.getModel();

        //armarCabecera();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jL_TITULO = new javax.swing.JLabel();
        jL_ETIQUETA_DNI = new javax.swing.JLabel();
        jL_ETIQUETA_NombreApellido = new javax.swing.JLabel();
        jL_ETIQUETA_Patologia = new javax.swing.JLabel();
        jL_ETIQUETA_AmbitoLaboral = new javax.swing.JLabel();
        jL_ETIQUETA_Celular = new javax.swing.JLabel();
        jL_ETIQUETA_email = new javax.swing.JLabel();
        jT_nomApellido = new javax.swing.JTextField();
        jtTipoPatologia = new javax.swing.JTextField();
        jT_DNI = new javax.swing.JTextField();
        jTCodArea = new javax.swing.JTextField();
        jT_email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaCiudadano = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jB_MODIFICAR = new javax.swing.JButton();
        jB_ELIMINAR = new javax.swing.JButton();
        jB_CITAS = new javax.swing.JButton();
        jCBox_ambLaboral = new javax.swing.JComboBox<>();
        jcbPatologia = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jtCelular = new javax.swing.JTextField();
        jcbDominioMail = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jL_TITULO.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_TITULO.setText("Carga de datos del ciudadano");

        jL_ETIQUETA_DNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_ETIQUETA_DNI.setText("DNI:");

        jL_ETIQUETA_NombreApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_ETIQUETA_NombreApellido.setText("Nombre y Apellido:");

        jL_ETIQUETA_Patologia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_ETIQUETA_Patologia.setText("Patologia de base:");

        jL_ETIQUETA_AmbitoLaboral.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_ETIQUETA_AmbitoLaboral.setText("Ambito laboral:");

        jL_ETIQUETA_Celular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_ETIQUETA_Celular.setText("Nro Celular:");

        jL_ETIQUETA_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_ETIQUETA_email.setText("E-mail:");

        jtTipoPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTipoPatologiaActionPerformed(evt);
            }
        });

        jTCodArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCodAreaActionPerformed(evt);
            }
        });

        jtTablaCiudadano.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Paciente", "Patología de Base", "Ámbito Laboral"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaCiudadano.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtTablaCiudadano);

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jB_MODIFICAR.setText("Modificar");
        jB_MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_MODIFICARActionPerformed(evt);
            }
        });

        jB_ELIMINAR.setText("Eliminar");
        jB_ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ELIMINARActionPerformed(evt);
            }
        });

        jB_CITAS.setText("Ver citas");

        jcbPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPatologiaActionPerformed(evt);
            }
        });

        jLabel1.setText("¿De qué tipo?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jtTipoPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jL_TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(137, 137, 137)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jL_ETIQUETA_Patologia)
                                    .addComponent(jL_ETIQUETA_NombreApellido)
                                    .addComponent(jL_ETIQUETA_DNI))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jT_nomApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jT_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbPatologia)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jL_ETIQUETA_AmbitoLaboral)
                                    .addComponent(jL_ETIQUETA_Celular)
                                    .addComponent(jL_ETIQUETA_email))
                                .addGap(92, 92, 92)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jT_email, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbDominioMail, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jCBox_ambLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTCodArea, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jB_MODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jB_ELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jB_CITAS, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jL_TITULO)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_ETIQUETA_DNI)
                    .addComponent(jT_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_ETIQUETA_NombreApellido)
                    .addComponent(jT_nomApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jL_ETIQUETA_Patologia)
                    .addComponent(jcbPatologia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtTipoPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBox_ambLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_ETIQUETA_AmbitoLaboral))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jL_ETIQUETA_Celular)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTCodArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_ETIQUETA_email)
                    .addComponent(jT_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDominioMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jB_MODIFICAR)
                    .addComponent(jB_ELIMINAR)
                    .addComponent(jB_CITAS))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTCodAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCodAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodAreaActionPerformed

    //--------------------------------------------------------------------------------------------------------

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed

        try {

            int dni = Integer.parseInt(jT_DNI.getText());
            String nomApellido = jT_nomApellido.getText();

            // si el usuario no llena el campo de nombre y apellido, salta este mensaje, e impide que quede vacio.
            if (nomApellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Este campo no puede quedar vacio. Por favor ingrese su nombre y apellido");
            }

            boolean patologia = jcbPatologia.isSelected();

            if (patologia) {
                String tipoPatologia = jtTipoPatologia.getText();
            }
            
            String ambito = (String) jCBox_ambLaboral.getSelectedItem();
            
            
                    Integer celular = Integer.parseInt(jt_Celular.getText());
            String email = jT_email.getText();

        } catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI valido, sin puntos ni comas");
        } 
            
    }//GEN-LAST:event_jbAgregarActionPerformed

//----------------------------------------------------------------------------------------------------------          
          
          
    private void jB_MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_MODIFICARActionPerformed

    }//GEN-LAST:event_jB_MODIFICARActionPerformed

    private void jB_ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ELIMINARActionPerformed

    }//GEN-LAST:event_jB_ELIMINARActionPerformed

    private void jcbPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPatologiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPatologiaActionPerformed

    private void jtTipoPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTipoPatologiaActionPerformed
        // Restrinjo la posibilidad de escribir, si selecciona falso en la patología, no podrá
        // ingresar una patología
        
        
        if (!jcbPatologia.isSelected()) {
                jtTipoPatologia.setEditable(false);
            } else {
                jtTipoPatologia.setEditable(true);
            }
    }//GEN-LAST:event_jtTipoPatologiaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CiudadanoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CiudadanoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CiudadanoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CiudadanoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CiudadanoView().setVisible(true);
            }
        });
    }
/*
    private void cargarComboLaboral() {
        jComboBoxAmbito.addItem(" ");
        jComboBoxAmbito.addItem("Arte y entretenimiento");
        jComboBoxAmbito.addItem("Educación");
        jComboBoxAmbito.addItem("Desempleado");
        jComboBoxAmbito.addItem("Finanzas y Contabilidad");
        jComboBoxAmbito.addItem("Gobierno y Sector Público");
        jComboBoxAmbito.addItem("Jubilado");
        jComboBoxAmbito.addItem("Salud y Medicina");
        jComboBoxAmbito.addItem("Seguridad");
        jComboBoxAmbito.addItem("Recursos Humanos");
        jComboBoxAmbito.addItem("Turismo");
        jComboBoxAmbito.addItem("Tecnología e Informática");
        jComboBoxAmbito.addItem("Transporte");
        jComboBoxAmbito.addItem("Turismo");
        jComboBoxAmbito.addItem("Otros");    
    }
    */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_CITAS;
    private javax.swing.JButton jB_ELIMINAR;
    private javax.swing.JButton jB_MODIFICAR;
    private javax.swing.JComboBox<String> jCBox_ambLaboral;
    private javax.swing.JLabel jL_ETIQUETA_AmbitoLaboral;
    private javax.swing.JLabel jL_ETIQUETA_Celular;
    private javax.swing.JLabel jL_ETIQUETA_DNI;
    private javax.swing.JLabel jL_ETIQUETA_NombreApellido;
    private javax.swing.JLabel jL_ETIQUETA_Patologia;
    private javax.swing.JLabel jL_ETIQUETA_email;
    private javax.swing.JLabel jL_TITULO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCodArea;
    private javax.swing.JTextField jT_DNI;
    private javax.swing.JTextField jT_email;
    private javax.swing.JTextField jT_nomApellido;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JComboBox<String> jcbDominioMail;
    private javax.swing.JCheckBox jcbPatologia;
    private javax.swing.JTextField jtCelular;
    private javax.swing.JTable jtTablaCiudadano;
    private javax.swing.JTextField jtTipoPatologia;
    // End of variables declaration//GEN-END:variables
/*
    private void armarCabecera () {
        
        modelo.addColumn ("Paciente");
        modelo.addColumn ("Fecha");
        modelo.addColumn ("Horario");
        modelo.addColumn ("Vacunatorio");
        modelo.addColumn ("Refuerzo");
        modelo.addColumn ("Dosis");
        modelo.addColumn ("Aplicado");
        
        jtTablaCiudadano.setModel (modelo);
        
        
    }*/
}
