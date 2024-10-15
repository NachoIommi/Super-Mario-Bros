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

	@Override
	public void sumarVida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sumarPuntos(int n) {
		// TODO Auto-generated method stub
		
	}
 
}
