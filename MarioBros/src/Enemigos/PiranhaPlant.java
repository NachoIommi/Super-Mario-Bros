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
	
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		
	}
	
	public void cargarSprite(Sprite s) {
	}
	
	public void morir() {
		
	}
	
	public EstadosDePiranhaPlant getEstadoActual() {
		return estadoActual;
	}
	
	public void setEstadoActual(EstadosDePiranhaPlant e) {
		
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
}
