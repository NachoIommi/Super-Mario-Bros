package Enemigos;

import Fabricas.Sprite;
import Logica.Visitor;

public class Lakitu extends Enemigo{
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	
	public Lakitu(Sprite sprite, int x, int y) {
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
		
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	
	public void morir() {
		
	}

}
