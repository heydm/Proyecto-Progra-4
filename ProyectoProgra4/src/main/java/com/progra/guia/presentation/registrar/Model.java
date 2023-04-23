/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.presentation.registrar;

import com.progra.guia.logic.Cliente;

/**
 *
 * @author Usuario
 */
public class Model {
      Cliente current;
     public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Cliente());        
    }
    
    public Cliente getCurrent() {
        return current;
    }

    public void setCurrent(Cliente current) {
        this.current = current;
    }
}
