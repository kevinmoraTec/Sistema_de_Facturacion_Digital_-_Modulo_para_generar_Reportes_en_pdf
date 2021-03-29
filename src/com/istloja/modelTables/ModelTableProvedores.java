package com.istloja.modelTables;

import com.istdloja.modelo.Persona;
import com.istdloja.modelo.Provedores;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danielmora
 */
public class ModelTableProvedores extends AbstractTableModel { // Como AbstractTableModel es una calse padre la subcalse debe Implementar todos los metodos;
    // Arreglo con el nombre de las Columnas 

    public  String[] m_colNames = {"Ruc", "Razon_Social", "Tipo de Actividad", "Nombre_Representante_Legal", "Apellido_Representante_Legal", "Telefono", "Correo", "DIRECCION", "FECHA VENCIMIENTO DEUDA"}; // Definimos el Encabezado de nuestra tabla 

    private  List<Provedores> provedores;
    
    private GestionContable gContable;

    public ModelTableProvedores(List<Provedores> provedores,GestionContable gContable) {
        this.provedores = provedores;
        this.gContable=gContable; 
    }

    @Override
    public int getRowCount() { // Me mustra el tamaño de las filas que tenemos en la tabla 
        return provedores.size();
    }

    // Determina el numero de columnas que tiene mi tabla
    @Override
    public int getColumnCount() { // Numero de columnas que tengo  en mi tabla 

        return m_colNames.length;
    }

    // Obtenemos las personas de mi arreglo
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Provedores provedor = provedores.get(rowIndex);// obtenemos la fila1,fila2,fila3,fila4
        switch (columnIndex) {
            case 0:
                return provedor.getRuc();
            case 1:
                return provedor.getRazonSocial();
            case 2:
                return provedor.getTipoActividad();
            case 3:
                return provedor.getNombreRepresentanteLegal();
            case 4:
                return provedor.getApellidoRepresentanteLegal();
            case 5:
                return provedor.getTelefono();
            case 6:
                return provedor.getCorreo();
            case 7:
                return provedor.getDireccion();
            case 8:
                return provedor.getFechaVencimientoDeuda();
        }
        return new String();
    }

    // Sirve para definir los nombres de las Coumnas 
    @Override
    public String getColumnName(int column) { // Me retorna un String con el nombre de cada una de las Columnas !!.

        return m_colNames[column]; // Definimos los nombres a las columnas y asignamos el tamaño
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickProveedores(provedores.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Provedores> getProvedores() {
        return provedores;
    }

    public void setProvedores(List<Provedores> provedores) {
        this.provedores = provedores;
    }

   
    
    
    
}
