package Personaje;

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
    //estos dos de aca abajo tal vez no hacen falta :: ver!
	public void sumarVida() {
		
	}

	public void sumarPuntos(int n) {

	}
}
