package com.istloja.vistas;

import com.istdloja.modelo.Provedores;
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
public class GestionContableProvedores {

    private JTextField txtxRuc;
    private JTextField txtxRazonSiocial;
    private JTextField txtTipo_actividad;
    private JTextField txtNombre_Representante_Legal;
    private JTextField txtApellido_Representante_legal;
    private JTextField txtTelefono_Provedores;
    private JTextField txtCorreo_provedores;
    private JTextField txtDireccionProvedores;
    private JDateChooser jDateFechaVencimientoDeuda;
    private Utilidades utilidades;
    private JFrame frameGestionContable;

    public GestionContableProvedores(JTextField txtxRuc, JTextField txtxRazonSiocial, JTextField txtTipo_actividad, JTextField txtNombre_Representante_Legal, JTextField txtApellido_Representante_legal, JTextField txtTelefono_Provedores, JTextField txtCorreo_provedores, JTextField txtDireccionProvedores, JDateChooser jDateFechaVencimientoDeuda, Utilidades utilidades, JFrame frameGestionContable) {
        this.txtxRuc = txtxRuc;
        this.txtxRazonSiocial = txtxRazonSiocial;
        this.txtTipo_actividad = txtTipo_actividad;
        this.txtNombre_Representante_Legal = txtNombre_Representante_Legal;
        this.txtApellido_Representante_legal = txtApellido_Representante_legal;
        this.txtTelefono_Provedores = txtTelefono_Provedores;
        this.txtCorreo_provedores = txtCorreo_provedores;
        this.txtDireccionProvedores = txtDireccionProvedores;
        this.jDateFechaVencimientoDeuda = jDateFechaVencimientoDeuda;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
    }

    public JTextField getTxtxRuc() {
        return txtxRuc;
    }

    public void setTxtxRuc(JTextField txtxRuc) {
        this.txtxRuc = txtxRuc;
    }

    public JTextField getTxtxRazonSiocial() {
        return txtxRazonSiocial;
    }

    public void setTxtxRazonSiocial(JTextField txtxRazonSiocial) {
        this.txtxRazonSiocial = txtxRazonSiocial;
    }

    public JTextField getTxtTipo_actividad() {
        return txtTipo_actividad;
    }

    public void setTxtTipo_actividad(JTextField txtTipo_actividad) {
        this.txtTipo_actividad = txtTipo_actividad;
    }

    public JTextField getTxtNombre_Representante_Legal() {
        return txtNombre_Representante_Legal;
    }

    public void setTxtNombre_Representante_Legal(JTextField txtNombre_Representante_Legal) {
        this.txtNombre_Representante_Legal = txtNombre_Representante_Legal;
    }

    public JTextField getTxtApellido_Representante_legal() {
        return txtApellido_Representante_legal;
    }

    public void setTxtApellido_Representante_legal(JTextField txtApellido_Representante_legal) {
        this.txtApellido_Representante_legal = txtApellido_Representante_legal;
    }

    public JTextField getTxtTelefono_Provedores() {
        return txtTelefono_Provedores;
    }

    public void setTxtTelefono_Provedores(JTextField txtTelefono_Provedores) {
        this.txtTelefono_Provedores = txtTelefono_Provedores;
    }

    public JTextField getTxtCorreo_provedores() {
        return txtCorreo_provedores;
    }

    public void setTxtCorreo_provedores(JTextField txtCorreo_provedores) {
        this.txtCorreo_provedores = txtCorreo_provedores;
    }

    public JTextField getTxtDireccionProvedores() {
        return txtDireccionProvedores;
    }

    public void setTxtDireccionProvedores(JTextField txtDireccionProvedores) {
        this.txtDireccionProvedores = txtDireccionProvedores;
    }

    public JDateChooser getjDateFechaVencimientoDeuda() {
        return jDateFechaVencimientoDeuda;
    }

    public void setjDateFechaVencimientoDeuda(JDateChooser jDateFechaVencimientoDeuda) {
        this.jDateFechaVencimientoDeuda = jDateFechaVencimientoDeuda;
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

    public void limpiar_Caja_Provedores() {
        txtxRuc.setText("");
        txtxRazonSiocial.setText("");
        txtTipo_actividad.setText("");
        txtNombre_Representante_Legal.setText("");
        txtApellido_Representante_legal.setText("");
        txtTelefono_Provedores.setText("");
        txtCorreo_provedores.setText("");
        txtDireccionProvedores.setText("");
        jDateFechaVencimientoDeuda.setCalendar(null);
    }

    public Provedores guardarEditarProvedores(boolean isEditar) {
        if (txtxRuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo ruc no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtxRuc.requestFocus();
            return null;
        }
        if (txtxRazonSiocial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo razón social no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtxRazonSiocial.requestFocus();
            return null;
        }
        if (txtTipo_actividad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo tipo de actividad no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTipo_actividad.requestFocus();
            return null;
        }
        if (txtNombre_Representante_Legal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Nombre de Representante Legal no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombre_Representante_Legal.requestFocus();
            return null;
        }
        if (txtApellido_Representante_legal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Apellido de Representante Legal no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtApellido_Representante_legal.requestFocus();
            return null;

        }
        if (txtTelefono_Provedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo teléfono no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTelefono_Provedores.requestFocus();
            return null;
        }
        if (!utilidades.validarNumero(txtTelefono_Provedores.getText())) {
            JOptionPane.showMessageDialog(frameGestionContable, "Los datos ingresados en el teléfono no son validos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTelefono_Provedores.requestFocus();
            return null;
        }
        if (txtDireccionProvedores.getText().isEmpty()) {
             JOptionPane.showMessageDialog(frameGestionContable, "El campo dirección no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
             txtDireccionProvedores.requestFocus();
             return null;
        }
        
        Provedores provedores = new Provedores();
        provedores.setRuc(txtxRuc.getText());
        provedores.setRazonSocial(txtxRazonSiocial.getText());
        provedores.setTipoActividad(txtTipo_actividad.getText());
        provedores.setNombreRepresentanteLegal(txtNombre_Representante_Legal.getText());
        provedores.setApellidoRepresentanteLegal(txtApellido_Representante_legal.getText());
        provedores.setTelefono(txtTelefono_Provedores.getText());
        provedores.setCorreo(txtCorreo_provedores.getText());
        provedores.setDireccion(txtDireccionProvedores.getText());
        if (isEditar) {
            provedores.setFechaActualizacion(new Date());
        }else{
            provedores.setFechaRegistro(new Date());
        }
        provedores.setFechaVencimientoDeuda(new Date());
        return provedores;
    }
}
