package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

public class Estrella extends PowerUp{
	
	protected int posX;
	protected int posY;
	protected Sprite sprite;
	protected Hitbox hitbox;
	
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
	
	
	public Estrella(Sprite s, int x, int y, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(0 ,0,30 ,30);
	}
	
	public void moverse() {
		if(mostrable){			
			if(tocandoBloqueIzquierda) {
				tocoParedIzquierda=true;
				tocoParedDerecha=false;}
			
			if(tocandoBloqueDerecha)
				tocoParedDerecha=true;
			
			if(!tocoParedDerecha) {
				moverDer();
				hitbox.actualizar (posX, posY);
			}
			else {
				tocoParedDerecha=true;
				moverIzq();
				hitbox.actualizar (posX, posY);
			}	
			
			if (!tocandoBloqueAbajo) {
		        posY=posY+3;}
			
			hitbox.actualizar (posX, posY);		
			corregirPosEnColision();
		}
		
	}
	public void moverIzq() {
		posX = posX-2;
	}
	public void moverDer() {
		posX = posX+2;
	}
	public void corregirPosEnColision() {
		if(tocandoBloqueIzquierda)  
	    	posX=posX+1;	    		
	    if(tocandoBloqueDerecha) 
	    	posX=posX-1;	    
	}
	
	
	public void aceptarVisita(Visitor v) {
		v.visitarEstrella(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}

	public void afectarPersonaje(Personaje p) {
		p.colisionEstrella();
		hitbox.actualizar(0, 0);
		setMostrable(false);
		hitbox.actualizar(0, 0);
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

	public Hitbox getHitbox() {
		return hitbox;
	}

	
	public void setPosX(int x) {
		posX = x;
	}

	
	public void setPosY(int y) {
		posY = y;
	}

	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}


	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado=actualizada;
	}
}