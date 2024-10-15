package Enemigos;

import Fabricas.Sprite;
import Logica.Visitor;

public class Lakitu extends Enemigo{
	
	protected int x;
	protected int y;
	protected Sprite sprite;
	
	public Lakitu(Sprite sprite, int x, int y) {
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

	public Sprite getSprite() {
		return sprite;
	}
}
