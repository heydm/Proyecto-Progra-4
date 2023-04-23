/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.logic;

import java.util.Objects;

public class Auto {
    //String numero;
    String placa;
    private String anio;
    Marca marca;
    private Modelo modelo;
    public Auto() {

        this("","",new Marca(),new Modelo());

    }

    public Auto( String placa, String anio, Marca marca, Modelo modelo) {
       // this.numero = numero;
        this.placa = placa;
        this.anio = anio;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

   
/*
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
*/
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

   

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
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
        final Auto other = (Auto) obj;
        return Objects.equals(this.placa, other.placa);
    }



   

    
   


   
    
    
    
    
}
