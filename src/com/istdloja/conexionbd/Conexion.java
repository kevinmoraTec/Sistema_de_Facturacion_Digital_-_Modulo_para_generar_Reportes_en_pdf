package com.istdloja.conexionbd;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author danielmora
 */
public class Conexion {
    // Creamos variables locales para almacenar la direccion de la base de datos y las credeciales 
    
    private  static final String url="jdbc:mysql://localhost:8889/bdEjercicio1?autoReconnect=true&useSSL=false"; // la autoconeccion a mi base de datos sea verdadera
                                                                                                             
    private static final String usuario="root";
    private static final String contraseña="root";
    
    public static Connection conexionMysql(){ // Creamos una clase Connctions la cual nos retorna una conexion;
    
        Connection connexion=null; // Creamos un objeto de tipo Connection
        
        try {
            //  Class.forName ·"registra el driver de conexión para la base de datos. "
            Class.forName("com.mysql.jdbc.Driver");
            connexion = (Connection) DriverManager.getConnection(url, usuario, contraseña); // llamamos a driver manager y realizamos la conexion; 
            //JOptionPane.showMessageDialog(null,"Conexion Exitosa !");
            System.out.println("Conexion Exitosa !");
        }
        catch(Exception ex){
            System.out.println("Eror al conectar "+ex.getMessage()); // mostramos si temenmos un error al conctar 
            
        }
        return connexion;
    }
    
    
}
