package com.istdloja.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author danielmora
 */
public class Provedores {
    
    private int idProvedores;
    private String ruc;
    private String razonSocial;
    private String tipoActividad;                       
    private String nombreRepresentanteLegal;
    private String apellidoRepresentanteLegal;
    private String telefono;
    private String correo;
    private String Direccion;
    private Date fechaVencimientoDeuda;
    private Date fechaRegistro;
    private Date fechaActualizacion;
    
    public Provedores() {
    }

    public Provedores(int idProvedores, String ruc, String razonSocial, String tipoActividad, String nombreRepresentanteLegal, String apellidoRepresentanteLegal, String telefono, String correo, String Direccion, Date fechaVencimientoDeuda, Date fechaRegistro, Date fechaActualizacion) {
        this.idProvedores = idProvedores;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.tipoActividad = tipoActividad;
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
        this.apellidoRepresentanteLegal = apellidoRepresentanteLegal;
        this.telefono = telefono;
        this.correo = correo;
        this.Direccion = Direccion;
        this.fechaVencimientoDeuda = fechaVencimientoDeuda;
        this.fechaRegistro = fechaRegistro;
        this.fechaActualizacion = fechaActualizacion;
    }


    
    
    

    public int getIdProvedores() {
        return idProvedores;
    }

    public void setIdProvedores(int idProvedores) {
        this.idProvedores = idProvedores;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public String getApellidoRepresentanteLegal() {
        return apellidoRepresentanteLegal;
    }

    public void setApellidoRepresentanteLegal(String apellidoRepresentanteLegal) {
        this.apellidoRepresentanteLegal = apellidoRepresentanteLegal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    

    public Date getFechaVencimientoDeuda() {
        return fechaVencimientoDeuda;
    }

    public void setFechaVencimientoDeuda(Date fechaVencimientoDeuda) {
        this.fechaVencimientoDeuda = fechaVencimientoDeuda;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @Override
    public String toString() {
        return "Provedores{" + "idProvedores=" + idProvedores + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", tipoActividad=" + tipoActividad + ", nombreRepresentanteLegal=" + nombreRepresentanteLegal + ", apellidoRepresentanteLegal=" + apellidoRepresentanteLegal + ", telefono=" + telefono + ", correo=" + correo + ", Direccion=" + Direccion + ", fechaVencimientoDeuda=" + fechaVencimientoDeuda + ", fechaRegistro=" + fechaRegistro + ", fechaActualizacion=" + fechaActualizacion + '}';
    }

 

}
