/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Agenda;
import Modelo.M_Inmuebles;
import Modelo.M_Usuario;
import Vista.V_AgendarCita;
import Vista.V_EditarCita;
import Vista.V_EditarInmueble;
import Vista.V_GestionCita;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author GUSTAVO RAMIREZ
 */
public class C_Agenda {
V_AgendarCita Iu_AgendarCita;
V_GestionCita Iu_GestionCita;
V_EditarCita Iu_EditarCita;

    
    public C_Agenda() {
    }
    
    public void RegistrarCita() {
        M_Agenda vu = new M_Agenda();
             
        vu.setIdInmueble(Iu_AgendarCita.getIdInmueble());
        vu.setCliente(Iu_AgendarCita.getCliente());
        vu.setAgente(Iu_AgendarCita.getAgente());
        vu.setEstado(Iu_AgendarCita.getEstado());
        vu.setFecha(Iu_AgendarCita.getFecha());
        vu.setObservaciones(Iu_AgendarCita.getObservaciones());

        if (!vu.RegistrarCita()) {
            JOptionPane.showMessageDialog(null, "Cita creada exitosamente");
            Iu_AgendarCita.dispose();
        }
    }
    
    
    public void ListarCitas() {
        M_Agenda u = new M_Agenda();
        ArrayList<M_Agenda> Agenda = u.ListarCitas();
        
        for (M_Agenda us : Agenda) {
            
            String datos[] = {String.valueOf(us.getIdentificador()), us.getIdInmueble(),
                us.getCliente(), us.getAgente(), us.getEstado(),
                us.getFecha(), us.getObservaciones()};
            this.Iu_GestionCita.AgregarFila(datos);
        }

    }
    
    
    public void ConsultarCitaId(int Identificador) {
        M_Agenda u = new M_Agenda();
        //consulta un usuario por el id
        u = u.ConsultaCitaId(Identificador);
        V_EditarCita vu = new V_EditarCita();
        //pongo la información del usuario en los campos

        vu.setIdentificador(String.valueOf(u.getIdentificador()));
        vu.setIdInmueble(u.getIdInmueble());
        vu.setCliente(u.getCliente());
        vu.setAgente(u.getAgente());
        vu.setEstado(u.getEstado());
        vu.setFecha(u.getFecha());
        vu.setObservaciones(u.getObservaciones());
    
        vu.setLocationRelativeTo(Iu_GestionCita);
        vu.setVisible(true);

    }
    
    
    public void ActualizarCita() {
        M_Agenda u = new M_Agenda();
        
        u.setIdentificador(Integer.parseInt(Iu_EditarCita.getIdentificador()));
        u.setIdInmueble(Iu_EditarCita.getIdInmueble());
        u.setCliente(Iu_EditarCita.getCliente());
        u.setAgente(Iu_EditarCita.getAgente());
        u.setEstado(Iu_EditarCita.getEstado());
        u.setFecha(Iu_EditarCita.getFecha());
        u.setObservaciones(Iu_EditarCita.getObservaciones());

        u.ActualizarCita();

    }
    

    public V_AgendarCita getIu_AgendarCita() {
        return Iu_AgendarCita;
    }

    public void setIu_AgendarCita(V_AgendarCita Iu_AgendarCita) {
        this.Iu_AgendarCita = Iu_AgendarCita;
    }

    public V_GestionCita getIu_GestionCita() {
        return Iu_GestionCita;
    }

    public void setIu_GestionCita(V_GestionCita Iu_GestionCita) {
        this.Iu_GestionCita = Iu_GestionCita;
    }

    public V_EditarCita getIu_EditarCita() {
        return Iu_EditarCita;
    }

    public void setIu_EditarCita(V_EditarCita Iu_EditarCita) {
        this.Iu_EditarCita = Iu_EditarCita;
    }
    
    
    
}
