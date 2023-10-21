
package Vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_AccesoADatos.Conexion.VacunaData;
import vacunar23_Entidades.Laboratorio;
import vacunar23_Entidades.Vacuna;

public class VacunasView extends javax.swing.JInternalFrame {
    
    private VacunaData vacunaData;
    private Vacuna vacunaActual;
    private LaboratorioData labData;
    
    private DefaultComboBoxModel modeloCombo; // Lo necesito para agregarle elementos al combo
    
    private ArrayList<Vacuna> ListaVacunas; // Lo voy a necesitar para llenar la tabla
    private ArrayList<Laboratorio> ListaLaboratorios; // Lo voy a necesitar para el comboBox de laboratorios

    public VacunasView() {
        initComponents();
        vacunaData = new VacunaData();
        vacunaActual = null;        
        
        modeloCombo = (DefaultComboBoxModel) jcbMedida.getModel();
        
        modeloCombo.addElement("0.3");
        modeloCombo.addElement("0.5");
        modeloCombo.addElement("0.9");
        
        jcbMedida.setModel(modeloCombo);
        jcbMedida.repaint();
        
        labData = new LaboratorioData();
        ListaLaboratorios = (ArrayList<Laboratorio>)labData.listarLaboratorios();
        // Explicación de la línea de arriba: Se recuperan de LaboratorioData los laboratotorios cargados activos
        // Como lo que devuelve es una lista, se castea a un ArrayList
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administración de Vacunas");
        setPreferredSize(new java.awt.Dimension(490, 500));

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

        jbEliminar.setText("Elimiar");

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
                                    .addComponent(jLabel3))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNroSerie)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jdcVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jbAgregar)
                        .addGap(65, 65, 65)
                        .addComponent(jbModificar)
                        .addGap(62, 62, 62)
                        .addComponent(jbEliminar)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        try {
            
            Laboratorio laboratorio = rescatandoAlSoldadoRian(); // lo voy a necesitar luego

           // Guardo en una variable cada uno de los datos ingresados en cada textField
            
            // Utilizo el método creado para acceder al nombre del laboratorio seleccionado
            String nombreLab = laboratorio.getNomLaboratorio();
            
            String marca = jtMarca.getText();
            int nroSerie = Integer.parseInt(jtNroSerie.getText());

            // Guardo la opción del comboBox en una variable
            String dosis = (String) jcbMedida.getSelectedItem(); // el combo me devuelve un Object
            Double dosisSeleccionada = Double.parseDouble(dosis); // Lo parseo a un Double para mandarlo a la base de datos

            LocalDate fechaCaducidad = jdcVencimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            
            
            
            ///-------> Me falta rescatar la elección de "aplicada" <---------
            
            
            
            
            // Verifico que no queden campos vacíos
            if (nombreLab.isEmpty() || marca.isEmpty() ||fechaCaducidad == null) {
                if( nroSerie == 0 || dosisSeleccionada == 0.0){
                   return; 
                }                
            }

            if (vacunaActual == null) {
               // vacunaActual = new Vacuna(nroSerie, marca, 0, fechaCaducidad, closable, WIDTH)
                vacunaData.cargarVacuna(vacunaActual);
            } else { // si no está nulo, es porque ya está cargada una vacuna con el mismo número de serie
                vacunaActual.setNroSerie(nroSerie);
                vacunaActual.setMarca(marca);
                vacunaActual.setMedida(dosisSeleccionada);
                vacunaActual.setFechaCaduca(fechaCaducidad);
                vacunaActual.setColocada(false); // configurar con el botoncito
                vacunaActual.setLaboratorio(laboratorio); // No estoy segura

                vacunaData.modificarVacuna(vacunaActual);
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "El campo 'Nro. Serie' solo admite números, sin puntos ni comas");
        } catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, "Los campos 'Laboratorio' y 'Marca' no son válidos");
        }  
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    /*
    Funcionalidades:
    - Botón insertar: chequea que los campos no estén vacíos y que cada uno sea válido 
    según el tipo de parámetro que puede recibir. Si está todo ok, agrega una fila en la tabla
    - Botón modifica: verifica que los campos hayan sido completados mediante la selección de una fila
    de la tabla, caso contrario, dará un mensaje del estilo "debe seleccionar una de las filas de la tabla", 
    luego chequea que los datos sean válidos y modifica
    - Botón eliminar: verifica de igual manera que el botón modificar. Agregar mensaje de confirmación de la operación,
    ya que la fila será eliminada de la tabla, no dada de baja.
    
    - Al ingresar el nombre del laboratorio, se verificará con la BD de los laboratorios activos, si el indicado
    se encuentra en convenio con el vacunatorio o no. En caso negativo, aparecerá un cartel del estilo "Actualmente el laboratorio
    indicado se encuentra dado de baja"
    
    - En el comboBox de medida, cargar las 3 opciones de medida posible para las vacunas. Antes de seleccionar alguna
    debe estar vacío.
    
    - En la fecha de vencimiento NO permitir colocar una fecha anterior mínimo, a un día posterior del día de la carga de datos
    
    - Agregar botón/ícono para buscar vacuna ingresando solo nombre o laboratorio, una vez encontrado, mostrar la tabla solo con esos datos
    y en caso de no encontrarlo imprimir un mensaje por pantalla. Si el usuario no ingresa ni laboratorio ni la marca, imprimir un mensaje 
    que indique lo necesario para poder realizar la búsqueda
    
    NOTA: en el stock quiero agregar un jSpinner, investigar cómo y de qué manera puedo enviarle lo seteado
    a la base de datos, debe ser la única columna editable
        
    */
    
    

    private Laboratorio rescatandoAlSoldadoRian() {
        Laboratorio lab = null;
        //String nombre = null;
        if (jcbLaboratorio != null) {
            lab = (Laboratorio) jcbLaboratorio.getSelectedItem();
            //nombre = (String) lab.getNomLaboratorio();
        }
        //return nombre;
        return lab;
        
        // Según yo, a partir de acá puedo acceder a todos los métodos de laboratorio
        // No tengo certezas pero tampoco dudas
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<String> jcbLaboratorio;
    private javax.swing.JComboBox<String> jcbMedida;
    private com.toedter.calendar.JDateChooser jdcVencimiento;
    private javax.swing.JTextField jtMarca;
    private javax.swing.JTextField jtNroSerie;
    private javax.swing.JTable jtTablaVacunas;
    // End of variables declaration//GEN-END:variables


    private void cargarListaVacunas() {

        ListaVacunas = (ArrayList) vacunaData.listarVacunas();
        /*
    for (VacunasView ListaVacuna : ListaVacunas) {
        jtTablaVacunas.
    }
         */
    }

    private void cargarComboLaboratorios() {
        jcbLaboratorio.removeAllItems();

        for (Laboratorio item : ListaLaboratorios) {
            jcbLaboratorio.addItem(item.getNomLaboratorio());
        }
    }

    




}
