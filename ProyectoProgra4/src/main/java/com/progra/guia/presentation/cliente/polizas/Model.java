/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.guia.presentation.cliente.polizas;

import com.progra.guia.logic.Poliza;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Escinf
 */
public class Model{
    List<Poliza> polizas;
    Poliza seleccionado;

    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Poliza> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setPolizas(rows);
    }
    
    public void setPolizas(List<Poliza> polizas){
        this.polizas =polizas;    
    }

     public List<Poliza> getPolizas() {
        return polizas;
    }

    public Poliza getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Poliza seleccionado) {
        this.seleccionado = seleccionado;
    }
}
