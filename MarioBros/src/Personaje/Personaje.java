package Personaje;

import Logica.Entidad;
import Logica.Hitbox;
import Logica.Visitor;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Fabricas.*;

public class Personaje extends Entidad{
	
	private EstadoDePersonaje estado;
	
	protected Sprite sprite;
	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	protected int posX;
	protected int posY;
	protected int direccionDelPersonaje;
	protected Hitbox hitb;
	protected int min = 10;
	protected int alto;
	
	protected boolean tocandoBloque;
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
    protected boolean saltando;
	
	protected int velX;
	protected int gravedad=1;
	protected int velY;
	protected int velSalto = -50;
	
	protected int tiempoSaltando=0;
	protected final int maxTiempoSalto=20;
	
	
	
	
	public Personaje(Sprite sprite, int x, int y) {
        vidas = 3;        
        monedas = 0;      
        puntuacion = 0;   
        estado = new EstadoNormal(this ,sprite, x ,y); 
        direccionDelPersonaje = 0; // direccion 0 -> Quieto
        posX = x;
        posY = y;
        //this.sprite = sprite;  
       // hitb = new Hitbox(x ,y,30 ,40);
        tocandoBloque=false;
        tocandoBloqueDerecha=false;
        tocandoBloqueIzquierda=false;
        tocandoBloqueAbajo=false;
        tocandoBloqueArriba=false;
        saltando=false;  
        alto=30;
        
    }
	
	//D 4
	public void colisionLateralGoomba() {
		estado.colisionLateralGoomba();
	}
	
	public void colisionSuperChampi() {
		estado.colisionSuperChampi();
	}
	public int getAlto() {
		return estado.getAlto();
	}
	public void moverPersonaje(){	
		estado.moverPersonaje();
	}
	
	public void saltar() {
		/*
		
        if (tocandoBloqueAbajo && !saltando) { // Solo saltar si está tocando el suelo
        	saltando=true;
        	velY = velSalto;
        	tiempoSaltando=0;
        	System.out.println("Saltando");
        }NNO TERMINADOOOO
        */
    }
	
	 public void actualizarSprite() {
	        estado.actualizarSprite();
	    }


	public boolean getSaltando() {
		return saltando;
	}
	public void setSaltando(boolean b){
		saltando=b;
	}
	public int getVelX() {
		return estado.getVelX();
	}
	
	public void setTocandoBloque(boolean b) {
		tocandoBloque=b;
	}
	
	public void setTocandoBloqueDerecha(boolean b) {
		estado.setTocandoBloqueDerecha(b);
	}
	public void setTocandoBloqueIzquierda(boolean b) {
		estado.setTocandoBloqueIzquierda(b);
	}
	public void setTocandoBloqueAbajo(boolean b) {
		estado.setTocandoBloqueAbajo(b);
	}
	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba=b;
	}
	public Hitbox getHitbox() {
    	return estado.getHitbox();
    }
 
    public void morir() {
        this.estado.morir();
        this.vidas -= 1;
        if (this.vidas == 0) {
        	System.out.println("Game Over");
        }
    }
    
    public void recibirDano() {
    	estado.recibirDano();
    }

    public void sumarVida() {
        this.vidas += 1;
    }

    public void sumarPuntos(int puntos) {
        this.puntuacion += puntos;
    }

    public void cambiarEstado(EstadoDePersonaje nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void aceptarVisita(Visitor v) {
        //v.visitarPersonaje(this);
    }

    public int getVidas(){
        return this.vidas;
    }
    
    public void setVidas(int n){
        this.vidas = n;
    }
    
    public int getMonedas(){
        return this.monedas;
    }
    
    public void setMonedas(int n){
        this.monedas = n;
    }

    
    public int getPuntuacion(){
        return this.puntuacion;
    }
    
    public void setPuntuacion(int n){
        this.puntuacion = n;
    }
    
    public EstadoDePersonaje getEstado(){
        return this.estado;
    }
    
    public void setEstado(EstadoDePersonaje nuevoEstado){
        this.estado = nuevoEstado;
    }
       
    public void establecerDireccion(int d) {
	    estado.establecerDireccion(d);
	    
    }
    public int getDireccion() {
    	return estado.getDireccion();
    }
    
	public void cargarSprite(Sprite s) {
		estado.cargarSprite(s);
	}
	
	public Sprite getSprite() {
		return estado.getSprite();
	}
	public int getPosX() {
		return estado.getPosX();
	}
	public int getPosY() {
		return estado.getPosY();
	}
	
	public void actualizarMin() {
		if(estado.getVelX()>0)
			
			min+=estado.getVelX();
	}
	
	public int getMin() {
		return min;
	}

	public void setPosX(int x) {
	    estado.setPosX(x); // Actualizar la hitbox después de ajustar la posición
	}
	public void setPosY(int y) {
		estado.setPosY(y);
	}
}
