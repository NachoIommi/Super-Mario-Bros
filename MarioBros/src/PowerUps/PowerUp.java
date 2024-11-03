package PowerUps;
import Fabricas.Sprite;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

public abstract class PowerUp extends Entidad{
	protected boolean mostrable;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
    
	public PowerUp(Nivel nivelActual) {
		super(nivelActual);
		mostrable = false;
		tocandoBloqueDerecha = false;
	    tocandoBloqueIzquierda = false;
	    tocandoBloqueAbajo = false;
	    tocandoBloqueArriba = false;
	}
	
	// Setters
	public abstract void afectarPersonaje(Personaje p);
	public abstract void aceptarVisita(Visitor r);
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Sprite getSprite();
	public abstract void setPosX(int x);
	public abstract void setPosY(int x);
	
	public void setMostrable(boolean b) {
		mostrable = b;
	}
	
	public abstract void moverse();
	
	public void setTocandoBloqueDerecha(boolean b) {
		tocandoBloqueDerecha = b;
	}

	public void setTocandoBloqueIzquierda(boolean b) {
		tocandoBloqueIzquierda = b;
	}

	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba = b;
	}


	public void setTocandoBloqueAbajo(boolean b) {
		tocandoBloqueAbajo = b;
	}
	
	// Getters
	public boolean mostrable() {
		return mostrable;
	}
}
