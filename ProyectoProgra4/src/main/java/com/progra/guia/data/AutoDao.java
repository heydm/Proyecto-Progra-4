/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.data;

import com.progra.guia.logic.Auto;
import com.progra.guia.logic.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diana
 */
public class AutoDao {
    RelDatabase db;

    public AutoDao(RelDatabase db){
        this.db= db;
    }
   public Auto read(String cedula) throws Exception {
        String sql = "select " +
                "* " +
                "from  Auto e " +
                "where e.placa=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Auto no Existe");
        }
    }

   
    
    private Auto from(ResultSet rs, String alias) {
        try {
            Auto e = new Auto();
            e.setNumero(rs.getString(alias + ".numero"));
            e.setPlaca(rs.getString(alias + ".placa"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }     
}
