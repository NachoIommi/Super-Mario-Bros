package Fabricas;

import Enemigos.*;

public class GenerarSpiny implements GenerarEnemigos {
	
	public Spiny crearEnemigo(Sprite sprite, int x, int y) {
		return new Spiny(sprite, x, y);
	}


	

}
