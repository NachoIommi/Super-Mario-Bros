package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Personaje.Personaje;

public abstract class EstadosDePiranhaPlant {
	
	protected PiranhaPlant piranha;
	
	public EstadosDePiranhaPlant(PiranhaPlant p) {
		this.piranha = p;
	}
	public abstract PiranhaPlant getPiranhaPlant();
	public abstract void setPiranhaPlant(PiranhaPlant p);
	public abstract Hitbox getHitbox();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	public abstract void actualizarSprite();
	public abstract void cambiarEstado() ;
	public abstract void moverse();
	public abstract int getPosX();
	public abstract Sprite getSprite();
	public abstract int getPosY();
	public abstract void cargarSprite(Sprite s);
	public abstract void afectarPersonaje(Personaje p);
	public abstract void serAfectadoPorPersonaje(Personaje p);
	public abstract void setMostrable(boolean b);
	public abstract boolean mostrable();
}
