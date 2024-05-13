/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.vistas;


import inventory.acceso.AccesoExcepciones;
import inventory.acceso.AccesoSucursal;
import inventory.objetos.ObjetosSucursal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class wdwCatalogoSucursales extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form CatalogoAdmonProductos
     */
    AccesoExcepciones Mensaje = new AccesoExcepciones();
    AccesoSucursal nuevaSucursal = new AccesoSucursal();
    ObjetosSucursal sucursal = new ObjetosSucursal();
    String seleccion = "";

//AccesoProveedor nuevoProveedor = new AccesoProveedor();
    
    
    public wdwCatalogoSucursales() {
        initComponents();
        buscarEnRegistrosGuardados();
    }
    
    private void guardarRegistro(){
        // Si se ingresan todos los datos del producto asigno valor al objeto
        if(verificarDatosProducto()){
            sucursal.setNombre_sucursal(txtNombreSucursal.getText());
            sucursal.setDescripcion_sucursal(txtDescripcionSucursal.getText());
            sucursal.setDireccion_sucursal(txtDireccionSucursal.getText());
        }
        
        try{
            nuevaSucursal.insertarSucursal(sucursal);
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al guardar los datos de la sucursal " + error);
        }
    }
        
    private boolean verificarDatosProducto(){
        boolean vDatosCorrectos = true;
        
        if (txtNombreSucursal.getText().isEmpty()) {
            Mensaje.manipulacionExcepciones("critico", "Ingrese el nombre de la sucursal");
            vDatosCorrectos = false;
        }
        if (txtDescripcionSucursal.getText().isEmpty()) {
            Mensaje.manipulacionExcepciones("critico", "Ingrese la descripcion de la sucursal");
            vDatosCorrectos = false;
        }
        if (txtDireccionSucursal.getText().isEmpty()) {
            Mensaje.manipulacionExcepciones("critico", "Ingrese la direccion de la sucursal");
            vDatosCorrectos = false;
        }
        
        return vDatosCorrectos;
    }
    
    public void limpiarCampos(){
        btnGuardar.setEnabled(true);
        txtIdSucursal.setText("");
        txtNombreSucursal.setText("");
        txtDescripcionSucursal.setText("");
        txtDireccionSucursal.setText("");
        txtBuscar.setText("");
    }
    
    private void buscarEnRegistrosGuardados(){
        
        String busqueda = txtBuscar.getText();
        
        if(busqueda != null || !busqueda.equals("")){
            
            DefaultTableModel tabla = new DefaultTableModel();
            ArrayList<ObjetosSucursal> listaSucursales = new ArrayList();
            
            int contadorFilas = 1;
            int c = 0;
            
            try{
                listaSucursales = nuevaSucursal.seleccionarSucursal(busqueda);
                System.out.println("SE CONSULTARON LOS DATOS DE USUARIOS");
                
            }catch(Exception error){
                Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar la informacion " + error);
            }
            
            if(listaSucursales.isEmpty()){
                Mensaje.manipulacionExcepciones("critico", "No existen datos de sucursales almacenados");
            }else{
                tabla.addColumn("CODIGO");
                tabla.addColumn("NOMBRE");
                tabla.addColumn("DESCRIPCION");
                tabla.addColumn("DIRECCION");
                
                for(ObjetosSucursal xSuc : listaSucursales){
                    tabla.setRowCount(contadorFilas);
                    
                    tabla.setValueAt(xSuc.getId_sucursal(), c, 0);
                    tabla.setValueAt(xSuc.getNombre_sucursal(), c, 1);
                    tabla.setValueAt(xSuc.getDescripcion_sucursal(), c, 2);
                    tabla.setValueAt(xSuc.getDireccion_sucursal(), c, 3);
                    
                    System.out.println("Se encontro el registro " + xSuc.getNombre_sucursal());
                    c++;
                    contadorFilas++;
                }
                
                tblSucursal.setModel(tabla);
            }
        }else{
            mostrarRegistrosGuardados();
        }
    }
    
    public void mostrarRegistrosGuardados(){
         DefaultTableModel tabla = new DefaultTableModel();
         ArrayList<ObjetosSucursal> listaSucursales = new ArrayList();
         int contadorFilas = 1;
         int c = 0;
         
         try{
             listaSucursales = nuevaSucursal.retornaSucursales();
         }catch(Exception error){
             Mensaje.manipulacionExcepciones("critico", "Error en busqueda " + error);
         }
         
         if(listaSucursales.isEmpty()){
                Mensaje.manipulacionExcepciones("critico", "No existen datos de sucursales almacenados");
            }else{
                
                tabla.addColumn("CODIGO");
                tabla.addColumn("NOMBRE");
                tabla.addColumn("DESCRIPCION");
                tabla.addColumn("DIRECCION");
                
                for(ObjetosSucursal xSuc : listaSucursales){
                    tabla.setRowCount(contadorFilas);
                    
                    tabla.setValueAt(xSuc.getId_sucursal(), c, 0);
                    tabla.setValueAt(xSuc.getNombre_sucursal(), c, 0);
                    tabla.setValueAt(xSuc.getDescripcion_sucursal(), c, 1);
                    tabla.setValueAt(xSuc.getDireccion_sucursal(), c, 2);
                    
                    System.out.println("Se encontro el registro " + xSuc.getNombre_sucursal());
                    c++;
                    contadorFilas++;
                }
                
                tblSucursal.setModel(tabla);
            }
    }
    
    private int obtenerIdUsuario(String pNombre, String pDescripcion, String pDireccion){
        
        int vId_producto = 0;
        ArrayList<ObjetosSucursal> BuscarUsuario = new ArrayList();
        
        try{
            BuscarUsuario = nuevaSucursal.obtenerIdSuc(pNombre, pDescripcion, pDireccion);
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar el id de la sucursal " + error);
        }
        
        if(BuscarUsuario.isEmpty()){
            Mensaje.manipulacionExcepciones("informacion", "Debe crear la sucursal en el sistema");
        }else{
            if(BuscarUsuario.size() > 1){
                System.out.println("EXISTEN " + BuscarUsuario.size() + " USUARIOS CON ESTOS DATOS");
                Mensaje.manipulacionExcepciones("critico", "Este ID esta repetido");
            }else{
                vId_producto = BuscarUsuario.get(0).getId_sucursal();
            }
        }
        
        return vId_producto;
        
    }
    
    private void actualizarRegistro(){
        
        sucursal.setId_sucursal(Integer.parseInt(txtIdSucursal.getText()));
        sucursal.setNombre_sucursal(txtNombreSucursal.getText());
        sucursal.setDescripcion_sucursal(txtDescripcionSucursal.getText());
        sucursal.setDireccion_sucursal(txtDireccionSucursal.getText());
        
        try{
            Mensaje.manipulacionExcepciones("informacion", nuevaSucursal.actualizarSucursal(sucursal));
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Error al actualizar el usuario " + error);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEncabezado = new javax.swing.JPanel();
        lblIdSucursal = new javax.swing.JLabel();
        txtIdSucursal = new javax.swing.JTextField();
        lblNombreSucursal = new javax.swing.JLabel();
        lblDescripcionSucursal = new javax.swing.JLabel();
        txtDescripcionSucursal = new javax.swing.JTextField();
        lblDireccionSucursal = new javax.swing.JLabel();
        txtDireccionSucursal = new javax.swing.JTextField();
        txtNombreSucursal = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSucursal = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sucursales");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/salir.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));

        pnlEncabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblIdSucursal.setText("ID Sucursal");

        txtIdSucursal.setBackground(new java.awt.Color(102, 102, 102));
        txtIdSucursal.setEditable(false);
        txtIdSucursal.setForeground(new java.awt.Color(255, 255, 255));
        txtIdSucursal.setToolTipText("Este campo es colocado automaticamente por el sistema");

        lblNombreSucursal.setText("Nombre");

        lblDescripcionSucursal.setText("Descripcion");
        lblDescripcionSucursal.setToolTipText("");

        txtDescripcionSucursal.setToolTipText("Ingrese una descripcion para la sucursal");

        lblDireccionSucursal.setText("Direccion");

        txtDireccionSucursal.setToolTipText("Ingrese la direccion de la sucursal");

        txtNombreSucursal.setToolTipText("Ingrese un nombre para la sucursal");

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdSucursal)
                    .addComponent(lblDescripcionSucursal))
                .addGap(18, 18, 18)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addComponent(txtDescripcionSucursal)
                        .addGap(18, 18, 18)
                        .addComponent(lblDireccionSucursal)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccionSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addComponent(txtIdSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblNombreSucursal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreSucursal)))
                .addContainerGap())
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdSucursal)
                    .addComponent(txtIdSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreSucursal)
                    .addComponent(txtNombreSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcionSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcionSucursal)
                    .addComponent(lblDireccionSucursal)
                    .addComponent(txtDireccionSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtDireccionSucursal.getAccessibleContext().setAccessibleName("txtDireccionSucursal");

        pnlBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBuscar.setText("Buscar");

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setActionCommand("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setToolTipText("Ingrese el nombre del producto que desea buscar");

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBuscar)
                        .addComponent(btnSalir)
                        .addComponent(btnLimpiar)
                        .addComponent(btnModificar)
                        .addComponent(btnGuardar)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDetalle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSucursal.getTableHeader().setReorderingAllowed(false);
        tblSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSucursalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSucursal);

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEncabezado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       guardarRegistro();
       buscarEnRegistrosGuardados();
       limpiarCampos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarEnRegistrosGuardados();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Mensaje.manipulacionExcepciones("interrogante", "¿Esta seguro que desea salir?");
        if (Mensaje.valor == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSucursalMouseClicked
btnGuardar.setEnabled(false);        
        if(String.valueOf(tblSucursal.getSelectedColumn()).equals("0")){
            txtIdSucursal.setText(String.valueOf(tblSucursal.getValueAt(tblSucursal.getSelectedRow(), 0)));
            txtNombreSucursal.setText(String.valueOf(tblSucursal.getValueAt(tblSucursal.getSelectedRow(), 1)));
            txtDescripcionSucursal.setText(String.valueOf(tblSucursal.getValueAt(tblSucursal.getSelectedRow(), 2)));
            txtDireccionSucursal.setText(String.valueOf(tblSucursal.getValueAt(tblSucursal.getSelectedRow(), 3)));
        }        
    }//GEN-LAST:event_tblSucursalMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(txtDescripcionSucursal.getText().isEmpty()){
            Mensaje.manipulacionExcepciones("informacion", "Debe seleccionar el registro a modificar");
        }else{
            actualizarRegistro();
            buscarEnRegistrosGuardados();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDescripcionSucursal;
    private javax.swing.JLabel lblDireccionSucursal;
    private javax.swing.JLabel lblIdSucursal;
    private javax.swing.JLabel lblNombreSucursal;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JTable tblSucursal;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcionSucursal;
    private javax.swing.JTextField txtDireccionSucursal;
    private javax.swing.JTextField txtIdSucursal;
    private javax.swing.JTextField txtNombreSucursal;
    // End of variables declaration//GEN-END:variables
}
