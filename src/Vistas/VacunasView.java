
package Vistas;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_AccesoADatos.Conexion.VacunaData;
import vacunar23_Entidades.Laboratorio;
import vacunar23_Entidades.Vacuna;

public class VacunasView extends javax.swing.JInternalFrame {
    
    private VacunaData vacunaData;
    private Vacuna vacunaActual;
    private Laboratorio lab;
    private LaboratorioData labData;    
    
    private DefaultComboBoxModel modeloComboDosis; // Lo necesito para agregarle elementos al comboDosis
    
    private List<Vacuna> ListaVacunas; // Lo voy a necesitar para llenar la tabla
    private List<Laboratorio> ListaLaboratorios; // Lo voy a necesitar para el comboBox de laboratorios

    private DefaultTableModel tablaVacunas;
    
    public VacunasView() {
        initComponents();
        vacunaData = new VacunaData();
        vacunaActual = null;  
                             
        tablaVacunas = (DefaultTableModel) jtTablaVacunas.getModel();
        
        cargarListaVacunas();
        
        cargarComboLaboratorios();
        
        cargarComboDosis(); 
        jcbMedida.setSelectedItem(null);
       
        jdcVencimiento.setDate(null);
        
        
        // No entiendo para qué sirve la línea de abajo
        //jtTablaVacunas.addMouseListener(new MouseAdapter() {
          //});
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaVacunas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtMarca = new javax.swing.JTextField();
        jtNroSerie = new javax.swing.JTextField();
        jcbMedida = new javax.swing.JComboBox<>();
        jdcVencimiento = new com.toedter.calendar.JDateChooser();
        jbAgregar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jcbLaboratorio = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jcbAplicada = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administración de Vacunas");
        setPreferredSize(new java.awt.Dimension(490, 600));

        jtTablaVacunas.setAutoCreateRowSorter(true);
        jtTablaVacunas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Laboratorio", "Marca", "Nro. Serie", "Dosis (ml)", "Vencimiento", "Aplicada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaVacunas.getTableHeader().setReorderingAllowed(false);
        jtTablaVacunas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtTablaVacunasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtTablaVacunas);
        if (jtTablaVacunas.getColumnModel().getColumnCount() > 0) {
            jtTablaVacunas.getColumnModel().getColumn(0).setResizable(false);
            jtTablaVacunas.getColumnModel().getColumn(1).setResizable(false);
            jtTablaVacunas.getColumnModel().getColumn(2).setResizable(false);
            jtTablaVacunas.getColumnModel().getColumn(3).setResizable(false);
            jtTablaVacunas.getColumnModel().getColumn(4).setResizable(false);
            jtTablaVacunas.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setText("LABORATORIO: ");

        jLabel2.setText("MARCA: ");

        jLabel3.setText("Nro. SERIE: ");

        jLabel4.setText("DOSIS (ml): ");

        jLabel5.setText("VENCIMIENTO: ");

        jcbMedida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcbMedida.setName(""); // NOI18N

        jbAgregar.setText("Insertar");
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

        jbEliminar.setText("Elimiar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jcbLaboratorio, org.jdesktop.beansbinding.ObjectProperty.create(), jcbLaboratorio, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel6.setText("APLICADA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNroSerie)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jdcVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbAplicada))
                                        .addGap(0, 81, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(72, 72, 72))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(30, 30, 30)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addComponent(jcbLaboratorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jbAgregar)
                        .addGap(46, 46, 46)
                        .addComponent(jbModificar)
                        .addGap(68, 68, 68)
                        .addComponent(jbEliminar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jdcVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbAplicada, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /// ---------- BOTÓN INSERTAR ----------
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        //String nombreLab = null;
        Double dosisSeleccionada = 0.0;
        LocalDate fechaCaducidad = null;
        try {
            /// Se guardan los datos de cada campo en su variable correpondiente
            Laboratorio lab = laboratorioSeleccionado();
            // Utilizo el método creado para acceder al nombre y al id del laboratorio seleccionado
            if(lab != null){
            //nombreLab = lab.getNomLaboratorio();
            int id = lab.getIdLaboratorio();           
            }
            
            String marca = jtMarca.getText();
            int nroSerie = Integer.parseInt(jtNroSerie.getText());
            
            // Guardo la opción del comboBoxDosis en una variable
            
            if(jcbMedida.getSelectedItem() != null){
            String dosis = (String) jcbMedida.getSelectedItem(); // el combo me devuelve un Object
            dosisSeleccionada = Double.parseDouble(dosis); // Lo parseo a un Double para mandarlo a la base de datos
            } else{
                dosisSeleccionada = 0.0;
            }
            
            if (jdcVencimiento.getDate() != null) {
               fechaCaducidad = jdcVencimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            
            Boolean aplicada = jcbAplicada.isSelected();       
            
            
            /// Verifico que no queden campos vacíos
            if (lab == null || marca.isEmpty() || nroSerie == 0 || dosisSeleccionada == 0.0 || fechaCaducidad == null) {
                JOptionPane.showMessageDialog(this, "No pueden haber campos vacíos");
                return;
            } else { /// Si los campos no están vacíos...  
                
                
                /*-----------------------------------------*/
                // Chequeo si el numSerie no existe en mi BD
                int nroExistente = vacunaData.buscarPorNroSerie(nroSerie).getNroSerie();
                
                /*-----------------------------------------*/
                

                if (vacunaActual == null && (nroExistente != nroSerie)) {
                    vacunaActual = new Vacuna(nroSerie, marca, dosisSeleccionada, fechaCaducidad, aplicada, lab);
                    vacunaData.cargarVacuna(vacunaActual);
                    limpiarCampos();
                } else if (nroSerie == nroExistente){ // si no está nulo, es porque ya está cargada una vacuna con el mismo número de serie
                    JOptionPane.showMessageDialog(this, "Ya existe una vacuna con el número de serie ingresado.");
                    limpiarCampos();                    
                }
            }

        } catch (NumberFormatException e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(this, "El campo 'Nro. Serie' está vacío o contiene carácteres inválidos "+e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Los campos 'Laboratorio' y 'Marca' no son válidos");
        }             
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    
    /// ---------- BOTÓN MODIFICAR ----------
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        
        int filaSeleccionada = jtTablaVacunas.getSelectedRow();
        
        if(filaSeleccionada != -1){
        
        Double dosisSeleccionada = 0.0;
        LocalDate fechaCaducidad = null;
        try {
            /// Se guardan los datos de cada campo en su variable correpondiente
            Laboratorio lab = laboratorioSeleccionado();
            // Utilizo el método creado para acceder al nombre y al id del laboratorio seleccionado
            if (lab != null) {
                int id = lab.getIdLaboratorio();
            }

            String marca = jtMarca.getText();
            int nroSerie = Integer.parseInt(jtNroSerie.getText());

            // Guardo la opción del comboBoxDosis en una variable
            if (jcbMedida.getSelectedItem() != null) {
                String dosis = (String) jcbMedida.getSelectedItem(); // el combo me devuelve un Object
                dosisSeleccionada = Double.parseDouble(dosis); // Lo parseo a un Double para mandarlo a la base de datos
            } else {
                dosisSeleccionada = 0.0;
            }

            if (jdcVencimiento.getDate() != null) {
                fechaCaducidad = jdcVencimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }

            Boolean aplicada = jcbAplicada.isSelected();

            /// Verifico que no queden campos vacíos
            if (lab == null || marca.isEmpty() || nroSerie == 0 || dosisSeleccionada == 0.0 || fechaCaducidad == null) {
                JOptionPane.showMessageDialog(this, "No pueden haber campos vacíos");
                return;
            } else {
                
                vacunaActual.setNroSerie(nroSerie);
                vacunaActual.setMarca(marca);
                vacunaActual.setMedida(dosisSeleccionada);
                vacunaActual.setFechaCaduca(fechaCaducidad);
                vacunaActual.setColocada(aplicada);
                vacunaActual.setLaboratorio(lab);

                vacunaData.modificarVacuna(vacunaActual);
                
                limpiarCampos();

            }
        } catch (NumberFormatException e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(this, "El campo 'Nro. Serie' está vacío o contiene carácteres inválidos " + e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Los campos 'Laboratorio' y 'Marca' no son válidos");
        }        
        } else{
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila haciendo doble click para modificar");
        }
       
    }//GEN-LAST:event_jbModificarActionPerformed

    
    /// ---------- DOBLE CLICK SOBRE UNA FILA DE LA TABLA ----------
    private void jtTablaVacunasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaVacunasMousePressed
        
        // Este evento me permite hacer doble click sobre una fila de la tabla y automáticamente setear los campos para
        // la edición y modificación de los datos
        JTable tabla = (JTable) evt.getSource();
        Point coordenadasTabla = evt.getPoint();
        
        /*-----------------------------------------------------------------------------
                   EXPLICACIÓN DE LAS LÍNEAS DE ARRIBA
        
        JTable tabla = (JTable) evt.getSource();
        Esta línea obtiene la fuente del evento llamado evt (por defecto al crear el evento de tipo "MousePressed".
        Esta fuente de evento, se almacena en la variable "tabla" de tipo JTable, por eso debo castear el objeto fuente a un "JTable".
        Una vez hecho esto, puedo acceder a las propiedades y métodos específicos de "JTable".
        
        Point coordenadasTabla = evt.getPoint();
        Esta línea obtiene las coordenadas del punto en el que ocurrió el evento (en qué parte de la tabla se hizo doble click).
        Permite determinar en qué fila se hizo click almacenando la información en la variable "coordenadasTabla".
        
        -------------------------------------------------------------------------------*/
        
        // Se guarda el número de la fila seleccionada en un int
        int fila = tabla.rowAtPoint(coordenadasTabla);
        // int fila = jtTablaVacunas.getSellectedRow();
        
        
        if(evt.getClickCount() == 2){ // el "== 2" indica que se hizo doble click, también puedo especificar la cantidad de click's que quiera
            
            // SETEAR NOMBRE LABORATORIO - DOSIS - FECHA CADUCA - COLOCADA
            
            
            
            jtMarca.setText(jtTablaVacunas.getValueAt(fila, 1).toString());
            jtNroSerie.setText(jtTablaVacunas.getValueAt(fila, 2).toString());
            jtNroSerie.setEditable(false); // Restrinjo su contenido para que NO sea editable
            //String dosis = (String) jtTablaVacunas.getValueAt(fila, 3);
            //double dosisSeleccionada = Double.parseDouble(dosis);
            jcbMedida.setSelectedItem(jtTablaVacunas.getValueAt(fila, 3));
            
        } else if (evt.getClickCount() == 1) {
            System.out.println("No hace nada :) porque hizo un solo click");
        }

    }//GEN-LAST:event_jtTablaVacunasMousePressed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        
       // JTable tabla = (JTable) 
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    /*
    Funcionalidades:
    
    
    - Botón eliminar: verifica de igual manera que el botón modificar. Agregar mensaje de confirmación de la operación,
    ya que la fila será eliminada de la tabla, no dada de baja.
    
        
    - En la fecha de vencimiento NO permitir colocar una fecha anterior mínimo, a un día posterior del día de la carga de datos
    
    */
    
    
    private void limpiarCampos(){
        jcbLaboratorio.removeAllItems(); 
        jtMarca.setText("");
        jtNroSerie.setText("");
        jcbMedida.removeAllItems(); 
        jdcVencimiento.setDate(null);
        jcbAplicada.setSelected(false);
    }
            
    private void cargarComboLaboratorios() {
        
        // Para el comboBox necesito los métodos de laboratorioData
        labData = new LaboratorioData();        
        // Llamo a la lista de laboratorios               
        ListaLaboratorios = labData.listarLaboratorios();
                
        jcbLaboratorio.addItem(null);
                
        for (Laboratorio item : ListaLaboratorios) {
            jcbLaboratorio.addItem(item); 
        }        
    }

    private void cargarComboDosis(){
        modeloComboDosis = (DefaultComboBoxModel) jcbMedida.getModel();
        
        modeloComboDosis.addElement(null);
        modeloComboDosis.addElement("0.3");
        modeloComboDosis.addElement("0.5");
        modeloComboDosis.addElement("0.9");
        
        jcbMedida.setModel(modeloComboDosis);
        jcbMedida.repaint();
    }
        
    private Laboratorio laboratorioSeleccionado() {
        
        if (jcbLaboratorio.getSelectedItem() != null) {
            lab = (Laboratorio) jcbLaboratorio.getSelectedItem();
            //nombre = (String) lab.getNomLaboratorio();
        } else{
            lab = null;
        }
        //return nombre;
        return lab;
        
        // Según yo, a partir de acá puedo acceder a todos los métodos de laboratorio
        // No tengo certezas pero tampoco dudas
    }
    
    private void cargarListaVacunas() { // CARGO LA TABLA

        ListaVacunas = (ArrayList) vacunaData.listarVacunas();
                
        for (Vacuna i : ListaVacunas) {
            tablaVacunas.addRow(new Object[]{i.getLaboratorio().getNomLaboratorio(), i.getMarca(), i.getNroSerie(), i.getMedida(), i.getFechaCaduca(), i.isColocada()});
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JCheckBox jcbAplicada;
    private javax.swing.JComboBox<Laboratorio> jcbLaboratorio;
    private javax.swing.JComboBox<String> jcbMedida;
    private com.toedter.calendar.JDateChooser jdcVencimiento;
    private javax.swing.JTextField jtMarca;
    private javax.swing.JTextField jtNroSerie;
    private javax.swing.JTable jtTablaVacunas;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


    

    

    




}
