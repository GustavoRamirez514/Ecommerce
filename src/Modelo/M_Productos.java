/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Utilidades.ConexionBD;
import static Vista.V_GestionProductoAdmin.G_Tabla;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wdg20
 */
public class M_Productos {

    String Precio, Estado, Nombre, Descripcion;
    int Identificador;

    public M_Productos() {
    }

    public int getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(int Identificador2) {
        this.Identificador = Identificador2;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean RegistrarProductos() {

        ConexionBD C = new ConexionBD();
        boolean Exito = false;
        M_Productos U = null;
        String sql = "insert into productos(Nombre, Precio, Descripcion, Estado)";
        sql += "values (";
        sql += "'" + this.Nombre + "','" + this.Precio + "','" + this.Descripcion + "','" + this.Estado + "')";
        try {
            Exito = C.ejecutarSql(sql);
            C.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
        return Exito;
    }

    public M_Productos ConsultaProductoId(int Identificador) {
        ConexionBD c = new ConexionBD();
        M_Productos u = null;
        String sql = "select * from productos where Identificador=" + Identificador;
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                u = new M_Productos();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setNombre(rs.getString("Nombre"));
                u.setPrecio(rs.getString("Precio"));
                u.setDescripcion(rs.getString("Descripcion"));
                u.setEstado(rs.getString("Estado"));
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");

        }

        return u;
    }

    public ArrayList<M_Productos> ListarProductos() {
        ConexionBD c = new ConexionBD();
        
        ArrayList<M_Productos> productos = new ArrayList<M_Productos>();
        
        String sql = "select * from productos where Estado !='Eliminado'";
        try {
            //ejecuta consulta
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                M_Productos u = new M_Productos();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setNombre(rs.getString("Nombre"));
                u.setPrecio(rs.getString("Precio"));
                u.setDescripcion(rs.getString("Descripcion"));
                u.setEstado(rs.getString("Estado"));

                //agrego el usuario al arraylist
                productos.add(u);
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");

        }

        return productos;
    }

    public void ActualizarProducto() {
        ConexionBD c = new ConexionBD();
        boolean exito = false;
        String sql = "update productos set ";
        sql += "Nombre = '" + this.Nombre + "', ";
        sql += "Precio = '" + this.Precio + "', ";
        sql += "Descripcion = '" + this.Descripcion + "', ";
        sql += "Estado = '" + this.Estado + "' ";

        sql += " where Identificador = " + this.Identificador;
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

    }

 
}
