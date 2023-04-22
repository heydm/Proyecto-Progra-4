/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.presentation.marca;

import com.progra.guia.logic.Marca;

/**
 *
 * @author joas2
 */
public class Model{
    Marca current;

    public Model() {
        current = new Marca("","");
    }

    public Marca getCurrent() {
        return current;
    }

    public void setCurrent(Marca current) {
        this.current = current;
    }

}
