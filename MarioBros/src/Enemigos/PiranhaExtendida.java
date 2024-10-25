package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Fabricas.*;


public class PiranhaExtendida extends EstadosDePiranhaPlant{
	private PiranhaPlant piranha;
	protected int x;
	protected int y;
	protected Sprite s;
	protected Hitbox hitb;
	
	public PiranhaExtendida(Sprite s,int x,int y,PiranhaPlant p) {
		super(p);
		piranha = p;
		this.s = s;
		this.x = x;
		this.y = y;
	}
	public void cambiarEstado() {
		piranha.setEstadoActual(new PiranhaInvulnerable(s,this.x,this.y - 30,piranha));  // Cambiar al estado invulnerable
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
	public void setPosY(int y) {
	}
	public void actualizarSprite() {
		this.s = null;
	}
	

}
