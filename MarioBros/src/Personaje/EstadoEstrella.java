package Personaje;

import Logica.Visitor;

public class EstadoEstrella implements EstadoDePersonaje {
	
	private Personaje personaje;
	
    public EstadoEstrella() {
     
    }

    public void correr() {
     
    }

    public void saltar() {
       
    }

    public void morir() {
       
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

	@Override
	public void setPuntuacion(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacionChampiVerde() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacionEstrella() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacionFlorDeFuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacionSuperChampi() {
		// TODO Auto-generated method stub
		
	}
    
}
