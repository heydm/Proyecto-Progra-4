/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.data;

import com.progra.guia.logic.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joas2
 */
public class MarcaDao {
    RelDatabase db;

    public MarcaDao(RelDatabase db){
        this.db= db;
    }    
    
    public Marca read(String id) throws Exception {
       String sql = "select " +
                "* " +
                "from  Marca e " +
                "where e.id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Marca no Existe");
        }
    }
    
    public Marca from(ResultSet rs, String alias) {
        try {
            Marca e = new Marca();
            e.setId(rs.getString(alias + ".id"));
            e.setNombre(rs.getString(alias + ".clave"));         
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }  

    public void update(Marca e) throws Exception {
        String sql = "update " +
                "Marca " +
                "set nombre=? " +
                "where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getNombre());
        stm.setString(2, e.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cliente no existe");
        }
    } 
    
    public void create(Marca e) throws Exception {
        String sql = "INSERT INTO MARCA (campo1, campo2) VALUES (?, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, String.valueOf(e.getId()));
        stm.setString(2, e.getNombre());
                
        db.executeQuery(stm);
    }

    public List<Marca> index() throws SQLException {
        List<Marca> marcas = new ArrayList<>(); 
        String sql = "SELECT * FROM MARCA; ";
        
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        
        while(rs.next()){
            String id = rs.getString("id");
            String nombre = rs.getString("nombre");
            
            Marca marca = new Marca(id, nombre);
            marcas.add(marca);
        }
        
        return marcas;
    }
}
