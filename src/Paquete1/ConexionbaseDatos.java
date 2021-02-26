/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete1;

import com.istdloja.modelo.Persona;
import com.istloja.controlador.Personabd;
import com.istloja.vistas.GestionContable;


/**
*
 * @author danielmora
 */
public class ConexionbaseDatos {

    public static void main(String[] args) { // Clase  Pricipal 

       Personabd personabd = new Personabd();
//        
//        for (Persona arg : personabd.obtenerPersona()) {
//            System.out.println(arg);
//        }
        
        GestionContable gestionpersona = new GestionContable();
        
//        Persona persona = new Persona(3, "1348908733", "Daniel","Gonzalez","Pradera","djkevindaniel3@gmail.com","0996789098");
//        
//        if (personabd.crearPersona(persona)) {
//            
//            System.out.println("Agregada Correctamente  Correcta");
//        }else{
//            System.out.println(" Error al Agregar  persona");
//        }
//       System.out.println("Personas "+personabd.obtenerPersona().toString());
//
//
//    
    }

}
