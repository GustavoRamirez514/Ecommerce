/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Productos;
import Utilidades.ConexionBD;
import Vista.V_CrearProducto;
import Vista.V_EditarProducto;
import Vista.V_GestionProductoAdmin;
import Vista.V_GestionProductoCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wdg20
 */
public class C_Productos {

    V_GestionProductoAdmin Iu_GestionProductoAdmin;
    V_GestionProductoCliente Iu_GestionProductoCliente;
    V_CrearProducto Iu_CrearProducto;
    V_EditarProducto Iu_EditarProducto;

    public C_Productos() {
    }

    public void CrearProducto() {

        M_Productos e = new M_Productos();
        e.setNombre(Iu_CrearProducto.getNombre());
        e.setPrecio(Iu_CrearProducto.getPrecio());
        
        e.setDescripcion(Iu_CrearProducto.getDescripcion());
        e.setEstado(Iu_CrearProducto.getEstado());

        if (!e.RegistrarProductos()) {
            JOptionPane.showMessageDialog(null, "Producto creado exitosamente");

            Iu_CrearProducto.dispose();
        }

    }

    public void ListarProductosAdmin() {
        M_Productos u = new M_Productos();
        ArrayList<M_Productos> Productos = u.ListarProductos();
        
        for (M_Productos us : Productos) {
            
            String datos[] = {String.valueOf(us.getIdentificador()),us.getNombre(),us.getPrecio(), us.getDescripcion(), us.getEstado()};
            this.Iu_GestionProductoAdmin.AgregarFila(datos);
        }

    }

    
    public void ListarProductosCliente() {
        M_Productos u = new M_Productos();
        ArrayList<M_Productos> Productos = u.ListarProductos();
        
        for (M_Productos us : Productos) {
            
            String datos[] = {String.valueOf(us.getIdentificador()),us.getNombre(),us.getPrecio(), us.getDescripcion(), us.getEstado()};
            this.Iu_GestionProductoCliente.AgregarFila(datos);
        }

    }
    
    public void ConsultarProductoId(int Identificador) {
        M_Productos u = new M_Productos();
        //consulta un usuario por el id
        u = u.ConsultaProductoId(Identificador);
        V_EditarProducto vu = new V_EditarProducto();
        //pongo la información del usuario en los campos

        vu.setIdentificador(String.valueOf(u.getIdentificador()));
        vu.setNombre(u.getNombre());
        vu.setPrecio(u.getPrecio());
        vu.setDescripcion(u.getDescripcion());
        vu.setEstado(u.getEstado());

        vu.setLocationRelativeTo(Iu_GestionProductoAdmin);//Iu_CrearInmueble
        vu.setLocationRelativeTo(Iu_GestionProductoCliente);
        vu.setVisible(true);

    }

    public void ActualizarProducto() {
        M_Productos u = new M_Productos();
        
        
        u.setIdentificador(Integer.parseInt(Iu_EditarProducto.getIdentificador()));
        u.setNombre(Iu_EditarProducto.getNombre());
        u.setPrecio(Iu_EditarProducto.getPrecio());
        u.setDescripcion(Iu_EditarProducto.getDescripcion());
        u.setEstado(Iu_EditarProducto.getEstado());
        u.ActualizarProducto();

    }
     

    public V_CrearProducto getIu_registro() {
        return Iu_CrearProducto;
    }

    public void setIu_registro(V_CrearProducto Iu_CrearProducto) {
        this.Iu_CrearProducto = Iu_CrearProducto;
    }

    public V_GestionProductoAdmin getIu_GestionProductoAdmin() {
        return Iu_GestionProductoAdmin;
    }

    public void setIu_GestionProductoAdmin(V_GestionProductoAdmin Iu_GestionProductoAdmin) {
        this.Iu_GestionProductoAdmin = Iu_GestionProductoAdmin;
    }
    
    
    
    public V_GestionProductoCliente getIu_GestionProductoCliente() {
        return Iu_GestionProductoCliente;
    }

    public void setIu_GestionProductoCliente(V_GestionProductoCliente Iu_GestionProductoCliente) {
        this.Iu_GestionProductoCliente = Iu_GestionProductoCliente;
    }
    
    

    public V_CrearProducto getIu_CrearProducto() {
        return Iu_CrearProducto;
    }

    public void setIu_CrearProducto(V_CrearProducto Iu_CrearProducto) {
        this.Iu_CrearProducto = Iu_CrearProducto;
    }

    public V_EditarProducto getIu_EditarProducto() {
        return Iu_EditarProducto;
    }

    public void setIu_EditarProducto(V_EditarProducto Iu_EditarProducto) {
        this.Iu_EditarProducto = Iu_EditarProducto;
    }

}
