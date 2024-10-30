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
	protected Hitbox hitb;
	protected int posX;
	protected int posY;
	protected boolean mostrable;
	protected boolean entroTimer;
	

    public EstadoPiranhaInvulnerable(PiranhaPlant p ,Sprite s,int x,int y) {
        super(p);
		sprite = s;
		posX = x;
		posY= y;
		hitb = new Hitbox(0,0,0 ,0);
		mostrable=true;
		entroTimer=false;
    }
    
    public void moverse() {   	
    	if(!entroTimer) {
    		entroTimer=true;   	
	    	Timer timer = new Timer();
		    timer.schedule(new TimerTask() {
		    	public void run() {		        	
		    		cambiarEstado();
		    		entroTimer=false;
	        }
	    }, 3000);}
    }
    
    private Sprite actualizarSpriteNormal() {
	    GenerarSprite fabrica = new GenerarSpriteOriginal();
	    return fabrica.getPiranhaPlantSpawneando(); // Asegúrate de tener un método que retorne la sprite de Koopa normal
	}
    
    public void cambiarEstado() {
    	actualizarSpriteCambioDeEstado();
		piranha.setEstadoActual(new EstadoPiranhaExtendida( piranha,sprite, posX, posY));	
    }
    
    public void actualizarSpriteCambioDeEstado() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		sprite = fabrica.getPiranhaPlant();
		piranha.setSpriteActualizado(true);
	}
    
    public PiranhaPlant getPiranhaPlant() {
		return piranha;
	}
	public void setPiranhaPlant(PiranhaPlant p) {
		piranha = p;
	}
	public Hitbox getHitbox() {
		return hitb;
	}
	
	
	public void setPosX(int x) {
		posX=x;
	}
	public void setPosY(int y) {
		posY=y;
	}

	public void cambiarEstado(EstadosDePiranhaPlant nuevoEstado) {
		// TODO Auto-generated method stub
		
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public Sprite getSprite() {
		return sprite;
	}
	public void cargarSprite(Sprite s) {
		this.sprite=s;	
	}
	public void serAfectadoPorPersonaje(Personaje p) {		
	}

	public void morir() {
    	
    }
	public void actualizarSprite() {
		
	}
	public boolean mostrable() {
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}

}

