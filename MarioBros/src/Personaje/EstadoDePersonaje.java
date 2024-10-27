package Personaje;

import Enemigos.EstadoDeKoopa;
import Fabricas.Sprite;
import Logica.Hitbox;
import Plataformas.*;

public abstract class EstadoDePersonaje {
	
	protected Personaje personaje;
	
	public EstadoDePersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	public abstract Hitbox getHitbox();
	public abstract Sprite getSprite();
	public abstract void moverPersonaje();
	public abstract void actualizarSprite();
	public abstract void saltar();
	public abstract void morir();
	public abstract void recibirDano();
	public abstract void sumarVida();
	public abstract void setPuntuacion(int n);
	public abstract void setPuntuacionChampiVerde();
	public abstract void setPuntuacionEstrella();
	public abstract void setPuntuacionFlorDeFuego();
	public abstract void setPuntuacionSuperChampi();
	public abstract void setPuntuacionMoneda();
	public abstract void romperLadrilloSolido(LadrilloSolido l);
	public abstract void moverBloqueGolpeable(BloqueGolpeable b);
	public abstract void cargarSprite(Sprite s);
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	public abstract void setTocandoBloqueAbajo(boolean b);
	public abstract void setTocandoBloqueDerecha(boolean b);
	public abstract void setTocandoBloqueIzquierda(boolean b);
	public abstract float getMin() ;
	public abstract void actualizarMin();
	public abstract float getVelX();
	public abstract void colisionSuperChampi();
	public abstract void colisionEstrella();
	public abstract void colisionFlorDeFuego();
	public abstract void colisionChampiVerde();
	public abstract void colisionMoneda();
	public abstract int getAlto();
	public abstract void colisionLateralGoomba();
	public abstract void setRight(boolean b);
	public abstract void setLeft(boolean b);
	public abstract void setJump(boolean b);
	public abstract double getToleranciaAltura();
	public abstract void setTocandoBloqueArriba(boolean b);
	public abstract float getVelY();
	public abstract void colisionPiranhaPlant();
	public abstract void saltarSobreEnemigo();

	public abstract void setSaltandoSobreEnemigo(boolean b);

	public abstract void colisionLateralKoopa(EstadoDeKoopa kt);
}
