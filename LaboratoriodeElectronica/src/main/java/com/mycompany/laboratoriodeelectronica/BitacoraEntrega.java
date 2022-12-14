/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratoriodeelectronica;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfre
 */
public class BitacoraEntrega extends javax.swing.JInternalFrame {

    /**
     * Creates new form BitacoraEntrega
     */
    private int IdPrestamo;
    private String userName;
    private String password;
    
    public BitacoraEntrega(String user, String passwrd) {
        initComponents();
        userName = user;
        password = passwrd;
        mostrarVistaBitacora();        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        prestamoID = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        entregadoBitacora = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBitacora = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        quitarSelec = new javax.swing.JButton();

        setTitle("Bitácora Entrega");

        prestamoID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                prestamoIDItemStateChanged(evt);
            }
        });

        jLabel1.setText("IdPréstamo");
        jLabel1.setToolTipText("");

        jLabel4.setText("Fecha Entregado");

        entregadoBitacora.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(39, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prestamoID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entregadoBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prestamoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(entregadoBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tablaBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaBitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBitacoraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBitacora);

        jButton1.setText("Agregar");
        jButton1.setMaximumSize(new java.awt.Dimension(96, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(25, 25));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.setMaximumSize(new java.awt.Dimension(96, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(96, 25));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.setMaximumSize(new java.awt.Dimension(96, 25));
        jButton3.setMinimumSize(new java.awt.Dimension(96, 25));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        quitarSelec.setText("Quitar Selec.");
        quitarSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarSelecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quitarSelec))
                        .addGap(156, 156, 156))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitarSelec))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prestamoIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_prestamoIDItemStateChanged

    }//GEN-LAST:event_prestamoIDItemStateChanged

    private void tablaBitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBitacoraMouseClicked
        cargarDatosBitacora();
    }//GEN-LAST:event_tablaBitacoraMouseClicked

    private void cargarDatosBitacora(){
        int row = tablaBitacora.getSelectedRow();
        String numInvFecha = tablaBitacora.getModel().getValueAt(row,0).toString();  
        prestamoID.addItem(numInvFecha);
        prestamoID.setSelectedItem(numInvFecha);
        String sql = "SELECT Id_Prestamo FROM Aula.Prestamo WHERE NumInv ="+numInvFecha.substring(0, numInvFecha.indexOf("-"));
        Cconexion conexion = new Cconexion(userName, password);
        try{
            Statement st = conexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
                IdPrestamo = Integer.parseInt(rs.getString(1));               
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        } 
        quitarSelec.setVisible(true);
    }    
    private void insertarRegBitacora(){
        if(prestamoID.getSelectedIndex() != 0){
            String[] numINV = prestamoID.getSelectedItem().toString().split("-");
            String cons1 = "Select Id_Prestamo, RPE_Empleado FROM Aula.Prestamo WHERE numInv=" + numINV[0];
            try{
                Cconexion conexion = new Cconexion(userName, password);
                Statement st = conexion.establecerConexion().createStatement();                               
                ResultSet rs = st.executeQuery(cons1);

                String idPrestamo = "", rpe = "";
                while(rs.next()){
                    idPrestamo = rs.getString(1);
                    rpe = rs.getString(2);
                }                                                    
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");              
                String strDate = dateFormat.format(entregadoBitacora.getDate());
                String consulta = "INSERT INTO Aula.BitacoraEntrega(Id_Prestamo,RPE_Empleado,Fecha_Entrega) VALUES ("+idPrestamo+","+rpe+",'"+strDate+"')";
                CallableStatement cs = conexion.establecerConexion().prepareCall(consulta);
                cs.execute();                      
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error" + e.toString());
            }
        }
    }    

    private void modificarRegBitacora(){
        String[] numInvent = prestamoID.getSelectedItem().toString().split("-");//numero inventario, fecha
        String cons1 = "Select Id_Prestamo, RPE_Empleado FROM Aula.Prestamo WHERE NumInv=" + numInvent[0];                
        
        Cconexion conexion = new Cconexion(userName, password);
        String idPrest = "";
        String rpe = "";                
        Statement st;        
        try
        {
            st = conexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(cons1);            
            while (rs.next())
            {
                //guarda los valores duvueltos de la consulta
                idPrest= rs.getString(1);
                rpe = rs.getString(2);                
            }              
            String consulta = "UPDATE Aula.BitacoraEntrega SET Id_Prestamo=" + idPrest + ",RPE_Empleado=" + rpe +" WHERE Id_Prestamo = "+IdPrestamo;
            CallableStatement cs = conexion.establecerConexion().prepareCall(consulta);
            cs.execute(); 
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
    }
    private void quitarSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarSelecActionPerformed
        clearFormBitacora();
    }//GEN-LAST:event_quitarSelecActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        eliminarRegBitacora();
        mostrarVistaBitacora();
        clearFormBitacora();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        modificarRegBitacora();
        mostrarVistaBitacora();
        clearFormBitacora();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        insertarRegBitacora();
        mostrarVistaBitacora();
        clearFormBitacora();
    }//GEN-LAST:event_jButton1MouseClicked

    private void eliminarRegBitacora(){
        Cconexion conexion = new Cconexion(userName, password);
        try{
            String consulta = "DELETE FROM Aula.BitacoraEntrega WHERE Id_Prestamo=" + IdPrestamo;
            CallableStatement cs = conexion.establecerConexion().prepareCall(consulta);
            cs.execute(); 
            consulta = "DELETE FROM Aula.Prestamo WHERE Id_Prestamo=" + IdPrestamo;
            cs = conexion.establecerConexion().prepareCall(consulta);
            cs.execute(); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
    }
    private void clearFormBitacora(){
        prestamoID.setSelectedIndex(0);
        quitarSelec.setVisible(false);
    }
    private void mostrarVistaBitacora(){
        VistaBitacora();
        LlenaIDPrestamo();
        Calendar clndr = Calendar.getInstance();
        entregadoBitacora.setCalendar(clndr);
        quitarSelec.setVisible(false);
    }
    private void VistaBitacora(){        
        Cconexion objetoConexion = new Cconexion(userName, password);
                
        DefaultTableModel modelo = new DefaultTableModel();   
        modelo.addColumn("id_Préstamo");        
        modelo.addColumn("RPE_Empleado");        
        modelo.addColumn("Fecha_Entrega");                

        String query = "SELECT * FROM Aula.BitacoraEntrega";                    
        String [] datos = new String[3];
        Statement st; 
        //tablaBitacora.removeAll();
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(query);            
            while (rs.next())
            {  
                datos[0]= concatenarNumInvFecha(rs.getString(1));  
                datos[1]= rs.getString(2);                              
                datos[2]= rs.getString(3);                           
                modelo.addRow(datos);
            }
            tablaBitacora.setModel(modelo);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }         
    }
    private String concatenarNumInvFecha(String idPrestamo){
        String sql = "SELECT NumInv, FechaEntrega FROM Aula.Prestamo WHERE Id_Prestamo="+idPrestamo;
        String [] datos = new String[2];
        Statement st;
        String numInvFecha="";
        Cconexion objetoConexion = new Cconexion(userName, password);
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);            
            while (rs.next())
            {                  
                datos[0]= rs.getString(1);                              
                datos[1]= rs.getString(2);                                           
            }  
            numInvFecha = datos[0]+"-"+datos[1];            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
        return numInvFecha;
    }
    private void LlenaIDPrestamo()
    {       
        Cconexion objetoConexion = new Cconexion(userName, password);        
        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA          
        String sql = "SELECT NumInv, FechaEntrega FROM Aula.Prestamo";
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[2];
        Statement st;        
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //Elimina los elementos actuales para no insertar duplicados
            prestamoID.removeAllItems();
            prestamoID.addItem("Seleccione");
            while (rs.next())
            {
                //guarda los valores duvueltos de la consulta
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                String item = datos[0]+"-"+datos[1];
                if(!registrado(item))
                    prestamoID.addItem(item);
            }            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
    }
    //Evalua si un elemento dado ya esta registrado, para evitar registros duplicados
    private Boolean registrado(String item){
        for (int i=0; i<tablaBitacora.getModel().getRowCount();i++) {
            if(tablaBitacora.getModel().getValueAt(i, 0).equals(item))
                return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser entregadoBitacora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> prestamoID;
    private javax.swing.JButton quitarSelec;
    private javax.swing.JTable tablaBitacora;
    // End of variables declaration//GEN-END:variables
}
