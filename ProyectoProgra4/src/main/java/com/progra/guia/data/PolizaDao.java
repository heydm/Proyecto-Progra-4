/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.data;

import com.progra.guia.logic.Cliente;
import com.progra.guia.logic.Poliza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESCINF
 */
public class PolizaDao {
    RelDatabase db;

    public PolizaDao(RelDatabase db){
        this.db= db;
    }
    public Poliza read(String numero) throws Exception {
        String sql = "select " +
                "* " +
                "from Poliza e " +
                "where e.numero=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, numero);
        ResultSet rs = db.executeQuery(stm);
        ClienteDao clienteDao = new ClienteDao(db);
        Poliza c;
        if (rs.next()) {
            c = from(rs, "e");
            c.setCliente(clienteDao.from(rs, "c"));
            return c;
        } else {
            throw new Exception("Poliza no Existe");
        }
    }
     public void create(Poliza e) throws Exception {
        String sql = "insert into Poliza (campo1, campo2,campo3,campo4,campo5,campo6,campo7) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, String.valueOf(e.getNumero()));
       
        stm.setString(3, e.getFecha());
       
        //stm.setString(6, e.getMarca());
       // stm.setstring(7, e.getCliente());

        
  
        db.executeQuery(stm);
    }

    public List<Poliza> findByCliente(Cliente cliente) {
        List<Poliza> resultado = new ArrayList<>();
        try {
            String sql = "select * " +
                    "from " +
                    "Poliza e " +
                    "where e.cliente=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, cliente.getCedula());
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    private Poliza from(ResultSet rs, String alias) {
        try {
            Poliza e = new Poliza();
            e.setNumero(rs.getString(alias + ".numero"));
           
     
            
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }     
}
