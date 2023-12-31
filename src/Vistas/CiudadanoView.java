package Vistas;

import java.awt.Color;
import java.awt.event.KeyEvent;
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
    private Ciudadano ciu;
    private CiudadanoData ciuData;
    private DefaultComboBoxModel<String> modeloComboAmbitoLab;
    private DefaultComboBoxModel<String> modeloComboDominioEmail;
    private DefaultComboBoxModel<String> modeloComboDistrito;
    
    private List<Ciudadano> ListaCiudadano;

    private int filaSeleccionada;

    public CiudadanoView() {
        initComponents();
        
        getContentPane().setBackground(new Color(240, 255, 240));
        
        ciu = new Ciudadano();
        ciu = null;
        ciuData = new CiudadanoData();
        ciudadanoActual = new Ciudadano();
        ciudadanoActual = null;

        tablaCiu = (DefaultTableModel) jtTablaCiudadano.getModel();

        jcbAmbitoLab.setSelectedItem(null);
        jcbDominioMail.setSelectedItem(null);

        jtRefuerzo.setEditable(false);
        jtTipoPatologia.setEditable(false);

        cargarComboLaboral();

        cargarComboDominioMail();
        
        //cargarComboDistrito();

        cargarListaCiudadanos();

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
        jLabel2 = new javax.swing.JLabel();
        jtDistrito = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbDominioMail = new javax.swing.JComboBox<>();
        jtCelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtNomApellido = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Base de Datos: Ciudadano");
        setPreferredSize(new java.awt.Dimension(750, 700));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 720));

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
                "DNI", "Nombre y Apellido", "Patología", "Ámbito Laboral", "Código Refuerzo"
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

        jtRefuerzo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtRefuerzoKeyTyped(evt);
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
        jtTipoPatologia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtTipoPatologiaKeyTyped(evt);
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

        jtDistrito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDistritoKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Distrito de Residencia:");

        jtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtEmailKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("E-mail:");

        jtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCelularKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nro. Celular:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Carga de Datos del Ciudadano");

        jtNomApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNomApellidoKeyTyped(evt);
            }
        });

        jtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDniKeyTyped(evt);
            }
        });

        jbBuscar.setText("Buscar por DNI");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar Campos");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                            .addComponent(jcbPatologia)
                            .addComponent(jcbAmbitoLab, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNomApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbBuscar)
                        .addGap(35, 35, 35)
                        .addComponent(jbModificar)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)
                        .addComponent(jLabel10)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jbAgregar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbDominioMail, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbLimpiar)
                        .addGap(36, 36, 36)
                        .addComponent(jbEliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
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
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbDominioMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNomApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(28, 91, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jbBuscar)
                    .addComponent(jbModificar)
                    .addComponent(jbAgregar)
                    .addComponent(jbLimpiar))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /// --------------- BOTÓN AGREGAR ---------------
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        int refuerzo = 0;
        String tipoPatologia = null;
        try {
            if (jtDni.getText() == null || jtNomApellido.getText() == null || jcbAmbitoLab.getSelectedItem() == null || jtCelular.getText() == null || jtEmail.getText() == null || jcbDominioMail.getSelectedItem() == null || (jcbPatologia.isSelected() == true && jtTipoPatologia.getText() == null) || jtDistrito.getText() == null) {
                JOptionPane.showMessageDialog(this, "No pueden quedar campos vacíos");
                return;
            } else {
                int dni = Integer.parseInt(jtDni.getText());
                String nomApellido = jtNomApellido.getText();

                boolean patologia = jcbPatologia.isSelected();

                if (patologia) {
                    tipoPatologia = jtTipoPatologia.getText();
                } else {
                    tipoPatologia = "Ninguna";
                }

                String ambito = (String) jcbAmbitoLab.getSelectedItem();

                String celu = jtCelular.getText();
                long celular = Long.parseLong(celu);

                String email = jtEmail.getText();
                String arrobaEmail = (String) jcbDominioMail.getSelectedItem();
                String emailCompleto = email + arrobaEmail;

                //String distrito = (String) jcbDistrito.getSelectedItem();
                String distrito = jtDistrito.getText();
                jtRefuerzo.setEditable(false);

                ciudadanoActual = new Ciudadano(dni, nomApellido, emailCompleto, celu, tipoPatologia, ambito, distrito, refuerzo);

                /*----------------------------------------------*/
                // Chequeo si el dni no existe en la BD
                ciu = ciuData.buscarCiudadano(dni);

                if (ciu != null) {
                    JOptionPane.showMessageDialog(this, "Ya existe un paciente con el dni ingresado");
                    return;
                }
                /*----------------------------------------------*/

                if (ciu == null) {
                    System.out.println("linea 363");
                    ciuData.guardarCiudadano(ciudadanoActual);
                    limpiarCampos();
                    tablaCiu.addRow(new Object[]{ciudadanoActual.getDni(), ciudadanoActual.getNombreCompleto(), ciudadanoActual.getPatologia(), ciudadanoActual.getAmbitoTrabajo(), ciudadanoActual.getCodRefuerzo()});
                }

            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Los campos 'DNI', 'Celular' y 'Cod. Refuerzo' deben contener númeeros enteros, sin puntos ni comas");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error al ingresar datos en los campos de texto");
        } catch (NullPointerException ex) {
            System.out.println("linea 375");
            JOptionPane.showMessageDialog(this, "Error al acceder a la base de datos de Ciudadano");
        }

    }//GEN-LAST:event_jbAgregarActionPerformed

    /// --------------- BOTÓN MODIFICAR ---------------
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        String tipoPatologia = null;
        jtRefuerzo.setEditable(false);
        try {
            if (jtDni.getText() == null || jtNomApellido.getText() == null || jcbAmbitoLab.getSelectedItem() == null || jtCelular.getText() == null || jtEmail.getText() == null || jcbDominioMail.getSelectedItem() == null || (jcbPatologia.isSelected() == true && jtTipoPatologia.getText() == null) || jtDistrito.getText() == null) {
                JOptionPane.showMessageDialog(this, "No pueden quedar campos vacíos");
                return;
            } else {
                int dni = Integer.parseInt(jtDni.getText());
                String nomApellido = jtNomApellido.getText();

                boolean patologia = jcbPatologia.isSelected();

                if (patologia) {
                    tipoPatologia = jtTipoPatologia.getText();
                } else {
                    tipoPatologia = "Ninguna";
                }

                String ambito = (String) jcbAmbitoLab.getSelectedItem();

                String celu = jtCelular.getText();
                long celular = Long.parseLong(celu);

                String email = jtEmail.getText();
                String arrobaEmail = (String) jcbDominioMail.getSelectedItem();
                String emailCompleto = email + arrobaEmail;

                //String distrito = (String) jcbDistrito.getSelectedItem();
                String distrito = jtDistrito.getText();
                int refuerzo = Integer.parseInt(jtRefuerzo.getText());
                
                ciudadanoActual = new Ciudadano(dni, nomApellido, emailCompleto, celu, tipoPatologia, ambito, distrito, refuerzo);

                ciuData.modificarCiudadano(ciudadanoActual);
                limpiarCampos();
                tablaCiu.addRow(new Object[]{ciudadanoActual.getDni(), ciudadanoActual.getNombreCompleto(), ciudadanoActual.getPatologia(), ciudadanoActual.getAmbitoTrabajo(), ciudadanoActual.getCodRefuerzo()});
                
                
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Los campos 'DNI', 'Celular' y 'Cod. Refuerzo' deben contener númeeros enteros, sin puntos ni comas");
            System.out.println(ex.getLocalizedMessage());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error al ingresar datos en los campos de texto");
        } catch (NullPointerException ex) {
            System.out.println("linea 375");
            JOptionPane.showMessageDialog(this, "Error al acceder a la base de datos de Ciudadano");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /// --------------- BOTÓN ELIMINAR ---------------
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed

        filaSeleccionada = jtTablaCiudadano.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valor = jtTablaCiudadano.getValueAt(filaSeleccionada, 0).toString();
            int dni = Integer.parseInt(valor);
            ciuData.eliminarCiudadano(dni);

            tablaCiu.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed


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
        } else {
            jtTipoPatologia.setEditable(false);
        }
    }//GEN-LAST:event_jcbPatologiaActionPerformed

    /// --------------- BOTÓN BUSCAR POR DNI ---------------
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // Busca al Ciudadano por el DNI ingresado y setea los campos, permitiendo modificaciones en todos
        // los campos, incluso en el código de refuerzo
        try {
            if (jtDni.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un DNI");
                return;
            } else {

                int dni = Integer.parseInt(jtDni.getText());
                ciudadanoActual = ciuData.buscarCiudadano(dni);

                if (ciudadanoActual != null) {
                    // RECUPERO LOS DATOS Y SETEO LOS CAMPOS
                    String nombre = ciudadanoActual.getNombreCompleto();
                    String patologia = ciudadanoActual.getPatologia();
                    if (patologia.equals("Ninguna")) {
                        jcbPatologia.setSelected(false);
                    } else {
                        jcbPatologia.setSelected(true);
                        jtTipoPatologia.setEditable(true);
                    }
                    String ambito = ciudadanoActual.getAmbitoTrabajo();
                    String celu = ciudadanoActual.getCelular();

                    // Recupero el email completo y luego separo las partes necesarias para setear los campos por separado
                    String emailCompleto = ciudadanoActual.getEmail();
                    int indiceSeparador = emailCompleto.indexOf("@");
                    String email = emailCompleto.substring(0, indiceSeparador);
                    String dominioEmail = emailCompleto.substring(indiceSeparador);

                    
                    String distrito = ciudadanoActual.getDistrito();
                    int refuerzo = ciudadanoActual.getCodRefuerzo();
                    String codigo = String.valueOf(refuerzo);

                    // Una vez recuperados todos los datos empiezo a setear los campos
                    jtNomApellido.setText(nombre);
                    jtTipoPatologia.setText(patologia);

                    setearComboAmbito(dni);

                    jtCelular.setText(celu);

                    // Ahora seteo los campos por separado
                    jtEmail.setText(email);

                    // SETEAR EL DOMINIO DEL MAIL
                    //setearComboDominioEmail(dni);
                    jcbDominioMail.setSelectedItem(dominioEmail);

                    // SETEAR EL DISTRITO
                    //setearComboDistrito(dni);                    
                    jtDistrito.setText(distrito);

                    jtRefuerzo.setText(codigo);

                } else {
                    JOptionPane.showMessageDialog(this, "No se ha encontrado el paciente en la Base de Datos");
                }

            }
        } catch(NumberFormatException ex){
            
        } catch(NullPointerException ex){
            
        }

    }//GEN-LAST:event_jbBuscarActionPerformed

    
    
    /*-------------------------- RESTRICCIONES --------------------------*/
    
    private void jtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyTyped
        char letra=evt.getKeyChar();
        if (!Character.isDigit(letra) && letra != KeyEvent.VK_BACK_SPACE || jtDni.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_jtDniKeyTyped

    private void jtNomApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomApellidoKeyTyped
        char letra=evt.getKeyChar();
        if (!Character.isLetter(letra) && letra != KeyEvent.VK_BACK_SPACE && letra != KeyEvent.VK_SPACE|| jtNomApellido.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jtNomApellidoKeyTyped

    private void jtTipoPatologiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTipoPatologiaKeyTyped
        char letra=evt.getKeyChar();
        if (!Character.isLetter(letra) && letra != KeyEvent.VK_BACK_SPACE && letra != KeyEvent.VK_SPACE|| jtTipoPatologia.getText().length() >= 30) {
             evt.consume();
        }
    }//GEN-LAST:event_jtTipoPatologiaKeyTyped

    private void jtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCelularKeyTyped
        char letra=evt.getKeyChar();
        if (!Character.isDigit(letra) && letra != KeyEvent.VK_BACK_SPACE || jtCelular.getText().length() >= 18) {
            evt.consume();
        }
    }//GEN-LAST:event_jtCelularKeyTyped

    private void jtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEmailKeyTyped
        char letra=evt.getKeyChar();
        if (letra != KeyEvent.VK_BACK_SPACE && (letra == '@') || jtEmail.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jtEmailKeyTyped

    private void jtDistritoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDistritoKeyTyped
        char letra=evt.getKeyChar();
        if (!Character.isLetter(letra) && letra != KeyEvent.VK_BACK_SPACE && letra != KeyEvent.VK_SPACE|| jtDistrito.getText().length() >= 12) {
            evt.consume();
        }
    }//GEN-LAST:event_jtDistritoKeyTyped

    private void jtRefuerzoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtRefuerzoKeyTyped
        char letra=evt.getKeyChar();
        if (!Character.isDigit(letra) && letra != KeyEvent.VK_BACK_SPACE || jtCelular.getText().length() >= 1) {
            evt.consume();
        }
    }//GEN-LAST:event_jtRefuerzoKeyTyped

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    /*---------------------------------------------------------------------*/
    
    
    
    public void cargarComboLaboral() {
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

    public void cargarComboDominioMail() {
        modeloComboDominioEmail = (DefaultComboBoxModel<String>) jcbDominioMail.getModel();

        modeloComboDominioEmail.addElement(null);
        modeloComboDominioEmail.addElement("@gmail.com");
        modeloComboDominioEmail.addElement("@hotmail.com");
        modeloComboDominioEmail.addElement("@outlook.com");
        modeloComboDominioEmail.addElement("@yahoo.com");

        jcbDominioMail.setModel(modeloComboDominioEmail);
        jcbDominioMail.repaint();
    }
    
    private void cargarComboDistrito(){
        //modeloComboDistrito = (DefaultComboBoxModel<String>) jcbDistrito.getModel();
        
        modeloComboDistrito.addElement(null);
        modeloComboDistrito.addElement("Zona Norte");
        modeloComboDistrito.addElement("Zona Sur");
        modeloComboDistrito.addElement("Zona Este");
        modeloComboDistrito.addElement("Zona Oeste");
    }

    public void cargarListaCiudadanos() {
        ListaCiudadano = (ArrayList<Ciudadano>) ciuData.listarCiudadanos();

        for (Ciudadano i : ListaCiudadano) {
            tablaCiu.addRow(new Object[]{i.getDni(), i.getNombreCompleto(), i.getPatologia(), i.getAmbitoTrabajo(), i.getCodRefuerzo()});
        }
    }

    public void limpiarCampos() {
        jtDni.setText("");
        jtNomApellido.setText("");
        jcbPatologia.setSelected(false);
        jtTipoPatologia.setEditable(false);
        jtTipoPatologia.setText("");
        jcbAmbitoLab.setSelectedItem(null);
        jtCelular.setText("");
        jtEmail.setText("");
        jcbDominioMail.setSelectedItem(null);
        jtDistrito.setText("");
        jtRefuerzo.setEditable(false);
        jtRefuerzo.setText("");
    }

    public void setearComboAmbito(int dni) {
      
        // Recupero el ciudadano correspondiente al dni ingresado y luego busco el ámbito laboral
        ciudadanoActual = ciuData.buscarCiudadano(dni);

        boolean estaEnCombo = false;

        for (int i = 0; i < modeloComboAmbitoLab.getSize(); i++) {
            // Guardo en un objeto el elemento del combo
            if (i > 0) {
                Object elementoCombo = modeloComboAmbitoLab.getElementAt(i);
                if (elementoCombo.toString().equals(ciudadanoActual.getAmbitoTrabajo())) {
                    estaEnCombo = true;
                    modeloComboAmbitoLab.setSelectedItem(elementoCombo);
                    break;
                }
            }
        }
    }
    
    public void setearComboDominioEmail(int dni) {
        ciudadanoActual = ciuData.buscarCiudadano(dni);

        boolean estaEnCombo = false;

        for (int i = 0; i < modeloComboDominioEmail.getSize(); i++) {
            // Guardo en un objeto el elemento del combo
            if (i > 0) {
                Object elementoCombo = modeloComboDominioEmail.getElementAt(i);
                String emailCompleto = ciudadanoActual.getEmail();
                int indiceSeparador = emailCompleto.indexOf("@");
                String email = emailCompleto.substring(0, indiceSeparador);
                String dominioEmail = emailCompleto.substring(indiceSeparador);
                if (elementoCombo.toString().equals(dominioEmail)) {
                    estaEnCombo = true;
                    modeloComboDominioEmail.setSelectedItem(elementoCombo);
                    break;
                }
            }
        }
    }

    public void setearComboDistrito(int dni) {
        ciudadanoActual = ciuData.buscarCiudadano(dni);
        
        boolean estaEnCombo = false;
        
        for (int i = 0; i < modeloComboDistrito.getSize(); i++) {
            // Guardo en un objeto el elemento del combo
            if (i > 0) {
                Object elementoCombo = modeloComboDistrito.getElementAt(i);
                
                if (elementoCombo.toString().equals(ciudadanoActual.getDistrito())) {
                    estaEnCombo = true;
                    modeloComboDistrito.setSelectedItem(elementoCombo);
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
    private javax.swing.JButton jbLimpiar;
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
