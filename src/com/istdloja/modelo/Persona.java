package com.istdloja.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author danielmora
 */
public class Persona {
    
    private int idPersona;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String telefono;
    private Date fechaRegistro;
    private int genero;
    
     public Persona() {
     
    }

    public Persona(String cedula, String nombre, String apellido, String direccion, String correo, String telefono, Date fechaRegistro, int genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.genero = genero;
    }



    public Persona(int idPersona, String cedula, String nombre, String apellido, String direccion, String correo, String telefono) {
        this.idPersona = idPersona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    
       @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + ", genero=" + genero + '}';
    }
    
    public String fechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY/MM/dd");
        return formatofecha.format(fecha);
    }



//    public void mostrarResultado(){
//        System.out.println("cedula -------->"+getCedula()+
//                "\n"+"Nombre --------->"+getNombre()
//                        + "\n"+"Apellido ------->"+getApellido()+""
//                                + "\n"+"Direccion ------>"+getDireccion()+""
//                                        + "\n"+"Telefono ------->"+getTelefono()+""
//                                                + "\n"+"Correo ------>"+getCorreo()+"\n"
//                                                        + "-------------------------");
//    }
//   

 
    
}
