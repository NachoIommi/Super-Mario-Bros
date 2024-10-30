package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Personaje.Personaje;

public abstract class EstadosDePiranhaPlant {
	
	protected PiranhaPlant piranha;
	
	public EstadosDePiranhaPlant(PiranhaPlant p) {
		piranha = p;
	}
	
	// Setters
	public abstract void cambiarEstado();
	public abstract void serAfectadoPorPersonaje(Personaje p);
	public abstract void morir();
	public abstract void moverse();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	public abstract void setMostrable(boolean b);
	public abstract void cargarSprite(Sprite s);
	public abstract void actualizarSprite();
	public abstract void actualizarSpriteCambioDeEstado();
	public abstract void setPiranhaPlant(PiranhaPlant p);
	// Getters
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Hitbox getHitbox();
	public abstract Sprite getSprite();
	public abstract boolean mostrable();
	public abstract PiranhaPlant getPiranhaPlant();
	
}
