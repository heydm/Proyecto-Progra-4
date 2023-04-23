/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Categoria {
    String id;
    String nombre;
     List<Cobertura>coberturas ;

    public Categoria() {
    }

    public Categoria(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
         this.coberturas = new ArrayList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }
    
     
}
