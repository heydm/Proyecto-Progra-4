/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.guia.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Escinf
 */
public class Cliente {
    String cedula;
    String nombre;
    Usuario usuario;
    List<Poliza> cuentas;

    public Cliente() {
        this("","",new Usuario());
    }

    public Cliente(String cedula, String nombre, Usuario usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.cuentas = new ArrayList();
    }

    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Poliza> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Poliza> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    
}
