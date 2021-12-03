/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Usuario;
import Vista.V_EditarInmueble;
import Vista.V_EditarUsuario;
import Vista.V_GestionInmueble;
import Vista.V_GestionUsuario;
import Vista.V_Login;
import Vista.V_Registro;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import realestatecalicity.Principal;

/**
 *
 * @author wdg20
 */
public class C_Usuario {

    V_Login Iu_login;
    V_Registro Iu_registro;
    V_GestionUsuario Iu_GestionUsuarios;
    
    public static boolean usuario= false;
    
    V_EditarUsuario Iu_EditarUsuario;
    public static M_Usuario UsuarioEnSesion;

    public C_Usuario() {
   
        
    }

    public void IniciarSesion() {
        M_Usuario u = new M_Usuario();
        String ID = Iu_login.getIdentificacion();
        String Clave = Iu_login.getContraseña();
        String Tipo = Iu_login.getTipoUsuario();

        //creo el objeto con los datos que conozco documento y clave
        u.setDocumento(ID);
        u.setContraseña(Clave);
        u.setTipoDeUsuario(Tipo);

        if (C_Usuario.UsuarioEnSesion == null) {
            C_Usuario.UsuarioEnSesion = u.IniciarSesion();
            if (UsuarioEnSesion != null) {
                    
                JOptionPane.showMessageDialog(null, "Bienvenido\n" + UsuarioEnSesion.getNombre() + " " + UsuarioEnSesion.getApellido());
                //cierra ventana inicio de sesion
                Iu_login.dispose();
                //habilita el menu usuarios
                Iu_login.HabilitarMenu("Gestión");

                if (Tipo.equals("Cliente")) {
                    usuario= true;
                    Principal.G_Usuarios.setVisible(false);
                    Principal.G_Citas.setVisible(false);
                    
                    
                    //V_GestionInmueble.Deshabilitar();
                    
                } else {
                    usuario=false;
                }
                if (Tipo.equals("Agente")) {
                    
                    Principal.G_Usuarios.setVisible(false);
                }
                

            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario en la sesión");

        }

    }

    public void Registro() {
        M_Usuario u = new M_Usuario();

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
        M_Usuario u = new M_Usuario();
        ArrayList<M_Usuario> Usuarios = u.ListarUsuarios();
        //recorro el listado de usuarios
        for (M_Usuario us : Usuarios) {
            //los envio a la tabla en la IU listado}
            String datos[] = {String.valueOf(us.getIdentificador()), us.getNombre(),
                us.getApellido(), us.getDocumento(), us.getTelefono(), us.getCorreo(),
                us.getTipoDeUsuario(), us.getContraseña()};
            this.Iu_GestionUsuarios.AgregarFila(datos);
        }
    }

    public void ConsultarUsuarioId(int id) {
        M_Usuario u = new M_Usuario();
        //consulta un usuario por el id
        u = u.ConsultaUsuarioId(id);
        V_EditarUsuario vu = new V_EditarUsuario();
        //pongo la información del usuario en los campos
        vu.setIdentificador(String.valueOf(u.getIdentificador()));
        vu.setNombre(u.getNombre());
        vu.setApellido(u.getApellido());
        vu.setDocumento(u.getDocumento());
        vu.setTelefono(u.getTelefono());
        vu.setCorreo(u.getCorreo());
        vu.setTipoUsuario(u.getTipoDeUsuario());
        vu.setContraseña(u.getContraseña());

        vu.setLocationRelativeTo(Iu_GestionUsuarios);
        vu.setVisible(true);

    }

    public void ActualizarUsuario() {
        M_Usuario u = new M_Usuario();
        u.setIdentificador(Integer.parseInt(Iu_EditarUsuario.getIdentificador()));
        u.setNombre(Iu_EditarUsuario.getNombre());
        u.setApellido(Iu_EditarUsuario.getApellido());
        u.setDocumento(Iu_EditarUsuario.getDocumento());
        u.setTelefono(Iu_EditarUsuario.getTelefono());
        u.setCorreo(Iu_EditarUsuario.getCorreo());
        u.setTipoDeUsuario(Iu_EditarUsuario.getTipoUsuario());
        u.setContraseña(Iu_EditarUsuario.getContraseña());

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

    public V_GestionUsuario getIu_GestionUsuarios() {
        return Iu_GestionUsuarios;
    }

    public void setIu_GestionUsuarios(V_GestionUsuario Iu_GestionUsuarios) {
        this.Iu_GestionUsuarios = Iu_GestionUsuarios;
    }

    public V_EditarUsuario getIu_EditarUsuario() {
        return Iu_EditarUsuario;
    }

    public void setIu_EditarUsuario(V_EditarUsuario Iu_EditarUsuario) {
        this.Iu_EditarUsuario = Iu_EditarUsuario;
    }

}
