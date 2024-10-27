package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class BuzzyBeetle extends Enemigo{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitb;
	protected boolean mostrable;
	public double toleranciaAltura=20;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
	
	public BuzzyBeetle(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30, 30);
		tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
		mostrable = true;
		
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
		if(tocandoBloqueIzquierda) 
			tocoParedIzquierda=true;
		
	
		if(!tocoParedIzquierda) {
			moverIzq();			
			hitb.actualizar (posX, posY);
		} else {
			tocoParedIzquierda=true;
			moverDer();
			hitb.actualizar (posX, posY);
		}
				
				
		if (tocandoBloqueDerecha) {
			tocoParedDerecha=true;
			tocoParedIzquierda=false; // lo hago caminar a la izquierda de vuelta
		}
		hitb.actualizar (posX, posY);	
		
		if (!tocandoBloqueAbajo) 
	        posY=posY+1;
		
		hitb.actualizar (posX, posY);	
	}
	
	public void moverIzq() {
		posX=posX-2;
	}
	public void moverDer() {
		posX=posX+2;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarBuzzyBeetle(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralGoomba();
		p.setPuntuacion(-15);
		p.morir();
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(30);
		morir();
	}
	
	public void morir() {
		actualizarSprite();
		hitb.actualizar(0, 0);
		System.out.println("buzzy muerto");
		
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getBuzzyBeetleRetraido();
    	cargarSprite(sprite);
	}
	public Hitbox getHitbox() {
		return hitb;
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

	public int getToleranciaAltura() {
		return (int)toleranciaAltura;
	}

	public boolean mostrable() {
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}

}
