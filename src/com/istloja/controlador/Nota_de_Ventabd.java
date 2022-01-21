package com.istloja.controlador;

import com.istdloja.conexionbd.Conexion;
import com.istdloja.modelo.Nota_de_venta;
import com.istloja.utilidad.Utilidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author danielmora
 */
public class Nota_de_Ventabd {
     public Utilidades utilidades;

    public Nota_de_Ventabd() {
        utilidades = new Utilidades();
    }
    
    
     public boolean registrarNotaVenta(Nota_de_venta notaVenta) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql;
        //INSERT INTO `bdEjercicio1`.`nota_venta` (`id_nota_venta`, `numero_nota_venta`, `persona_id_persona`, `fecha_venta`, `sub_total`, `iva`, `total`, `tipo_de_pago`) VALUES ('1', '1', '8', '2019-09-09', '2.40', '3.90', '3.00', '1');

        sql ="INSERT INTO `bdEjercicio1`.`nota_venta` (`numero_nota_venta`, `persona_id_persona`, `fecha_venta`, `sub_total`, `iva`, `total`, `tipo_de_pago`) "
                + "VALUES "
                + "('"+notaVenta.getNumeroNotaVenta()+"',"
                + " '"+notaVenta.getPersonaIdPersona()+"', "
                + "'"+utilidades.devolverFecha(notaVenta.getFechaVenta())+"',"
                + " '"+notaVenta.getSubTotal()+"',"
                + " '"+notaVenta.getIva()+"', "
                + "'"+notaVenta.getTotal()+"',"
                + " '"+notaVenta.getTipoPago()+"');";
        try {
            //Es una instancia de la conexion previamente creada.
            Conexion conexion = new Conexion();
            con = conexion.conexionMysql();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error registrarNotaVenta (Nota de VentaBd): " + e.getMessage());
        }
        return registrar;
    }
     
          public boolean productoVendido(Nota_de_venta notaVenta) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql;
        sql ="INSERT INTO `ejercicio`.`nota_venta` (`numero_nota_venta`, `id_persona`, `fecha_venta`, `sub_total`, `iva`, `total`, `tipo_pago`) "
                + "VALUES "
                + "('"+notaVenta.getNumeroNotaVenta()+"',"
                + " '"+notaVenta.getPersonaIdPersona()+"', "
                + "'"+utilidades.devolverFecha(notaVenta.getFechaVenta())+"',"
                + " '"+notaVenta.getSubTotal()+"',"
                + " '"+notaVenta.getIva()+"', "
                + "'"+notaVenta.getTotal()+"',"
                + " '"+notaVenta.getTipoPago()+"');";
        try {
            //Es una instancia de la conexion previamente creada.
            Conexion conexion = new Conexion();
            con = conexion.conexionMysql();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error ProductoVendido: (Nota de VentaBd) " + e.getMessage());
        }
        return registrar;
    }
          
     public int idRegistrarNotaVenta(){
         int ultimoidNotaVenta = 0;
         boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;
        String sql;
        sql = "select max(id_nota_venta) from nota_venta;";
        try {
            Conexion conexion = new Conexion();
            con = conexion.conexionMysql();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
               ultimoidNotaVenta =rs.getInt(1);
                System.out.println(ultimoidNotaVenta);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del producto:" + e.getMessage());
        }

        return ultimoidNotaVenta;
     
     }     
     
     public String NotaVentaSerie_Generar(){
         String num_serie="";
         boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;
        String sql;
        sql = "select max(numero_nota_venta) from nota_venta;";
        try {
            Conexion conexion = new Conexion();
            con = conexion.conexionMysql();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                num_serie = rs.getNString(1);
                
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del producto:" + e.getMessage());
        }

        return num_serie;
     
     }     
          
    
    
}
