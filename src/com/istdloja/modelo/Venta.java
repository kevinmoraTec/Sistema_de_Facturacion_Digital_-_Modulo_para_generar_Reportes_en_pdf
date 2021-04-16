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
public class Venta {
    
    private int cantidad;
    private String descripcioPventa;
    private double subtotal;
    private double total;

    public Venta() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcioPventa() {
        return descripcioPventa;
    }

    public void setDescripcioPventa(String descripcioPventa) {
        this.descripcioPventa = descripcioPventa;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
