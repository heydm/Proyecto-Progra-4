/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.guia.presentation.cliente.poliza;

import com.progra.guia.logic.Poliza;



/**
 *
 * @author Escinf
 */
public class Model{
    Poliza current;

    public Model() {
        //current = new Poliza("","","",0.0,"",null,null);
    }

    public Poliza getCurrent() {
        return current;
    }

    public void setCurrent(Poliza current) {
        this.current = current;
    }

}
