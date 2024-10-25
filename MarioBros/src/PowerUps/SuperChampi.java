package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class SuperChampi extends PowerUps{
	
	protected int x;
	protected int y;
	protected Sprite sprite;
	protected Hitbox hitb;
	
	public SuperChampi(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x , y, 30, 30);
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarSuperChampi(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	
	public void afectarPersonaje(Personaje p) {
		p.colisionSuperChampi();		
		//p.setEstado(null);
		//p.getEstado().setPuntuacionSuperChampi();
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getPosX() {
		return x;
	}
	
	public int getPosY() {
		return y;
	}

	public Hitbox getHitbox() {
		return hitb;
	}

	@Override
	public void activarPowerUp() {
		// TODO Auto-generated method stub
		
	}
	
}
