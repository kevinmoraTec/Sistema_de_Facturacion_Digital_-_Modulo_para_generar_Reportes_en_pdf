package com.istdloja.modelo;

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
    
     public Persona() {
     
    }

    public Persona(String cedula, String nombre, String apellido, String direccion, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + '}';
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
