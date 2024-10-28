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
	protected Sprite s;
	protected Hitbox hitb;
	protected boolean mostrable;
	protected int desplazado;
	protected boolean subiendo;
	protected boolean bajando;
	protected boolean entroTimer;
	
	
	public EstadoPiranhaExtendida(PiranhaPlant p,Sprite s,int x,int y) {
		super(p);
		this.s = s;
		posX = x;
		posY = y;
		hitb = new Hitbox(x+15, y, 20, 30);
		mostrable=true;
		desplazado=0;
		subiendo=true;
		bajando=false;
		entroTimer=false;
	}
	
	public void moverse() {		
		if(desplazado<30 && subiendo) {
			posY = posY - 1; 	         
	        desplazado++;
	        hitb.actualizar(posX+15, posY);}
		
		if(desplazado==30) {
			subiendo =false;}
		
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
		    hitb.actualizar(posX+15, posY); }
		
		if(bajando && desplazado==0) {
			subiendo=true;
			bajando=false;
			desplazado=0;
			cambiarEstado();
		}
			
	}
    
	private Sprite actualizarSpriteNormal() {
	    GenerarSprite fabrica = new GenerarSpriteOriginal();
	    return fabrica.getPiranhaPlant(); 
	}
	
	
	 public void cambiarEstado() {
	    this.actualizarSprite();
		piranha.setEstadoActual(new EstadoPiranhaInvulnerable( piranha,s, posX, posY));	
	 }
	
	 public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		this.s = fabrica.getPiranhaPlant();
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
	
	
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public Sprite getSprite() {
		return s;
	}
	public void cargarSprite(Sprite s) {
		this.s=s;	
	}
	public void serAfectadoPorPersonaje(Personaje p) {		
	}
	public void morir() {   
		hitb = new Hitbox(0 ,0,0 ,0);	
		new Thread(() -> {	        
	        int posY = getPosY();
	        // Animación de desplazamiento hacia arriba
	        for (int i = 0; i < 30; i++) {
	            setPosY(posY - (i * 2));
	            try {
	                Thread.sleep(14);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        // Caída hacia la parte inferior de la ventana
	        while (getPosY() < ConstantesVistas.VENTANA_ALTO) {
	            setPosY(getPosY() + 5);
	            try {
	                Thread.sleep(14);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }).start();
	}
	public boolean mostrable() {
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}

	

}
