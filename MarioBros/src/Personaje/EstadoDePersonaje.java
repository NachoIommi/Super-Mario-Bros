package Personaje;

import Enemigos.*;  
import Fabricas.Sprite;
import Logica.Hitbox;
import Plataformas.*;

public abstract class EstadoDePersonaje {
	
	protected Personaje personaje;
	
	protected boolean right;
	protected boolean left;
	protected boolean jump;
	
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
    protected boolean saltando;
    protected boolean saltandoSobreEnemigo;
	
	public EstadoDePersonaje(Personaje personaje) {
		this.personaje = personaje;
		 jump = false;
		 right = false;
		 left = false;
		 
		 tocandoBloqueDerecha = false;
		 tocandoBloqueIzquierda = false;
		 tocandoBloqueAbajo = false;
		 tocandoBloqueArriba = false;
		 saltando = false;
		 saltandoSobreEnemigo = false;
	}
	// Setters
	public abstract void morir();
	public abstract void moverPersonaje();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	public abstract void saltar();	
	public abstract void recibirDano();
	public abstract void sumarVida();
	public abstract void sumarPuntos(int puntos);
	
	public abstract void setPuntuacion(int n);
	public abstract void setPuntuacionChampiVerde();
	public abstract void setPuntuacionEstrella();
	public abstract void setPuntuacionFlorDeFuego();
	public abstract void setPuntuacionSuperChampi();
	public abstract void setPuntuacionMoneda();
	
	public void setTocandoBloqueDerecha(boolean b) {
		tocandoBloqueDerecha = b;
	}
	
	public void setTocandoBloqueIzquierda(boolean b) {
		tocandoBloqueIzquierda = b;
	}
	
	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba = b;
	}
	
	public void setTocandoBloqueAbajo(boolean b) {
		tocandoBloqueAbajo = b;
	}
	
	
	public abstract void actualizarSprite();
	public abstract void actualizarMin();
	public abstract void cargarSprite(Sprite s);
	
	public void setSaltando(boolean b){
		saltando = b;
	}
	
	public void setSaltandoSobreEnemigo(boolean b) {
		saltandoSobreEnemigo = b;
	}
	
	public abstract void saltarSobreEnemigo();
	
	public void setRight(boolean b){
		right = b;
	}
	
	public void setLeft(boolean b){
		left = b;
	}
	
	public void setJump(boolean b){
		jump = b;
	}
	
	public abstract void colisionSuperChampi();
	public abstract void colisionFlorDeFuego();
	public abstract void colisionEstrella();
	public abstract void colisionChampiVerde();
	public abstract void colisionMoneda();
	
	public abstract void colisionLateralGoomba(Goomba goomba);
	public abstract void colisionLateralKoopa(KoopaTroopa koopaTroopa);
	public abstract void colisionLateralBuzzyBeetle(BuzzyBeetle buzzy);
	public abstract void colisionLateralLakitu(Lakitu lakitu);
	public abstract void colisionLateralSpiny(Spiny spiny);
	public abstract void colisionLateralPiranha(PiranhaPlant piranha);
	public abstract void colisionVacio();
	
	public abstract void romperLadrilloSolido(LadrilloSolido l);
	public abstract void moverBloqueGolpeable(BloqueGolpeable b);
	public abstract void moverIzquierda();
	public abstract void moverDerecha();
	public abstract void corregirPosEnColision();
	public abstract void gravedad();
	public abstract void gravedadSaltando();
	public abstract void detenerSalto();
	public abstract void detenerFriccion();
	public abstract void colisionDesliz();
	public abstract void disparar();
	
	// Getters
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Hitbox getHitbox();
	public abstract Sprite getSprite();
	public abstract float getVelX();
	public abstract float getVelY();
	public abstract double getToleranciaAltura();
	public abstract int getAlto();
	public abstract float getMin();
	public boolean getSaltando() {
		return saltando;
	}
}
