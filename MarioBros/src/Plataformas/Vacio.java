package Plataformas;
import Logica.*;
import Enemigos.*;
import Fabricas.Sprite;

import Logica.Visitor;

public class Vacio extends Plataforma {
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	
	public Vacio(Sprite sprite, int x,int y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
	}


	public void aceptarVisita(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	public void cargarSprite(Sprite s) {
		// TODO Auto-generated method stub
		
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
