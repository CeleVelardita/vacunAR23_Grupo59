
package Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vacunar23_AccesoADatos.Conexion.CiudadanoData;
import vacunar23_Entidades.Ciudadano;

public class CiudadanoView extends javax.swing.JInternalFrame {

    private DefaultTableModel tablaCiu;
    private Ciudadano ciudadanoActual;
    private CiudadanoData ciuData;
    private DefaultComboBoxModel<String> modeloComboAmbitoLab;
    private DefaultComboBoxModel<String> modeloComboDominioEmail;
   
    private List<Ciudadano> ListaCiudadano;
    
    private int filaSeleccionada;
    
    public CiudadanoView() {
        initComponents();
        ciuData = new CiudadanoData();
        ciudadanoActual = null;

        tablaCiu = (DefaultTableModel) jtTablaCiudadano.getModel();

        jcbAmbitoLab.setSelectedItem(null);
        jcbDominioMail.setSelectedItem(null);
        
        jtRefuerzo.setEditable(false);
        jtTipoPatologia.setEditable(false);
        
        cargarComboLaboral();
        
        cargarComboDominioMail();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaCiudadano = new javax.swing.JTable();
        jtRefuerzo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbAmbitoLab = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtTipoPatologia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbPatologia = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jtNomApellido = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtDistrito = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbDominioMail = new javax.swing.JComboBox<>();
        jtCelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Base de Datos: Ciudadano");
        setPreferredSize(new java.awt.Dimension(800, 700));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar Según DNI");
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

        jtTablaCiudadano.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre y Apellido", "Ámbito Laboral", "Patología", "Código Refuerzo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        if (jtTablaCiudadano.getColumnModel().getColumnCount() > 0) {
            jtTablaCiudadano.getColumnModel().getColumn(0).setResizable(false);
            jtTablaCiudadano.getColumnModel().getColumn(2).setResizable(false);
            jtTablaCiudadano.getColumnModel().getColumn(3).setResizable(false);
            jtTablaCiudadano.getColumnModel().getColumn(4).setResizable(false);
        }

        jtRefuerzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtRefuerzoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cod. Refuerzo:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ámbito Laboral:");

        jtTipoPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTipoPatologiaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("¿De qué tipo?");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Patología de base:");

        jcbPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPatologiaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre y Apellido:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("DNI:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Distrito de Residencia:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("E-mail:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nro. Celular:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Carga de Datos del Ciudadano");

        jbBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtNomApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbPatologia)
                                    .addComponent(jcbAmbitoLab, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbBuscar)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbDominioMail, 0, 109, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbEliminar))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jbAgregar)
                        .addGap(34, 34, 34)
                        .addComponent(jbModificar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtTipoPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcbAmbitoLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNomApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbDominioMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPatologia)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtTipoPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jtRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /// --------------- BOTÓN AGREGAR ---------------
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        int dniExistente = 0;
        int refuerzo = 0;        
        try {
            dniExistente = Integer.parseInt(jtDni.getText());
            if (dniExistente != 0) {
                int dni = Integer.parseInt(jtDni.getText());
                String nomApellido = jtNomApellido.getText();

                boolean patologia = jcbPatologia.isSelected();

                String tipoPatologia = null;
                if (patologia) {
                    tipoPatologia = jtTipoPatologia.getText();
                }

                String ambito = (String) jcbAmbitoLab.getSelectedItem();

                String celu = jtCelular.getText();
                int celular = Integer.parseInt(celu);

                String email = jtEmail.getText();
                String arrobaEmail = (String) jcbDominioMail.getSelectedItem();
                String emailCompleto = email + arrobaEmail;
                String distrito = jtDistrito.getText();
                jtRefuerzo.setEditable(false);

                if (dni == 0 || nomApellido == null || ambito == null || celular == 0 || emailCompleto == null || (patologia == true && tipoPatologia == null) || distrito == null) {
                    JOptionPane.showMessageDialog(this, "No pueden quedar campos vacíos");
                    return;
                } else {

                    /*----------------------------------------------*/
                    // Chequeo si el dni no existe en la BD
                    ciudadanoActual = ciuData.buscarCiudadano(dni);

                    if (ciudadanoActual != null) {
                        dniExistente = ciudadanoActual.getDni();
                        if (dni == dniExistente) {
                            JOptionPane.showMessageDialog(this, "Ya existe un paciente con el dni ingresado");
                        }
                    }

                    /*----------------------------------------------*/
                    if (ciudadanoActual == null && dni != dniExistente) {
                        ciudadanoActual = new Ciudadano(dni, nomApellido, emailCompleto, celu, tipoPatologia, ambito, distrito, refuerzo);
                        ciuData.guardarCiudadano(ciudadanoActual);
                        limpiarCampos();
                        tablaCiu.addRow(new Object[]{ciudadanoActual.getDni(), ciudadanoActual.getNombreCompleto(), ciudadanoActual.getPatologia(), ciudadanoActual.getAmbitoTrabajo()});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor ingrese");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Los campos 'DNI', 'Celular' y 'Cod. Refuerzo' deben contener númeeros enteros, sin puntos ni comas");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error al ingresar datos en los campos de texto");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Error al acceder a la base de datos de Ciudadano");
        }


    }//GEN-LAST:event_jbAgregarActionPerformed

    /// --------------- BOTÓN MODIFICAR ---------------
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // Busca al Ciudadano por el DNI ingresado y setea los campos, permitiendo modificaciones en todos
        // los campos, incluso en el código de refuerzo
        
        if (jtDni.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un DNI");
        } else {
            try {
                int dni = Integer.parseInt(jtDni.getText());
                ciudadanoActual = ciuData.buscarCiudadano(dni);
                if (ciudadanoActual != null) {
                    jtNomApellido.setText(ciudadanoActual.getNombreCompleto());

                    if (ciudadanoActual.getPatologia() != null) {
                        jcbPatologia.setSelected(true);
                        jtRefuerzo.setText(ciudadanoActual.getPatologia());
                    }

                    // SETEAR COMBO ÁMBITO LABORAL
                    jcbAmbitoLab.setSelectedItem(ciudadanoActual);

                    jtCelular.setText(ciudadanoActual.getCelular());

                    // Recupero el email completo y luego separo las partes necesarias para setear los campos por separado
                    String emailCompleto = ciudadanoActual.getEmail();
                    int indiceSeparador = emailCompleto.indexOf("@");
                    String email = emailCompleto.substring(0, indiceSeparador);
                    String dominioEmail = emailCompleto.substring(indiceSeparador);

                    // Ahora seteo los campos
                    jtEmail.setText(email);

                    // SETEAR EL DOMINIO DEL MAIL
                    jcbDominioMail.setSelectedItem(dominioEmail);

                    jtDistrito.setText(ciudadanoActual.getDistrito());
                    jtRefuerzo.setEditable(true);

                    // Luego de setear todos los campos, permite editar los mismos y se llama al método modificar
                    int dniExistente = 0;

                    dni = Integer.parseInt(jtDni.getText());
                    String nomApellido = jtNomApellido.getText();

                    boolean patologia = jcbPatologia.isSelected();

                    String tipoPatologia = null;
                    if (patologia) {
                        tipoPatologia = jtTipoPatologia.getText();
                    }

                    String ambito = (String) jcbAmbitoLab.getSelectedItem();

                    String celu = jtCelular.getText();
                    int celular = Integer.parseInt(celu);

                    email = jtEmail.getText();
                    String arrobaEmail = (String) jcbDominioMail.getSelectedItem();
                    emailCompleto = email + arrobaEmail;
                    String distrito = jtDistrito.getText();
                    int refuerzo = Integer.parseInt(jtRefuerzo.getText());

                    if (dni == 0 || nomApellido == null || ambito == null || celular == 0 || emailCompleto == null || (patologia == true && tipoPatologia == null) || distrito == null) {
                        JOptionPane.showMessageDialog(this, "No pueden quedar campos vacíos");
                        return;
                    } else {

                        /*----------------------------------------------*/
                        // Chequeo si el dni no existe en la BD
                        ciudadanoActual = ciuData.buscarCiudadano(dni);

                        if (ciudadanoActual != null) {
                            dniExistente = ciudadanoActual.getDni();
                            if (dni == dniExistente) {
                                JOptionPane.showMessageDialog(this, "Ya existe un paciente con el dni ingresado");
                            }
                        }

                        /*----------------------------------------------*/
                        if (ciudadanoActual == null && dni != dniExistente) {
                            ciudadanoActual = new Ciudadano(dni, nomApellido, emailCompleto, celu, tipoPatologia, ambito, distrito, refuerzo);
                            ciuData.modificarCiudadano(ciudadanoActual);
                            limpiarCampos();
                            tablaCiu.addRow(new Object[]{ciudadanoActual.getDni(), ciudadanoActual.getNombreCompleto(), ciudadanoActual.getPatologia(), ciudadanoActual.getAmbitoTrabajo()});
                        }
                    }
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Los campos 'DNI', 'Celular' y 'Cod. Refuerzo' deben contener númeeros enteros, sin puntos ni comas");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Error al ingresar datos en los campos de texto");
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Error al acceder a la base de datos de Ciudadano");
            }
        }


    }//GEN-LAST:event_jbModificarActionPerformed

    /// --------------- BOTÓN ELIMINAR ---------------
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        
       filaSeleccionada = jtTablaCiudadano.getSelectedRow();
        
        if(filaSeleccionada != -1){
            String valor = jtTablaCiudadano.getValueAt(filaSeleccionada, 0).toString();
            int dni = Integer.parseInt(valor);
            ciuData.eliminarCiudadano(dni);
            
            tablaCiu.removeRow(filaSeleccionada);
        } else{
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtRefuerzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtRefuerzoActionPerformed
                
         int dni = Integer.parseInt(jtDni.getText());
        Ciudadano ciuEncontrado = ciuData.buscarCiudadano(dni);
        
        if (ciuEncontrado != null) {
            jtRefuerzo.setEditable(true);
        }
    }//GEN-LAST:event_jtRefuerzoActionPerformed

    
    private void jtTipoPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTipoPatologiaActionPerformed
        // Restrinjo la posibilidad de escribir, si selecciona falso en la patología, no podrá
        // ingresar una patología        
        
        if (!jcbPatologia.isSelected()) {
                jtTipoPatologia.setEditable(false);
            } else {
                jtTipoPatologia.setEditable(true);
            }
    }//GEN-LAST:event_jtTipoPatologiaActionPerformed
    
    
    /// Si se marca como "verdadero" en patología, se habilita el campo para el tipo de patología
    private void jcbPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPatologiaActionPerformed
        if (jcbPatologia.isSelected()) {
            jtTipoPatologia.setEditable(true);
        }else{
            jtTipoPatologia.setEditable(false);
        }
    }//GEN-LAST:event_jcbPatologiaActionPerformed


    public void cargarComboLaboral(){
        modeloComboAmbitoLab = (DefaultComboBoxModel<String>) jcbAmbitoLab.getModel();
        
        modeloComboAmbitoLab.addElement(null);
        modeloComboAmbitoLab.addElement("Salud");
        modeloComboAmbitoLab.addElement("Educación");
        modeloComboAmbitoLab.addElement("Seguridad");
        modeloComboAmbitoLab.addElement("Atención al Público");
        modeloComboAmbitoLab.addElement("Otros");
        
        jcbAmbitoLab.setModel((modeloComboAmbitoLab));
        jcbAmbitoLab.repaint();                
    }
    
    public void cargarComboDominioMail(){
        modeloComboDominioEmail = (DefaultComboBoxModel<String>) jcbDominioMail.getModel();
        
        modeloComboDominioEmail.addElement(null);
        modeloComboDominioEmail.addElement("@gmail.com");
        modeloComboDominioEmail.addElement("@hotmail.com");
        modeloComboDominioEmail.addElement("@outlook.com");
        modeloComboDominioEmail.addElement("@yahoo.com");
        
        jcbDominioMail.setModel(modeloComboDominioEmail);
        jcbDominioMail.repaint();        
    }
    
    public void cargarListaCiudadanos(){
        ListaCiudadano = (ArrayList<Ciudadano>) ciuData.listarCiudadanos();
        
        for(Ciudadano i: ListaCiudadano){
            tablaCiu.addRow(new Object[]{i.getDni(), i.getNombreCompleto(), i.getAmbitoTrabajo(), i.getPatologia(), i.getCodRefuerzo()});
        }
    }
        
    public void limpiarCampos(){
        jtDni.setText("");
        jtNomApellido.setText("");
        jcbPatologia.setSelected(false);
        jtTipoPatologia.setEditable(false);
        jcbAmbitoLab.setSelectedItem(null);
        jtCelular.setText("");
        jtEmail.setText("");
        jtDistrito.setText("");
        jtRefuerzo.setEditable(false);
    }
    
    public void setearComboAmbito(int dni){
        /*
        // Recupero el ciudadano correspondiente al dni ingresado y luego busco el ámbito laboral
        ciudadanoActual = ciuData.buscarCiudadano(dni);
        // Casteo el combo a un DefaultComboBoxModel para poder acceder a todos los métodos del jComboBox
        modeloComboAmbitoLab = (DefaultComboBoxModel<String>) jcbAmbitoLab.getModel();
        // Recupero la cantidad de objetos que tiene mi combo para recorrer cada uno mediante un if
        int elementos = modeloComboAmbitoLab.getSize();
        
        for (int i = 0; i < elementos; i++) {
            // Instancio un objeto de tipo Ciudadano donde voy a guardar para elemento del combo para comparar
            Ciudadano ciu = modeloComboAmbitoLab.getElementAt(i);
            // Hago una comparación entre el objeto que tiene el combo y el de la BD
            
        }
*/
        
        // Recupero el ciudadano correspondiente al dni ingresado y luego busco el ámbito laboral
        ciudadanoActual = ciuData.buscarCiudadano(dni);
        
        boolean estaEnCombo = false;
        
        for(int i = 0; i < modeloComboAmbitoLab.getSize(); i++){
            // Guardo en un objeto el elemento del combo
            if(i > 0){
                Object elementoCombo = modeloComboAmbitoLab.getElementAt(i);
                if (elementoCombo.toString().equals(ciudadanoActual.getAmbitoTrabajo())) {
                    estaEnCombo = true;
                    modeloComboAmbitoLab.setSelectedItem(elementoCombo);
                    break;
                }
            }
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<String> jcbAmbitoLab;
    private javax.swing.JComboBox<String> jcbDominioMail;
    private javax.swing.JCheckBox jcbPatologia;
    private javax.swing.JTextField jtCelular;
    private javax.swing.JTextField jtDistrito;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtNomApellido;
    private javax.swing.JTextField jtRefuerzo;
    private javax.swing.JTable jtTablaCiudadano;
    private javax.swing.JTextField jtTipoPatologia;
    // End of variables declaration//GEN-END:variables
}
