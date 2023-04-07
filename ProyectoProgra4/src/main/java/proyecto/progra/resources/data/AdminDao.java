/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.progra.resources.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyecto.progra.resources.logic.Admin;

/**
 *
 * @author joas2
 */
public class AdminDao {
    DBConnection db;

    public AdminDao(DBConnection db){
        this.db= db;
    }    
    
    public Admin read(String cedula) throws Exception {
        String sql = "select " +
                "* " +
                "from Admin e inner join Usuario u on e.usuario=u.cedula " +
                "where e.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        UsuarioDao usuarioDao = new UsuarioDao(db);
        Admin c;
        if (rs.next()) {
            c= from(rs, "e");
            c.setUsuario(usuarioDao.from(rs,"u"));
            return c;
        } else {
            throw new Exception("Empleado no Existe");
        }
    }
    
    public Admin from(ResultSet rs, String alias) {
        try {
            Admin e = new Admin();
            e.setCedula(rs.getString(alias + ".cedula"));
            e.setNombre(rs.getString(alias + ".nombre"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }    

    public void update(Admin e) throws Exception {
        String sql = "update " +
                "Admin " +
                "set nombre=? " +
                "where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getNombre());
        stm.setString(2, e.getCedula());
        /*int count = db.executeQuery(stm);
        if (count == 0) {
            throw new Exception("Admin no existe");
        }*/
        
        // TODO arrreglar esto
    } 
}
