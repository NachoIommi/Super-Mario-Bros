package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Personaje.Personaje;

public abstract class EstadoDeKoopa {
		
	protected KoopaTroopa koopa;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
    
    protected boolean recibirDano;
    protected boolean murio;
	
	public EstadoDeKoopa(KoopaTroopa kt) {
		koopa = kt;
		
		tocandoBloqueDerecha = false;
	    tocandoBloqueIzquierda = false;
	    tocandoBloqueAbajo = false;
	    tocandoBloqueArriba = false;
	    mostrable = true;	
	    recibirDano = false;
	    murio = false;
	}
	
	// Setters
    public abstract void cambiarEstado();
    public abstract void serAfectadoPorPersonaje(Personaje p);
    public abstract void morir();
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
	
	public void setKoopaTroopa(KoopaTroopa kt) {
		koopa = kt;		
	}
	// Getters
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Hitbox getHitbox();
	public abstract Sprite getSprite();
	
	public boolean mostrable() {
		return mostrable;
	}
	
	public boolean murio() {
		return murio;
	}
	
	public KoopaTroopa getKoopaTroopa() {
		return koopa;
	}
}