package Enemigos;

import Logica.Visitor;

public class PiranhaInvulnerable implements EstadosDePiranhaPlant {
    private PiranhaPlant piranha;

    public PiranhaInvulnerable(PiranhaPlant piranha) {
        this.piranha = piranha;
    }

    public void moverse() {
       
    }

    public void morir() {
      
    }

    public void aceptarVisita(Visitor v) {
       
    }

}
