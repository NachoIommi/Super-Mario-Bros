package Personaje;

import Logica.Visitor;

public class EstadoSuperMario extends EstadoDePersonaje {
	
	protected Personaje personaje;
	
	public EstadoSuperMario(Personaje personaje) {
		super(personaje);
	}

    public void correr() {
      
    }

    public void saltar() {
    	
    }

    public void morir() {
    	
    }
    
    public void recibirDano() {
    	personaje.cambiarEstado(new EstadoNormal(personaje));
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
	
	public int getFactorVelocidad() {
		return 1;
	}
	
}