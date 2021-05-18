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
        sql ="INSERT INTO `bdEjercicio1`.`nota_venta` (`numero_nota_venta`, `id_persona`, `fecha_venta`, `sub_total`, `iva`, `total`, `tipo_de_pago`) "
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
          
     public Nota_de_venta idRegistrarNotaVenta(Nota_de_venta nota_de_venta){
         boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT * FROM bdEjercicio1.nota_venta where numero_nota_venta like " + nota_de_venta.getNumeroNotaVenta() + ";";
        try {
            Conexion conexion = new Conexion();
            con = conexion.conexionMysql();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                nota_de_venta.setIdNotaVenta(rs.getInt("id_nota_venta"));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del producto:" + e.getMessage());
        }

        return nota_de_venta;
     
     }     
          
    
    
}
