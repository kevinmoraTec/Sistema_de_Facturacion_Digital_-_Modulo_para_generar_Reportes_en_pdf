/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istdloja.ConexionReportesJva;

import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author danielmora
 */
public class ConexionReporte {
    /**
     * 
     * @param conexionBaseDatos  Conexion con la base de Daros 
     * @param rutaReporte  La ruta donde esta mi reporte con la estencion . jasper
     * @param parametros  Vna a estar Compuestos Por clave Valor  
     */
    
    public static void crearReporte(Connection conexionBaseDatos,String rutaReporte,Map parametros){
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(rutaReporte);
            JasperPrint jp  = JasperFillManager.fillReport(jr,parametros,conexionBaseDatos);
            JasperViewer jv  = new JasperViewer(jp,false);// El Segundo Nos Permite Que la Ventana no Cierre Todo El Programa.
            jv.setVisible(true);
            //jv.show();
            jv.setTitle("Reporte Clientes");
            //JasperViewer  jasperViewer = new JasperViewer(jp)
        
        }catch(JRException E){
            System.out.println("Error ClaseConexionReporte \t"+E.getMessage());
            
        }
            
    }
    
}
