package com.istloja.modelTables;

import com.istdloja.modelo.Persona;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danielmora
 */
public class ModelTablePersona extends AbstractTableModel { // Como AbstractTableModel es una calse padre la subcalse debe Implementar todos los metodos;
    // Arreglo con el nombre de las Columnas 

    public  String[] m_colNames = {"Cedula", "Nombre", "Apellido", "Direccion", "Telefono", "Correo"}; // Definimos el Encabezado de nuestra tabla 

    private  List<Persona> personas;
    
    private GestionContable gContable;

    public ModelTablePersona(List<Persona> personas,GestionContable gContable) {
        this.personas = personas;
        this.gContable=gContable; 
    }

    @Override
    public int getRowCount() { // Me mustra el tamaño de las filas que tenemos en la tabla 
        return personas.size();
    }

    // Determina el numero de columnas que tiene mi tabla
    @Override
    public int getColumnCount() { // Numero de columnas que tengo  en mi tabla 

        return m_colNames.length;
    }

    // Obtenemos las personas de mi arreglo
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona persona = personas.get(rowIndex);// obtenemos la fila1,fila2,fila3,fila4
        switch (columnIndex) {
            case 0:
                return persona.getCedula();
            case 1:
                return persona.getNombre();
            case 2:
                return persona.getApellido();
            case 3:
                return persona.getDireccion();
            case 4:
                return persona.getTelefono();
            case 5:
                return persona.getCorreo(); 

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
        gContable.clickPersona(personas.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    
    
    
}
