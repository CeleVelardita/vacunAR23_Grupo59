
package Vistas;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_Entidades.Laboratorio;

public class Admin_Laboratorio_Principal extends javax.swing.JInternalFrame {
    
    //Declaración de atributos
    private DefaultTableModel modeloTabla;//modelo para la tabla
    private List<Laboratorio> ListaLaboratorios;
    private LaboratorioData labData;
    private Laboratorio lab;
    
    private int filaSeleccionada;
    
    
    public Admin_Laboratorio_Principal() {
        initComponents();        
        
        //definición de atributos (inicializamos)
        modeloTabla = (DefaultTableModel) jTListadoLab.getModel();
                
        labData= new LaboratorioData();
        lab= new Laboratorio();
        
     
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEscritorioLab = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jLNombreLab = new javax.swing.JLabel();
        jLCuit = new javax.swing.JLabel();
        jLPais = new javax.swing.JLabel();
        jLDomicilio = new javax.swing.JLabel();
        jLEstado = new javax.swing.JLabel();
        jtNombreLab = new javax.swing.JTextField();
        jtCuit = new javax.swing.JTextField();
        jtPais = new javax.swing.JTextField();
        jtDomicilio = new javax.swing.JTextField();
        jCheckBoxEstado = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListadoLab = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jbBuscarXCuit = new javax.swing.JButton();
        jbBuscarXNombre = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jbListarLab = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbDarBaja = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Base de Datos: Laboratorios");
        setPreferredSize(new java.awt.Dimension(750, 550));

        jpEscritorioLab.setPreferredSize(new java.awt.Dimension(750, 550));

        jLTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("Inscripción de Laboratorios");
        jLTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLNombreLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLNombreLab.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLNombreLab.setText("Nombre del Laboratorio: ");

        jLCuit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLCuit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCuit.setText("CUIT: ");

        jLPais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLPais.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPais.setText("País: ");

        jLDomicilio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLDomicilio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDomicilio.setText("Domicilio Comercial: ");

        jLEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLEstado.setText("Activo: ");

        jtNombreLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreLabKeyTyped(evt);
            }
        });

        jtCuit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCuitKeyTyped(evt);
            }
        });

        jtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPaisKeyTyped(evt);
            }
        });

        jTListadoLab.setAutoCreateRowSorter(true);
        jTListadoLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTListadoLab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la Empresa", "Cuit", "País", "Domicilio Comercial", "Contrato/Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
        jTListadoLab.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTListadoLab);

        jbAgregar.setText("Nuevo / Guardar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbBuscarXCuit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbBuscarXCuit.setText("Buscar por Cuit");
        jbBuscarXCuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarXCuitActionPerformed(evt);
            }
        });

        jbBuscarXNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbBuscarXNombre.setText("Buscar por Nombre");
        jbBuscarXNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarXNombreActionPerformed(evt);
            }
        });

        jbListarLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbListarLab.setText("Listar Laboratorios");
        jbListarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarLabActionPerformed(evt);
            }
        });

        jbModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbDarBaja.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbDarBaja.setText("Dar de Baja/Alta");
        jbDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEscritorioLabLayout = new javax.swing.GroupLayout(jpEscritorioLab);
        jpEscritorioLab.setLayout(jpEscritorioLabLayout);
        jpEscritorioLabLayout.setHorizontalGroup(
            jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLNombreLab)
                    .addComponent(jLCuit)
                    .addComponent(jLPais)
                    .addComponent(jLDomicilio)
                    .addComponent(jLEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxEstado)
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112)
                        .addComponent(jbAgregar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbListarLab)
                            .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jbBuscarXNombre)
                                .addComponent(jbBuscarXCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbModificar)
                            .addComponent(jbDarBaja)))
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEscritorioLabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        jpEscritorioLabLayout.setVerticalGroup(
            jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombreLab)
                    .addComponent(jtNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCuit)
                            .addComponent(jtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLPais)))
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jbAgregar)))
                .addGap(18, 18, 18)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDomicilio)
                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLEstado)
                    .addComponent(jCheckBoxEstado))
                .addGap(35, 35, 35)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addComponent(jbBuscarXCuit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBuscarXNombre)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbListarLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbDarBaja))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpEscritorioLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpEscritorioLab, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    /*-----------------------------EVENTOS de ACCIÓN-------------------------------------*/
        
    ///Botón Agregar
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        //Botón Agregar agregará un laboratorio nuevo o modificara, por ende, usa 2 métodos: cargarLaboratorio() y modificarLaboratorio()
        
        //Obtenemos los valores ingresador por el usuario:    
        try{            
            //verificamos que no queden campos vacíos en los JTextField
            if (jtNombreLab.getText().isEmpty() || jtPais.getText().isEmpty() || jtDomicilio.getText().isEmpty() || jtCuit.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
                return; //return sale del método
            }

            //declaro atributos y almaceno en ellos lo ingresado en los jtextfield y jcheckbox para manipularlos            
            String nombreLab = jtNombreLab.getText();
            String numerito = jtCuit.getText();
            System.out.println(numerito);
            long cuit = Long.parseLong(numerito); //tendrá Exception
            String pais = jtPais.getText();
            String domicilio = jtDomicilio.getText();
            Boolean estado = jCheckBoxEstado.isSelected();
            
            //cargo éstos datos en el constructor de laboratorio
            lab = new Laboratorio(cuit, nombreLab, pais, domicilio, estado); //constructor creado en laboratorio(Entidades)
            
            
            
            
            
            /*-----------------------------------------------*/
            // este método no está funcionando y no entiendo por qué
            /*
            //verifico que éste laboratorio no se encuentre en la lista
            //pido la lista de laboratorios para comparar con el ingresado (podria crear un metodo buscar en labdata también)
            
            ListaLaboratorios = (ArrayList<Laboratorio>) labData.listarLaboratorios();
            boolean resultado=false;
            for(Laboratorio labor:ListaLaboratorios){
                //resultado= lab.equals(labor);
                if(resultado==true){
                    return;
                }
            }
            
            //si return == true es porque el laboratorio ya existe y debo modificarlo sino se agrega 
            if(resultado==true){
                labData.modificarLaboratorio(lab);
            }else{
                labData.cargarLaboratorio(lab);
            }
            */
            /*------------------------------------------*/
            
            // Reemplazo lo anterior por la línea de abajo para chequear si el Laboratorio existe en la BD
            Laboratorio laborat = labData.buscarLaboratorioXCUIT(cuit);            
            
            if (lab == null) {
                labData.cargarLaboratorio(lab);
                limpiarCampos();//limpio los campos textfield
                modeloTabla.addRow(new Object[]{lab.getNomLaboratorio(), lab.getCuit(), lab.getPais(), lab.getDomComercial(), lab.isEstado()});
            } else {
                filaSeleccionada = jTListadoLab.getSelectedRow();
                labData.modificarLaboratorio(lab);
                limpiarCampos();//limpio los campos textfield
                actualizarFilaTabla(filaSeleccionada, lab);
            }
            
            }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El CUIT son sólo 11 dígitos, sin puntos ni guiones");
        }
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    ///Botón Listar Laboratorios
    private void jbListarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarLabActionPerformed
        borrarFilaDeTabla();
        ListarLaboratorios();
    }//GEN-LAST:event_jbListarLabActionPerformed

    ///Botón Modificar
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        /*
        Este botón sólo carga los datos del laboratorio seleccionado de la tabla 
        hacia los campos editables para luego ser agregados/modificados por
        el botón Agregar
        */        
        extraerLabdeTabla();//extrae laboratorio de la tabla
      
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBuscarXCuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarXCuitActionPerformed
        admin_lab_BuscarxCuit buscarCuit = new admin_lab_BuscarxCuit(this); // Pasa una referencia al JFrame principal
         // hago visible la ventana buscarXCuit
        buscarCuit.setVisible(true);

        // Agrego al jpEscritorioLab 
        jpEscritorioLab.add(buscarCuit);

        buscarCuit.moveToFront();
    }//GEN-LAST:event_jbBuscarXCuitActionPerformed

    private void jbBuscarXNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarXNombreActionPerformed
        admin_lab_BuscarxNombre buscarNombreFrame = new admin_lab_BuscarxNombre(this); // Pasa una referencia al JFrame principal
        // Agrego al jpEscritorioLab 
        jpEscritorioLab.add(buscarNombreFrame);
        // hago visible la ventana buscarXNombre
        buscarNombreFrame.setVisible(true);
    }//GEN-LAST:event_jbBuscarXNombreActionPerformed

    /*-----------------------------EVENTOS de CONTROL-------------------------------------*/    
    
    private void jtNombreLabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreLabKeyTyped
        char letra = evt.getKeyChar();
        if (!Character.isLetter(letra) && letra != KeyEvent.VK_BACK_SPACE && letra != KeyEvent.VK_SPACE) {
            evt.consume();  // Rechaza el carácter si no es una letra, espacio o retroceso
        }
    }//GEN-LAST:event_jtNombreLabKeyTyped

    private void jtCuitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCuitKeyTyped
        char letra=evt.getKeyChar();
        if (!Character.isDigit(letra) && letra != KeyEvent.VK_BACK_SPACE) {
            // Rechaza el carácter si no es un dígito o un retroceso
            evt.consume();
        }
    }//GEN-LAST:event_jtCuitKeyTyped

    private void jtPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPaisKeyTyped
        char letra = evt.getKeyChar();
        if (!Character.isLetter(letra) && letra != KeyEvent.VK_BACK_SPACE && letra != KeyEvent.VK_SPACE) {
            evt.consume();  // Rechaza el carácter si no es una letra, espacio o retroceso
        }
    }//GEN-LAST:event_jtPaisKeyTyped

    /*------------------------------------------------------------------------------------*/
    
    ///Botón dar de alta/baja
    private void jbDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarBajaActionPerformed
        try {
            filaSeleccionada = jTListadoLab.getSelectedRow();
            
            if(filaSeleccionada != -1){
                // Recupero el valor del CUIT de la tabla, es un objeto, luego lo casteo a un String para poder
                // parsearlo a un Long
                Object num = jTListadoLab.getValueAt(filaSeleccionada, 1);
                String numerito = num.toString();
                Long cuit = Long.parseLong(numerito);
                labData.cambiarEstadoLaboratorio(cuit);
                lab = labData.buscarLaboratorioXCUIT(cuit);
                actualizarFilaTabla(filaSeleccionada, lab);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila de la tabla");
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
    private javax.swing.JButton jbBuscarXCuit;
    private javax.swing.JButton jbBuscarXNombre;
    private javax.swing.JButton jbDarBaja;
    private javax.swing.JButton jbListarLab;
    private javax.swing.JButton jbModificar;
    private javax.swing.JPanel jpEscritorioLab;
    private javax.swing.JTextField jtCuit;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTextField jtNombreLab;
    private javax.swing.JTextField jtPais;
    // End of variables declaration//GEN-END:variables
    
    
    
    
    
    /*---------------------MÉTODOS---------------------*/
     
     
    
    //borra/setea la tabla
    private void borrarFilaDeTabla(){
        int indice = modeloTabla.getRowCount() -1;
        for(int i = indice ; i >= 0 ; i--){
            modeloTabla.removeRow(i);           
        }
    }    
       
    /*-----método para limpiar/setear campos (textfield y checkbox)-----*/
    private void limpiarCampos(){
        jtNombreLab.setText("");
        jtCuit.setText("");
        jtPais.setText("");
        jtDomicilio.setText("");
        jCheckBoxEstado.setEnabled(false);
    }
        
    /*-----Carga la Lista de Laboratorios de la BD a la tabla-----*/
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
        

        // Obtener la lista de laboratorios
        ListaLaboratorios = (ArrayList<Laboratorio>) labData.listarLaboratorios();

        for(Laboratorio i: ListaLaboratorios){
            modeloTabla.addRow(new Object []{i.getNomLaboratorio(), i.getCuit(), i.getPais(), i.getDomComercial(), i.isEstado()});
            System.out.println(lab.getNomLaboratorio());
        }
    }
    
    /*-----extrae el laboratorio seleccionado de la tabla hacia los textfield para modificar un dato-----*/
    private void extraerLabdeTabla(){
        try{
            // Obtiene la fila seleccionada
            filaSeleccionada = jTListadoLab.getSelectedRow();
            
            // Primero verifico que haya una fila seleccionada
            if(jTListadoLab.getSelectedRow() != -1){
                jtNombreLab.setText(jTListadoLab.getValueAt(filaSeleccionada, 0).toString());
                jtCuit.setText(jTListadoLab.getValueAt(filaSeleccionada, 1).toString());
                jtPais.setText(jTListadoLab.getValueAt(filaSeleccionada, 2).toString());
                jtDomicilio.setText(jTListadoLab.getValueAt(filaSeleccionada, 3).toString());
                
                Boolean estado = (Boolean) jTListadoLab.getValueAt(filaSeleccionada, 4);
                jCheckBoxEstado.setSelected(estado);
            }
            
            
            
/*
            // Obtiene los datos de la fila seleccionada
            //Object[] data = (Object[]) jTListadoLab.getValueAt(row, 0); // La primera columna contiene los datos del laboratorio

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
            
            */



        }catch (NullPointerException e) {
             // La tabla no tiene filas seleccionadas
             JOptionPane.showMessageDialog(null, "La tabla no tiene filas seleccionadas"+e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
             // La fila seleccionada no existe
             JOptionPane.showMessageDialog(null, "La fila seleccionada no existe"+e.getMessage());
        }        
    }
    
    /*-----actualiza la tabla con el Laboratorio que el usuario busca con el Cuit o Nombre-----*/
    public void actualizarJTable(Laboratorio lab) {
        //limpio la tabla
        borrarFilaDeTabla();
        
    //imprimo en tabla el laboratorio encontrado por el boton buscarxCuit o buscarxNombre
     modeloTabla.addRow(new Object []{lab.getNomLaboratorio(),lab.getCuit(),lab.getPais(),lab.getDomComercial(),lab.isEstado()});

    }
    
    /*----- actualiza la fila una vez se hayan efectuado cambios------*/
    public void actualizarFilaTabla(int filaSeleccionada, Laboratorio laboratorio){
        jTListadoLab.setValueAt(laboratorio.getNomLaboratorio(), filaSeleccionada, 0);
        jTListadoLab.setValueAt(laboratorio.getCuit(), filaSeleccionada, 1);
        jTListadoLab.setValueAt(laboratorio.getPais(), filaSeleccionada, 2);
        jTListadoLab.setValueAt(laboratorio.getDomComercial(), filaSeleccionada, 3);
        jTListadoLab.setValueAt(laboratorio.isEstado(), filaSeleccionada, 4);
    }
    
   
}
