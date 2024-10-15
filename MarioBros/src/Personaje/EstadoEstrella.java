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

	@Override
	public void sumarVida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sumarPuntos(int n) {
		// TODO Auto-generated method stub
		
	}
    
}
