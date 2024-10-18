package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class PiranhaPlant extends Enemigo{
	
	private EstadosDePiranhaPlant estadoActual;
	protected int x;
	protected int y;
	protected Sprite sprite;
	protected Hitbox hitb;
	
	public PiranhaPlant(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public EstadosDePiranhaPlant getEstadoActual() {
		return estadoActual;
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
		v.visitarPiranhaPlant(this);
	}
	public void cargarSprite(Sprite s) {
		
	}
	public void afectarPersonaje(Personaje p) {
		
	}
	public void morir() {
		
	}
	public void setEstadoActual(EstadosDePiranhaPlant e) {
		
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}
}
