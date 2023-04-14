/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.guia.logic;

import java.util.Objects;

public class Poliza {
    
    String numero;
    String fecha;
    Auto auto;
    Cliente cliente;

    public Poliza() {

        this("","",new Auto(),new Cliente());

    }

    public Poliza(String numero,String fecha, Auto auto, Cliente cliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.auto = auto;
        this.cliente = cliente;
         
    }

    
   
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
 public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        final Poliza other = (Poliza) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
