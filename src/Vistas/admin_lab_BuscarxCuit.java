
package Vistas;

import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_Entidades.Laboratorio;

public class admin_lab_BuscarxCuit extends javax.swing.JInternalFrame {
    
    LaboratorioData buscar_labData=new LaboratorioData();//para acceder al metodo buscar
    Laboratorio lab= new Laboratorio();//para guardar los datos del laboratorio que necesite (es mi modelo)
    
    //referencia a la ventana principal de laboratorio
    private Admin_Laboratorios jframePrincipal;
    //constructor de ésta clase
    public admin_lab_BuscarxCuit() {
        initComponents();
    }
    //el siguiente método permite el vínculo con la ventana principal
    /*
        en el envento del boton buscar por cuit pondremos:
        admin_lab_BuscarxCuit buscarCuit = new admin_lab_BuscarxCuit(this); 
        y si éste método no está aquí no habrá referencia y dará error esa línea anterior
    */
    public admin_lab_BuscarxCuit(Admin_Laboratorios jframePrincipal) {
        this.jframePrincipal = jframePrincipal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlIngreseCuit = new javax.swing.JLabel();
        jtCuit = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();

        setTitle("Búsqueda por CUIT");

        jlIngreseCuit.setText("Ingrese CUIT del Laboratorio: ");

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
                .addGap(21, 21, 21)
                .addComponent(jlIngreseCuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlIngreseCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
       String cuit= jtCuit.getText();
        lab = buscar_labData.buscarLaboratorioXNombre(cuit);//almaceno el lab que encuentre el méotodo de laboratorioData        
        //verifico en el if si encontró un lab para cerrar esta ventana e imprimir el lab encontrado en la tabla

        if(lab!=null){
            // Llama al método para actualizar la JTable en el JFrame principal
            jframePrincipal.actualizarJTable(lab);//método de la ventana principal que actualiza la tabla
            this.dispose();//cierra ésta ventana en caso de encontrar el laboratorio
        }
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbBuscar;
    private javax.swing.JLabel jlIngreseCuit;
    private javax.swing.JTextField jtCuit;
    // End of variables declaration//GEN-END:variables


}
