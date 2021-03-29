/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istdloja.modelo;

import java.util.Date;

/**
 *
 * @author danielmora
 */
public class Inventario { // creamos mi modelo de inventario con geters y seter y el contructor 
   private int id_inventario;
   private String codigo_pro;
   private String can_productos;
   private String descripcion;
    private double precios_compra_sin_iva;
    private double precios_compra_con_iva;
    private double precio_mayorista;
    private double precio_cliente_fijo;
    private double precio_cliente_normal;
    private Date fecha_caducidad;
    private Date fecha_registro;
    private Date fecha_actualizacion;
   

    public Inventario() {
    }

    public Inventario(int id_inventario, String codigo_pro, String can_productos, String descripcion, double precios_compra_sin_iva, double precios_compra_con_iva, double precio_mayorista, double precio_cliente_fijo, double precio_cliente_normal, Date fecha_caducidad, Date fecha_registro, Date fecha_actualizacion) {
        this.id_inventario = id_inventario;
        this.codigo_pro = codigo_pro;
        this.can_productos = can_productos;
        this.descripcion = descripcion;
        this.precios_compra_sin_iva = precios_compra_sin_iva;
        this.precios_compra_con_iva = precios_compra_con_iva;
        this.precio_mayorista = precio_mayorista;
        this.precio_cliente_fijo = precio_cliente_fijo;
        this.precio_cliente_normal = precio_cliente_normal;
        this.fecha_caducidad = fecha_caducidad;
        this.fecha_registro = fecha_registro;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getCodigo_pro() {
        return codigo_pro;
    }

    public void setCodigo_pro(String codigo_pro) {
        this.codigo_pro = codigo_pro;
    }

    public String getCan_productos() {
        return can_productos;
    }

    public void setCan_productos(String can_productos) {
        this.can_productos = can_productos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecios_compra_sin_iva() {
        return precios_compra_sin_iva;
    }

    public void setPrecios_compra_sin_iva(double precios_compra_sin_iva) {
        this.precios_compra_sin_iva = precios_compra_sin_iva;
    }

    public double getPrecios_compra_con_iva() {
        return precios_compra_con_iva;
    }

    public void setPrecios_compra_con_iva(double precios_compra_con_iva) {
        this.precios_compra_con_iva = precios_compra_con_iva;
    }

    public double getPrecio_mayorista() {
        return precio_mayorista;
    }

    public void setPrecio_mayorista(double precio_mayorista) {
        this.precio_mayorista = precio_mayorista;
    }

    public double getPrecio_cliente_fijo() {
        return precio_cliente_fijo;
    }

    public void setPrecio_cliente_fijo(double precio_cliente_fijo) {
        this.precio_cliente_fijo = precio_cliente_fijo;
    }

    public double getPrecio_cliente_normal() {
        return precio_cliente_normal;
    }

    public void setPrecio_cliente_normal(double precio_cliente_normal) {
        this.precio_cliente_normal = precio_cliente_normal;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id_inventario=" + id_inventario + ", codigo_pro=" + codigo_pro + ", can_productos=" + can_productos + ", descripcion=" + descripcion + ", precios_compra_sin_iva=" + precios_compra_sin_iva + ", precios_compra_con_iva=" + precios_compra_con_iva + ", precio_mayorista=" + precio_mayorista + ", precio_cliente_fijo=" + precio_cliente_fijo + ", precio_cliente_normal=" + precio_cliente_normal + ", fecha_caducidad=" + fecha_caducidad + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + '}';
    }
 
    
   
   
   
   
           
    
}
