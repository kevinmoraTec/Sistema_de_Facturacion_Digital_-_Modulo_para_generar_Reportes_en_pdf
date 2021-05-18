/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istdloja.modelo;

/**
 *
 * @author danielmora
 */
public class ProductoVendido {
    
    private int idProductoVendido;
    private int inventarioIdInvetario;
    private int notaVentaIdNotaVenta;
    private int cantidadProductos;
    private double valorTotal;

    public int getIdProductoVendido() {
        return idProductoVendido;
    }

    public void setIdProductoVendido(int idProductoVendido) {
        this.idProductoVendido = idProductoVendido;
    }

    public int getInventarioIdInvetario() {
        return inventarioIdInvetario;
    }

    public void setInventarioIdInvetario(int inventarioIdInvetario) {
        this.inventarioIdInvetario = inventarioIdInvetario;
    }

    public int getNotaVentaIdNotaVenta() {
        return notaVentaIdNotaVenta;
    }

    public void setNotaVentaIdNotaVenta(int notaVentaIdNotaVenta) {
        this.notaVentaIdNotaVenta = notaVentaIdNotaVenta;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
