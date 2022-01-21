/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import javax.swing.table.AbstractTableModel;
import com.istdloja.modelo.Venta;
import com.istloja.vistas.GestionContable;
import java.util.List;

/**
 *
 * @author danielmora
 */
public class ModelTableVentaFinal extends AbstractTableModel {

    public String[] n_colNames = {"Cod.Producto","CANTIDAD", "DESCRIPCION", "SUBTOTAL", "TOTAL"};
    public List<Venta> ventaProductos;
    private GestionContable gestionContableVenta;

    public ModelTableVentaFinal(List<Venta> ventaProductos, GestionContable gestionContableVenta) {
        this.ventaProductos = ventaProductos;
        this.gestionContableVenta = gestionContableVenta;
    }

    @Override
    public int getRowCount() {
        //Numero de fila que tengo en mi tabla :
        return ventaProductos.size();
    }

    @Override
    public int getColumnCount() {
        return n_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venta venta = ventaProductos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return venta.getIdProductoInventario();
                
            case 1:
                return venta.getCantidad();
                
            case 2:
                return venta.getDescripcioPventa();
                

            case 3:
                return venta.getSubtotal();
            case 4:    
                return venta.getTotal();
            //default:

        }
        return new String();

    }

    @Override
    public String getColumnName(int column) {
        return n_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionContableVenta.clickProductovender(ventaProductos.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);

    }

    public List<Venta> getProductoVentas() {
        return ventaProductos;
    }

    public void setProductoVenta(List<Venta> productoVentas) {
        this.ventaProductos = productoVentas;
    }

}
