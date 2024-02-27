/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author ESPE
 */
public class Conexion {
    
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/listaatletas";
     
    Connection conectar = null;
    
    public Connection conexion(){
        try{
            Class.forName(driver);
            conectar=(Connection) DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de conexion"+e.getMessage());
                }
        return conectar;
    } 
 }

