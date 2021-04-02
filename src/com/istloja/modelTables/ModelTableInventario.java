package com.istloja.modelTables;

import com.istdloja.modelo.Inventario;
import com.istdloja.modelo.Persona;
import com.istdloja.modelo.Provedores;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danielmora
 */
public class ModelTableInventario extends AbstractTableModel { // Como AbstractTableModel es una calse padre la subcalse debe Implementar todos los metodos;
    // Arreglo con el nombre de las Columnas 

    public  String[] m_colNames = {"CODIGO PRODUCTO", "DESCRIPCION", "CANTIDAD PRODUCTOS", "PRECIO VENTA SIN IVA", "PRECIO VENTA CON IVA", "PRECIO MAYORISTA", "PRECIO CLIENTE FIJO", "PRECIO CLIENTE NORMAL", "FECHA CADUCIDAD"}; // Definimos el Encabezado de nuestra tabla 

    private  List<Inventario> inventarios;
    
    private GestionContable gContable;

    public ModelTableInventario(List<Inventario> inventarios,GestionContable gContable) {
        this.inventarios = inventarios;
        this.gContable=gContable; 
    }

  

    @Override
    public int getRowCount() { // Me mustra el tamaño de las filas que tenemos en la tabla 
        return inventarios.size();
    }

    // Determina el numero de columnas que tiene mi tabla
    @Override
    public int getColumnCount() { // Numero de columnas que tengo  en mi tabla 

        return m_colNames.length;
    }

    // Obtenemos las personas de mi arreglo
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inventario inventario = inventarios.get(rowIndex);// obtenemos la fila1,fila2,fila3,fila4
        switch (columnIndex) {
            case 0:
                return inventario.getCodigo_pro();
            case 1:
                return inventario.getDescripcion();
            case 2:
                return inventario.getCan_productos();
            case 3:
                return inventario.getPrecios_compra_sin_iva();
            case 4:
                return inventario.getPrecios_compra_con_iva();
                case 5:
                return inventario.getPrecio_mayorista();
                case 6:
                return inventario.getPrecio_cliente_fijo();
                case 7:
                return inventario.getPrecio_cliente_normal();
                case 8:
                return inventario.getFecha_caducidad();
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
        gContable.clickInventario(inventarios.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }


   
    
    
    
}
