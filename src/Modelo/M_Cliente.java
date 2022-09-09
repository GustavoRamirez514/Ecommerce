/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Utilidades.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wdg20
 */
public class M_Cliente {

    String Nombre, Apellido, Documento, Telefono, Correo, TipoDeUsuario, Contraseña;
    int Identificador;

    public M_Cliente() {
    }

    public int getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(int Identificador) {
        this.Identificador = Identificador;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTipoDeUsuario() {
        return TipoDeUsuario;
    }

    public void setTipoDeUsuario(String TipoDeUsario) {
        this.TipoDeUsuario = TipoDeUsario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public M_Cliente IniciarSesion() {
        ConexionBD C = new ConexionBD();
        M_Cliente u = null;
        String sql = "select * from usuarios where Documento='" + this.Documento + "' and TipoDeUsuario='" + this.TipoDeUsuario + "' and Contraseña='" + this.Contraseña + "' ";
        try {
            ResultSet rs = C.ejecutarQuery(sql);

            if (rs.next()) {
                u = new M_Cliente();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setNombre(rs.getString("Nombre"));
                u.setApellido(rs.getString("Apellido"));
                u.setDocumento(rs.getString("Documento"));
                u.setTelefono(rs.getString("Telefono"));
                u.setCorreo(rs.getString("Correo"));
                u.setTipoDeUsuario("TipoDeUsuario");
                u.setContraseña(rs.getString("Contraseña"));
            }
            C.cerrarConexion();
        } catch (SQLException e) {

        }

        return u;
    }
  
    
    public boolean RegistrarUsuario() {

        ConexionBD C = new ConexionBD();
        boolean Exito = false;
        M_Cliente u = null;
        String sql = "insert into usuarios( Nombre, Apellido, Documento, Telefono, Correo, TipoDeUsuario, Contraseña)";
        sql += "values (";
        sql += "'" + this.Nombre + "','" + this.Apellido + "','" + this.Documento + "','" + this.Telefono + "','" + this.Correo + "','" + this.TipoDeUsuario + "','" + this.Contraseña + "')";
        try {
            Exito = C.ejecutarSql(sql);
            C.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return Exito;

    }

    public M_Cliente ConsultaUsuarioId(int Identificador) {
        ConexionBD c = new ConexionBD();
        M_Cliente u = null;
        String sql = "select * from usuarios where Identificador=" + Identificador;
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                u = new M_Cliente();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setNombre(rs.getString("Nombre"));
                u.setApellido(rs.getString("Apellido"));
                u.setDocumento(rs.getString("Documento"));
                u.setTelefono(rs.getString("Telefono"));
                u.setCorreo(rs.getString("Correo"));
                u.setContraseña(rs.getString("Contraseña"));

            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");

        }

        return u;
    }

    public ArrayList<M_Cliente> ListarUsuarios() {
        ConexionBD c = new ConexionBD();
        //creo arraylist de usuarios
        ArrayList<M_Cliente> usuarios = new ArrayList<M_Cliente>();
        //consulto todos los usuarios
        String sql = "select * from usuarios where TipoDeUsuario!= 'Administrador'" ;
        try {
            //ejecuta consulta
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                M_Cliente u = new M_Cliente();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setNombre(rs.getString("Nombre"));
                u.setApellido(rs.getString("Apellido"));
                u.setDocumento(rs.getString("Documento"));
                u.setTelefono(rs.getString("Telefono"));
                u.setCorreo(rs.getString("Correo"));
                u.setTipoDeUsuario(rs.getString("TipoDeUsuario"));
                u.setContraseña(rs.getString("Contraseña"));
                //agrego el usuario al arraylist
                usuarios.add(u);
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");

        }

        return usuarios;
    }

    public void ActualizarUsuario() {
        ConexionBD c = new ConexionBD();
        boolean exito = false;
        String sql = "update usuarios set ";
        sql += "Nombre = '" + this.Nombre + "',";
        sql += "Apellido = '" + this.Apellido + "',";
        sql += "Correo = '" + this.Correo + "',";
        sql += "Telefono = '" + this.Telefono + "',";
        sql += "Contraseña = '" + this.Contraseña + "' ";
        sql += " where Identificador = " + this.Identificador;
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

    }

}
