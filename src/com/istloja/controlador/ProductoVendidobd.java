/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;
import com.istdloja.modelo.ProductoVendido;
import com.istdloja.conexionbd.Conexion;
import com.istloja.utilidad.Utilidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author danielmora
 */
public class ProductoVendidobd {

    public boolean registrarProductosVendidos(ProductoVendido productoVendido) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql;
        sql = "INSERT INTO `bdEjercicio1`.`producto_vendido` (`inventario_id_invetario`, `nota_venta_id_nota_venta`, `cantidad_productos`, `valor_total`) VALUES ("
                + "'"+productoVendido.getInventarioIdInvetario()+"', "
                + "'"+productoVendido.getNotaVentaIdNotaVenta()+"', "
                + "'"+productoVendido.getCantidadProductos()+"', "
                + "'"+productoVendido.getValorTotal()+"');";
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
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    }
}
