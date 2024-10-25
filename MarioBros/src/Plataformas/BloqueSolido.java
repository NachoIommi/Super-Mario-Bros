package Plataformas;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class BloqueSolido extends Plataforma{
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	protected Hitbox hitb;
	
	public BloqueSolido(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30, 30);
	}
	
	public void recibirGolpe() {

	}
	
	public void aceptarVisita(Visitor v) {
		// no acepta nunca visita
	}
	
	public void afectarPersonaje(Personaje p) {
		// tampoco afecta al personaje
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
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
	
}
