
package Vistas;

import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_Entidades.Laboratorio;

public class admin_lab_BuscarxNombre extends javax.swing.JInternalFrame {

    LaboratorioData buscar_labData=new LaboratorioData();
    Laboratorio lab= new Laboratorio();
    
    private Admin_Laboratorios jframePrincipal;

   
    
    
    public admin_lab_BuscarxNombre() {
        initComponents();
    }
    
    
     public admin_lab_BuscarxNombre(Admin_Laboratorios jframePrincipal) {
        this.jframePrincipal = jframePrincipal;
        
    }
    
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlIngreseNombre = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();

        setTitle("Búsqueda por Nombre");
        setPreferredSize(new java.awt.Dimension(431, 133));

        jlIngreseNombre.setText("Ingrese Nombre del Laboratorio: ");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlIngreseNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIngreseNombre)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String nombre= jtNombre.getText();
        lab = buscar_labData.buscarLaboratorioXNombre(nombre);
        if(lab!=null){
            this.dispose();
            // Obtén una referencia al JFrame principal
            jframePrincipal = obtenerReferenciaAlJFramePrincipal();

            // Llama al método para actualizar la JTable en el JFrame principal
            jframePrincipal.actualizarJTable(lab);
        }
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbBuscar;
    private javax.swing.JLabel jlIngreseNombre;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
