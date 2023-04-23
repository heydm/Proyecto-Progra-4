/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.guia.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Poliza {
    
    String numero; 
    String fecha;
    double precio;
   List <Cobertura>coberturas;
    private Auto auto;
    private Cliente cliente;

    public Poliza(String numero, String fecha, double precio, List<Cobertura> coberturas, Auto auto, Cliente cliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.coberturas = coberturas;
        this.auto = auto;
        this.cliente = cliente;
    }
    public Poliza(String numero, String fecha, double precio, Auto auto, Cliente cliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.coberturas = new ArrayList();
        this.auto = auto;
        this.cliente = cliente;
    }
    public Poliza() {
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


 public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

   public String getPlaca() {
        return this.auto.getPlaca();
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
