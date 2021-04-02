/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.vistas;

import com.istdloja.modelo.Inventario;
import com.istloja.utilidad.Utilidades;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author danielmora
 */
public class GestionInventario {

    private JTextField txtcodigoProductoInvntario;
    private JTextField txtdescripcionInventario;
    private JTextField txtcatidadInventario;
    private JTextField txtprecioCompraInvntario_sinIva;
    private JTextField txtprecioCompraInvntario_conIva;
    private JTextField txtprecioMayoristaInventario;
    private JTextField txtPrecioClienteFijo;
    private JTextField txtPrecioClienteNormal;
    private JDateChooser jDateInventario;
    private Utilidades utilidades;
    private JFrame frameGestionContable;

    public GestionInventario(JTextField txtcodigoProductoInvntario, JTextField txtdescripcionInventario, JTextField txtcatidadInventario, JTextField txtprecioCompraInvntario_sinIva, JTextField txtprecioCompraInvntario_conIva, JTextField txtprecioMayoristaInventario, JTextField txtPrecioClienteFijo, JTextField txtPrecioClienteNormal, JDateChooser jDateInventario, Utilidades utilidades, JFrame frameGestionContable) {
        this.txtcodigoProductoInvntario = txtcodigoProductoInvntario;
        this.txtdescripcionInventario = txtdescripcionInventario;
        this.txtcatidadInventario = txtcatidadInventario;
        this.txtprecioCompraInvntario_sinIva = txtprecioCompraInvntario_sinIva;
        this.txtprecioCompraInvntario_conIva = txtprecioCompraInvntario_conIva;
        this.txtprecioMayoristaInventario = txtprecioMayoristaInventario;
        this.txtPrecioClienteFijo = txtPrecioClienteFijo;
        this.txtPrecioClienteNormal = txtPrecioClienteNormal;
        this.jDateInventario = jDateInventario;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
    }

    public JTextField getTxtcodigoProductoInvntario() {
        return txtcodigoProductoInvntario;
    }

    public void setTxtcodigoProductoInvntario(JTextField txtcodigoProductoInvntario) {
        this.txtcodigoProductoInvntario = txtcodigoProductoInvntario;
    }

    public JTextField getTxtdescripcionInventario() {
        return txtdescripcionInventario;
    }

    public void setTxtdescripcionInventario(JTextField txtdescripcionInventario) {
        this.txtdescripcionInventario = txtdescripcionInventario;
    }

    public JTextField getTxtcatidadInventario() {
        return txtcatidadInventario;
    }

    public void setTxtcatidadInventario(JTextField txtcatidadInventario) {
        this.txtcatidadInventario = txtcatidadInventario;
    }

    public JTextField getTxtprecioCompraInvntario_sinIva() {
        return txtprecioCompraInvntario_sinIva;
    }

    public void setTxtprecioCompraInvntario_sinIva(JTextField txtprecioCompraInvntario_sinIva) {
        this.txtprecioCompraInvntario_sinIva = txtprecioCompraInvntario_sinIva;
    }

    public JTextField getTxtprecioCompraInvntario_conIva() {
        return txtprecioCompraInvntario_conIva;
    }

    public void setTxtprecioCompraInvntario_conIva(JTextField txtprecioCompraInvntario_conIva) {
        this.txtprecioCompraInvntario_conIva = txtprecioCompraInvntario_conIva;
    }

    public JTextField getTxtprecioMayoristaInventario() {
        return txtprecioMayoristaInventario;
    }

    public void setTxtprecioMayoristaInventario(JTextField txtprecioMayoristaInventario) {
        this.txtprecioMayoristaInventario = txtprecioMayoristaInventario;
    }

    public JTextField getTxtPrecioClienteFijo() {
        return txtPrecioClienteFijo;
    }

    public void setTxtPrecioClienteFijo(JTextField txtPrecioClienteFijo) {
        this.txtPrecioClienteFijo = txtPrecioClienteFijo;
    }

    public JTextField getTxtPrecioClienteNormal() {
        return txtPrecioClienteNormal;
    }

    public void setTxtPrecioClienteNormal(JTextField txtPrecioClienteNormal) {
        this.txtPrecioClienteNormal = txtPrecioClienteNormal;
    }

    public JDateChooser getjDateInventario() {
        return jDateInventario;
    }

    public void setjDateInventario(JDateChooser jDateInventario) {
        this.jDateInventario = jDateInventario;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public JFrame getFrameGestionContable() {
        return frameGestionContable;
    }

    public void setFrameGestionContable(JFrame frameGestionContable) {
        this.frameGestionContable = frameGestionContable;
    }

    public void limpiarInventario() {
        txtcodigoProductoInvntario.setText("");
        txtdescripcionInventario.setText("");
        txtcatidadInventario.setText("");
        txtprecioCompraInvntario_sinIva.setText("");
        txtprecioCompraInvntario_conIva.setText("");
        txtprecioMayoristaInventario.setText("");
        txtPrecioClienteFijo.setText("");
        txtPrecioClienteNormal.setText("");
        jDateInventario.setCalendar(null);

    }

    public Inventario guardarEditarInventario(boolean isEditar) {

        if (txtcodigoProductoInvntario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo código no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcodigoProductoInvntario.requestFocus();
            return null;
        }
        if (txtdescripcionInventario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo descripción no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);

            txtdescripcionInventario.requestFocus();
            return null;
        }
        if (txtcatidadInventario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo cantidad no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcatidadInventario.requestFocus();
            return null;
        }
        if (txtprecioCompraInvntario_sinIva.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo precio cliente sin iva no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtprecioCompraInvntario_sinIva.requestFocus();
            return null;
        }

        if (txtprecioCompraInvntario_conIva.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo precio cliente con iva no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtprecioCompraInvntario_conIva.requestFocus();
            return null;
        }
        if (txtprecioMayoristaInventario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo precio venta Mayorista no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtprecioMayoristaInventario.requestFocus();
            return null;
        }
        if (txtPrecioClienteFijo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo precio Cliente Fijo venta no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtPrecioClienteFijo.requestFocus();
            return null;
        }
        if (txtPrecioClienteNormal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Precio Cliente Normal no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtPrecioClienteNormal.requestFocus();
            return null;
        }
        
        Inventario inventario = new Inventario();
        inventario.setCodigo_pro(txtcodigoProductoInvntario.getText());
        inventario.setDescripcion(txtdescripcionInventario.getText());
        inventario.setCan_productos(txtcatidadInventario.getText());
        inventario.setPrecios_compra_sin_iva(Double.parseDouble(txtprecioCompraInvntario_sinIva.getText()));
        inventario.setPrecios_compra_con_iva(Double.parseDouble(txtprecioCompraInvntario_conIva.getText()));
        inventario.setPrecio_mayorista(Double.parseDouble(txtprecioMayoristaInventario.getText()));
        inventario.setPrecio_cliente_fijo(Double.parseDouble(txtPrecioClienteFijo.getText()));
        inventario.setPrecio_cliente_normal(Double.parseDouble(txtPrecioClienteNormal.getText()));
        inventario.setFecha_caducidad(new Date());
        if (isEditar) {
            inventario.setFecha_actualizacion(new Date());
        }else{
            inventario.setFecha_registro(new Date());
        }
        return inventario;
    }

}
