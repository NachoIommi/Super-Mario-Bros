package Personaje;

import Enemigos.*; 
import Fabricas.Sprite;
import Logica.Hitbox;
import Plataformas.*;

public abstract class EstadoDePersonaje {
	
	protected Personaje personaje;
	
	public EstadoDePersonaje(Personaje personaje) {
		this.personaje = personaje;
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
	public abstract void setTocandoBloqueDerecha(boolean b);
	public abstract void setTocandoBloqueIzquierda(boolean b);
	public abstract void setTocandoBloqueArriba(boolean b);
	public abstract void setTocandoBloqueAbajo(boolean b);
	
	
	public abstract void actualizarSprite();
	public abstract void actualizarMin();
	public abstract void cargarSprite(Sprite s);
	
	public abstract void setSaltando(boolean b);
	public abstract void setSaltandoSobreEnemigo(boolean b);
	public abstract void saltarSobreEnemigo();
	public abstract void setRight(boolean b);
	public abstract void setLeft(boolean b);
	public abstract void setJump(boolean b);
	
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
	public abstract  boolean getSaltando();
}
