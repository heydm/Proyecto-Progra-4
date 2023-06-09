/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.guia.logic;

import com.progra.guia.data.ClienteDao;
import com.progra.guia.data.MarcaDao;
import com.progra.guia.data.PolizaDao;
import com.progra.guia.data.RelDatabase;
import com.progra.guia.data.UsuarioDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
    PolizaDao polizaDao;
    MarcaDao marcaDao; 
    HashMap<String,Usuario> usuarios;
    HashMap<String,Cliente> clientes;
    
//    HashMap<String,Usuario> usuarios;
//    HashMap<String,Cliente> clientes;
//    HashMap<String,Cuenta> cuentas;
//    HashMap<String,List<String>> favoritas;
    
    
    private Service(){
        relDatabase = new RelDatabase();
        usuarioDao = new UsuarioDao(relDatabase);
        clienteDao = new ClienteDao(relDatabase);
        polizaDao = new PolizaDao(relDatabase);
        marcaDao = new MarcaDao(relDatabase);
        
         usuarios = new HashMap();
          clientes = new HashMap();
          
        
        
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
    
    public List<Poliza> polizasFind(Cliente cliente) throws Exception{

        List<Poliza> polizas = polizaDao.findByCliente(cliente);

        for(Poliza e:polizas) e.setCliente(cliente);
        cliente.setPolizas(polizas);
        return polizas;
    }

    public void clienteUpdate(Cliente cliente) throws Exception{
        clienteDao.update(cliente);
    }
    
    public Poliza polizaFind(String numero) throws Exception{
        return polizaDao.read(numero);
    }    
    
    public void marcaCreate(Marca marca) throws Exception {
        marcaDao.create(marca);
    }
    
    public List<Marca> marcaIndex() throws Exception {
        return marcaDao.index();
    }
    
     public boolean UsuarioExistente(String cedula,String clave) throws Exception{
        if (usuarios.get(cedula)!=null)
            throw new Exception("Existe una cuenta creada con ese usuario");
        else 
            return false;
    }
     
        public void cargaUsuarios(HashMap<String,Usuario> usuarios) throws SQLException{
        List<Usuario> usuariosDB = usuarioDao.UsuariosTotal();
        for (Usuario u: usuariosDB){
            usuarios.put(u.getCedula(), u);
        }
    }
        private void cargaClientes(HashMap<String, Cliente> clientes) throws SQLException {
            List<Cliente> clientesDB = clienteDao.getAllClientes();
            for (Cliente c: clientesDB){
            clientes.put(c.getCedula(), c);
       }
    }
        
    public void agregarCliente(Cliente cliente ){
        clientes.put(cliente.getCedula(), cliente);
    }
    public void agregarUsuario(Usuario usuario ){
        usuarios.put(usuario.getCedula(), usuario);
    }
}
