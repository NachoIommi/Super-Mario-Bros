package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class PiranhaPlant extends Enemigo{
	
	private EstadosDePiranhaPlant estadoActual;
	protected Sprite sprite;
	protected Hitbox hitb;
	protected int x;
	protected int y;
	
	public PiranhaPlant(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30, 30);
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
	public void setPosX(int x) {
	    this.x = x;
	    hitb.actualizar((int) x, (int) y);  // Actualizar la hitbox después de ajustar la posición
	}

	public void setPosY(int y) {
	    this.y = y;
	    hitb.actualizar((int) x, (int) y);  // Actualizar la hitbox después de ajustar la posición
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarPiranhaPlant(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	
	public void afectarPersonaje(Personaje p) {
		p.setPuntuacion(-30);
		p.morir();
	}
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(30);
		morir();
	}
	
	public void morir() {
		
	}
	
	public void setEstadoActual(EstadosDePiranhaPlant e) {
		
	}

	public Hitbox getHitbox() {
		return hitb;
	}
	
}
