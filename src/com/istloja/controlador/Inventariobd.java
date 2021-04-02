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
import com.istloja.utilidad.Utilidades;
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

    Utilidades utilidades;

    public Inventariobd() {
        utilidades = new Utilidades();
    }

    public boolean insertarProducto(Inventario inventario) { // Recibe como paraametro un iNVENTARIO
        boolean registrar = false;
        // Interfaz de acceso con la base de datos 
        Statement stm = null;
        // Conexion con la base de datos 
        Connection con = null;
        String sql;                                                                                                                                                                                                                                                                                                                                                              ///  `precio_compra_sin_iva`, `precio_compra_con_iva`, `precio_mayorista`, `precio_cliente_fijo`, `precio_cliente_normal`, `fecha_registro`
        if (inventario.getFecha_caducidad() == null) {
            sql = "INSERT INTO `bdEjercicio1`.`inventario` (`id_inventario`,`codigo_pro`, `descripcion`, `can_productos`, `precio_compra_sin_iva`, `precio_compra_con_iva`, `precio_mayorista`, `precio_cliente_fijo`, `precio_cliente_normal`, `fecha_registro`) VALUES ('" + inventario.getId_inventario() + "', '" + inventario.getCodigo_pro() + "', '" + inventario.getDescripcion() + "', '" + inventario.getCan_productos() + "', '" + inventario.getPrecios_compra_sin_iva() + "', '" + inventario.getPrecios_compra_con_iva() + "', '" + inventario.getPrecio_mayorista() + "', '" + inventario.getPrecio_cliente_fijo() + "', '" + inventario.getPrecio_cliente_normal() + "', '" + utilidades.devolverFecha(inventario.getFecha_registro()) + "');";

        } else {
            sql = "INSERT INTO `bdEjercicio1`.`inventario` (`id_inventario`,`codigo_pro`, `descripcion`, `can_productos`, `precio_compra_sin_iva`, `precio_compra_con_iva`, `precio_mayorista`, `precio_cliente_fijo`, `precio_cliente_normal`, `fecha_registro`, `fechaCaducidad`) VALUES ('" + inventario.getId_inventario() + "', '" + inventario.getCodigo_pro() + "', '" + inventario.getDescripcion() + "', '" + inventario.getCan_productos() + "', '" + inventario.getPrecios_compra_sin_iva() + "', '" + inventario.getPrecios_compra_con_iva() + "', '" + inventario.getPrecio_mayorista() + "', '" + inventario.getPrecio_cliente_fijo() + "', '" + inventario.getPrecio_cliente_normal() + "', '" + utilidades.devolverFecha(inventario.getFecha_registro()) + "', '" + utilidades.devolverFecha(inventario.getFecha_caducidad()) + "');";
        }

        try {
            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos (puente)
            stm.execute(sql);// Ejecutamos el comando sql 
            registrar = true;
            stm.close(); // cerramos la interfaz 
            con.close();// cerramos la conexion con la base de datos ;
        } catch (Exception ex) {
            System.out.println("Error en crearIventario (Iventariobd)" + ex.getMessage());

        }
        return registrar;
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
                c.setCan_productos(rs.getString(4));
                c.setPrecios_compra_sin_iva(rs.getDouble(5));
                c.setPrecios_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFecha_actualizacion(rs.getDate(11));
                c.setFecha_caducidad(rs.getDate(12));

                listainventario.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error metodo =List<Inventario> obtenerInventario (Inventariobd)" + ex.getMessage());

        }
        return listainventario;

    }

    public boolean actualizarInventario(Inventario inventario) {

        boolean registrar = false;
        Statement stm = null; // Sentencia sql para btener los resultados producidos por la base de datos 
        // Conexion con la base de datos 
        Connection con = null;

        String sql = "UPDATE `bdEjercicio1`.`inventario` SET `codigo_pro`='" + inventario.getCodigo_pro() + "', `descripcion`='" + inventario.getDescripcion() + "', `can_productos`='" + inventario.getCan_productos() + "', `precio_compra_sin_iva`='" + inventario.getPrecios_compra_sin_iva() + "', `precio_compra_con_iva`='" + inventario.getPrecios_compra_con_iva() + "', `precio_mayorista`='" + inventario.getPrecio_mayorista() + "', `precio_cliente_fijo`='" + inventario.getPrecio_cliente_fijo() + "', `precio_cliente_normal`='" + inventario.getPrecio_cliente_normal() + "', `fecha_registro`='" + utilidades.devolverFecha(inventario.getFecha_registro()) + "', `fecha_actualizados`='" + utilidades.devolverFecha(inventario.getFecha_actualizacion()) + "', `fechaCaducidad`='" + utilidades.devolverFecha(inventario.getFecha_caducidad()) + "' WHERE `id_inventario`='" + inventario.getId_inventario() + "';";

        try {
            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos 
            stm.execute(sql);// Ejecutamos el comando sql 
            registrar = true;
            stm.close(); // cerramos la interfaz 
            con.close();// cerramos la conexion con la base de datos ;
        } catch (Exception ex) {
            System.out.println("Error en actualizar (Inventariobd)" + ex.getMessage());

        }
        return registrar;
    }

    public boolean eliminarInventario(Inventario inventario) {

        boolean eliminar = false;

        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 

        Connection con = null; // conexion con la base de datos 

        String sql = "DELETE FROM `bdEjercicio1`.`inventario` WHERE `id_inventario`='" + inventario.getId_inventario() + "';";

        try {

            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos 
            stm.execute(sql);// Ejecutamos el comando sql
            eliminar = true;

        } catch (Exception ex) {
            System.out.println("Error Eliminar (Inventariobd) " + ex.getMessage());
        }
        return eliminar;
    }
        public Inventario getInventarioParaCodigo(String codigo) {
        Connection co = null; // Coneccion con la base de datos 
        Statement stm = null;//  Preparar los datos de la base de datos
        ResultSet rs = null;// Obtener los datos de la base de datos 
        Inventario c = null;

        String sql = "SELECT * FROM bdEjercicio1.inventario where codigo_pro like \"%" + codigo + "%\"";

        try {
            co = new Conexion().conexionMysql();// conectamos la base de daatos
            stm = co.createStatement(); // el cvalor inicial para coorer la sentencia 
            rs = stm.executeQuery(sql);// Corremos la Sentencia 
            while (rs.next()) {// recorre ls datos de la base de datos  ("Si no entra al metodo nos da una Persona VACIA ")
                c = new Inventario(); // Instancion Una Persona ;
                c.setId_inventario(rs.getInt(1));// rs. Trae wl resultado de la base de datos 
                c.setCodigo_pro(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setCan_productos(rs.getString(4));
                c.setPrecios_compra_sin_iva(rs.getDouble(5));
                c.setPrecios_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFecha_actualizacion(rs.getDate(11));
                c.setFecha_caducidad(rs.getDate(12));
            }

            stm.close();// Cierra la interfaz
            rs.close();// Cieree el resultado con la base de datos 
            co.close();;//Cierra  la coneccion

        } catch (Exception ex) {
            System.out.println("Error ::5::" + ex.getMessage());

        }
        return c;
    }

        public List<Inventario> obetenerProdctoInventarioCodgo(String codigo) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.inventario where codigo_pro like \"%" + codigo + "%\"";

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
                c.setCan_productos(rs.getString(4));
                c.setPrecios_compra_sin_iva(rs.getDouble(5));
                c.setPrecios_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFecha_actualizacion(rs.getDate(11));
                c.setFecha_caducidad(rs.getDate(12));

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

    public List<Inventario> obetenerProdctoInventarioDescripcion(String descripcion) {
        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.inventario where descripcion like \"%" + descripcion + "%\"";

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
                c.setCan_productos(rs.getString(4));
                c.setPrecios_compra_sin_iva(rs.getDouble(5));
                c.setPrecios_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFecha_actualizacion(rs.getDate(11));
                c.setFecha_caducidad(rs.getDate(12));
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

    public List<Inventario> obetenerProdctoInventarioCompraSinIva(String precio_compra_sin_iva) {
        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.inventario where precio_compra_sin_iva like \"%" + precio_compra_sin_iva + "%\"";

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
                c.setCan_productos(rs.getString(4));
                c.setPrecios_compra_sin_iva(rs.getDouble(5));
                c.setPrecios_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFecha_actualizacion(rs.getDate(11));
                c.setFecha_caducidad(rs.getDate(12));
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

    public List<Inventario> obetenerProdctoInventarioCompraConIva(String precio_compra_con_iva) {
        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.inventario where precio_compra_con_iva like \"%" + precio_compra_con_iva + "%\"";

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
                c.setCan_productos(rs.getString(4));
                c.setPrecios_compra_sin_iva(rs.getDouble(5));
                c.setPrecios_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFecha_actualizacion(rs.getDate(11));
                c.setFecha_caducidad(rs.getDate(12));
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

    public List<Inventario> obetenerProdctoInventarioCantidad(String can_productos) {
        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.inventario where can_productos like \"%" + can_productos + "%\"";

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
                c.setCan_productos(rs.getString(4));
                c.setPrecios_compra_sin_iva(rs.getDouble(5));
                c.setPrecios_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFecha_actualizacion(rs.getDate(11));
                c.setFecha_caducidad(rs.getDate(12));
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
