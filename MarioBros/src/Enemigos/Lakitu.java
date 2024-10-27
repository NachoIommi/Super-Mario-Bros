package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite ;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class Lakitu extends Enemigo{
	
	protected Sprite sprite;
	protected Hitbox hitb;
	protected int posX;
	protected int posY;
	
	protected boolean tocandoBloqueDerecha=false;
	protected boolean tocandoBloqueIzquierda=false;
	protected boolean tocandoBloqueAbajo=false;
	protected boolean tocandoBloqueArriba=false;
	protected boolean mostrable=true;
	
	public Lakitu(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30, 30);
		mostrable = true;
		setSpriteActualizado(false);
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarLakitu(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void afectarPersonaje(Personaje p) {
		p.morir();
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(60);
		morir();
	}
	
	public void morir() {
		actualizarSprite();
		hitb.actualizar(0, 0);
		posX=0;
		posY=-300;
	}
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getLakituPorDisparar();
    	cargarSprite(sprite);
	}
	public Hitbox getHitbox() {
		return hitb;
	}

	@Override
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
	public int getToleranciaAltura() {
		return 0;
	}

	public boolean mostrable() {
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}

	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}

	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
		
	}

}
