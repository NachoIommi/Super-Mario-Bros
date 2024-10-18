package PowerUps;

import Fabricas.Sprite;
import Logica.Visitor;
import Personaje.Personaje;

public class SuperChampi extends PowerUps{
	
	protected int x;
	protected int y;
	protected Sprite sprite;
	
	public SuperChampi(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarSuperChampi(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	
	public void afectarPersonaje(Personaje p) {
		p.getEstado().setPuntuacionSuperChampi();
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
	
}
