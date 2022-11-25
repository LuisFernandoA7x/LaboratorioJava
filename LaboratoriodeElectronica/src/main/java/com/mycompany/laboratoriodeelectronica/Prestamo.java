/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.laboratoriodeelectronica;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class Prestamo extends javax.swing.JInternalFrame {
    Integer idPrestamo=0;
     Integer ClaveAlumno=0;
    Integer ClaveEquipo=0;
    Integer rpeEmpleado=0;
    private String userName;
    private String password;
    /**
     * Creates new form Prestamo
     */
    public Prestamo(String user, String passwrd) {
        initComponents();
        userName = user;
        password = passwrd;
        Mostrar(datosPrestamo);
        LlenaClavesAsistencia();
        LlenaRPEAsistencia();
        LlenaEquipo();
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        fechaPrestamo.setVisible(false);
        fechaEntrega.setVisible(false);
    }
    private void LlenaClavesAsistencia(){
        
        Cconexion objetoConexion = new Cconexion(userName, password);
        
        //incorporar modelo a la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
  

        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "SELECT Nombre,Generacion FROM Persona.Alumno;";
        
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[2];
        //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
        Statement st; 
        alumnoPrestamo.removeAllItems();
        alumnoPrestamo.addItem("Seleccione un dato");
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);            
            while (rs.next())
            {
                //guarda los valores duvueltos de la consulta
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);                       
                alumnoPrestamo.addItem(datos[0]+"-"+datos[1]);
            }
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
        }
      
    private void LlenaRPEAsistencia(){        
        
        Cconexion objetoConexion = new Cconexion(userName, password);        
        //incorporar modelo a la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
  
        empleadoPrestamo.addItem("Selecciona un dato");
        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "SELECT RPE_Empleado,Nombre FROM Persona.Empleado;";
        
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[2];
        //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
        Statement st; 
        
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            empleadoPrestamo.removeAllItems();
            empleadoPrestamo.addItem("Seleccione un dato");
            while (rs.next())
            {
                //guarda los valores duvueltos de la consulta
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);                       
                empleadoPrestamo.addItem(datos[0]+"-"+datos[1]);
            }        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
    }
      
    private void LlenaEquipo(){
            
        Cconexion objetoConexion = new Cconexion(userName, password);        
        //incorporar modelo a la tabla
        DefaultTableModel modelo = new DefaultTableModel();

        String sql = "";
        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "SELECT Nombre,Modelo,Marca FROM Aula.Equipo;";

        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[3];
        //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
        Statement st; 
        equipoPrestamo.removeAllItems();
        equipoPrestamo.addItem("Seleccione un dato");
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                //guarda los valores duvueltos de la consulta
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                String item = datos[0]+"-"+datos[1]+"-"+datos[2];
                if(!registrado(item))
                    equipoPrestamo.addItem(item);                
            }             
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
            }
    }
    //Evalua si un elemento dado ya esta registrado, para evitar registros duplicados
    private Boolean registrado(String item){
        for (int i=0; i<datosPrestamo.getModel().getRowCount();i++) {
            if(datosPrestamo.getModel().getValueAt(i, 4).equals(item))
                return true;
        }
        return false;
    }   
    public static String truncate(String value, int length) {
        // Ensure String length is longer than requested size.
        if (value.length() > length) {
            return value.substring(0, length);
        } else {
            return value;
        }
    }
             
     public void Mostrar(JTable paramCliente)
    {
        Cconexion objetoConexion = new Cconexion(userName, password);
        
        //incorporar modelo a la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        String sql1 = "";
        String sql2="";
        String sql3="";
        modelo.addColumn("Id Préstamo");
        modelo.addColumn("Equipo");
        modelo.addColumn("Alumno");
        modelo.addColumn("Empleado");
        modelo.addColumn("Equipo");
        modelo.addColumn("Alumno1");
        modelo.addColumn("Empleado");
        modelo.addColumn("Fecha Préstamo");
        modelo.addColumn("Fecha Entrega");
        
        //aqui solo se le da nombre a las columnas

        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "Select * from Aula.Prestamo;";
        
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[9];
        //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
        Statement st;
        Statement st1; 
        Statement st2;
        Statement st3;
        //sql1 = "Select Nombre,Generacion from Persona.Alumno WHERE Nombre=" + "'" + s1 + "'";
        sql1="SELECT Nombre,Generacion FROM Persona.Alumno INNER JOIN Aula.Prestamo ON Aula.Prestamo.Clave_Unica=Persona.Alumno.Clave_Unica";
        sql2="SELECT Persona.Empleado.RPE_Empleado,Nombre FROM Persona.Empleado INNER JOIN Aula.Prestamo ON Aula.Prestamo.RPE_Empleado=Persona.Empleado.RPE_Empleado";
        sql3="SELECT Nombre,Modelo,Marca FROM Aula.Equipo INNER JOIN Aula.Prestamo ON Aula.Equipo.numinv=Aula.Prestamo.numinv";
        try
        {
            st1 = objetoConexion.establecerConexion().createStatement();
             ResultSet ct = st1.executeQuery(sql1);
            st2=objetoConexion.establecerConexion().createStatement();
            ResultSet empleado = st2.executeQuery(sql2);
            st3=objetoConexion.establecerConexion().createStatement();
            ResultSet materia = st3.executeQuery(sql3);
          /* while(ct.next())
           {
               datos[6]= ct.getString(1)+"-"+ct.getString(2);
           }*/
             st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()&& ct.next() && empleado.next() && materia.next())
            {
                //guarda los valores duvueltos de la consulta
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                //Valores de asistencia referentes a fehas
                datos[3]= rs.getString(4);
                datos[7]= rs.getString(6);
                datos[8]=rs.getString(5);
                //Concatenaciones
                datos[5]=ct.getString(1)+"-"+ct.getString(2);
                datos[6]=empleado.getString(1)+"-"+empleado.getString(2);
                datos[4]=materia.getString(1)+"-"+materia.getString(2)+"-"+materia.getString(3);
                //aqui se incorporan los datos
                modelo.addRow(datos);
            }
            
            paramCliente.setModel(modelo);
          
            paramCliente.removeColumn(paramCliente.getColumnModel().getColumn(1));
             paramCliente.removeColumn(paramCliente.getColumnModel().getColumn(1));
             paramCliente.removeColumn(paramCliente.getColumnModel().getColumn(1));
             // paramCliente.removeColumn(paramCliente.getColumnModel().getColumn(4));
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
    }
     
      private void insertarRegistroPrestamo()
        {
            Cconexion objetoConexion = new Cconexion(userName, password);
            String consulta = "Insert into Aula.Prestamo(numinv,clave_unica,rpe_empleado) VALUES(?,?,?);";
        
            try
            {
                
                String[] claveP = alumnoPrestamo.getSelectedItem().toString().split("-");
                String[] materiaP = equipoPrestamo.getSelectedItem().toString().split("-");
                String[] rpeP = empleadoPrestamo.getSelectedItem().toString().split("-");
              
                int lastId = obtenEquipo(materiaP[0],materiaP[1]);
                int lastId1 = obtenAlumno(claveP[0],claveP[1]);
                CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
                cs.setInt(1,lastId);
                   cs.setInt(2,lastId1);
                cs.setInt(3,Integer.parseInt(rpeP[0]));
                
                 cs.execute();
                
            }
            catch (Exception e)
            {
               
                //MessageBox.Show("ee" + ex.);
                  JOptionPane.showMessageDialog(null,"Error" + e.toString());
            }
        }

        public Integer obtenAlumno(String s1,String s2){
        Cconexion objetoConexion = new Cconexion(userName, password);
        Integer clav=0;
        String sql = "";
        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "SELECT Clave_Unica FROM Persona.Alumno WHERE Nombre=" + "'" + s1 + "'" + " AND Generacion=" + Integer.parseInt(s2) + "";
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[2];
        //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
        Statement st; 
        
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                clav=rs.getInt(1);
            }
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
        return clav;
    }
    
       public Integer obtenEquipo(String s1,String s2){
        Cconexion objetoConexion = new Cconexion(userName, password);
        String sql = "";
        Integer clavMat=0;
        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "SELECT numinv FROM Aula.Equipo WHERE Nombre=" + "'" + s1 + "' AND Modelo=" + "'" + s2 + "'";
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[2];
        //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
        Statement st; 
        
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                clavMat=rs.getInt(1);
            }
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
        return clavMat;
    }  
       
    public void seleccionarCar(JTable Equipo){
        try{
              
            int fila = datosPrestamo.getSelectedRow();
            if(fila >= 0)
            {                                
                idPrestamo=Integer.parseInt(datosPrestamo.getValueAt(fila,0).toString());
                rpeEmpleado= Integer.parseInt(datosPrestamo.getModel().getValueAt(fila,3).toString());
                ClaveAlumno=Integer.parseInt(datosPrestamo.getModel().getValueAt(fila,2).toString());
                ClaveEquipo = Integer.parseInt(datosPrestamo.getModel().getValueAt(fila,1).toString());
                
                empleadoPrestamo.setSelectedItem(datosPrestamo.getValueAt(fila,3).toString());
                equipoPrestamo.addItem(datosPrestamo.getValueAt(fila,1).toString());
                equipoPrestamo.setSelectedItem(datosPrestamo.getValueAt(fila,1).toString());
                alumnoPrestamo.setSelectedItem(datosPrestamo.getValueAt(fila,2).toString());
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }
    }
        
    public void EliminarPrestamo()
    {
        
        Cconexion objetoConexion = new Cconexion(userName, password);
        
        String consulta;
        try
        {
            consulta ="DELETE FROM Aula.BitacoraEntrega WHERE Id_Prestamo = ?;";
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);            
            cs.setInt(1,idPrestamo);
            cs.execute();
            
            consulta ="DELETE FROM Aula.Prestamo WHERE Id_Prestamo = ?;";  
            cs = objetoConexion.establecerConexion().prepareCall(consulta);                                                                     
            cs.setInt(1,idPrestamo);
            cs.execute();
                        
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }
    }
            
    public void ModificarPrestamo()
    {
        Cconexion objetoConexion = new Cconexion(userName, password);
        
        String consulta = "UPDATE Aula.Prestamo SET numinv = ? ,clave_unica = ?,rpe_empleado = ? WHERE Id_Prestamo = ? ;";
        //String consulta = "UPDATE persona.cliente SET nombre = '"+nombreMC+"', email ='"+emailMC+"', telefono = '"+telefonoMC+"', fechaNac = '"+fechaMC+"' WHERE id_cliente="+getIdcliente()+";";
        
        try
        {
              String[] claveP = alumnoPrestamo.getSelectedItem().toString().split("-");
                String[] materiaP =equipoPrestamo.getSelectedItem().toString().split("-");
                String[] rpeP = empleadoPrestamo.getSelectedItem().toString().split("-");
              
                int lastId = obtenEquipo(materiaP[0],materiaP[1]);
                int lastId1 = obtenAlumno(claveP[0],claveP[1]);
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
          
             cs.setInt(1,lastId);
              cs.setInt(3,Integer.parseInt(rpeP[0]));
            cs.setInt(2,lastId1);   
            cs.setInt(4,idPrestamo);
          
            cs.execute();
            //JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:" + e.toString());
        }
    }
     
     private void EliminaSeleccion(){
         equipoPrestamo.setSelectedIndex(0);
         alumnoPrestamo.setSelectedIndex(0);
         empleadoPrestamo.setSelectedIndex(0);
         LlenaEquipo();
         LlenaClavesAsistencia();
         LlenaRPEAsistencia();
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alumnoPrestamo = new javax.swing.JComboBox<>();
        empleadoPrestamo = new javax.swing.JComboBox<>();
        fechaEntrega = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datosPrestamo = new javax.swing.JTable();
        fechaPrestamo = new javax.swing.JTextField();
        equipoPrestamo = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Préstamo");

        fechaEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaEntregaActionPerformed(evt);
            }
        });

        jLabel1.setText("Equipo");

        jLabel2.setText("Alumno");

        jButton1.setText("Agregar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Empleado");

        jButton2.setText("Modificar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel4.setText("Fecha Préstamo");

        jButton3.setText("Eliminar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel5.setText("Fecha Entrega");

        datosPrestamo.setModel(new javax.swing.table.DefaultTableModel(
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
        datosPrestamo.setRowHeight(40);
        datosPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosPrestamoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(datosPrestamo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(equipoPrestamo, 0, 236, Short.MAX_VALUE)
                    .addComponent(empleadoPrestamo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alumnoPrestamo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechaPrestamo)
                    .addComponent(fechaEntrega))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(equipoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(alumnoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(empleadoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(fechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        insertarRegistroPrestamo();
        Mostrar(datosPrestamo);
        EliminaSeleccion();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[]clav = equipoPrestamo.getSelectedItem().toString().split("-");
        String cMat= empleadoPrestamo.getSelectedItem().toString();
        //claveTest.setText(cMatobtenAlumno(clav[0],clav[1]).toString);
        //obtenMateria(cMat);
        // claveTest.setText(ClaveMateria.toString());

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        ModificarPrestamo();
        Mostrar(datosPrestamo);
        EliminaSeleccion();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
       EliminarPrestamo();
       Mostrar(datosPrestamo);
       EliminaSeleccion();
    }//GEN-LAST:event_jButton3MouseClicked

    private void datosPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datosPrestamoMouseClicked
        // TODO add your handling code here:
        seleccionarCar(datosPrestamo);
    }//GEN-LAST:event_datosPrestamoMouseClicked

    private void fechaEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaEntregaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alumnoPrestamo;
    private javax.swing.JTable datosPrestamo;
    private javax.swing.JComboBox<String> empleadoPrestamo;
    private javax.swing.JComboBox<String> equipoPrestamo;
    private javax.swing.JTextField fechaEntrega;
    private javax.swing.JTextField fechaPrestamo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
