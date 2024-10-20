package Personaje;

import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

public class EstadoEstrella extends EstadoDePersonaje {
	
	protected Personaje personaje;
	
	public EstadoEstrella(Personaje personaje) {
		super(personaje);
	}

    public void correr() {
     
    }

    public void saltar() {
       
    }

    public void morir() {
       
    }
    
    public void recibirDano() {
    	//No va a recibir danio nunca en este estado, solo de vacio
    }

    public void aceptarVisita(Visitor visitor) {
     
    }
    
    public Personaje getPersonaje() {
		return personaje;
        
    }

    public void setPersonaje(Personaje personaje) {
       
    }

	public void sumarVida() {
	
	}

	public void sumarPuntos(int n) {

	}

	
	public void setPuntuacion(int n) {
		
	}

	
	public void setPuntuacionChampiVerde() {
	}

	
	public void setPuntuacionEstrella() {
		
	}

	
	public void setPuntuacionFlorDeFuego() {
		
	}

	
	public void setPuntuacionSuperChampi() {
		
	}
	
	public int getFactorVelocidad() {
		return 4;
	}

	@Override
	public void romperBloque(LadrilloSolido l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverLadrilloSolido(LadrilloSolido l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverBloqueGolpeable(BloqueGolpeable b) {
		// TODO Auto-generated method stub
		
	}
    
}
