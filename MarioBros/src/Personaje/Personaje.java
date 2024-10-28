package Personaje;

import Logica.Entidad;   
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Enemigos.*;
import Fabricas.*;

public class Personaje extends Entidad{
	
	public double toleranciaAltura;
	private EstadoDePersonaje estado;
	protected Hitbox hitb;
	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	protected int posX;
	protected int posY;
	protected int direccionDelPersonaje;
	protected Sprite s;
	protected Nivel nivelActual;

	protected float min = 10.0f;
	public int max = 2700;
	protected int alto;
	
	protected boolean tocandoBloque;
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
    protected boolean saltando;
    protected boolean saltandoSobreEnemigo;
	
	protected int velX;
	protected int gravedad=1;
	protected int velY;
	protected int velSalto = -50;
	
	protected int tiempoSaltando=0;
	protected final int maxTiempoSalto=20;
	
	private boolean invulnerable;
    protected int tiempoInvulnerable;
    protected static final int TIEMPO_INVULNERABILIDAD = 3000;
	
	public Personaje(Sprite sprite, int x, int y, Nivel nivel) {
		nivelActual = nivel;
        vidas = 3;        
        monedas = 0;      
        puntuacion = 10;   
        estado = new EstadoSuperMario(this ,sprite, x ,y); 
        direccionDelPersonaje = 0;
        posX = x;
        posY = y;
        tocandoBloque=false;
        tocandoBloqueDerecha=false;
        tocandoBloqueIzquierda=false;
        tocandoBloqueAbajo=false;
        tocandoBloqueArriba=false;
        saltandoSobreEnemigo=false;
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
	
	public void colisionPiranhaPlant() {
		estado.colisionPiranhaPlant();
	}
	
	public void colisionLateralGoomba(Goomba goomba) {
		estado.colisionLateralGoomba(goomba);
	}
	
	public void colisionLateralKoopa(KoopaTroopa koopaTroopa) {
		estado.colisionLateralKoopa(koopaTroopa);
	}
	public void colisionLateralBuzzyBeetle(BuzzyBeetle buzzy) {
		estado.colisionLateralBuzzyBeetle(buzzy);
	}
	public void colisionLateralLakitu(Lakitu lakitu) {
		estado.colisionLateralLakitu(lakitu);
	}
	public void colisionLateralSpiny(Spiny spiny) {
		estado.colisionLateralSpiny(spiny);
	}
	public void colisionSuperChampi() {
		estado.colisionSuperChampi();
	}
    
    public void colisionFlorDeFuego() {
    	estado.colisionFlorDeFuego();
    }
    
    public void colisionEstrella() {
    	estado.colisionEstrella();
    }
    
    public void colisionVacio() {
		estado.morir();
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
        if (this.vidas == 0) {
        	System.out.println("Game Over");
        }
      
    }
    public void activarInvulnerabilidad() {
        if (!invulnerable) {
            invulnerable = true; // Activa la invulnerabilidad
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    invulnerable = false; // Desactiva invulnerabilidad después de 3 segundos
                    timer.cancel();
                }
            }, 3000); // Tiempo de invulnerabilidad en milisegundos (3 segundos)
        }
    }
    public boolean esInvulnerable() {
        return invulnerable;
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

        this.puntuacion = puntuacion+n;

        this.puntuacion += n;
    }
    
    public EstadoDePersonaje getEstado(){
        return this.estado;
    }
    public void saltarSobreEnemigo() {
    	estado.saltarSobreEnemigo();
    }
    
    public void setSaltandoSobreEnemigo(boolean b) {
    	estado.setSaltandoSobreEnemigo(b);
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
