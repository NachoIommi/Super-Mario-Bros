package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Personaje.Personaje;

public abstract class EstadosDePiranhaPlant {
	
	protected PiranhaPlant piranha;
	
	protected boolean mostrable;
	protected boolean entroTimer;
	
	public EstadosDePiranhaPlant(PiranhaPlant p) {
		piranha = p;
		mostrable = true;
		entroTimer = false;
	}
	
	// Setters
	public abstract void cambiarEstado();
	public abstract void serAfectadoPorPersonaje(Personaje p);
	public abstract void morir();
	public abstract void moverse();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	
	public void setMostrable(boolean b) {
		mostrable = b;
	}
	public abstract void cargarSprite(Sprite s);
	public abstract void actualizarSprite();
	public abstract void actualizarSpriteCambioDeEstado();
	
	public void setPiranhaPlant(PiranhaPlant p) {
		piranha = p;
	}
	// Getters
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Hitbox getHitbox();
	public abstract Sprite getSprite();
	
	public boolean mostrable() {
		return mostrable;
	}
	public PiranhaPlant getPiranhaPlant() {
		return piranha;
	}
}
