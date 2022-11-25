/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratoriodeelectronica;

import com.toedter.calendar.JDateChooser;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfre
 */
public class Sancion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Sancion
     */
    private String userName;
    private String password;
    public Sancion(String user, String passwrd) {
        initComponents();
        userName = user;
        password = passwrd;
        mostrarVistaSancion();
        quitarSelec.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        quitarSelec = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSancion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        claveUnicaSancion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rpeSancion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        descripcionSancion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fechaSancion = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        fechaLiquidacion = new com.toedter.calendar.JDateChooser();
        montoSancion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setTitle("Sanción");

        jButton1.setText("Agregar");
        jButton1.setMaximumSize(new java.awt.Dimension(96, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(25, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.setMaximumSize(new java.awt.Dimension(96, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(96, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.setMaximumSize(new java.awt.Dimension(96, 25));
        jButton3.setMinimumSize(new java.awt.Dimension(96, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        quitarSelec.setText("Quitar Selec.");
        quitarSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarSelecActionPerformed(evt);
            }
        });

        tablaSancion.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaSancion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSancionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaSancion);

        claveUnicaSancion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                claveUnicaSancionItemStateChanged(evt);
            }
        });

        jLabel1.setText("Clave_Única");
        jLabel1.setToolTipText("");

        jLabel2.setText("RPE_Empleado");

        rpeSancion.setToolTipText("");
        rpeSancion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rpeSancionItemStateChanged(evt);
            }
        });

        jLabel3.setText("Descripción");

        jLabel4.setText("Fecha");

        jLabel8.setText("Fecha Liquidación");

        fechaLiquidacion.setToolTipText("");

        jLabel6.setText("Monto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descripcionSancion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(claveUnicaSancion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rpeSancion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaSancion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaLiquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(montoSancion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveUnicaSancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rpeSancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionSancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaSancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaLiquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoSancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quitarSelec)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quitarSelec)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertarSancion();
        mostrarVistaSancion();
        clearFormSancion();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private String concatenarRPE(String rpe){
        String tmp = "";
        for(int i = 0; i < rpeSancion.getItemCount();i++){
            if(rpeSancion.getItemAt(i).contains(rpe)){
                tmp = rpeSancion.getItemAt(i);
            }
        }
        return tmp;
    } 
    private String concatenarNombreGen(String clve){
        
        
        Cconexion objetoConexion = new Cconexion(userName, password);        
        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        String sql = "SELECT Nombre, Generacion FROM Persona.Alumno WHERE Clave_Unica=" + clve;
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[2];            //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
        Statement st;   
        String tmp = "";
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {                
                //guarda los valores duvueltos de la consulta
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                tmp=datos[0] + "-" + datos[1];
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }                
        return tmp;
    } 
    public void vistaSancion()
    {
        Cconexion objetoConexion = new Cconexion(userName, password);
                
        DefaultTableModel modelo = new DefaultTableModel();   
        modelo.addColumn("id");
        modelo.addColumn("Clave_Unica");
        modelo.addColumn("RPE_Empleado");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Fecha");
        modelo.addColumn("F_liquidacion");
        modelo.addColumn("Monto");

        String sql = "Select * from Aula.Sancion;";                    
        String [] datos = new String[7];
        Statement st;         
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next())
            {  
                datos[0]= rs.getString(1);
                datos[1]= concatenarNombreGen(rs.getString(2));
                datos[2]= concatenarRPE(rs.getString(3));
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                datos[6]= rs.getString(7);                            
                modelo.addRow(datos);
            }
            tablaSancion.setModel(modelo);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        } 
        tablaSancion.removeColumn(tablaSancion.getColumnModel().getColumn(0));
    }
    private void mostrarVistaSancion(){
        LlenaClaveUnicaSancion();
        LlenaRPESancion();
        vistaSancion();
    }
    
    private void LlenaRPESancion()
        {       
            Cconexion objetoConexion = new Cconexion(userName, password);        
           //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
            String sql = "SELECT RPE_Empleado, Nombre FROM Persona.Empleado;";
            //es un arrgelo para la longitud de la tabla (columnas)
            String [] datos = new String[2];
            //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
            Statement st;        
            try
            {
                st = objetoConexion.establecerConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);
                //Elimina los elementos actuales para no insertar duplicados
                rpeSancion.removeAllItems();
                rpeSancion.addItem("Seleccione");
                while (rs.next())
                {
                    //guarda los valores duvueltos de la consulta
                    datos[0]= rs.getString(1);
                    datos[1]= rs.getString(2);
                    rpeSancion.addItem(datos[0]+"-"+datos[1]);
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
            }
    }
    private void clearFormSancion(){
        rpeSancion.setSelectedIndex(0);
        claveUnicaSancion.setSelectedIndex(0);
        descripcionSancion.setText("");
        montoSancion.setText("");
        quitarSelec.setVisible(false);
    }
    private void LlenaClaveUnicaSancion()
        {       
            Cconexion objetoConexion = new Cconexion(userName, password);        
           //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
            String sql = "SELECT Nombre, Generacion FROM Persona.Alumno;";
            //es un arrgelo para la longitud de la tabla (columnas)
            String [] datos = new String[2];
            //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
            Statement st;        
            try
            {
                st = objetoConexion.establecerConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);
                //Elimina los elementos actuales del comboBox para no insertar duplicados
                claveUnicaSancion.removeAllItems();
                claveUnicaSancion.addItem("Seleccione");
                while (rs.next())
                {
                    //guarda los valores duvueltos de la consulta
                    datos[0]= rs.getString(1);
                    datos[1]= rs.getString(2);
                    claveUnicaSancion.addItem(datos[0]+"-"+datos[1]);
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
            }
    }
    private void insertarSancion(){
        Cconexion conexion = new Cconexion(userName, password); 
        //El comboBox Item esta en formato: Nombre-Gen, String.split los separa
        String[] claveSancion = claveUnicaSancion.getSelectedItem().toString().split("-");
        String cons1 = "Select Clave_Unica FROM Persona.Alumno WHERE Nombre='" + claveSancion[0] + "' AND Generacion='" +claveSancion[1]+ "'";//revisar: concatenacion
        try{
            Statement st = conexion.establecerConexion().createStatement();                               
            ResultSet rs = st.executeQuery(cons1);
            //falta acumular adeudo en tabla alumno
            String claveUnica = "";
            while(rs.next())
                claveUnica = rs.getString(1);
            String rpe = rpeSancion.getSelectedItem().toString();
            rpe = rpe.substring(0, rpe.indexOf("-"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate1 = dateFormat.format(fechaLiquidacion.getDate());
            String strDate = dateFormat.format(fechaSancion.getDate());
            String consulta = "INSERT INTO Aula.Sancion(Clave_Unica,RPE_Empleado,Descripcion,F_liquidacion,Fecha,Monto) VALUES (" + claveUnica + "," + rpe + ", '" + descripcionSancion.getText() + "', '" + strDate + "', '" + strDate1 + "','" + montoSancion.getText() + "')";
            CallableStatement cs = conexion.establecerConexion().prepareCall(consulta);
            cs.execute();                      
            actualizarAdeudo("insert");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }


    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modificarSancion();
        mostrarVistaSancion();
        clearFormSancion();
    }//GEN-LAST:event_jButton2ActionPerformed
    //si se modifica el monto de una sancion, tomar el monto anterior(sin modificar), restarselo al nuevo a insertar, eso nos dará el valor modificado
    private void modificarSancion(){
        try{
            Cconexion conexion = new Cconexion(userName, password);
            String idSancion = tablaSancion.getModel().getValueAt(tablaSancion.getSelectedRow(),0).toString();
            
            actualizarAdeudo("update");
            
            String[] clve = claveUnicaSancion.getSelectedItem().toString().split("-");
            String cons1 = "Select Clave_Unica FROM Persona.Alumno WHERE Nombre='" + clve[0] + "' AND Generacion='" + clve[1] + "'";
            Statement st = conexion.establecerConexion().createStatement();                               
            ResultSet rs = st.executeQuery(cons1);       
            String rpe = rpeSancion.getSelectedItem().toString();
            rpe = rpe.substring(0, rpe.indexOf("-"));
            String claveU = "";
            while(rs.next())
                claveU = rs.getString(1);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate1 = dateFormat.format(fechaLiquidacion.getDate());
            String strDate = dateFormat.format(fechaSancion.getDate());
            String consulta = "UPDATE Aula.Sancion SET Clave_Unica = "+claveU + ",RPE_Empleado = "+ rpe +",Descripcion ='"+descripcionSancion.getText() + "',Fecha = '" + strDate + "',F_liquidacion = '" + strDate1 + "',Monto = '" + montoSancion.getText()+"' WHERE id = " + idSancion;
            
            CallableStatement cs = conexion.establecerConexion().prepareCall(consulta);
            cs.execute(); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }    
        
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarSancion();
        mostrarVistaSancion();
        clearFormSancion();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void actualizarAdeudo(String transaccion){
        Cconexion conexion = new Cconexion(userName, password);        
        String[] claveSancion = claveUnicaSancion.getSelectedItem().toString().split("-");        
        String consulta, claveU = "";
        try{
            consulta = "SELECT Clave_Unica FROM Persona.Alumno WHERE Nombre='"+claveSancion[0]+"' AND Generacion = '"+claveSancion[1]+"'";
            Statement st = conexion.establecerConexion().createStatement();                               
            ResultSet rs = st.executeQuery(consulta);             
            while(rs.next())
                claveU = rs.getString(1);            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al obtener datos del alumno: " + e.toString());
        }
        consulta = "SELECT Adeudo FROM Persona.Alumno WHERE Clave_Unica=" + claveU;
        try{
            Statement st = conexion.establecerConexion().createStatement();                               
            ResultSet rs = st.executeQuery(consulta); 
            CallableStatement cs;
           //Cantidad es el monto actual en la base de datos es el total acumulado en tabla alumno
            String cantidad = "";
            while(rs.next())
                cantidad = rs.getString(1);            
            //Obtener el monto a insertar/actualizar
            String montoNuevo = montoSancion.getText();
            switch(transaccion){
                case "insert":
                    if(cantidad == null)
                        cantidad = "0"; 
                    if(montoNuevo != null){
                        int total = Integer.parseInt(cantidad) + Integer.parseInt(montoNuevo);
                        consulta = "UPDATE Persona.Alumno SET Adeudo =" + total+ "WHERE Clave_Unica="+claveU;
                        cs = conexion.establecerConexion().prepareCall(consulta); 
                        cs.execute();
                    }
                    break;
                case "delete":
                    //MontoScn es el monto de la tupla seleccionada y es el que se encuentra en la BD, en tabla sancion
                    String montoScn = tablaSancion.getModel().getValueAt(tablaSancion.getSelectedRow(),6).toString();                    
                    if(cantidad != null && montoScn != null){
                        int total = Integer.parseInt(cantidad) - Integer.parseInt(montoScn);
                        if(total >= 0){
                            consulta = "UPDATE Persona.Alumno SET Adeudo =" + total + "WHERE Clave_Unica="+claveU;
                            cs = conexion.establecerConexion().prepareCall(consulta); 
                            cs.execute();
                        }                        
                    }
                    break;
                case "update":
                    //MontoScn es el monto de la tupla seleccionada y es el que se encuentra en la BD, en tabla sancion
                    String montoScn2 = tablaSancion.getModel().getValueAt(tablaSancion.getSelectedRow(),6).toString();
                    if(cantidad != null && montoScn2 != null){
                        //El campo Adeudo se actualiza restando el valor anterior antes de modificar
                        //y se suma el nuevo que se ingresó en el formulario
                        int total = Integer.parseInt(cantidad) - Integer.parseInt(montoScn2) + Integer.parseInt(montoNuevo);
                        consulta = "UPDATE Persona.Alumno SET Adeudo =" + total+ "WHERE Clave_Unica="+claveU;
                        cs = conexion.establecerConexion().prepareCall(consulta); 
                        cs.execute();                        
                    }
                    break;
            }                        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }         
    }
    private void eliminarSancion(){        

        String id = tablaSancion.getModel().getValueAt(tablaSancion.getSelectedRow(),0).toString();        
        Cconexion conexion = new Cconexion(userName, password);
        String claveSancion = claveUnicaSancion.getSelectedItem().toString();
        claveSancion = claveSancion.substring(claveSancion.indexOf("-"));        
        //obtener el adeudo del alumno y restarlo en la tabla alumno
        //Restar el monto de la sancion, actualizar el adeudo con el valor nuevo
        try{
           actualizarAdeudo("delete");
           String consulta = "DELETE FROM Aula.Sancion WHERE id=" + id;
           CallableStatement cs = conexion.establecerConexion().prepareCall(consulta);
           cs.execute();             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }
        
    }
    private void quitarSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarSelecActionPerformed
        clearSancionForm();
    }//GEN-LAST:event_quitarSelecActionPerformed

    private void clearSancionForm(){
        claveUnicaSancion.setSelectedIndex(0);
        rpeSancion.setSelectedIndex(0);
        descripcionSancion.setText("");        
        montoSancion.setText("");
        quitarSelec.setVisible(false);
    }
    private void tablaSancionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSancionMouseClicked
        cargarDatosSancion();
    }//GEN-LAST:event_tablaSancionMouseClicked
    private void setDateToControl(String date, JDateChooser jd){
        try{
            java.util.Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);              
            jd.setDate(date1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString()); 
        }
    }
    private void cargarDatosSancion(){
        int row = tablaSancion.getSelectedRow();
        String claveU = tablaSancion.getModel().getValueAt(row, 1).toString();
        String rpe = tablaSancion.getModel().getValueAt(row, 2).toString();
        String descripcion = tablaSancion.getModel().getValueAt(row, 3).toString();
        String fecha = tablaSancion.getModel().getValueAt(row, 4).toString();
        String f_liq = tablaSancion.getModel().getValueAt(row, 5).toString();
        String monto = tablaSancion.getModel().getValueAt(row, 6).toString();                
        
        claveUnicaSancion.setSelectedItem(claveU);
        rpeSancion.setSelectedItem(rpe);
        descripcionSancion.setText(descripcion);
        setDateToControl(fecha, fechaSancion);
        setDateToControl(f_liq, fechaLiquidacion);        
        montoSancion.setText(monto);
        quitarSelec.setVisible(true);
    }
    private void claveUnicaSancionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_claveUnicaSancionItemStateChanged

    }//GEN-LAST:event_claveUnicaSancionItemStateChanged

    private void rpeSancionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rpeSancionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rpeSancionItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> claveUnicaSancion;
    private javax.swing.JTextField descripcionSancion;
    private com.toedter.calendar.JDateChooser fechaLiquidacion;
    private com.toedter.calendar.JDateChooser fechaSancion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField montoSancion;
    private javax.swing.JButton quitarSelec;
    private javax.swing.JComboBox<String> rpeSancion;
    private javax.swing.JTable tablaSancion;
    // End of variables declaration//GEN-END:variables
}
