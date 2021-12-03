/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Utilidades.ConexionBD;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author GUSTAVO RAMIREZ
 */
public class M_Agenda {

    String Cliente, Agente, Fecha, Observaciones, IdInmueble, Estado;
    int Identificador;

    public M_Agenda() {
    }

    public String getIdInmueble() {
        return IdInmueble;
    }

    public void setIdInmueble(String IdInmueble) {
        this.IdInmueble = IdInmueble;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getAgente() {
        return Agente;
    }

    public void setAgente(String Agente) {
        this.Agente = Agente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public int getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(int Identificador) {
        this.Identificador = Identificador;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public boolean RegistrarCita() {

        ConexionBD C = new ConexionBD();
        boolean Exito = false;
        M_Usuario u = null;
        String sql = "insert into citas(IdInmueble, Cliente, Agente, Estado, Fecha, Observaciones)";
        sql += "values (";
        sql += "'" + this.IdInmueble + "','" + this.Cliente + "','" + this.Agente + "','" + this.Estado + "','" + this.Fecha + "','" + this.Observaciones + "')";
        try {
            Exito = C.ejecutarSql(sql);
            C.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return Exito;

    }

    public M_Agenda ConsultaCitaId(int Identificador) {
        ConexionBD c = new ConexionBD();
        M_Agenda u = null;
        String sql = "select * from citas where Identificador=" + Identificador;
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                u = new M_Agenda();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setIdInmueble(rs.getString("IdInmueble"));
                u.setCliente(rs.getString("Cliente"));
                u.setAgente(rs.getString("Agente"));
                u.setEstado(rs.getString("Estado"));
                u.setFecha(rs.getString("Fecha"));
                u.setObservaciones(rs.getString("Observaciones"));

            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");

        }
        return u;

    }
    
    
    public ArrayList<M_Agenda> ListarCitas() {
        ConexionBD c = new ConexionBD();
        
        ArrayList<M_Agenda> agenda = new ArrayList<M_Agenda>();
        
        String sql = "select * from citas where Estado!='Terminada'";
        try {
            //ejecuta consulta
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                M_Agenda u = new M_Agenda();
                u.setIdentificador(rs.getInt("Identificador"));
                u.setIdInmueble(rs.getString("IdInmueble"));
                u.setCliente(rs.getString("Cliente"));
                u.setAgente(rs.getString("Agente"));
                u.setEstado(rs.getString("Estado"));
                u.setFecha(rs.getString("Fecha"));
                u.setObservaciones(rs.getString("Observaciones"));

                //agrego el usuario al arraylist
                agenda.add(u);
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");

        }

        return agenda;
    }
 
    public void ActualizarCita() {
        ConexionBD c = new ConexionBD();
        boolean exito = false;
        String sql = "update citas set ";
        sql += "IdInmueble = '" + this.IdInmueble + "',";
        sql += "Cliente = '" + this.Cliente + "',";
        sql += "Agente = '" + this.Agente + "',";
        sql += "Estado = '" + this.Estado + "',";
        sql += "Fecha = '" + this.Fecha + "', ";
        sql += "Observaciones = '" + this.Observaciones + "' ";

        sql += " where Identificador = " + this.Identificador;
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

    }
    
}
