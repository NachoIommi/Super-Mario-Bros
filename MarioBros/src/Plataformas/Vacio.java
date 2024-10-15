package Plataformas;
import Logica.*;
import Enemigos.*;
import Fabricas.Sprite;

import Logica.Visitor;

public class Vacio extends Plataforma {
	
	protected Sprite sprite;
	
	public Vacio(Sprite sprite, int x,int y) {
		this.sprite = sprite;
	}


	public void aceptarVisita(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	public void cargarSprite(Sprite s) {
		// TODO Auto-generated method stub
		
	}

	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
