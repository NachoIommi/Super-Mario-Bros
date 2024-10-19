package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class BuzzyBeetle extends Enemigo{
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	protected Hitbox hitb;
	
	public BuzzyBeetle(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
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
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarBuzzyBeetle(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	public void afectarPersonaje(Personaje p) {
		p.setPuntuacion(-15);
		p.morir();
	}
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(30);
		morir();
	}
	public void morir() {
		
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}

}
