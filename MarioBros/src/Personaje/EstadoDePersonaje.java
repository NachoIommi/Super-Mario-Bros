package Personaje;

public interface EstadoDePersonaje {
	
	public void correr();
	public void saltar();
	public void morir();
	public void sumarVida();
	public void setPuntuacion(int n);
	public void setPuntuacionChampiVerde();
	public void setPuntuacionEstrella();
	public void setPuntuacionFlorDeFuego();
	public void setPuntuacionSuperChampi();
}
