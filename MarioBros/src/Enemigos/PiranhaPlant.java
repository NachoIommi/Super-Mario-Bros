package Enemigos;

import Fabricas.Sprite;
import Logica.Visitor;

public class PiranhaPlant extends Enemigo{
	
	private EstadosDePiranhaPlant estadoActual;
	protected int x;
	protected int y;
	protected Sprite sprite;
	
	public PiranhaPlant(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	// :: getters y setter ::
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
	
	// :: Comandos ::
	public void aceptarVisita(Visitor v) {
		
	}
	
	public void cargarSprite(Sprite s) {
	}
	
	public void morir() {
		
	}

	public void setEstadoActual(EstadosDePiranhaPlant e) {
		
	}

}
