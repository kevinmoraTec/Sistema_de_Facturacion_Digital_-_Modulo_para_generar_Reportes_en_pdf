package com.istloja.controlador;

import com.istdloja.modelo.Persona;
import java.sql.Connection;
import java.sql.Statement;
import com.istdloja.conexionbd.Conexion;
import com.istloja.utilidad.Utilidades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author danielmora
 */
public class Personabd {

    public Utilidades utilidades;

    public Personabd() {
        utilidades = new Utilidades();
    }

    // Gestiona la conexion con la base de datos y el modelo que implementamos en java 
    public boolean crearPersona(Persona persona) { // Recibe como paraametro una persona 

        boolean registrar = false;
        // Interfaz de acceso con la base de datos 
        Statement stm = null;
        // Conexion con la base de datos 
        Connection con = null;
        String sql;
        if (persona.getFecha_de_nacimiento() ==null) {
          sql = "INSERT INTO `bdEjercicio1`.`persona` (`cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `correo`, `fecha_registro`, `genero`) VALUES ('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getTelefono() + "', '" + persona.getCorreo() + "', '" + utilidades.devolverFecha(persona.getFechaRegistro()) + "', '" + persona.getGenero() + "');";

        }else{
         sql = "INSERT INTO `bdEjercicio1`.`persona` (`cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `correo`, `fecha_registro`, `genero`, `fecha_de_nacimiento`) VALUES ('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getTelefono() + "', '" + persona.getCorreo() + "', '" + utilidades.devolverFecha(persona.getFechaRegistro()) + "', '" + persona.getGenero() + "', '" + utilidades.devolverFecha(persona.getFecha_de_nacimiento()) + "');";

        }
        
        try {
            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos (puente)
            stm.execute(sql);// Ejecutamos el comando sql 
            registrar = true;
            stm.close(); // cerramos la interfaz 
            con.close();// cerramos la conexion con la base de datos ;
        } catch (Exception ex) {
            System.out.println("Error ::1::" + ex.getMessage());

        }
        return registrar;
    }

    public boolean modificarPersona(Persona persona) {

        boolean registrar = false;
        Statement stm = null; // Sentencia sql para btener los resultados producidos por la base de datos 
        // Conexion con la base de datos 
        Connection con = null;

        String sql = "UPDATE `bdEjercicio1`.`persona` SET `cedula`='" + persona.getCedula() + "', `nombre`='" + persona.getNombre() + "', `apellido`='" + persona.getApellido() + "', `direccion`='" + persona.getDireccion() + "', `telefono`='" + persona.getTelefono() + "', `correo`='" + persona.getCorreo() + "', `fecha_registro`='" + utilidades.devolverFecha(persona.getFechaRegistro()) + "', `genero`='" + persona.getGenero() + "', `fecha_Actualizacion`='" + utilidades.devolverFecha(persona.getFechaAactualizacion()) + "' WHERE `id_persona`='" + persona.getIdPersona() + "';";

        try {
            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos 
            stm.execute(sql);// Ejecutamos el comando sql 
            registrar = true;
            stm.close(); // cerramos la interfaz 
            con.close();// cerramos la conexion con la base de datos ;
        } catch (Exception ex) {
            System.out.println("Error ::2::" + ex.getMessage());

        }
        return registrar;
    }

    public boolean eliminarPersona(Persona persona) {

        boolean eliminar = false;

        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 

        Connection con = null; // conexion con la base de datos 

        String sql = "DELETE FROM `bdEjercicio1`.`persona` WHERE (`id_persona` = '" + String.valueOf(persona.getIdPersona()) + "')";

        try {

            Conexion conexion = new Conexion(); // instaciamos un objeto de la clase Conexion del paquete com.istdloja.conexionbd
            con = Conexion.conexionMysql();
            stm = con.createStatement(); // Indicamos que vamos hacer una conexion con la base de datos 
            stm.execute(sql);// Ejecutamos el comando sql
            eliminar = true;

        } catch (Exception ex) {
            System.out.println("Error::3:: " + ex.getMessage());
        }
        return eliminar;
    }

    public List<Persona> obtenerPersona() {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.persona;";

        List<Persona> listapersonas = new ArrayList<Persona>();

        try {
            co = new Conexion().conexionMysql();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            //El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.
            while (rs.next()) {
                // Estos para metros Tienes que ir en orden
                Persona c = new Persona();
                c.setIdPersona(rs.getInt(1));// rs. Trae wl resultado de la base de datos
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaAactualizacion(rs.getDate(10));
                c.setFecha_de_nacimiento(rs.getDate(11));
                listapersonas.add(c); /// Agregamos los objetos obtenidos a mi listapersonas

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error ::4::" + ex.getMessage());

        }
        return listapersonas;

    }

    public Persona getPersonaCedula(String cedula) {
        Connection co = null; // Coneccion con la base de datos 
        Statement stm = null;//  Preparar los datos de la base de datos
        ResultSet rs = null;// Obtener los datos de la base de datos 
        Persona c = null;

        String sql = "SELECT * FROM bdEjercicio1.persona where cedula = " + cedula + ";";
                 
        try {
            co = new Conexion().conexionMysql();// conectamos la base de daatos
            stm = co.createStatement(); // el cvalor inicial para coorer la sentencia 
            rs = stm.executeQuery(sql);// Corremos la Sentencia 
            while (rs.next()) {// recorre ls datos de la base de datos  ("Si no entra al metodo nos da una Persona VACIA ")
                c = new Persona(); // Instancion Una Persona ;
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaAactualizacion(rs.getDate(10));
                c.setFecha_de_nacimiento(rs.getDate(11));

            }

            stm.close();// Cierra la interfaz
            rs.close();// Cieree el resultado con la base de datos 
            co.close();;//Cierra  la coneccion

        } catch (Exception ex) {
            System.out.println("Error ::5::" + ex.getMessage());

        }
        return c;
    }

    public Persona getPersonaTelefono(String telefono) {

        Connection co = null; // Conexion con la base de datos 
        Statement stm = null;// Interfaz o prepara los datos de la Bd
        ResultSet rs = null;// Trae los resultados de la base de datos 
        Persona p = null; // objeto de persona
        String sql = "SELECT * FROM bdEjercicio1.persona where telefono = " + telefono + ";";

        try {

            co = new Conexion().conexionMysql(); // conectamos la base de daatos
            stm = co.createStatement(); //// el cvalor inicial para coorer la sentencia 
            rs = stm.executeQuery(sql);

            p = new Persona();

            while (rs.next()) { // Recoore los datos de nuestra bd
                p.setIdPersona(rs.getInt(1));
                p.setCedula(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setApellido(rs.getString(4));
                p.setDireccion(rs.getString(5));
                p.setTelefono(rs.getString(6));
                p.setCorreo(rs.getString(7));
                p.setFechaRegistro(rs.getDate(8));
                p.setGenero(rs.getInt(9));
                p.setFechaAactualizacion(rs.getDate(10));
                p.setFecha_de_nacimiento(rs.getDate(11));

            }
            stm.close();// Cierra la interfaz
            rs.close();// Cieree el resultado con la base de datos 
            co.close();;//Cierra  la coneccion

        } catch (Exception ex) {
            System.out.println("Error ::6::" + ex.getMessage());

        }
        return p;
    }
        public List<Persona> obtenerPersonaCedula(String cedula) {
        Connection co = null; // Coneccion con la base de datos 
        Statement stm = null;//  Preparar los datos de la base de datos
        ResultSet rs = null;// Obtener los datos de la base de datos 
         List<Persona> personasEncontradas = new ArrayList<>();

        String sql = "SELECT * FROM bdEjercicio1.persona where cedula like \"%" + cedula + "%\"";
                 
        try {
            co = new Conexion().conexionMysql();// conectamos la base de daatos
            stm = co.createStatement(); // el cvalor inicial para coorer la sentencia 
            rs = stm.executeQuery(sql);// Corremos la Sentencia 
            while (rs.next()) {// recorre ls datos de la base de datos  ("Si no entra al metodo nos da una Persona VACIA ")
              Persona c = new Persona(); // Instancion Una Persona ;
                
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaAactualizacion(rs.getDate(10));
                c.setFecha_de_nacimiento(rs.getDate(11));
                 personasEncontradas.add(c);
            }

            stm.close();// Cierra la interfaz
            rs.close();// Cieree el resultado con la base de datos 
            co.close();;//Cierra  la coneccion

        } catch (Exception ex) {
            System.out.println("Error ::5.1::" + ex.getMessage());

        }
        return personasEncontradas;
    }

    public List<Persona> getPersonaNombre(String nombre) {
        Connection co = null; // Coneccion con la base de datos 
        Statement stm = null;//  Preparar los datos de la base de datos
        ResultSet rs = null;// Obtener los datos de la base de datos 
        List<Persona> personasEncontradas = new ArrayList<>();

        String sql = "SELECT * FROM bdEjercicio1.persona where nombre like \"%" + nombre + "%\"";

        try {
            co = new Conexion().conexionMysql();// conectamos la base de daatos
            stm = co.createStatement(); // el cvalor inicial para coorer la sentencia 
            rs = stm.executeQuery(sql);// Corremos la Sentencia 
            while (rs.next()) {// recorre ls datos de la base de datos  ("Si no entra al metodo nos da una Persona VACIA ")
                Persona c = new Persona(); // Instancion Una Persona ;
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaAactualizacion(rs.getDate(10));
                c.setFecha_de_nacimiento(rs.getDate(11));
                personasEncontradas.add(c);

            }

            stm.close();// Cierra la interfaz
            rs.close();// Cieree el resultado con la base de datos 
            co.close();;//Cierra  la coneccion

        } catch (Exception ex) {
            System.out.println("Error ::7::" + ex.getMessage());

        }
        return personasEncontradas;
    }

    // metodo para buscar por correo
    public List<Persona> getPersonaCorreo(String correo) {
        Connection co = null; // Coneccion con la base de datos 
        Statement stm = null;//  Preparar los datos de la base de datos
        ResultSet rs = null;// Obtener los datos de la base de datos 
        List<Persona> correosEncontrados = new ArrayList<>();

        String sql = "SELECT * FROM bdEjercicio1.persona where nombre like \"%" + correo + "%\"";

        try {
            while (rs.next()) {
                Persona c = new Persona();
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaAactualizacion(rs.getDate(10));
                c.setFecha_de_nacimiento(rs.getDate(11));
                correosEncontrados.add(c);
            }
            stm.close();// Cierra la interfaz
            rs.close();// Cieree el resultado con la base de datos 
            co.close();;//Cierra  la coneccion

        } catch (Exception ex) {
            System.out.println("Error ::8::" + ex.getMessage());
        }
        return correosEncontrados;
    }

    public List<Persona> getPersonaApellido(String apellido) {
        Connection co = null; // Coneccion con la base de datos 
        Statement stm = null;//  Preparar los datos de la base de datos
        ResultSet rs = null;// Obtener los datos de la base de datos 
        List<Persona> apellidoEncontradas = new ArrayList<>();

        String sql = "SELECT * FROM bdEjercicio1.persona where nombre like \"%" + apellido + "%\"";

        try {
            co = new Conexion().conexionMysql();// conectamos la base de daatos
            stm = co.createStatement(); // el cvalor inicial para coorer la sentencia 
            rs = stm.executeQuery(sql);// Corremos la Sentencia 
            while (rs.next()) {// recorre ls datos de la base de datos  ("Si no entra al metodo nos da una Persona VACIA ")
                Persona c = new Persona(); // Instancion Una Persona ;
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaAactualizacion(rs.getDate(10));
                c.setFecha_de_nacimiento(rs.getDate(11));
                apellidoEncontradas.add(c);

            }

            stm.close();// Cierra la interfaz
            rs.close();// Cieree el resultado con la base de datos 
            co.close();;//Cierra  la coneccion

        } catch (Exception ex) {
            System.out.println("Error ::9::" + ex.getMessage());

        }
        return apellidoEncontradas;
    }

}
