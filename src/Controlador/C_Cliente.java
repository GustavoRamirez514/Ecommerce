/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Cliente;
import Vista.V_EditarProducto;
import Vista.V_GestionProductoAdmin;
import Vista.V_GestionCliente;
import Vista.V_Login;
import Vista.V_Perfil;
import Vista.V_Registro;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ecommerce.Principal;

/**
 *
 * @author wdg20
 */
public class C_Cliente {

    V_Login Iu_login;
    V_Registro Iu_registro;
    V_GestionCliente Iu_GestionCliente;
    V_Perfil Iu_Perfil;
    
    public static boolean usuario = false;

    

    public static M_Cliente UsuarioEnSesion;

    public C_Cliente() {

    }

    
    
    public void IniciarSesion() {
        M_Cliente u = new M_Cliente();
        String ID = Iu_login.getIdentificacion();
        String Clave = Iu_login.getContraseña();
        String Tipo = Iu_login.getTipoUsuario();

        //creo el objeto con los datos que conozco documento y clave
        u.setDocumento(ID);
        u.setContraseña(Clave);
        u.setTipoDeUsuario(Tipo);

        if (C_Cliente.UsuarioEnSesion == null) {
            C_Cliente.UsuarioEnSesion = u.IniciarSesion();
            if (UsuarioEnSesion != null) {

                JOptionPane.showMessageDialog(null, "Bienvenido\n" + UsuarioEnSesion.getNombre() + " " + UsuarioEnSesion.getApellido());
                //cierra ventana inicio de sesion
                Iu_login.dispose();
                //habilita el menu usuarios
                Iu_login.HabilitarMenu("Gestión");

                if (Tipo.equals("Cliente")) {
                    usuario = true;
                    Principal.G_Clientes.setVisible(false);
                    Principal.G_ProductosAdmin.setVisible(false);

                    //V_GestionInmueble.Deshabilitar();
                } else {
                    usuario = false;
                }
                if (Tipo.equals("Administrador")) {

                    Principal.G_Perfil.setVisible(false);
                    Principal.G_ProductosClientes.setVisible(false);

                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario en la sesión");

        }

    }

    public void Registro() {
        M_Cliente u = new M_Cliente();

        u.setNombre(Iu_registro.getNombre());
        u.setApellido(Iu_registro.getApellido());
        u.setDocumento(this.Iu_registro.getDocumento());
        u.setTelefono(Iu_registro.getTelefono());
        u.setCorreo(Iu_registro.getCorreo());
        u.setTipoDeUsuario(Iu_registro.getTipoUsuario());
        u.setContraseña(Iu_registro.getContraseña());

        if (!u.RegistrarUsuario()) {
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
            Iu_registro.dispose();
        }
    }

    public void ListarUsuarios() {
        M_Cliente u = new M_Cliente();
        ArrayList<M_Cliente> Usuarios = u.ListarUsuarios();
        //recorro el listado de usuarios
        for (M_Cliente us : Usuarios) {
            //los envio a la tabla en la IU listado}
            String datos[] = {String.valueOf(us.getIdentificador()), us.getNombre(),
                us.getApellido(), us.getDocumento(), us.getTelefono(), us.getCorreo()};
            this.Iu_GestionCliente.AgregarFila(datos);
        }
    }

    public void ConsultarUsuarioId(int id) {
        M_Cliente u = new M_Cliente();
        //consulta un usuario por el id
        u = u.ConsultaUsuarioId(id);
        V_Perfil vu = new V_Perfil();
        //pongo la información del usuario en los campos
        vu.setIdentificador(String.valueOf(u.getIdentificador()));
        vu.setNombre(UsuarioEnSesion.getNombre());
        vu.setApellido(UsuarioEnSesion.getApellido());
        vu.setDocumento(UsuarioEnSesion.getDocumento());
        vu.setTelefono(UsuarioEnSesion.getTelefono());
        vu.setCorreo(UsuarioEnSesion.getCorreo());
        vu.setContraseña(UsuarioEnSesion.getContraseña());

        vu.setLocationRelativeTo(Iu_Perfil);
        vu.setVisible(true);

    }

    public void ActualizarUsuario() {
        M_Cliente u = new M_Cliente();
        u.setIdentificador(Integer.parseInt(Iu_Perfil.getIdentificador()));
        u.setNombre(Iu_Perfil.getNombre());
        u.setApellido(Iu_Perfil.getApellido());
        u.setDocumento(Iu_Perfil.getDocumento());
        u.setTelefono(Iu_Perfil.getTelefono());
        u.setCorreo(Iu_Perfil.getCorreo());
        u.setContraseña(Iu_Perfil.getContraseña());

        u.ActualizarUsuario();

    }

    public V_Login getIu_login() {
        return Iu_login;
    }

    public void setIu_login(V_Login Iu_login) {
        this.Iu_login = Iu_login;
    }

    public V_Registro getIu_registro() {
        return Iu_registro;
    }

    public void setIu_registro(V_Registro Iu_registro) {
        this.Iu_registro = Iu_registro;
    }

    public V_GestionCliente getIu_GestionUsuarios() {
        return Iu_GestionCliente;
    }

    public void setIu_GestionUsuarios(V_GestionCliente Iu_GestionCliente) {
        this.Iu_GestionCliente = Iu_GestionCliente;
    }

    public V_Perfil getIu_Perfil() {
        return Iu_Perfil;
    }

    public void setIu_Perfil(V_Perfil Iu_Perfil) {
        this.Iu_Perfil = Iu_Perfil;
    }
}
