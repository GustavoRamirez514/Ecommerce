/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Vista.V_GestionInmueble;
import javax.swing.JOptionPane;
import realestatecalicity.Principal;

/**
 *
 * @author GUSTAVO RAMIREZ
 */
public class HiloTiempo extends Thread{
    V_GestionInmueble p;
    
    public HiloTiempo(V_GestionInmueble p){
      this.p = p;
    }
    
    public void run() {
        int Minutos = 00;
        int Segundos = 00;
        int Horas= 00;
        

        try {
            for (;;) {
                    if (Segundos != 59) {
                        Segundos++;
                    } else {
                        if (Minutos != 59) {
                            Segundos = 00;
                            Minutos++;
                        } else {//incremento el numero de horas
                            Horas++;
                            Minutos = 00;//pongo en cero los minutos
                            Segundos = 00;//pongo en cero los segundos    
                        }
                       }

                String Tiempo=Horas + ":" + Minutos + ":" + Segundos;
                sleep(1000);
                p.setTiempo(Tiempo);
            }
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el hilo");
        }

    }
    
}
