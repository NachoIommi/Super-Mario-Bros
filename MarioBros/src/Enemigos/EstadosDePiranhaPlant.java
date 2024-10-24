package Enemigos;

import Logica.Hitbox;

public abstract class EstadosDePiranhaPlant {
	
	protected PiranhaPlant piranha;
	
	public EstadosDePiranhaPlant(PiranhaPlant p) {
		this.piranha = p;
	}
	public abstract PiranhaPlant getPiranhaPlant();
	public abstract void setPiranhaPlant(PiranhaPlant p);
	public abstract Hitbox getHitbox();
	public abstract void setPosX(int x);
	public abstract void setPosy(int y);
	public abstract void actualizarSprite();
	
	
}
