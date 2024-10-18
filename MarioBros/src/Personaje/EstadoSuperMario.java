package Personaje;

import Logica.Visitor;

public class EstadoSuperMario implements EstadoDePersonaje {
	
	private Personaje personaje;
	
    public EstadoSuperMario(Personaje personaje) {
      
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

	public void setPuntuacion(int n) {
		personaje.setPuntuacion(n);
	}

	public void setPuntuacionChampiVerde() {
		personaje.setPuntuacion(100);
	}

	public void setPuntuacionEstrella() {
		personaje.setPuntuacion(30);
	}

	public void setPuntuacionFlorDeFuego() {
		personaje.setPuntuacion(30);
	}

	public void setPuntuacionSuperChampi() {
		personaje.setPuntuacion(50);
	}
	
}