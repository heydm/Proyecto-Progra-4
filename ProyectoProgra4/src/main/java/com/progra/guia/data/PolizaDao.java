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
                "from Cuenta e inner join Cliente c on e.cliente=c.cedula " +
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
            throw new Exception("Cuenta no Existe");
        }
    }

    public List<Poliza> findByCliente(Cliente cliente) {
        List<Poliza> resultado = new ArrayList<>();
        try {
            String sql = "select * " +
                    "from " +
                    "Cuenta e " +
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
            e.setPlaca(rs.getString(alias + ".saldo"));
            e.setFecha(rs.getString(alias + ".saldo"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }     
}
