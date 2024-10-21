package Personaje;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

public class EstadoNormal extends EstadoDePersonaje {
	
	//protected Personaje personaje;
	protected Sprite sprite;
	
	public EstadoNormal(Personaje personaje) {
		super(personaje);
	}
	

    public void correr() {
        GenerarSprite fabrica = new GenerarSpriteOriginal();
        sprite = fabrica.getPersonajeNormalCorriendo();
        personaje.cargarSprite(sprite);
    }

    public void saltar() {
    	
    }

    public void morir() {
    	personaje.setVidas(personaje.getVidas()-1);
    	//personaje.cargarSprite("spritesOriginales\marioNormalMuerto.png"); 
    }
    
    public void recibirDano() {
		personaje.morir();
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
		personaje.setPuntuacion(20);
	}

	public void setPuntuacionFlorDeFuego() {
		personaje.setPuntuacion(5);
	}

	public void setPuntuacionSuperChampi() {
		personaje.setPuntuacion(10);
	}


	public int getFactorVelocidad() {
		return 1;
	}


	public void romperLadrilloSolido(LadrilloSolido l) {
		// Mario en estado normal simplemente hace que se le mueva el gif si lo colisiona de abajo
		// por medio segundo 
	}

	public void moverBloqueGolpeable(BloqueGolpeable b) {
		// en ambos estados le cambia el gif por medio segundo y el bloque me da una moneda o algun power up
	}
	
 
}
