package Fabricas;

import Enemigos.*;

public class GenerarSpiny implements GenerarEnemigos {
	
	public Spiny crearEnemigo(int x, int y) {
		return new Spiny(x,y);
	}


	

}
