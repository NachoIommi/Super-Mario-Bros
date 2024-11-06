package Enemigos;

import java.util.Timer;
import java.util.TimerTask;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Personaje.Personaje;

public class EstadoKoopaRetraido extends EstadoDeKoopa{
	
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected boolean saltoArriba;
	protected int posX;
	protected int posY;
	
	public EstadoKoopaRetraido(KoopaTroopa kt, Sprite s, int x, int y) {
		super(kt);
		posX = x;
		posY = y;		
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);		
	    saltoArriba = false;
	}
	
	// Setters
	public void cambiarEstado() {
		actualizarSprite();
        koopa.setEstadoActual(new EstadoKoopaNormal(koopa, sprite, posX, posY));
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
				tocoParedIzquierda = true;
			
			if(!tocoParedIzquierda) {
				moverIzq();			
				hitbox.actualizar(posX, posY);
			} else {
				tocoParedIzquierda = true;
				moverDer();
				hitbox.actualizar(posX, posY);}				
					
			if (tocandoBloqueDerecha) {
				tocoParedDerecha = true;
				tocoParedIzquierda = false;
			}	
			
			if (!tocandoBloqueAbajo) 
		        posY = posY + 1;
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
		GenerarSprite fabricaSprite;
		Sprite nuevoSprite = sprite;
        if(koopa.getNivelActual().getJuego().getModoDeJuego() == 1) {
            fabricaSprite = new GenerarSpriteOriginal();
        } else {
            fabricaSprite = new GenerarSpriteReemplazo();
        }
        
        if(!murio) {
        	nuevoSprite = fabricaSprite.getKoopaTroopaRetraido();
        } else {
        	nuevoSprite = fabricaSprite.getKoopaTroopaMuerto();
        }
        
        if(!koopa.getSprite().getRutaImagen().equals(nuevoSprite.getRutaImagen())) {
	    	koopa.cargarSprite(nuevoSprite);
	    	koopa.setSpriteActualizado(true);
	    }		
	}
	
	public void moverIzq() {
		posX = posX - 4;
	}
	
	public void moverDer() {
		posX = posX + 4;
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