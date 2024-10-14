package Enemigos;

import Fabricas.Sprite;
import Logica.Visitor;

public class Goomba extends Enemigo{
	
	protected int x;
	protected int y;
	
	public Goomba(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	
	public void morir() {
		
	}

	public Sprite getSprite() {
		return null;
	}
	
}

