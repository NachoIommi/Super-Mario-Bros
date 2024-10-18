package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class FlorDeFuego extends PowerUps{
	
	protected int x;
	protected int y;
	protected Sprite sprite;
	protected Hitbox hitb;
	
	public FlorDeFuego(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarFlorDeFuego(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}

	public void afectarPersonaje(Personaje p) {
		p.getEstado().setPuntuacionFlorDeFuego();
	}

	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public int getPosX() {
		return x;
	}

	@Override
	public int getPosY() {
		return y;
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}
}
