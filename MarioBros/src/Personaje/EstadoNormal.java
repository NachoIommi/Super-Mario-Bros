package Personaje;

import Logica.Visitor;

class EstadoNormal implements EstadoDePersonaje {
	
	private Personaje personaje;
	
    public EstadoNormal(Personaje personaje) {
    	this.personaje = personaje;
    }

    public void correr() {
        
    }

    public void saltar() {
    	
    }

    public void morir() {
    	
    }

    public void aceptarVisita(Visitor v) {
        
    }

    public Personaje getPersonaje() {
        return personaje;
    }

	public void sumarVida() {

	}

	public void sumarPuntos(int n) {

	}
 
}
