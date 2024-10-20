package Personaje;

import Logica.Visitor;

public class EstadoDeFuego extends EstadoSuperMario {
	
    public EstadoDeFuego(Personaje personaje) {
      super(personaje);
    }

    public void correr() {
    
    }

    public void saltar() {
    
    }

    public void morir() {
    	
    }
    
    public void recibirDano() {
    	super.personaje.cambiarEstado(new EstadoSuperMario(super.personaje));
    }

    public void aceptarVisita(Visitor v) {
    
    }

}