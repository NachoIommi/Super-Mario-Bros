package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

public class Spiny extends Enemigo{
	
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected int posX;
	protected int posY;
	
	public Spiny(Sprite s, int x, int y, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
		setSpriteActualizado(false);
	}
	
	// Setters	
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralSpiny(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		morir();
		p.setPuntuacion(60);
		murio = true;
	}
	
	public void morir() {
		hitbox = new Hitbox(0 ,0,0 ,0);
		murio = true;
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarSpiny(this);
	}
	
	public void moverse() {
		if(tocandoBloqueAbajo) {
			if(tocandoBloqueIzquierda) 
			tocoParedIzquierda=true;
		
			if(!tocoParedIzquierda) {
				moverIzq();			
				hitbox.actualizar (posX, posY);
			
			} else {
				tocoParedIzquierda=true;
				moverDer();
				hitbox.actualizar (posX, posY);
			}
						
			if (tocandoBloqueDerecha) {
				tocoParedDerecha=true;
				tocoParedIzquierda=false; // lo hago caminar a la izquierda de vuelta
			}
			actualizarSpriteACaminando();
		} else {
			if (!tocandoBloqueAbajo) { 
				posY=posY+2;
			}
		} 
			
			setSpriteActualizado(true);
		hitbox.actualizar (posX, posY);	
	}
	
	public void setPosX(int x) {
		 posX = x;
	}
	
	public void setPosY(int y) {
		 posY = y;
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getSpinyMuerto();
    	cargarSprite(sprite);
    	setSpriteActualizado(true);
    	
    	
	}
	
	public void actualizarSpriteACaminando(){
		 GenerarSprite fabrica = new GenerarSpriteOriginal();
	     sprite = fabrica.getSpinyCaminandoDerecha();
	}
	
	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;	
	}
	
	public void moverIzq() {
		posX = posX-2;
	}
	public void moverDer() {
		posX = posX+2;
	}
	
	public void spawnear() {
        moverse();
    }

	// Getters
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
		
	public boolean mostrable() {
		return mostrable;
	}

	public int getToleranciaAltura() {
		return 0;
	}
	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}
	
	public boolean getTocandoAbajo() {
		return tocandoBloqueAbajo;
	}
}
