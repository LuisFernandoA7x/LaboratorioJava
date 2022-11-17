/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratoriodeelectronica;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Cconexion {
    
     Connection  conectar = null;
    
    String usuario = "postgres";
    String contrasenia = "postgres";
    String bd = "Laboratorio";
    String ip = "localhost";
    String Puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+Puerto+"/"+bd;
    
    public Connection establecerConexion()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null,"Se conecto correctamente a la base de datos ");
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos,"+ e.toString());
        }
        return conectar;
    }
}


