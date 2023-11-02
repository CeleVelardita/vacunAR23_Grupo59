
package Vistas;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
    
    private DefaultComboBoxModel<String> modeloComboDosis; // Lo necesito para agregarle elementos al comboDosis
    private DefaultComboBoxModel<Laboratorio> modeloComboLaboratorios;    
    
    private DefaultTableModel tablaVacunas;
     
    private List<Vacuna> ListaVacunas; // Lo voy a necesitar para llenar la tabla
    private List<Laboratorio> ListaLaboratorios; // Lo voy a necesitar para el comboBox de laboratorios
 
    private Double dosisSeleccionada = 0.0;
    private LocalDate fechaCaducidad = null;
    
    private String nombreLabTabla;
    
    private int filaSeleccionada;
    
    public VacunasView() {
        initComponents();
        
        //Le cambio el colorcito al JInternalFrame sin necesidad de usar un JPanel 
        getContentPane().setBackground(new Color(240, 255, 240));
       
        vacunaData = new VacunaData();
        vacunaActual = new Vacuna();
        vacunaActual = null;  
                             
        tablaVacunas = (DefaultTableModel) jtTablaVacunas.getModel();
        
        cargarListaVacunas();
        
        cargarComboLaboratorios();
        
        cargarComboDosis(); 
        
        jcbMedida.setSelectedItem(null);
       
        jdcVencimiento.setDate(null);
        
        // Configuro para que el campo del calendario no sea editable
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jdcVencimiento.getDateEditor();
        editor.setEditable(false);
        // Otra posibilidad para hacer lo de arriba...
        // ((JTextFieldDateEditor) jDCFechaDeNacimiento.getDateEditor()).setEditable(false);
        
        
        // Seteo la restricción para la elección de las fechas, tiene que tener un mínimo
        // de 2 meses a la fecha del día de carga de datos
        Calendar diaMinimo = Calendar.getInstance();
        diaMinimo.add(Calendar.MONTH, 2); // Se calcula la fecha mínima permitida
        long diaLimite = diaMinimo.getTimeInMillis();
        
        jdcVencimiento.setMinSelectableDate(new Date(diaLimite)); // Se establece la fecha mínima permitida en el jDateChooser
        
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
        jbLimpiarCampos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administración de Vacunas");
        setPreferredSize(new java.awt.Dimension(700, 600));

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
                false, false, false, false, false, false
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

        jtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtMarcaKeyTyped(evt);
            }
        });

        jtNroSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNroSerieKeyTyped(evt);
            }
        });

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

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jcbLaboratorio, org.jdesktop.beansbinding.ObjectProperty.create(), jcbLaboratorio, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel6.setText("APLICADA:");

        jbLimpiarCampos.setText("Limpiar Campos");
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbLaboratorio, 0, 393, Short.MAX_VALUE)
                            .addComponent(jtMarca))
                        .addContainerGap(150, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbLimpiarCampos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcbAplicada)
                                            .addComponent(jtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jdcVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jbAgregar)
                                                .addGap(72, 72, 72)
                                                .addComponent(jbModificar)
                                                .addGap(90, 90, 90)
                                                .addComponent(jbEliminar)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLimpiarCampos))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jdcVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbAplicada, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /// ---------- BOTÓN INSERTAR ----------
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        int nroExistente = 0;
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
                vacunaActual = vacunaData.buscarPorNroSerie(nroSerie);
                
                if (vacunaActual != null) {
                    nroExistente = vacunaActual.getNroSerie();
                    System.out.println(nroExistente);
                    if (nroSerie == nroExistente) { // si no está nulo, es porque ya está cargada una vacuna con el mismo número de serie
                        JOptionPane.showMessageDialog(this, "Ya existe una vacuna con el número de serie ingresado.");
                        //limpiarCampos();
                    }
                }
                
                /*-----------------------------------------*/
                

                if (vacunaActual == null && (nroExistente != nroSerie)) {
                    vacunaActual = new Vacuna(nroSerie, marca, dosisSeleccionada, fechaCaducidad, aplicada, lab);                    
                    vacunaData.cargarVacuna(vacunaActual);                              
                    limpiarCampos();
                    tablaVacunas.addRow(new Object[]{vacunaActual.getLaboratorio().getNomLaboratorio(), vacunaActual.getMarca(), vacunaActual.getNroSerie(), vacunaActual.getMedida(), vacunaActual.getFechaCaduca(), vacunaActual.isColocada()});
                } 
            }

        } catch (NumberFormatException e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(this, "El campo 'Nro. Serie' está vacío o contiene carácteres inválidos "+e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Los campos 'Laboratorio' y 'Marca' no son válidos");
        }  catch(NullPointerException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getLocalizedMessage());
            System.out.println(ex.getStackTrace());
        }           
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    
    /// ---------- BOTÓN MODIFICAR ----------
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        
        filaSeleccionada = jtTablaVacunas.getSelectedRow();

        if (filaSeleccionada != -1) {
            
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
                if (lab == null || marca.isEmpty() || dosisSeleccionada == 0.0 || fechaCaducidad == null) {
                    JOptionPane.showMessageDialog(this, "No pueden haber campos vacíos");
                    return;
                } else {
                    vacunaActual = vacunaData.buscarPorNroSerie(nroSerie);
                    
                    vacunaActual.setNroSerie(nroSerie);
                    vacunaActual.setMarca(marca);
                    System.out.println(nroSerie);
                    vacunaActual.setMedida(dosisSeleccionada);
                    vacunaActual.setFechaCaduca(fechaCaducidad);
                    vacunaActual.setColocada(aplicada);
                    vacunaActual.setLaboratorio(lab);
                    
                    vacunaData.modificarVacuna(vacunaActual);
                    limpiarCampos();                    
                    actualizarFilaTabla(filaSeleccionada, vacunaActual);
                    jtNroSerie.setEditable(true);
                    
                }
            } catch (NumberFormatException e) {
                e.getStackTrace();
                JOptionPane.showMessageDialog(this, "Por favor seleccione una fila haciendo doble click");
                //JOptionPane.showMessageDialog(this, "El campo 'Nro. Serie' está vacío o contiene carácteres inválidos " + e.getMessage());
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Los campos 'Laboratorio' y 'Marca' no son válidos");
            }
        } else {
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
        Esta línea obtiene la fuente del evento llamado evt (por defecto al crear el evento de tipo "MousePressed").
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
            
            setearComboLab(fila);
            
            jtMarca.setText(jtTablaVacunas.getValueAt(fila, 1).toString());
            jtNroSerie.setText(jtTablaVacunas.getValueAt(fila, 2).toString());
            jtNroSerie.setEditable(false); // Restrinjo su contenido para que NO sea editable
            
            setearComboDosis(fila);
            
            LocalDate fecha = (LocalDate) jtTablaVacunas.getValueAt(fila, 4);
            jdcVencimiento.setDate(Date.valueOf(fecha));
            
            Boolean aplicacion = (Boolean) jtTablaVacunas.getValueAt(fila, 5);
            jcbAplicada.setSelected(aplicacion);
                        
            
        } else if (evt.getClickCount() == 1) {
            System.out.println("No hace nada :) porque hizo un solo click");
        }

    }//GEN-LAST:event_jtTablaVacunasMousePressed

    
    ///----------- BOTÓN ELIMINAR -----------
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        
        filaSeleccionada = jtTablaVacunas.getSelectedRow();
        
        if(filaSeleccionada != -1){
            String valor = jtTablaVacunas.getValueAt(filaSeleccionada, 2).toString();
            int numSerie = Integer.parseInt(valor);
            vacunaData.eliminarVacuna(numSerie); 
            
            // Elimino una fila de la tabla
            tablaVacunas.removeRow(filaSeleccionada);
        }     
    }//GEN-LAST:event_jbEliminarActionPerformed


    /*------------------------------------- RESTRICCIONES ----------------------------------------*/
    
    private void jtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMarcaKeyTyped
        // Condición para que no ingrese más de 30 carácteres
        char letra = evt.getKeyChar();
        if (!Character.isLetter(letra) && letra != KeyEvent.VK_BACK_SPACE && letra != KeyEvent.VK_SPACE || jtMarca.getText().length() >= 30) {
            // Rechaza el carácter si no es un dígito o un retroceso
            evt.consume();
        }
    }//GEN-LAST:event_jtMarcaKeyTyped
    
    private void jtNroSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNroSerieKeyTyped
        // Condición para que no ingrese otra cosa más que un número
        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra) && letra != KeyEvent.VK_BACK_SPACE || jtNroSerie.getText().length() >= 8) {
            // Rechaza el carácter si no es un dígito o un retroceso
            evt.consume();
        }
    }//GEN-LAST:event_jtNroSerieKeyTyped
        
    /*--------------------------------------------------------------------------------------------*/
    
    
    /// ---------- BOTÓN LIMPIAR CAMPOS ----------
    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbLimpiarCamposActionPerformed

     
    
    /*---------------------------------------- MÉTODOS -------------------------------------------*/
    
    private void limpiarCampos(){
        jcbLaboratorio.setSelectedItem(null); 
        jtMarca.setText("");
        jtNroSerie.setText("");
        jcbMedida.setSelectedItem(null); 
        jdcVencimiento.setDate(null);
        jcbAplicada.setSelected(false);
    }
            
    private void cargarComboLaboratorios() {
        //modeloComboLaboratorios = (DefaultComboBoxModel) jcbLaboratorio.getModel();
       
        
        // Para el comboBox necesito los métodos de laboratorioData
        labData = new LaboratorioData();        
        // Llamo a la lista de laboratorios               
        ListaLaboratorios = labData.listarLaboratorios();
                
        jcbLaboratorio.addItem(null);
        
        for (Laboratorio item : ListaLaboratorios) {
            jcbLaboratorio.addItem(item); 
            //modeloComboLaboratorios.addElement(item);
        }        
    }

    private void cargarComboDosis(){
        modeloComboDosis = (DefaultComboBoxModel<String>) jcbMedida.getModel();
        
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
        } else{
            lab = null;
        }
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
    
    private void setearComboLab(int fila) {
        // Recupero el nombre del laboratorio de la fila que seleccioné y lo guardo en una variable
        nombreLabTabla = jtTablaVacunas.getValueAt(fila, 0).toString();
        // Envío ese nombre a labData para obtener el Laboratorio al que pertenece y lo guardo en una variable de tipo Laboratorio
        lab = labData.buscarLaboratorioXNombre(nombreLabTabla);
        // Casteo mi combo a un DefaultComboBoxModel para poder acceder a todos los método del jComboBox
        modeloComboLaboratorios = (DefaultComboBoxModel<Laboratorio>) jcbLaboratorio.getModel();
        // Recupero la cantidad de objetos que tiene mi combo para recorer uno por uno mediante un for
        int elementos = modeloComboLaboratorios.getSize();

        // System.out.println(elementos);

        for (int i = 0; i < elementos; i++) {
            // instancio un objeto de tipo Laboratorio donde voy a guardar cada elemento del combo para comparar
            Laboratorio laboratorio = modeloComboLaboratorios.getElementAt(i);
            // Hago una comparación entre el objeto que tiene el combo y el objeto de la tabla
            if (lab.equals(laboratorio)) {
                // Si su contenido es el mismo, entonces el combo es seteado con ese objeto
                jcbLaboratorio.setSelectedItem(lab);
                break;
            }
        }
        
        /*------------------------------------------------------------------
                                  IMPORTANTE
        
        NO olvidar que para el contenido de dos OBJETOS se debe implementar
        el método .equals();
        
        --------------------------------------------------------------------*/
        
    }
    
    private void setearComboDosis(int fila){
        
        Object valorSeleccionado = tablaVacunas.getValueAt(fila, 3);
        
        boolean estaEnComboBox = false;
        
        for (int i = 0; i < modeloComboDosis.getSize(); i++) {
            // Guardo en un objeto el elemento del combo
            if (i > 0) {
               Object elementoCombo = modeloComboDosis.getElementAt(i);
            if(elementoCombo.toString().equals(valorSeleccionado.toString())){
                estaEnComboBox = true;
                modeloComboDosis.setSelectedItem(elementoCombo);
                break;
            } 
            }            
        }       
    }

    public void actualizarFilaTabla(int filaSeleccionada, Vacuna vacuna){
        tablaVacunas.setValueAt(vacuna.getLaboratorio().getNomLaboratorio(),filaSeleccionada, 0);
        tablaVacunas.setValueAt(vacuna.getMarca(), filaSeleccionada, 1);
        tablaVacunas.setValueAt(vacuna.getNroSerie(), filaSeleccionada, 2);
        tablaVacunas.setValueAt(vacuna.getMedida(), filaSeleccionada, 3);
        tablaVacunas.setValueAt(vacuna.getFechaCaduca(), filaSeleccionada, 4);
        tablaVacunas.setValueAt(vacuna.isColocada(), filaSeleccionada, 5);        
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
    private javax.swing.JButton jbLimpiarCampos;
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
