package Enemigos;

import Logica.Hitbox;
import Personaje.Personaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import Fabricas.*;
import GUI.ConstantesVistas;


public class EstadoPiranhaExtendida extends EstadosDePiranhaPlant{

	protected int posX;
	protected int posY;
	protected Sprite sprite;
	protected Hitbox hitbox;
	
	protected boolean mostrable;
	protected int desplazado;
	protected boolean subiendo;
	protected boolean bajando;
	protected boolean entroTimer;
	protected boolean muerto;
	
	
	public EstadoPiranhaExtendida(PiranhaPlant p,Sprite s,int x,int y) {
		super(p);
		sprite = s;
		posX = x;
		posY = y;
		hitbox = new Hitbox(x+1, y, 28, 30);
		
		desplazado=0;
		subiendo=true;
		bajando=false;
		muerto = false;
	}
	
	public void moverse() {		
		if(desplazado<30 && subiendo) {
			posY = posY - 1; 	         
	        desplazado++;
	        hitbox.actualizar(posX+1, posY);
	    }
		
		if(desplazado==30) {
			subiendo =false;
		}
		
		if(!subiendo && !entroTimer){
			entroTimer=true;
			Timer timer = new Timer();
		    timer.schedule(new TimerTask() {
		        public void run() {		
		        	bajando=true;
		        	entroTimer=false;
		        }
		    }, 2000);		    
		}
		
		if(bajando && desplazado!=0) {			
			posY=posY+1;				
		    desplazado--;
		    hitbox.actualizar(posX+1, posY); 
		}
		
		if(bajando && desplazado==0) {
			subiendo=true;
			bajando=false;
			desplazado=0;
			cambiarEstado();
		}	
	}
		
	public void cambiarEstado() {
		actualizarSprite();
		piranha.setEstadoActual(new EstadoPiranhaInvulnerable( piranha,sprite, posX, posY));	
	 }
	
	public void serAfectadoPorPersonaje(Personaje p) {
		
	}
	
	public void morir() {   
		muerto = true;
		hitbox = new Hitbox(0 ,0,0 ,0);	
		actualizarSprite();
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica;		
		if(piranha.getNivelActual().getJuego().getModoDeJuego() == 1) {
			fabrica = new GenerarSpriteOriginal();
		}else {
			fabrica = new GenerarSpriteReemplazo();
		}		
		if(!muerto) {
			sprite = fabrica.getPiranhaPlant();
		} else {
			sprite = fabrica.getPiranhaPlantMuerta();
		}
		cargarSprite(sprite);
		piranha.setSpriteActualizado(true);
	}
	
	// Setters
	public void setPosX(int x) {
		posX = x;
	}
	
	public void setPosY(int y) {
		posY = y;
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;	
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
