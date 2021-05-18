package com.istdloja.modelo;

import java.util.Date;

/**
 *
 * @author danielmora
 */
public class Nota_de_venta{
    
    private int idNotaVenta;
    private String numeroNotaVenta;
    private int personaIdPersona;
    private Date fechaVenta;
    private double subTotal;
    private double iva;
    private double total;
    private int tipoPago;

    public int getIdNotaVenta() {
        return idNotaVenta;
    }

    public void setIdNotaVenta(int idNotaVenta) {
        this.idNotaVenta = idNotaVenta;
    }

    public String getNumeroNotaVenta() {
        return numeroNotaVenta;
    }

    public void setNumeroNotaVenta(String numeroNotaVenta) {
        this.numeroNotaVenta = numeroNotaVenta;
    }

    public int getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(int personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    
    
}
