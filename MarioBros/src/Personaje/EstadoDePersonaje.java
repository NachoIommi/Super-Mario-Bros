package Personaje;

public abstract class EstadoDePersonaje {
	
	protected Personaje personaje;
	
	public EstadoDePersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	public abstract void correr();
	public abstract void saltar();
	public abstract void morir();
	public abstract void recibirDano();
	public abstract void sumarVida();
	public abstract void setPuntuacion(int n);
	public abstract void setPuntuacionChampiVerde();
	public abstract void setPuntuacionEstrella();
	public abstract void setPuntuacionFlorDeFuego();
	public abstract void setPuntuacionSuperChampi();
	public abstract int getFactorVelocidad();
	
	
	
}
