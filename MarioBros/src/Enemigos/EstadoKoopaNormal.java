package Enemigos;

import java.util.Timer; 
import java.util.TimerTask;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Personaje.EstadoSuperMario;
import Personaje.Personaje;

public class EstadoKoopaNormal extends EstadoDeKoopa {
	
	protected Sprite sprite;
    protected Hitbox hitbox;
	protected int posX;
	protected int posY;	   
	
	public EstadoKoopaNormal(KoopaTroopa kt, Sprite s, int x, int y) {
		super(kt);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
	}
	
	// Setters
	public void cambiarEstado() {
		GenerarSprite fabricaSprite;		
        if(koopa.getNivelActual().getJuego().getModoDeJuego() == 1) {
            fabricaSprite = new GenerarSpriteOriginal();
        } else {
            fabricaSprite = new GenerarSpriteReemplazo();
        }	       
        sprite = fabricaSprite.getKoopaTroopaRetraido();
        cargarSprite(sprite);
        koopa.setSpriteActualizado(true);
        koopa.setEstadoActual(new EstadoKoopaRetraido(koopa,sprite,posX,posY));  
    }
	
	public void serAfectadoPorPersonaje(Personaje p) {		
	    recibirDano = true;
	    cambiarEstado();
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	        public void run() {	
	        	GenerarSprite fabrica;
	    		if(koopa.getNivelActual().getJuego().getModoDeJuego() == 1) {
	    			 fabrica = new GenerarSpriteOriginal();
	    		} else {
	    			 fabrica = new GenerarSpriteReemplazo();
	    		}
		        koopa.setEstadoActual(new EstadoKoopaNormal(koopa, fabrica.getKoopaTroopa(), koopa.getX(), koopa.getY()));
		        koopa.setSpriteActualizado(true);	            
	        }
	    }, 10000);     
	}
	
	public void morir() {
		hitbox = new Hitbox(0, 0, 0, 0);
		murio = true;
	}
	
	public void moverse() {
		if(!recibirDano) {		
			if(tocandoBloqueIzquierda) 
				tocoParedIzquierda = true;
			
			if(!tocoParedIzquierda) {
				moverIzq();			
				hitbox.actualizar (posX, posY);
			} else {
				tocoParedIzquierda=true;
				moverDer();
				hitbox.actualizar (posX, posY);
			}
			
			if (tocandoBloqueDerecha) {
				tocoParedDerecha = true;
				tocoParedIzquierda = false;				
			}	
			if (!tocandoBloqueAbajo) {
				posY = posY + 1;
			}   	
			hitbox.actualizar (posX, posY);	
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
        	nuevoSprite = fabricaSprite.getKoopaTroopa();
        } else {
        	nuevoSprite = fabricaSprite.getKoopaTroopaMuerto();
        }	
        if(!koopa.getSprite().getRutaImagen().equals(nuevoSprite.getRutaImagen())) {
	    	cargarSprite(nuevoSprite);
	    	koopa.setSpriteActualizado(true);
	    }		
	}
	
	public void moverIzq() {
		posX = posX - 1;
	}
	
	public void moverDer() {
		posX = posX + 1;
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
