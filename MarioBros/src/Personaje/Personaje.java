package Personaje;

import Logica.Entidad;
import Logica.Hitbox;
import Logica.Visitor;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Fabricas.*;

public class Personaje extends Entidad{
	
	public double toleranciaAltura;
	private EstadoDePersonaje estado;
	protected Sprite sprite;
	protected Hitbox hitb;
	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	protected int posX;
	protected int posY;
	protected int direccionDelPersonaje;

	protected float min = 10.0f;
	public int max = 2700;
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
        direccionDelPersonaje = 0;
        posX = x;
        posY = y;
        tocandoBloque=false;
        tocandoBloqueDerecha=false;
        tocandoBloqueIzquierda=false;
        tocandoBloqueAbajo=false;
        tocandoBloqueArriba=false;
        saltando=false;  
        alto=30;
        
    }
	public void setRight(boolean b){
		estado.setRight(b);
	}
	
	public void setLeft(boolean b){
		estado.setLeft(b);
	}
	
	public void setJump(boolean b){
		estado.setJump(b);
	}
	
	public double getToleranciaAltura() {
		return estado.getToleranciaAltura();
	}
	
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

    }
	
	public void actualizarSprite() {
		estado.actualizarSprite();
	}

	public boolean getSaltando() {
		return saltando;
	}
	
	public void setSaltando(boolean saltando){
		this.saltando=saltando;
	}
	
	public float getVelX() {
		return estado.getVelX();
	}
	
	public float getVelY() {
		return estado.getVelY();
	}
	
	public void setTocandoBloque(boolean tocando) {
		tocandoBloque=tocando;
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
		estado.setTocandoBloqueArriba(b);
	}
	
	public Hitbox getHitbox() {
    	return estado.getHitbox();
    }
 
    public void morir() {
        estado.morir();
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
	
	public float getMin() {
		return min;
	}

	public void setPosX(int x) {
	    estado.setPosX(x);
	}
	
	public void setPosY(int y) {
		estado.setPosY(y);
	}
	
}
