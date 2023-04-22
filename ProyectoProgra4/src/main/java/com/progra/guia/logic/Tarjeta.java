/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.logic;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Tarjeta {
     private String numeroTarjeta;
    private String fechaVencimineto;

    public Tarjeta() {
    }

    public Tarjeta(String numeroTarjeta, String fechaVencimineto) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimineto = fechaVencimineto;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimineto() {
        return fechaVencimineto;
    }

    public void setFechaVencimineto(String fechaVencimineto) {
        this.fechaVencimineto = fechaVencimineto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Tarjeta other = (Tarjeta) obj;
        return Objects.equals(this.numeroTarjeta, other.numeroTarjeta);
    }
}
