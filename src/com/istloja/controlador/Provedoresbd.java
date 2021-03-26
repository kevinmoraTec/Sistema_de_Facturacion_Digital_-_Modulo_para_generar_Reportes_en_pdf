package com.istloja.controlador;

import com.istdloja.conexionbd.Conexion;
import com.istdloja.modelo.Persona;
import com.istdloja.modelo.Provedores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.management.StringValueExp;

/**
 *
 * @author danielmora
 */
public class Provedoresbd {

    public boolean registrarProvedores(Provedores provedores) {

        boolean registrar = false;
        // interfas de acceso con la base de datos
        Statement stm = null;
        //conexion con la base de datos
        Connection con = null;
        String sql = "INSERT INTO `bdEjercicio1`.`proveedores` (`ruc`, `razon_social`, `tipo_actividad`, `nombre_representante_legal`, `apellido_representante_legal`, `telefono`, `correo`, `direccion`, `fechaVencimientoDeuda`, `fechaRegistro`) VALUES ('" + provedores.getRuc() + "', '" + provedores.getRazonSocial() + "', '" + provedores.getTipoActividad() + "', '" + provedores.getNombreRepresentanteLegal() + "', '" + provedores.getApellidoRepresentanteLegal() + "', '" + provedores.getTelefono() + "', '" + provedores.getCorreo() + "',, '" + provedores.getDireccion() + "',, '" + provedores.getFechaVencimientoDeuda() + "',, '" + provedores.getFechaRegistro()+ "');";

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

    public boolean actualizarProvedores(Provedores provedores) {

        boolean registrar = false;
        Statement stm = null; // Sentencia sql para btener los resultados producidos por la base de datos 
        // Conexion con la base de datos 
        Connection con = null;

        String sql = "UPDATE `bdEjercicio1`.`proveedores` SET `ruc`='" + provedores.getRuc() + "', `razon_social`='" + provedores.getRazonSocial() + "', `tipo_actividad`='" + provedores.getTipoActividad() + "', `nombre_representante_legal`='" + provedores.getNombreRepresentanteLegal() + "', `apellido_representante_legal`='" + provedores.getApellidoRepresentanteLegal() + "', `telefono`='" + provedores.getTelefono() + "', `correo`='" + provedores.getCorreo() + "', direccion`='" + provedores.getDireccion() + "', `fechaVencimientoDeuda`='" + provedores.getFechaVencimientoDeuda() + "', `fechaRegistro`='" + provedores.fechaActualProvedores() + "' WHERE `id_proveedores`='" + provedores.getIdProvedores() + "';";

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

    public boolean eliminarProvedores(Provedores provedores) {

        boolean eliminar = false;

        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 

        Connection con = null; // conexion con la base de datos 

        String sql = "DELETE FROM `bdEjercicio1`.`proveedores` WHERE `id_proveedores`='" + provedores.getIdProvedores() + "';";

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
     public List<Provedores> obtenerProvedores() {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.proveedores;";

        List<Provedores> listaprovedores = new ArrayList<Provedores>();

        try {
            co = new Conexion().conexionMysql();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                Provedores c = new Provedores();
                c.setIdProvedores(rs.getInt(1));// rs. Trae wl resultado de la base de datos 
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombreRepresentanteLegal(rs.getString(5));
                c.setApellidoRepresentanteLegal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFechaVencimientoDeuda(rs.getDate(10));
                c.setFechaRegistro(rs.getDate(11));

                listaprovedores.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listaprovedores;

    }

}
