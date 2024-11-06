package Enemigos;

import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import Fabricas.*;

public class EstadoPiranhaInvulnerable extends EstadosDePiranhaPlant {

	protected Sprite sprite;
	protected Hitbox hitbox;
	protected int posX;
	protected int posY;
	
    public EstadoPiranhaInvulnerable(PiranhaPlant p , Sprite s, int x, int y) {
        super(p);
		sprite = s;
		posX = x;
		posY = y;
		hitbox = new Hitbox(0, 0, 0, 0);
    }
    
    // Setters
    public void cambiarEstado() {
    	actualizarSpriteCambioDeEstado();
		piranha.setEstadoActual(new EstadoPiranhaExtendida(piranha, sprite, posX, posY));	
    }
    
    public void serAfectadoPorPersonaje(Personaje p) {
    	
	}

	public void morir() {
    	
    }
    
    public void moverse() {   	
    	if(!entroTimer) {
    		entroTimer = true;   	
	    	Timer timer = new Timer();
		    timer.schedule(new TimerTask() {
		    	public void run() {		        	
		    		cambiarEstado();
		    		entroTimer = false;
	        }
	    }, 3000);}
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
		
	}
	
	public void actualizarSpriteCambioDeEstado() {
		GenerarSprite fabrica;
		
		if(piranha.getNivelActual().getJuego().getModoDeJuego() == 1) {
			fabrica = new GenerarSpriteOriginal();
		} else {
			fabrica = new GenerarSpriteReemplazo();
		}

		sprite = fabrica.getPiranhaPlant();
		piranha.setSpriteActualizado(true);
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
