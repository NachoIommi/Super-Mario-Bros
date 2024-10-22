package Personaje;

import Fabricas.Sprite;
import Logica.Hitbox;
import Plataformas.*;

public abstract class EstadoDePersonaje {
	
	protected Personaje personaje;
	
	public EstadoDePersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
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
	public abstract int getFactorVelocidad();
	public abstract void romperLadrilloSolido(LadrilloSolido l);
	public abstract void moverBloqueGolpeable(BloqueGolpeable b);
	public abstract void establecerDireccion(int d);
	public abstract int getDireccion();
	public abstract void cargarSprite(Sprite s);
	public abstract Sprite getSprite();
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract void setPosX(int x);
	public abstract Hitbox getHitbox();
	public abstract void setPosY(int y);
	public abstract void setTocandoBloqueAbajo(boolean b);
	public abstract void setTocandoBloqueDerecha(boolean b);
	public abstract void setTocandoBloqueIzquierda(boolean b);
	public abstract int getMin() ;
	public abstract void actualizarMin();
	public abstract int getVelX();
	public abstract void colisionSuperChampi();
	public abstract int getAlto();
	public abstract void colisionLateralGoomba();
	
		
	
}
