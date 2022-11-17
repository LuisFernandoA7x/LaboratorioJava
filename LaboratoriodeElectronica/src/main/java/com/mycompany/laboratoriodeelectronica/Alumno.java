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
public class Alumno extends javax.swing.JInternalFrame {
    public int claveAlumnoAntigua=0;
    /**
     * Creates new form Alumno
     */
    public Alumno() {
        initComponents();
        Mostrar(datosAlumno);
        jLabel5.setVisible(false);
        adeudoAlumno.setVisible(false);
    }

    public void insertarAlumno()
    {
        
        
        Cconexion objetoConexion = new Cconexion();
        //donde se guarda la consulta 
        String consulta = "Insert into Persona.Alumno(Clave_Unica,Nombre,Generacion,Carrera,Adeudo) VALUES(?,?,?,?,?);";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1,Integer.parseInt(claveAlumno.getText()));
            cs.setString(2,nombreAlumno.getText());
            cs.setInt(3,Integer.parseInt(generacionAlumno.getText()));
            cs.setString(4,carreraAlumno.getText());
            cs.setInt(5, 0);
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
        modelo.addColumn("Clave_Única");
        modelo.addColumn("Nombre");
        modelo.addColumn("Generación");
        modelo.addColumn("Carrera");
        modelo.addColumn("Adeudo");
        //aqui solo se le da nombre a las columnas

        //CONSULTA PARA MOSTRAR LA INFORMACION DE LA TABLA
        sql = "Select * from Persona.Alumno;";
        
        //es un arrgelo para la longitud de la tabla (columnas)
        String [] datos = new String[5];
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
                claveAlumnoAntigua =Integer.parseInt( Equipo.getValueAt(fila,0).toString());
                claveAlumno.setText(Equipo.getValueAt(fila,0).toString());
                nombreAlumno.setText(Equipo.getValueAt(fila,1).toString());
                generacionAlumno.setText(Equipo.getValueAt(fila,2).toString());
                carreraAlumno.setText(Equipo.getValueAt(fila,3).toString());
               // adeudoAlumno.setText(Equipo.getValueAt(fila,5).toString());
                //tipoEquipo.setText(Equipo.getValueAt(fila,6).toString());
                  jLabel5.setVisible(false);
                  adeudoAlumno.setVisible(false);
                
                adeudoAlumno.setEditable(false);
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
    
    public void ModificarAlumno()
    {
       

        Cconexion objetoConexion = new Cconexion();
        
        String consulta = "UPDATE Persona.Alumno SET Clave_Unica =?, Nombre =?, Generacion =?, Carrera =? WHERE Clave_Unica=?;";
        //String consulta = "UPDATE persona.cliente SET nombre = '"+nombreMC+"', email ='"+emailMC+"', telefono = '"+telefonoMC+"', fechaNac = '"+fechaMC+"' WHERE id_cliente="+getIdcliente()+";";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
          
             cs.setInt(1,Integer.parseInt(claveAlumno.getText()));
            cs.setString(2,nombreAlumno.getText());
            cs.setInt(3,Integer.parseInt(generacionAlumno.getText()));
            cs.setString(4,carreraAlumno.getText());
            cs.setInt(5,claveAlumnoAntigua);
            cs.execute();
            //JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:" + e.toString());
        }
    }
    
    public void EliminarAlumno()
    {
        
        Cconexion objetoConexion = new Cconexion();
        
        String consulta ="DELETE FROM Persona.Alumno WHERE Clave_Unica = ?;";
        
        try
        {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1,Integer.parseInt(claveAlumno.getText()));
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
        datosAlumno = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        claveAlumno = new javax.swing.JTextField();
        nombreAlumno = new javax.swing.JTextField();
        generacionAlumno = new javax.swing.JTextField();
        carreraAlumno = new javax.swing.JTextField();
        adeudoAlumno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setMaximizable(true);
        setResizable(true);
        setTitle("Alumno");

        datosAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        datosAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosAlumnoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(datosAlumno);

        jLabel1.setText("Clave_Unica");
        jLabel1.setToolTipText("");

        jLabel2.setText("Nombre");

        jLabel3.setText("Generación");

        jLabel4.setText("Carrera");

        jLabel5.setText("Adeudo");

        nombreAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAlumnoActionPerformed(evt);
            }
        });

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
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(claveAlumno)
                            .addComponent(nombreAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(generacionAlumno)
                            .addComponent(carreraAlumno)
                            .addComponent(adeudoAlumno))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(claveAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(generacionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(carreraAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adeudoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datosAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datosAlumnoMouseClicked
        // TODO add your handling code here:
        seleccionarCar(datosAlumno);
    }//GEN-LAST:event_datosAlumnoMouseClicked

    private void nombreAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreAlumnoActionPerformed
    private void clearFormAlumno(){
        claveAlumno.setText("");
        nombreAlumno.setText("");
        generacionAlumno.setText("");
        carreraAlumno.setText("");
        adeudoAlumno.setText("");
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           insertarAlumno();           
           Mostrar(datosAlumno);
           clearFormAlumno();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ModificarAlumno();
        Mostrar(datosAlumno);
        clearFormAlumno();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       EliminarAlumno();
       clearFormAlumno();
       Mostrar(datosAlumno);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adeudoAlumno;
    private javax.swing.JTextField carreraAlumno;
    private javax.swing.JTextField claveAlumno;
    private javax.swing.JTable datosAlumno;
    private javax.swing.JTextField generacionAlumno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombreAlumno;
    // End of variables declaration//GEN-END:variables
}
