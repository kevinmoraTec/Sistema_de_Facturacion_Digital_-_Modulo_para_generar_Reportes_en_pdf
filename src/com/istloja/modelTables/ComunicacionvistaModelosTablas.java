/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import com.istdloja.modelo.Inventario;
import com.istdloja.modelo.Persona;
import com.istdloja.modelo.Provedores;

/**
 *
 * @author danielmora
 */
public interface ComunicacionvistaModelosTablas {
    void clickPersona (Persona p);
    void clickProveedores (Provedores provedores);
    void clickInventario (Inventario inventarios);
}
