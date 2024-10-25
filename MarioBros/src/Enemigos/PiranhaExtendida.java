package Enemigos;

import Logica.Hitbox;

public class PiranhaExtendida extends EstadosDePiranhaPlant{
	private PiranhaPlant piranha;
	
	public PiranhaExtendida(PiranhaPlant p) {
		super(p);
	}
	
	public PiranhaPlant getPiranhaPlant() {
		return piranha;
	}
	
	public void setPiranhaPlant(PiranhaPlant p) {
		piranha = p;
	}
	public Hitbox getHitbox() {
		return null;
	}
	public void setPosX(int x) {
	}
	public void setPosy(int y) {
	}
	public void actualizarSprite() {
	}

}
