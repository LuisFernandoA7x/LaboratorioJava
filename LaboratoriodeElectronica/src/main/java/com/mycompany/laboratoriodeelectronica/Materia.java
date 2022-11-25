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
public class Materia extends javax.swing.JInternalFrame {
    public int claveMateriaAntiguo=0;
    /**
     * Creates new form Materia
     */
    private String userName;
    private String password;
    
    public Materia(String user, String passwrd) {
        initComponents();
        userName = user;
        password = passwrd;
        Mostrar(datosMateria);
    }

     public void insertarMateria()
    {
        
        
        Cconexion objetoConexion = new Cconexion(userName, password);
        //donde se guarda la consulta 
        String consulta = "Insert into Aula.Materia(clavemateria,Nombre,Nivel) VALUES(?,?,?);";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1,Integer.parseInt(claveMateria.getText()));
            cs.setString(2,nombreMateria.getText());
            cs.setInt(3,Integer.parseInt(nivelMateria.getText()));
          
            cs.execute();
            //JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }
    }
     
      public void Mostrar(JTable paramCliente)
    {
        Cconexion objetoConexion = new Cconexion(userName, password);
        
        //incorporar modelo a la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        modelo.addColumn("Clave Materia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nivel");

        //aqui solo se le da nombre a las columnas
        paramCliente.setModel(modelo);
        
        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "Select * from Aula.Materia;";
        
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[3];
        //para que se ejecute la consulta , y debemos de importar  import java.sql.Statement;
        Statement st; 
        
        try
        {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next())
            {
                //guarda los valores duvueltos de la consulta
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
           
                //aqui se incorporan los datos
                modelo.addRow(datos);
            }
            paramCliente.setModel(modelo);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+ e.toString());
        }
    }
      
        public void seleccionarCar(JTable Equipo)
    {
        try
        {
              
            int fila = Equipo.getSelectedRow();
            if(fila >= 0)
            {
                //(Cliente.getValueAt(fila, 0).toString());
                claveMateriaAntiguo =Integer.parseInt( Equipo.getValueAt(fila,0).toString());
                claveMateria.setText(Equipo.getValueAt(fila,0).toString());
                nombreMateria.setText(Equipo.getValueAt(fila,1).toString());
                nivelMateria.setText(Equipo.getValueAt(fila,2).toString());
            
                //descripcionEquipo.setText(Equipo.getValueAt(fila,7).toString());
                //String spl[]=Equipo.getValueAt(fila,4).toString().split("-");
                
                
                //fechaSC.setDate(date1);
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
            
                  
            //JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }
    }
    
    public void ModificarMateria()
    {
       

        Cconexion objetoConexion = new Cconexion(userName, password);
        
        String consulta = "UPDATE Aula.Materia SET clavemateria =?, Nombre =?, Nivel =? WHERE clavemateria=?;";
        //String consulta = "UPDATE persona.cliente SET nombre = '"+nombreMC+"', email ='"+emailMC+"', telefono = '"+telefonoMC+"', fechaNac = '"+fechaMC+"' WHERE id_cliente="+getIdcliente()+";";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
          
             cs.setInt(1,Integer.parseInt(claveMateria.getText()));
            cs.setString(2,nombreMateria.getText());
            cs.setInt(3,Integer.parseInt(nivelMateria.getText()));
            cs.setInt(4,claveMateriaAntiguo);
          
            cs.execute();
            //JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:" + e.toString());
        }
    }
    
    public void EliminarMateria()
    {
        
        Cconexion objetoConexion = new Cconexion(userName, password);
        
        String consulta ="DELETE FROM Aula.Materia WHERE clavemateria = ?;";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1,claveMateriaAntiguo);
            cs.execute();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        datosMateria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        claveMateria = new javax.swing.JTextField();
        nombreMateria = new javax.swing.JTextField();
        nivelMateria = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setMaximizable(true);
        setResizable(true);
        setTitle("Materia");

        datosMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        datosMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosMateriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(datosMateria);

        jLabel1.setText("Clave Materia");

        jLabel2.setText("Nombre");

        jLabel3.setText("Nivel");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(claveMateria)
                            .addComponent(nombreMateria)
                            .addComponent(nivelMateria, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(claveMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nivelMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datosMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datosMateriaMouseClicked
        // TODO add your handling code here:
        seleccionarCar(datosMateria);
    }//GEN-LAST:event_datosMateriaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertarMateria();
        clearFormMateria();
        Mostrar(datosMateria);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void clearFormMateria(){
        claveMateria.setText("");
        nombreMateria.setText("");
        nivelMateria.setText("");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ModificarMateria();
        clearFormMateria();
        Mostrar(datosMateria);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       EliminarMateria();
       clearFormMateria();
       Mostrar(datosMateria);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField claveMateria;
    private javax.swing.JTable datosMateria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nivelMateria;
    private javax.swing.JTextField nombreMateria;
    // End of variables declaration//GEN-END:variables
}
