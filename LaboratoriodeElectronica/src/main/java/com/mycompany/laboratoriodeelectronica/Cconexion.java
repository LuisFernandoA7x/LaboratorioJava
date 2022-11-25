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
    
    private String usuario = "postgres";
    private String contrasenia = "postgres";
    private String bd = "Laboratorio";
    private String ip = "localhost";
    private String Puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+Puerto+"/"+bd;

    public Cconexion(String user, String password){
        usuario = user;
        contrasenia = password;                
    }
    public Cconexion(){
        
    }
    //mofificar constructor de conexion para que reciba por parametro el usuario y contraseña
    public Connection establecerConexion()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error: Usuario o contraseña incorrectos");
        }
        return conectar;
    }
}


