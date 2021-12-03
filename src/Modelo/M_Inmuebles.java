/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Utilidades.ConexionBD;
import static Vista.V_GestionInmueble.G_Tabla;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wdg20
 */
public class M_Inmuebles {

    String TipoInmueble, AreaInmueble, CantidadHabitaciones, CantidadBaños, CantidadPisos,
            Direccion, TipoProceso, Precio, Estado, FechaVentaAlquiler, AgenteEncargado, Descripcion;
    int Identificador;

    public M_Inmuebles() {
    }

    public int getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(int Identificador2) {
        this.Identificador = Identificador2;
    }

    public String getTipoInmueble() {
        return TipoInmueble;
    }

    public void setTipoInmueble(String TipoInmueble) {
        this.TipoInmueble = TipoInmueble;
    }

    public String getAreaInmueble() {
        return AreaInmueble;
    }

    public void setAreaInmueble(String AreaInmueble) {
        this.AreaInmueble = AreaInmueble;
    }

    public String getCantidadHabitaciones() {
        return CantidadHabitaciones;
    }

    public void setCantidadHabitaciones(String CantidadHabitaciones) {
        this.CantidadHabitaciones = CantidadHabitaciones;
    }

    public String getCantidadBaños() {
        return CantidadBaños;
    }

    public void setCantidadBaños(String CantidadBaños) {
        this.CantidadBaños = CantidadBaños;
    }

    public String getCantidadPisos() {
        return CantidadPisos;
    }

    public void setCantidadPisos(String CantidadPiso) {
        this.CantidadPisos = CantidadPiso;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTipoProceso() {
        return TipoProceso;
    }

    public void setTipoProceso(String TipoProceso) {
        this.TipoProceso = TipoProceso;
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

    public String getFechaVentaAlquiler() {
        return FechaVentaAlquiler;
    }

    public void setFechaVentaAlquiler(String FechaVentaAlquiler) {
        this.FechaVentaAlquiler = FechaVentaAlquiler;
    }

    public String getAgenteEncargado() {
        return AgenteEncargado;
    }

    public void setAgenteEncargado(String AgenteEncargado) {
        this.AgenteEncargado = AgenteEncargado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean RegistrarInmueble() {

        ConexionBD C = new ConexionBD();
        boolean Exito = false;
        M_Inmuebles U = null;
        String sql = "insert into inmuebles(TipoDeInmueble , Area, CantidadDeHabitaciones, CantidadDeBaños, CantidadDePisos, Direccion, TipoDeProceso, Precio, Estado, Fecha, AgenteEncargado, Descripcion)";
        sql += "values (";
        sql += "'" + this.TipoInmueble + "','" + this.AreaInmueble + "','" + this.CantidadHabitaciones
                + "','" + this.CantidadBaños + "','" + this.CantidadPisos + "','" + this.Direccion + "','"
                + this.TipoProceso + "','" + this.Precio + "','" + this.Estado + "','" + this.FechaVentaAlquiler
                + "','" + this.AgenteEncargado + "','" + this.Descripcion + "')";
        try {
            Exito = C.ejecutarSql(sql);
            C.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
        return Exito;
    }

    public M_Inmuebles ConsultaInmuebleId(int Identificador) {
        ConexionBD c = new ConexionBD();
        M_Inmuebles u = null;
        String sql = "select * from inmuebles where Identificador=" + Identificador;
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                u = new M_Inmuebles();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setTipoInmueble(rs.getString("TipoDeInmueble"));
                u.setAreaInmueble(rs.getString("Area"));
                u.setCantidadHabitaciones(rs.getString("CantidadDeHabitaciones"));
                u.setCantidadBaños(rs.getString("CantidadDeBaños"));
                u.setCantidadPisos(rs.getString("CantidadDePisos"));
                u.setDireccion(rs.getString("Direccion"));
                u.setTipoProceso(rs.getString("TipoDeProceso"));
                u.setPrecio(rs.getString("Precio"));
                u.setEstado(rs.getString("Estado"));
                u.setFechaVentaAlquiler(rs.getString("Fecha"));
                u.setAgenteEncargado(rs.getString("AgenteEncargado"));
                u.setDescripcion(rs.getString("Descripcion"));
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");

        }

        return u;
    }

    public ArrayList<M_Inmuebles> ListarInmuebles() {
        ConexionBD c = new ConexionBD();
        
        ArrayList<M_Inmuebles> inmuebles = new ArrayList<M_Inmuebles>();
        
        String sql = "select * from inmuebles where Estado !='Eliminado'";
        try {
            //ejecuta consulta
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                M_Inmuebles u = new M_Inmuebles();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setTipoInmueble(rs.getString("TipoDeInmueble"));
                u.setAreaInmueble(rs.getString("Area"));
                u.setCantidadHabitaciones(rs.getString("CantidadDeHabitaciones"));
                u.setCantidadBaños(rs.getString("CantidadDeBaños"));
                u.setCantidadPisos(rs.getString("CantidadDePisos"));
                u.setDireccion(rs.getString("Direccion"));
                u.setTipoProceso(rs.getString("TipoDeProceso"));
                u.setPrecio(rs.getString("Precio"));
                u.setEstado(rs.getString("Estado"));
                u.setFechaVentaAlquiler(rs.getString("Fecha"));
                u.setAgenteEncargado(rs.getString("AgenteEncargado"));
                u.setDescripcion(rs.getString("Descripcion"));

                //agrego el usuario al arraylist
                inmuebles.add(u);
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");

        }

        return inmuebles;
    }

    public void ActualizarInmueble() {
        ConexionBD c = new ConexionBD();
        boolean exito = false;
        String sql = "update inmuebles set ";
        sql += "TipoDeInmueble = '" + this.TipoInmueble + "',";
        sql += "Area = '" + this.AreaInmueble + "',";
        sql += "CantidadDeHabitaciones = '" + this.CantidadHabitaciones + "',";
        sql += "CantidadDeBaños = '" + this.CantidadBaños + "',";
        sql += "CantidadDePisos = '" + this.CantidadPisos + "', ";
        sql += "Direccion = '" + this.Direccion + "', ";
        sql += "TipoDeProceso = '" + this.TipoProceso + "', ";
        sql += "Precio = '" + this.Precio + "', ";
        sql += "Estado = '" + this.Estado + "', ";
        sql += "Fecha = '" + this.FechaVentaAlquiler + "', ";
        sql += "AgenteEncargado = '" + this.AgenteEncargado + "', ";
        sql += "Descripcion = '" + this.Descripcion + "' ";

        sql += " where Identificador = " + this.Identificador;
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

    }

 
}
