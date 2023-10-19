
package Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_Entidades.Laboratorio;

public class Admin_Laboratorios extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla;//modelo para la tabla
    private ArrayList<Laboratorio> ListaLaboratorios;
    private LaboratorioData labData;
    private Laboratorio lab;
    
    
    public Admin_Laboratorios() {
        initComponents();
        armarCabeceraTabla();
        
        lab=null;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTListadoLab = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbDarBaja = new javax.swing.JButton();
        jLTitulo = new javax.swing.JLabel();
        jbListarLab = new javax.swing.JButton();
        jLNombreLab = new javax.swing.JLabel();
        jtNombreLab = new javax.swing.JTextField();
        jLCuit = new javax.swing.JLabel();
        jLPais = new javax.swing.JLabel();
        jLDomicilio = new javax.swing.JLabel();
        jCheckBoxEstado = new javax.swing.JCheckBox();
        jLEstado = new javax.swing.JLabel();
        jtCuit = new javax.swing.JTextField();
        jtPais = new javax.swing.JTextField();
        jtDomicilio = new javax.swing.JTextField();
        jbBuscarxCuit = new javax.swing.JButton();
        jbBuscarxNombre = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administración de Laboratorios");
        setPreferredSize(new java.awt.Dimension(800, 700));
        setRequestFocusEnabled(false);

        jTListadoLab.setAutoCreateRowSorter(true);
        jTListadoLab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la Empresa", "CUIT", "País", "Domicilio Comercial", "Contrato/Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTListadoLab.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTListadoLab);

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbDarBaja.setText("Dar de Alta/Baja");
        jbDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarBajaActionPerformed(evt);
            }
        });

        jLTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLTitulo.setText("Inscripción de Laboratorios");

        jbListarLab.setText("Listar Laboratorios");
        jbListarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarLabActionPerformed(evt);
            }
        });

        jLNombreLab.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLNombreLab.setText("Nombre del Laboratorio: ");

        jLCuit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLCuit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCuit.setText("CUIT: ");

        jLPais.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLPais.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPais.setText("País: ");

        jLDomicilio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLDomicilio.setText("Domicilio Comercial: ");

        jLEstado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLEstado.setText("Activo: ");

        jbBuscarxCuit.setText("Buscar por CUIT");

        jbBuscarxNombre.setText("Buscar por Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbDarBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbListarLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jbBuscarxNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbBuscarxCuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLPais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLDomicilio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLCuit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLNombreLab))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(215, 215, 215)
                                .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLTitulo)
                                    .addComponent(jtNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBoxEstado))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTitulo)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCuit)
                            .addComponent(jtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPais)
                            .addComponent(jtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDomicilio)
                            .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLEstado)
                            .addComponent(jCheckBoxEstado))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(jbBuscarxCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jbListarLab, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        
        agregarLaboratorio();
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbListarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarLabActionPerformed
        borrarFilaDeTabla();
        ListarLaboratorios ();
    }//GEN-LAST:event_jbListarLabActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        /*
        1ero usuario debe elegir un laboratorio de la lista sino avisa por cartel ésto.
        //seleccionado el laboratorio:
             guardamos el cuit del laboratorio seleccionado en la tabla
             mandamos el cuit al método cargarLaboratorio de laboratorioData
        */
        
        extraerLabdeTabla();//extrae 
        agregarLaboratorio();//modifica y guarda
        ListarLaboratorios ();//actualiza la tabla
               
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarBajaActionPerformed
        
        try{
            // Obtiene la fila seleccionada
            int row = jTListadoLab.getSelectedRow();

            // Obtiene los datos de la fila seleccionada
            Object[] colum = (Object[]) jTListadoLab.getValueAt(row, 0); // La primera columna contiene los datos del laboratorio
            
            //extraemos cuit de la fila seleccionada
            int cuit = (int)colum[1];
            //lo mandamos al método de laboratorioData que invierte el estado del laboratorio
            labData.cambiarEstadoLaboratorio(cuit); //accedemos al  método por el objeto lab de clase laboratorioData       
            ListarLaboratorios();
        }catch (NullPointerException e) {
             // La tabla no tiene filas seleccionadas
             JOptionPane.showMessageDialog(null, "La tabla no tiene filas seleccionadas"+e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
             // La fila seleccionada no existe
             JOptionPane.showMessageDialog(null, "La fila seleccionada no existe"+e.getMessage());
        }
        
    }//GEN-LAST:event_jbDarBajaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxEstado;
    private javax.swing.JLabel jLCuit;
    private javax.swing.JLabel jLDomicilio;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLNombreLab;
    private javax.swing.JLabel jLPais;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTListadoLab;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscarxCuit;
    private javax.swing.JButton jbBuscarxNombre;
    private javax.swing.JButton jbDarBaja;
    private javax.swing.JButton jbListarLab;
    private javax.swing.JButton jbModificar;
    private javax.swing.JTextField jtCuit;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTextField jtNombreLab;
    private javax.swing.JTextField jtPais;
    // End of variables declaration//GEN-END:variables

    
    //cabeceras de la tabla
    public void armarCabeceraTabla(){    
            modeloTabla.addColumn("Nombre de la Empresa");
            modeloTabla.addColumn("Cuit");         
            modeloTabla.addColumn("País");
            modeloTabla.addColumn("Domicilio Comercial");
            modeloTabla.addColumn("Contrato/Estado");
            jTListadoLab.setModel(modeloTabla);
    }
    
    //borra/setea la tabla
    private void borrarFilaDeTabla(){
        int indice = modeloTabla.getRowCount() -1;
        for(int i = indice ; i >= 0 ; i--){
            modeloTabla.removeRow(i);           
        }
    }    
    
    
    //método para limpiar/setear campos (textfield y checkbox)
    private void limpiarCampos(){
        jtNombreLab.setText("");
        jtCuit.setText("");
        jtPais.setText("");
        jtDomicilio.setText("");
        jCheckBoxEstado.setEnabled(false);
    }
    
    private void agregarLaboratorio(){
        try{
            
            //verificamos que no queden campos vacíos en los JTextField
            if (jtNombreLab.getText().isEmpty() || jtPais.getText().isEmpty() || jtDomicilio.getText().isEmpty() || jtCuit.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
                return; //return sale del método
            }

            //declaro atributos y almaceno en ellos lo ingresado en los jtextfield y jcheckbox para manipularlos            
            String nombreLab = jtNombreLab.getText();
            int cuit = Integer.getInteger(jtCuit.getText()); //tendrá Exception
            String pais = jtPais.getText();
            String domicilio = jtDomicilio.getText();
            Boolean estado = jCheckBoxEstado.isSelected();
            
            //seteamos los JTextField y jcheckbox
            limpiarCampos();
            
            //carga del laboratorio
            if(lab == null){
                 // Si lab es nulo significa que está en blanco/vacío
                // le pasamos a lab (que es el modelo de laboratorio) los datos rescatados ingresados por el usuario
                lab = new Laboratorio(cuit,nombreLab, pais, domicilio, estado); //constructor creado en laboratorio(Entidades)
                // una vez listo el modelo con sus datos debemos mandarlo al método de laboratorioData que carga laboratorios
                //para acceder al método de laboratorioData necesito el objeto de esa clase labData declarado anteriormente en este código
                labData.cargarLaboratorio(lab);
            }else{
                System.out.println("problemas en el contenido de lab - laboratorio");
            }            
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "el CUIT son sólo 11 dígitos");
        }
    }
    
    private void ListarLaboratorios(){
        /*
        1ero- necesitamos el objeto de la clase LaboratorioData para acceder a su método listarLaboratorios ->labData
        2do- necesitamos un arrayList donde almacenaremos la lista de laboratorios que nos devolverá ese método
        3er- necesitamos el modelo de la tabla para pasarle las filas
        4to- en un for agregaremos fila por fila los datos de la lista recuperada
            Para ellos necesitamos recuperar el laboratorio de 1 fila guardandolo en un objeto de tipo laboratorio ->lab
        */
        
        
        //varios objetos ya fueron declarados anteriormente, aquí los usamos directamente
        
        /*
        objeto clase Laboratorio -> lab
        objeto clase LaboratorioData -> labData
        modelo tabla -> modeloTabla
        lista declarada aquí ->listaLab
        */
        

        // Obtener la lista de materias
        List<Laboratorio> listaLab = labData.listarLaboratorios();


        for(Laboratorio Lab: listaLab){
            modeloTabla.addRow(new Object []{lab.getNomLaboratorio(),lab.getCuit(),lab.getPais(),lab.getDomComercial(),lab.isEstado()});
        }
    }
    
    //extrae el laboratorio seleccionado de la tabla hacia los textfield para modificar un dato
    private void extraerLabdeTabla(){
        try{
            // Obtiene la fila seleccionada
            int row = jTListadoLab.getSelectedRow();

            // Obtiene los datos de la fila seleccionada
            Object[] data = (Object[]) jTListadoLab.getValueAt(row, 0); // La primera columna contiene los datos del laboratorio

            // Setea los datos en los componentes jtextfield
            jtNombreLab.setText((String) data[0]);//los números son posiciones de las columnas en la tabla
            jtCuit.setText((String) data[1]);
            jtPais.setText((String) data[2]);
            jtDomicilio.setText((String) data[3]);
            // Setea los datos en el componente jcheckbox
            jCheckBoxEstado.setSelected((Boolean) data[4]);
            // Si el estado es verdadero, tilda el checkbox
            if ((Boolean) data[4]) {
              jCheckBoxEstado.setSelected(true);
            } else {
              jCheckBoxEstado.setSelected(false);
            }
        }catch (NullPointerException e) {
             // La tabla no tiene filas seleccionadas
             JOptionPane.showMessageDialog(null, "La tabla no tiene filas seleccionadas"+e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
             // La fila seleccionada no existe
             JOptionPane.showMessageDialog(null, "La fila seleccionada no existe"+e.getMessage());
        }        
    }
    
    //el siguiente método actualiza la tabla por el baoratorio que el usuario busca con el cuit
    public void actualizarJTable(Laboratorio lab) {
        // Actualiza la JTable con el laboratorio recibido como argumento
        // Puedes usar el DefaultTableModel o el modelo personalizado que estés utilizando.
    }
    
}
