package Enemigos;

import Fabricas.Sprite;
import Logica.Visitor;

public class BuzzyBeetle extends Enemigo{
	protected int x;
	protected int y;
	public BuzzyBeetle(int x,int y) {
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


	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
}
