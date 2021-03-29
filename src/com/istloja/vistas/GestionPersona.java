package com.istloja.vistas;

import com.istdloja.modelo.Persona;
import com.istloja.utilidad.Utilidades;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Flow;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author danielmora
 */
public class GestionPersona { // JFrame es una clase que pertece al paquete javax.swing

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private Utilidades utilidades;
    private JFrame frameGestionContable;
    private JComboBox ComboBoxGeneroPersona;

    public GestionPersona(JTextField txtCedula, JTextField txtNombre, JTextField txtApellido, JTextField txtDireccion, JTextField txtTelefono, JTextField txtCorreo, Utilidades utilidades, JFrame frameGestionContable, JComboBox ComboBoxGeneroPersona) {
        this.txtCedula = txtCedula;
        this.txtNombre = txtNombre;
        this.txtApellido = txtApellido;
        this.txtDireccion = txtDireccion;
        this.txtTelefono = txtTelefono;
        this.txtCorreo = txtCorreo;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
        this.ComboBoxGeneroPersona = ComboBoxGeneroPersona;
    }



    

  

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public void vaciarCajasPersona() {
        txtCedula.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtDireccion.setText(null);
        txtTelefono.setText(null);
        txtCorreo.setText(null);
        txtCedula.requestFocus();
        ComboBoxGeneroPersona.setSelectedIndex(0);

    }

    public Persona guardarEditar(boolean isEditar) { // etornamos una persona nulos par activar los mensajes de error 
        Persona persona = new Persona();

        if (txtCedula.getText().isEmpty()) {// Sidetecta que el campo cedula esta vacia
            JOptionPane.showMessageDialog(frameGestionContable, "El campo cedula no tiene datos ", "Error", JOptionPane.ERROR_MESSAGE);//mensaje de alerta 
            txtCedula.requestFocus();// muestra el campo que esta vacia 

            return null; // Cortamos la ejecucion de la aplicacion dentro del main 
        }

        if (!utilidades.validadorDeCedula(txtCedula.getText())) { // El (!) al inicios es negacion 
            JOptionPane.showMessageDialog(frameGestionContable, "El campo cedula tiene datos Erroneos", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (txtNombre.getText().isEmpty()) {// Sidetecta que el campo cedula esta vacia
            JOptionPane.showMessageDialog(frameGestionContable, "El campo nombre no tiene datos ", "Error", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocus();// muestra el campo que esta vacia 

            return null; // Cortamos la ejecucion de la aplicacion dentro del main 
        }

        if (txtApellido.getText().isEmpty()) {// Sidetecta que el campo cedula esta vacia
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Apellido no tiene datos ", "Error", JOptionPane.ERROR_MESSAGE);
            txtApellido.requestFocus();// muestra el campo que esta vacia 

            return null; // Cortamos la ejecucion de la aplicacion dentro del main 
        }

        if (txtDireccion.getText().isEmpty()) {// Sidetecta que el campo cedula esta vacia
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Direccion no tiene datos ", "Error", JOptionPane.ERROR_MESSAGE);
            txtDireccion.requestFocus();// Ubica el campo que esta vacia 

            return null; // Cortamos la ejecucion de la aplicacion dentro del main 
        }

        if (txtTelefono.getText().isEmpty()) {// Sidetecta que el campo cedula esta vacia
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Telefono no tiene datos ", "Error", JOptionPane.ERROR_MESSAGE);
            txtTelefono.requestFocus();// muestra el campo que esta vacia 

            return null; // Cortamos la ejecucion de la aplicacion dentro del main 
        }

        if (!utilidades.validarNumero(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Numero Tiene datos Invalidos " + "\n Ingrese un numero que empieze con 0 y no contenga carateres", "Error", JOptionPane.ERROR_MESSAGE);

            txtTelefono.requestFocus();
            return null;

        }

        if (txtCorreo.getText().isEmpty()) {// Sidetecta que el campo cedula esta vacia
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Correo no tiene datos ", "Error", JOptionPane.ERROR_MESSAGE);
            txtCorreo.requestFocus();// muestra el campo que esta vacia 

            return null; // Cortamos la ejecucion de la aplicacion dentro del main 
        }

        if (!utilidades.validarCorreol(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Coreo Tiene datos Invalidos ", "Error", JOptionPane.ERROR_MESSAGE);
            txtCorreo.requestFocus();
            return null;
        }

        persona.setCedula(txtCedula.getText());
        persona.setNombre(txtNombre.getText());
        persona.setApellido(txtApellido.getText());
        persona.setDireccion(txtDireccion.getText());
        persona.setCorreo(txtCorreo.getText());
        persona.setTelefono(txtTelefono.getText());
        persona.setFechaRegistro(new Date());
        persona.setGenero(ComboBoxGeneroPersona.getSelectedIndex());
        if (isEditar) {
            persona.setFechaAactualizacion(new Date());       
        }else{
            persona.setFechaRegistro(new Date());
        }
        return persona;

    }

}
