/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Inmuebles;
import Utilidades.ConexionBD;
import Vista.V_CrearInmueble;
import Vista.V_EditarInmueble;
import Vista.V_GestionInmueble;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wdg20
 */
public class C_Inmuebles {

    V_GestionInmueble Iu_GestionInmueble;
    V_CrearInmueble Iu_CrearInmueble;
    V_EditarInmueble Iu_EditarInmueble;

    public C_Inmuebles() {
    }

    public void CrearInmueble() {

        M_Inmuebles e = new M_Inmuebles();

        e.setTipoInmueble(Iu_CrearInmueble.getTipoInmueble());
        e.setAreaInmueble(Iu_CrearInmueble.getAreaInmueble());
        e.setCantidadHabitaciones(Iu_CrearInmueble.getCantidadHabitaciones());
        e.setCantidadBaños(Iu_CrearInmueble.getCantidadBaños());
        e.setCantidadPisos(Iu_CrearInmueble.getCantidadPisos());
        e.setDireccion(Iu_CrearInmueble.getDireccion());
        e.setTipoProceso(Iu_CrearInmueble.getTipoProceso());
        e.setPrecio(Iu_CrearInmueble.getPrecio());
        e.setEstado(Iu_CrearInmueble.getEstado());
        e.setFechaVentaAlquiler(Iu_CrearInmueble.getFechaVentaAlquiler());
        e.setAgenteEncargado(Iu_CrearInmueble.getAgenteEncargado());
        e.setDescripcion(Iu_CrearInmueble.getDescripcion());

        if (!e.RegistrarInmueble()) {
            JOptionPane.showMessageDialog(null, "Inmueble creado exitosamente");

            Iu_CrearInmueble.dispose();
        }

    }

    public void ListarInmuebles() {
        M_Inmuebles u = new M_Inmuebles();
        ArrayList<M_Inmuebles> Inmuebles = u.ListarInmuebles();
        
        for (M_Inmuebles us : Inmuebles) {
            
            String datos[] = {String.valueOf(us.getIdentificador()), us.getTipoInmueble(),
                us.getAreaInmueble(), us.getCantidadHabitaciones(), us.getCantidadBaños(),
                us.getCantidadPisos(), us.getDireccion(), us.getTipoProceso(), us.getPrecio(),
                us.getEstado(), us.getFechaVentaAlquiler(), us.getAgenteEncargado(), us.getDescripcion()
            };
            this.Iu_GestionInmueble.AgregarFila(datos);
        }

    }

    public void ConsultarInmuebleId(int Identificador) {
        M_Inmuebles u = new M_Inmuebles();
        //consulta un usuario por el id
        u = u.ConsultaInmuebleId(Identificador);
        V_EditarInmueble vu = new V_EditarInmueble();
        //pongo la información del usuario en los campos

        vu.setIdentificador(String.valueOf(u.getIdentificador()));
        vu.setTipoInmueble(u.getTipoInmueble());
        vu.setAreaInmueble(u.getAreaInmueble());
        vu.setCantidadHabitaciones(u.getCantidadHabitaciones());
        vu.setCantidadBaños(u.getCantidadBaños());
        vu.setCantidadPisos(u.getCantidadPisos());
        vu.setDireccion(u.getDireccion());
        vu.setTipoProceso(u.getTipoProceso());
        vu.setPrecio(u.getPrecio());
        vu.setEstado(u.getEstado());
        vu.setFechaVentaAlquiler(u.getFechaVentaAlquiler());
        vu.setAgenteEncargado(u.getAgenteEncargado());
        vu.setDescripcion(u.getDescripcion());

        vu.setLocationRelativeTo(Iu_GestionInmueble);//Iu_CrearInmueble
        vu.setVisible(true);

    }

    public void ActualizarInmueble() {
        M_Inmuebles u = new M_Inmuebles();
        
        
        u.setIdentificador(Integer.parseInt(Iu_EditarInmueble.getIdentificador()));
        u.setTipoInmueble(Iu_EditarInmueble.getTipoInmueble());
        u.setAreaInmueble(Iu_EditarInmueble.getAreaInmueble());
        u.setCantidadHabitaciones(Iu_EditarInmueble.getCantidadHabitaciones());
        u.setCantidadBaños(Iu_EditarInmueble.getCantidadBaños());
        u.setCantidadPisos(Iu_EditarInmueble.getCantidadPisos());
        u.setDireccion(Iu_EditarInmueble.getDireccion());
        u.setTipoProceso(Iu_EditarInmueble.getTipoProceso());
        u.setPrecio(Iu_EditarInmueble.getPrecio());
        u.setEstado(Iu_EditarInmueble.getEstado());
        u.setFechaVentaAlquiler(Iu_EditarInmueble.getFechaVentaAlquiler());
        u.setAgenteEncargado(Iu_EditarInmueble.getAgenteEncargado());
        u.setDescripcion(Iu_EditarInmueble.getDescripcion());

        u.ActualizarInmueble();

    }
     

    public V_CrearInmueble getIu_registro() {
        return Iu_CrearInmueble;
    }

    public void setIu_registro(V_CrearInmueble Iu_CrearInmueble) {
        this.Iu_CrearInmueble = Iu_CrearInmueble;
    }

    public V_GestionInmueble getIu_GestionInmueble() {
        return Iu_GestionInmueble;
    }

    public void setIu_GestionInmueble(V_GestionInmueble Iu_GestionInmueble) {
        this.Iu_GestionInmueble = Iu_GestionInmueble;
    }

    public V_CrearInmueble getIu_CrearInmueble() {
        return Iu_CrearInmueble;
    }

    public void setIu_CrearInmueble(V_CrearInmueble Iu_CrearInmueble) {
        this.Iu_CrearInmueble = Iu_CrearInmueble;
    }

    public V_EditarInmueble getIu_EditarInmueble() {
        return Iu_EditarInmueble;
    }

    public void setIu_EditarInmueble(V_EditarInmueble Iu_EditarInmueble) {
        this.Iu_EditarInmueble = Iu_EditarInmueble;
    }

}
