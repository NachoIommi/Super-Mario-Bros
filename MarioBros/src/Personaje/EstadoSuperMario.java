package Personaje;

import Fabricas.GenerarLadrilloSolido;
import Fabricas.GenerarPlataformas;
import Fabricas.Sprite;
import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

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
	public void romperLadrilloSolido(LadrilloSolido l) {
		Sprite s = new Sprite("/spritesOriginales/bloqueSolido1");
		l.cargarSprite(s);
		//l. tiene que haber un metodo que lo setee nulo al ladrillo
	}
	public void moverBloqueGolpeable(BloqueGolpeable b) {
		// en ambos estados le cambia el gif por medio segundo y el bloque me da una moneda o algun power up
	}
	
}