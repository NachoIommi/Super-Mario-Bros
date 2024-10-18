package Personaje;

import Logica.Visitor;

public class EstadoNormal implements EstadoDePersonaje {
	
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

	public void setPuntuacion(int n) {
		personaje.setPuntuacion(n);
	}

	@Override
	public void setPuntuacionChampiVerde() {
		personaje.setPuntuacion(100);
	}

	@Override
	public void setPuntuacionEstrella() {
		personaje.setPuntuacion(20);
	}

	@Override
	public void setPuntuacionFlorDeFuego() {
		personaje.setPuntuacion(5);
	}

	@Override
	public void setPuntuacionSuperChampi() {
		personaje.setPuntuacion(10);
	}
 
}
