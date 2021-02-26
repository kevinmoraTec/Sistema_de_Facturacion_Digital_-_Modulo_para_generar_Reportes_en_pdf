/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;

import com.istdloja.conexionbd.Conexion;
import com.istdloja.modelo.Inventario;
import com.istdloja.modelo.Persona;
import com.istdloja.modelo.Provedores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielmora
 */
public class Inventariobd {

    public boolean insertarProducto(Inventario inventario) { // Recibe como paraametro un iNVENTARIO
        boolean registrar = false;
        // Interfaz de acceso con la base de datos 
        Statement stm = null;
        // Conexion con la base de datos 
        Connection con = null;

        String sql = "INSERT INTO `bdEjercicio1`.`inventario` (`codigo_pro`, `descripcion`, `precio_compra`, `precio_venta`, `can_productos`) VALUES ('" + inventario.getCodigo_pro() + "', '" + inventario.getDescripcion() + "', '" + inventario.getPrecio_compra() + "', '" + inventario.getPrecio_venta() + "', '" + inventario.getCan_productos() + "');";

        try {
            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos (puente)
            stm.execute(sql);// Ejecutamos el comando sql 
            registrar = true;
            stm.close(); // cerramos la interfaz 
            con.close();// cerramos la conexion con la base de datos ;
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return registrar;
    }

    public boolean actualizarInventario(Inventario inventario) {

        boolean registrar = false;
        Statement stm = null; // Sentencia sql para btener los resultados producidos por la base de datos 
        // Conexion con la base de datos 
        Connection con = null;

        String sql = "UPDATE `bdEjercicio1`.`inventario` SET `codigo_pro`='" + inventario.getCodigo_pro() + "', `descripcion`='" + inventario.getDescripcion() + "', `precio_compra`='" + inventario.getPrecio_compra() + "', `precio_venta`='" + inventario.getPrecio_venta() + "', `can_productos`='" + inventario.getCan_productos() + "' WHERE `id_inventario`='" + inventario.getId_inventario() + "';";

        try {
            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos 
            stm.execute(sql);// Ejecutamos el comando sql 
            registrar = true;
            stm.close(); // cerramos la interfaz 
            con.close();// cerramos la conexion con la base de datos ;
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return registrar;
    }

    public boolean eliminarInventario(Inventario inventario) {

        boolean eliminar = false;

        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 

        Connection con = null; // conexion con la base de datos 

        String sql = "DELETE FROM `bdEjercicio1`.`inventario` WHERE `id_inventario`='"+inventario.getId_inventario()+"';";

        try {

            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos 
            stm.execute(sql);// Ejecutamos el comando sql
            eliminar = true;

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return eliminar;
    }
    
    public List<Inventario> obtenerInventario() {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.inventario;";

        List<Inventario> listainventario = new ArrayList<Inventario>();

        try {
            co = new Conexion().conexionMysql();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                Inventario c = new Inventario();
                c.setId_inventario(rs.getInt(1));// rs. Trae wl resultado de la base de datos 
                c.setCodigo_pro(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setPrecio_compra(rs.getString(4));
                c.setPrecio_venta(rs.getString(5));
                c.setCan_productos(rs.getString(6));
             
                listainventario.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listainventario;

    }

}
