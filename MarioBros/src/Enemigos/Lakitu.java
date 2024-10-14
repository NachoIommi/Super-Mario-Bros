package Enemigos;

import Fabricas.Sprite;
import Logica.Visitor;

public class Lakitu extends Enemigo{
	protected int x;
	protected int y;
	public Lakitu(int x,int y) {
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
