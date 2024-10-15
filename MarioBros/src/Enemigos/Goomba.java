package Enemigos;

import Fabricas.Sprite;
import Logica.Visitor;

public class Goomba extends Enemigo{
	
	protected int x;
	protected int y;
	protected Sprite sprite;
	
	public Goomba(Sprite sprite,int x,int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		System.out.println("la ruta del sprite de goomba es: "+sprite.getRutaImagen());
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void morir() {
		
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

