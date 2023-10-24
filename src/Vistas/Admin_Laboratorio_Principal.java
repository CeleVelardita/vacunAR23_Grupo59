
package Vistas;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vacunar23_AccesoADatos.Conexion.LaboratorioData;
import vacunar23_Entidades.Laboratorio;

public class Admin_Laboratorio_Principal extends javax.swing.JInternalFrame {
    
    //Declaración de atributos
    private DefaultTableModel modeloTabla;//modelo para la tabla
    private ArrayList<Laboratorio> ListaLaboratorios;
    private LaboratorioData labData;
    private Laboratorio lab;
    
    
    public Admin_Laboratorio_Principal() {
        initComponents();
        armarCabeceraTabla();
        
        //definición de atributos (inicializamos)
        modeloTabla= new DefaultTableModel();
        ListaLaboratorios= new ArrayList();
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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTListadoLab);

        jbAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAgregar.setText("Agregar");
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

        javax.swing.GroupLayout jpEscritorioLabLayout = new javax.swing.GroupLayout(jpEscritorioLab);
        jpEscritorioLab.setLayout(jpEscritorioLabLayout);
        jpEscritorioLabLayout.setHorizontalGroup(
            jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEscritorioLabLayout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxEstado)
                                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLTitulo))
                                    .addComponent(jtNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(jtCuit, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbBuscarXCuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbBuscarXNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1))
                            .addComponent(jbListarLab)
                            .addComponent(jbModificar)
                            .addComponent(jbDarBaja))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(77, 77, 77))
            .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLDomicilio)
                    .addComponent(jLNombreLab)
                    .addComponent(jLEstado)
                    .addComponent(jLPais)
                    .addComponent(jLCuit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpEscritorioLabLayout.setVerticalGroup(
            jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLTitulo)
                        .addGap(30, 30, 30)
                        .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLNombreLab)
                            .addComponent(jtNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCuit)
                            .addComponent(jtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPais))
                .addGap(18, 18, 18)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDomicilio))
                .addGap(22, 22, 22)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxEstado)
                    .addComponent(jLEstado))
                .addGap(31, 31, 31)
                .addGroup(jpEscritorioLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpEscritorioLabLayout.createSequentialGroup()
                        .addComponent(jbBuscarXCuit)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarXNombre)
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jbListarLab)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificar)
                        .addGap(34, 34, 34)
                        .addComponent(jbDarBaja)))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEscritorioLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEscritorioLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            int cuit = Integer.getInteger(jtCuit.getText()); //tendrá Exception
            String pais = jtPais.getText();
            String domicilio = jtDomicilio.getText();
            Boolean estado = jCheckBoxEstado.isSelected();
            
            //cargo éstos datos en el constructor de laboratorio
            lab = new Laboratorio(cuit,nombreLab, pais, domicilio, estado); //constructor creado en laboratorio(Entidades)
            
            //verifico que éste laboratorio no se encuentre en la lista
            //pido la lista de laboratorios para comparar con el ingresado (podria crear un metodo buscar en labdata también)
            
            ListaLaboratorios = (ArrayList<Laboratorio>) labData.listarLaboratorios();
            boolean resultado=false;
            for(Laboratorio labor:ListaLaboratorios){
                resultado= lab.equals(labor);
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
            
            
            limpiarCampos();//limpio los campos textfield
            ListarLaboratorios ();//actualiza la tabla           
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "el CUIT son sólo 11 dígitos");
        }
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    ///Botón Listar Laboratorios
    private void jbListarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarLabActionPerformed
        borrarFilaDeTabla();
        ListarLaboratorios ();
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
        // Agrego al jpEscritorioLab 
        jpEscritorioLab.add(buscarCuit);
        // hago visible la ventana buscarXCuit
        buscarCuit.setVisible(true);
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
    
    
    /*-----cabeceras de la tabla-----*/
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


        for(Laboratorio Lab: ListaLaboratorios){
            modeloTabla.addRow(new Object []{lab.getNomLaboratorio(),lab.getCuit(),lab.getPais(),lab.getDomComercial(),lab.isEstado()});
        }
    }
    
    /*-----extrae el laboratorio seleccionado de la tabla hacia los textfield para modificar un dato-----*/
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
    
    /*-----actualiza la tabla con el Laboratorio que el usuario busca con el Cuit o Nombre-----*/
    public void actualizarJTable(Laboratorio lab) {
        //limpio la tabla
        borrarFilaDeTabla();
        
    //imprimo en tabla el laboratorio encontrado por el boton buscarxCuit o buscarxNombre
     modeloTabla.addRow(new Object []{lab.getNomLaboratorio(),lab.getCuit(),lab.getPais(),lab.getDomComercial(),lab.isEstado()});

    }

   
}
