package Personaje;

import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

public class EstadoNormal extends EstadoDePersonaje {
	
	protected Personaje personaje;
	
	public EstadoNormal(Personaje personaje) {
		super(personaje);
	}
	

    public void correr() {
        
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


	public void romperBloque(LadrilloSolido l) {
		// TODO Auto-generated method stub
		
	}


	public void moverLadrilloSolido(LadrilloSolido l) {
		// TODO Auto-generated method stub
		
	}


	public void moverBloqueGolpeable(BloqueGolpeable b) {
		// TODO Auto-generated method stub
		
	}
	
 
}
