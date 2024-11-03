
package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

public class Goomba extends Enemigo{
	
	public double toleranciaAltura=20;
	protected Sprite sprite;
	protected Hitbox hitbox;

	protected int posX;
	protected int posY;
	

	public Goomba(Sprite s,int x,int y, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
        posY = y;
        sprite = s;
        hitbox = new Hitbox(x ,y,30 ,30);
	    setSpriteActualizado(false);
	}
	// Setters
	public void afectarPersonaje(Personaje p) {	
		p.colisionLateralGoomba(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		murio = true;
		morir();
		p.setPuntuacion(60);
	}
	
	public void morir() {
		hitbox = new Hitbox(0 ,0,0 ,0);
		murio = true;
		actualizarSprite();
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarGoomba(this);
	}
	
	public void moverse() {
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

		hitbox.actualizar (posX, posY);		
	

		if (!tocandoBloqueAbajo) 
	        posY=posY+1;
		
		hitbox.actualizar (posX, posY);		
	}

	
	public void moverIzq() {
		posX=posX-1;
	}
	
	public void moverDer() {
		posX=posX+1;
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
		GenerarSprite fabricaSprite;
		
		if(nivelActual.getJuego().getModoDeJuego() == 1) {
			fabricaSprite = new GenerarSpriteOriginal();
		}else {
			fabricaSprite = new GenerarSpriteReemplazo();
		}

    	sprite = fabricaSprite.getGoombaMuerto();
    	cargarSprite(sprite);
    	setSpriteActualizado(true);
    	
    	
	}
	
	public void setSpriteActualizado(boolean actualizado) {
		spriteActualizado = actualizado;
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

	public int getToleranciaAltura() {
		return (int)toleranciaAltura;
	}
	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}
}