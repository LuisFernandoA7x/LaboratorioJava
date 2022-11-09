/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratoriodeelectronica;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class Equipo extends javax.swing.JInternalFrame {
    public int NumInvEquipo=0;
    /**
     * Creates new form Equipo
     */
    public Equipo() {
        initComponents();
        Mostrar(datosEquipo);
    }

     public void insertarEquipo()
    {
        
        
        Cconexion objetoConexion = new Cconexion();
        //donde se guarda la consulta 
        String consulta = "Insert into Aula.Equipo(Nombre,Modelo,Descripcion,UbicacionEnLab,Marca,TipoEquipo) VALUES(?,?,?,?,?,?);";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,nombreEquipo.getText());
            cs.setString(2,modeloEquipo.getText());
            cs.setString(3,descripcionEquipo.getText());
            cs.setString(4,ubicacionEquipo.getText());
            cs.setString(5,marcaEquipo.getText());
            cs.setString(6, (String) tipoEquipo.getSelectedItem());
            cs.execute();
            //JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }
    }
     
      public void Mostrar(JTable paramCliente)
    {
        Cconexion objetoConexion = new Cconexion();
        
        //incorporar modelo a la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        modelo.addColumn("NumInv");
        modelo.addColumn("Nombre");
        modelo.addColumn("Modelo");
        modelo.addColumn("Descripción");
        modelo.addColumn("Ubicación");
        modelo.addColumn("Marca");
        modelo.addColumn("Tipo");
        //aqui solo se le da nombre a las columnas
        paramCliente.setModel(modelo);
        
        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "Select * from Aula.Equipo;";
        
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[7];
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
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
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
                NumInvEquipo =Integer.parseInt( Equipo.getValueAt(fila,0).toString());
                nombreEquipo.setText(Equipo.getValueAt(fila,1).toString());
                modeloEquipo.setText(Equipo.getValueAt(fila,2).toString());
                descripcionEquipo.setText(Equipo.getValueAt(fila,3).toString());
                ubicacionEquipo.setText(Equipo.getValueAt(fila,4).toString());
                marcaEquipo.setText(Equipo.getValueAt(fila,5).toString());
                //tipoEquipo.setText(Equipo.getValueAt(fila,6).toString());
                tipoEquipo.setSelectedItem(Equipo.getValueAt(fila,6).toString());
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
    
    public void ModificarEquipo()
    {
       

        Cconexion objetoConexion = new Cconexion();
        
        String consulta = "UPDATE Aula.Equipo SET Nombre =?, Modelo =?, Descripcion =?, UbicacionEnLab =?,Marca=?,TipoEquipo=? WHERE NumInv=?;";
        //String consulta = "UPDATE persona.cliente SET nombre = '"+nombreMC+"', email ='"+emailMC+"', telefono = '"+telefonoMC+"', fechaNac = '"+fechaMC+"' WHERE id_cliente="+getIdcliente()+";";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
          
             cs.setString(1,nombreEquipo.getText());
            cs.setString(2,modeloEquipo.getText());
            cs.setString(3,descripcionEquipo.getText());
            cs.setString(4,ubicacionEquipo.getText());
            cs.setString(5,marcaEquipo.getText());
            cs.setString(6, (String) tipoEquipo.getSelectedItem());
             cs.setInt(7, NumInvEquipo);
            cs.execute();
            //JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:" + e.toString());
        }
    }
    
    public void EliminarEquipo()
    {
        
        Cconexion objetoConexion = new Cconexion();
        
        String consulta ="DELETE FROM Aula.Equipo WHERE NumInv = ?;";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1,NumInvEquipo);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombreEquipo = new javax.swing.JTextField();
        modeloEquipo = new javax.swing.JTextField();
        descripcionEquipo = new javax.swing.JTextField();
        ubicacionEquipo = new javax.swing.JTextField();
        marcaEquipo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        datosEquipo = new javax.swing.JTable();
        tipoEquipo = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Nombre");

        jLabel2.setText("Modelo");

        jLabel3.setText("Descripción");

        jLabel4.setText("Ubicación");

        jLabel5.setText("Marca");

        jLabel6.setText("Tipo");

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

        datosEquipo.setModel(new javax.swing.table.DefaultTableModel(
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
        datosEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosEquipoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(datosEquipo);

        tipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Multimetro", "Fuente de Voltaje", "Osciloscopio", "Pinzas de corte" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(81, 81, 81)
                                        .addComponent(ubicacionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(descripcionEquipo))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tipoEquipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 293, Short.MAX_VALUE)
                                                    .addComponent(marcaEquipo, javax.swing.GroupLayout.Alignment.TRAILING)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(96, 96, 96)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreEquipo)
                                            .addComponent(modeloEquipo))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(361, 361, 361))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(modeloEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descripcionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ubicacionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(marcaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tipoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        insertarEquipo();
        Mostrar(datosEquipo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ModificarEquipo();
        Mostrar(datosEquipo);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        EliminarEquipo();
        Mostrar(datosEquipo);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void datosEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datosEquipoMouseClicked
        // TODO add your handling code here:
        seleccionarCar(datosEquipo);
    }//GEN-LAST:event_datosEquipoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable datosEquipo;
    private javax.swing.JTextField descripcionEquipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField marcaEquipo;
    private javax.swing.JTextField modeloEquipo;
    private javax.swing.JTextField nombreEquipo;
    private javax.swing.JComboBox<String> tipoEquipo;
    private javax.swing.JTextField ubicacionEquipo;
    // End of variables declaration//GEN-END:variables
}
