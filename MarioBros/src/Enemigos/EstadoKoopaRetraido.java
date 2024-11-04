package Enemigos;

import java.util.Timer;
import java.util.TimerTask;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Personaje.Personaje;

public class EstadoKoopaRetraido extends EstadoDeKoopa{
	
	protected int posX;
	protected int posY;
	
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected boolean saltoArriba;
	
	
	public EstadoKoopaRetraido(KoopaTroopa kt, Sprite s,int x,int y) {
		super(kt);
		posX = x;
		posY = y;
		
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
		
	    saltoArriba=false;
	}
	
	// Setters
	public void cambiarEstado() {
		this.actualizarSpriteKoopaRetraido();
        koopa.setEstadoActual(new EstadoKoopaNormal(koopa,sprite,posX,posY));  // Cambiar al estado extendido
    }
	
	public void serAfectadoPorPersonaje(Personaje p) {
		saltoArriba = true;
	}
	
	public void morir() {
		hitbox = new Hitbox(0 ,0,0 ,0);
		murio = true;
	}
	
	public void moverse() {
		if(saltoArriba) {
			
			if(tocandoBloqueIzquierda) 
				tocoParedIzquierda=true;
				
			if(!tocoParedIzquierda) {
				moverIzq();			
				hitbox.actualizar (posX, posY);
			}
			else
				 {
				tocoParedIzquierda=true;
				moverDer();
				hitbox.actualizar (posX, posY);}				
					
			if (tocandoBloqueDerecha) {
				tocoParedDerecha=true;
				tocoParedIzquierda=false; // lo hago caminar a la izquierda de vuelta
					}
	
			if (!tocandoBloqueAbajo) 
		        posY=posY+1;
		}
		
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
		sprite = fabrica.getKoopaTroopaMuerto();
		cargarSprite(sprite);
		koopa.setSpriteActualizado(true);
		
	
	}
	
	public void actualizarSpriteKoopaRetraido() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		sprite = fabrica.getKoopaTroopaRetraido();		
		cargarSprite(sprite);
		koopa.setSpriteActualizado(true);
	}
	
	public void moverIzq() {
		posX = posX-4;
	}
	public void moverDer() {
		posX = posX+4;
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
}