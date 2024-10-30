package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Personaje.Personaje;

public abstract class EstadoDeKoopa {
		
	protected KoopaTroopa koopa;
	
	public EstadoDeKoopa(KoopaTroopa kt) {
		koopa = kt;
	}
	public abstract KoopaTroopa getKoopaTroopa();
	public abstract void setKoopaTroopa(KoopaTroopa kt);
	public abstract Hitbox getHitbox();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	public abstract void actualizarSpriteKoopaRetraido();
    public abstract void cambiarEstado();
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract void moverse();
	public abstract void setMostrable(boolean b);
	public abstract Sprite getSprite();
	public abstract void setTocandoBloqueAbajo(boolean b);
	public abstract void setTocandoBloqueArriba(boolean b);
	public abstract void setTocandoBloqueIzquierda(boolean b);
	protected abstract void setTocandoBloqueDerecha(boolean b);
	public abstract boolean mostrable();
	public abstract void cargarSprite(Sprite s);
	public abstract void serAfectadoPorPersonaje(Personaje p);
	public abstract void morir();
	public abstract void actualizarSprite();
}


