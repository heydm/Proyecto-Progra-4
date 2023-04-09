/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.guia.logic;

import com.progra.guia.data.ClienteDao;
import com.progra.guia.data.CuentaDao;
import com.progra.guia.data.RelDatabase;
import com.progra.guia.data.UsuarioDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Escinf
 */
public class Service {
    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance; 
    }
    RelDatabase relDatabase;
    UsuarioDao usuarioDao;
    ClienteDao clienteDao;
    CuentaDao cuentaDao;
    
//    HashMap<String,Usuario> usuarios;
//    HashMap<String,Cliente> clientes;
//    HashMap<String,Cuenta> cuentas;
//    HashMap<String,List<String>> favoritas;
    
    
    private Service(){
        relDatabase = new RelDatabase();
        usuarioDao = new UsuarioDao(relDatabase);
        clienteDao = new ClienteDao(relDatabase);
        cuentaDao = new CuentaDao(relDatabase);
        
//        usuarios = new HashMap();
//        usuarios.put("111", new Usuario("111","111",1));
//        usuarios.put("222", new Usuario("222","222",1));
//        usuarios.put("333", new Usuario("333","333",2));
//        
//        clientes = new HashMap(); 
//        clientes.put("111", new Cliente("111","J.Perez",usuarios.get("111")));
//        clientes.put("222", new Cliente("222","B.Banner",usuarios.get("222")));
//        clientes.put("333", new Cliente("333","L.Kjero",usuarios.get("333")));
//        
//        cuentas = new HashMap(); 
//        cuentas.put("1-111-11", new Cuenta("1-111-11",100.0,clientes.get("111")));
//        cuentas.put("1-222-22", new Cuenta("1-222-22",200.0,clientes.get("111")));        
//        cuentas.put("2-111-11", new Cuenta("2-111-11",150.0,clientes.get("222")));
//
//        //HashMap<String,List<String>> favoritas;
//        favoritas = new HashMap(); 
//        favoritas.put("111", Arrays.asList(new String[]{"2-111-11"}));
//        favoritas.put("222", Arrays.asList(new String[]{"1-111-11","1-222-22"}));
    }

    public Usuario usuarioFind(String cedula,String clave) throws Exception{
        return usuarioDao.read(cedula);
        // Falta verificar clave
    }

    public Cliente clienteFind(Usuario usuario) throws Exception{
        return clienteDao.read(usuario.getCedula());
    }
    
    public List<Cuenta> cuentasFind(Cliente cliente) throws Exception{
        List<Cuenta> cuentas = cuentaDao.findByCliente(cliente);
        for(Cuenta e:cuentas) e.setCliente(cliente);
        cliente.setCuentas(cuentas);
        return cuentas;
    }

    public void clienteUpdate(Cliente cliente) throws Exception{
        clienteDao.update(cliente);
    }
    
    public Cuenta cuentaFind(String numero) throws Exception{
        return cuentaDao.read(numero);
    }    
}
