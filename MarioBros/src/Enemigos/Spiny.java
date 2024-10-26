package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class Spiny extends Enemigo{
	
	protected Sprite sprite;
	protected Hitbox hitb;
	protected int x;
	protected int y;
	protected boolean mostrable;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
	
	
	public Spiny(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30, 30);
		mostrable = true;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarSpiny(this);
	}

	public void cargarSprite(Sprite s) {
		
	}
	
	public void afectarPersonaje(Personaje p) {
		p.setPuntuacion(-30);
		p.morir();
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(60);
		morir();
	}
	
	public void morir() {
		
	}

	public Hitbox getHitbox() {
		return hitb;
	}

	
	public int getToleranciaAltura() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean mostrable() {
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}

	public void setTocandoBloqueDerecha(boolean b) {
		tocandoBloqueDerecha=b;
	}

	public void setTocandoBloqueIzquierda(boolean b) {
		tocandoBloqueIzquierda=b;
	}

	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba=b;
	}


	public void setTocandoBloqueAbajo(boolean b) {
		tocandoBloqueAbajo=b;
	}
	
}
