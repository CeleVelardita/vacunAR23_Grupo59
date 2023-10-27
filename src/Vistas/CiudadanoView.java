      
package Vistas;

public class CiudadanoView extends javax.swing.JFrame {

    private DefaulTableModel modelo = new DefaulTableModel ();
    
    public CiudadanoView() {
        initComponents();
        armarCabecera ();
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
        jT_patologia = new javax.swing.JTextField();
        jT_DNI = new javax.swing.JTextField();
        jT_Celular = new javax.swing.JTextField();
        jT_email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_TABLA = new javax.swing.JTable();
        jB_AGREGAR = new javax.swing.JButton();
        jB_MODIFICAR = new javax.swing.JButton();
        jB_ELIMINAR = new javax.swing.JButton();
        jB_CITAS = new javax.swing.JButton();
        jCBox_ambLaboral = new javax.swing.JComboBox<>();

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

        jT_patologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_patologiaActionPerformed(evt);
            }
        });

        jT_Celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_CelularActionPerformed(evt);
            }
        });

        jTable_TABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_TABLA);

        jB_AGREGAR.setText("Agregar");

        jB_MODIFICAR.setText("Modificar");

        jB_ELIMINAR.setText("Eliminar");

        jB_CITAS.setText("Ver citas");

        jCBox_ambLaboral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jL_ETIQUETA_Patologia)
                            .addComponent(jL_ETIQUETA_AmbitoLaboral)
                            .addComponent(jL_ETIQUETA_NombreApellido)
                            .addComponent(jL_ETIQUETA_DNI)
                            .addComponent(jL_ETIQUETA_email)
                            .addComponent(jL_ETIQUETA_Celular))
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jT_Celular)
                            .addComponent(jT_DNI, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jT_nomApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jT_patologia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBox_ambLaboral, javax.swing.GroupLayout.Alignment.LEADING, 0, 198, Short.MAX_VALUE)
                            .addComponent(jT_email)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jB_AGREGAR)
                        .addGap(67, 67, 67)
                        .addComponent(jB_MODIFICAR)
                        .addGap(63, 63, 63)
                        .addComponent(jB_ELIMINAR)
                        .addGap(44, 44, 44)
                        .addComponent(jB_CITAS)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jL_TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jL_TITULO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_ETIQUETA_DNI))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_nomApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_ETIQUETA_NombreApellido))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_patologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_ETIQUETA_Patologia))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBox_ambLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_ETIQUETA_AmbitoLaboral))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_ETIQUETA_Celular))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_ETIQUETA_email)
                    .addComponent(jT_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_ELIMINAR)
                    .addComponent(jB_CITAS)
                    .addComponent(jB_AGREGAR)
                    .addComponent(jB_MODIFICAR))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    private void jT_CelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_CelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_CelularActionPerformed

    private void jT_patologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_patologiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_patologiaActionPerformed

   
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_AGREGAR;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_Celular;
    private javax.swing.JTextField jT_DNI;
    private javax.swing.JTextField jT_email;
    private javax.swing.JTextField jT_nomApellido;
    private javax.swing.JTextField jT_patologia;
    private javax.swing.JTable jTable_TABLA;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera () {
        
        modelo.addColumn ("Paciente");
        modelo.addColumn ("Fecha");
        modelo.addColumn ("Horario");
        modelo.addColumn ("Vacunatorio");
        modelo.addColumn ("Refuerzo");
        modelo.addColumn ("Dosis");
        modelo.addColumn ("Aplicado");
        
        jTable_TABLA.setModel (modelo);
        
        
    }
}
