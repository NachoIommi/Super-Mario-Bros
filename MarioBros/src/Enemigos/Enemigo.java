package Enemigos;
import Fabricas.Sprite; 
import Logica.Entidad;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;
public abstract class Enemigo extends Entidad{
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
    protected boolean murio;
	
	public Enemigo(Nivel nivelActual) {
		super(nivelActual);
		tocandoBloqueDerecha = false;
		tocandoBloqueIzquierda = false;
		tocandoBloqueAbajo = false;
		tocandoBloqueArriba = false;
		mostrable = true;
		murio = false;
	}
	// Setters
	public abstract void afectarPersonaje(Personaje p);
	public abstract void serAfectadoPorPersonaje(Personaje p);
	public abstract void morir();
	public abstract void aceptarVisita(Visitor r);
	public abstract void moverse();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	
	public void setMostrable(boolean b) {
		mostrable = b;
	}
	
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
	public abstract void cargarSprite(Sprite s);
	public abstract void actualizarSprite();
	public abstract void setSpriteActualizado(boolean actualizado);
	
	// Getters
	public Nivel getNivelActual() {
		return nivelActual;
	}
	
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Hitbox getHitbox();
	public abstract Sprite getSprite();
	public boolean mostrable() {
		return mostrable;
	}
	
	public abstract int getToleranciaAltura();
	
	public boolean murio() {
		return murio;
	}
	
	public abstract boolean necesitaActualizarSprite();
}
