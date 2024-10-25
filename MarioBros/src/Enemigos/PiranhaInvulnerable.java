package Enemigos;

import Logica.Hitbox;
import Logica.Visitor;

public class PiranhaInvulnerable extends EstadosDePiranhaPlant {
    private PiranhaPlant piranha;

    public PiranhaInvulnerable(PiranhaPlant p) {
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
	public void actualizarSprite() {		
	}
	public void setPosX(int x) {
	}
	public void setPosy(int y) {
	}

}
