package Enemigos;

import Logica.Hitbox;
import Logica.Visitor;
import Fabricas.*;

public class PiranhaInvulnerable extends EstadosDePiranhaPlant {
    private PiranhaPlant piranha;
    protected int x;
	protected int y;
	protected Sprite s;
	protected Hitbox hitb;


    public PiranhaInvulnerable(Sprite s,int x,int y,PiranhaPlant p) {
        super(p);
        piranha = p;
		this.s = s;
		this.x = x;
		this.y = y;
    }
    
    public void cambiarEstado() {
    	this.actualizarSprite();
        piranha.setEstadoActual(new PiranhaExtendida(s,this.x,this.y + 30,piranha));  // Cambiar al estado extendido
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
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		this.s = fabrica.getPiranhaPlantSpawneando();
	}
	public void setPosX(int x) {
	}
	public void setPosY(int y) {
	}

	



}

