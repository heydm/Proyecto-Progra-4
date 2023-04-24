/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.guia.data;

import com.progra.guia.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao {
    RelDatabase db;
   boolean resultado;
    public UsuarioDao(RelDatabase db){
        this.db= db;
    }
    public void create(Usuario c) throws Exception {
        String sql = "insert into Usuario (cedula, clave, tipo) VALUES (?, ?, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getCedula());
        stm.setString(2, c.getClave());
        stm.setInt(3, c.getTipo());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("No es posible registrar el usuario");
        }
    }
    public Usuario read(String cedula) throws Exception {
        String sql = "select " +
                "* " +
                "from  Usuario e " +
                "where e.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Usuario no Existe");
        }
    }
    
    public Usuario from(ResultSet rs, String alias) {
        try {
            Usuario e = new Usuario();
            e.setCedula(rs.getString(alias + ".cedula"));
            e.setClave(rs.getString(alias + ".clave"));
            e.setTipo(rs.getInt(alias + ".tipo"));            
            return e;
        } catch (SQLException ex) {
            return null;
        }
    } 
    
     public void update(Usuario e) throws Exception {
        String sql = "update Usuario set clave=?, tipo=? where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getCedula());
        stm.setString(2, e.getClave());
        stm.setInt(3, e.getTipo());
       
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("EMPLEADO NO EXISTE");
        }

    }
     
     public void delete(Usuario e) throws Exception {
        String sql = "delete from Usuario where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Usuario NO EXISTE");
        }
    }
    public boolean existeUsuario(String cedula,String clave) throws Exception{
        
        String sql = "select from Usuario where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        int nFilas = db.executeUpdate(stm);
        if (nFilas > 0) {
            resultado = true;
            throw new Exception("Usuario Existe");
        } else {
            resultado = false;
        }
        return resultado;
    }
    
     public List<Usuario> UsuariosTotal() throws SQLException {
        String sql = "select * from Usuario e";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);

        List<Usuario> usuarios = new ArrayList<>();
        while (rs.next()) {
            Usuario usuario = this.from(rs, "e");
            usuarios.add(usuario);
        }
        return usuarios;
    }
 }
 