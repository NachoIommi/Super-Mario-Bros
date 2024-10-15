package Fabricas;

import Enemigos.Lakitu;

public class GenerarLakitu implements GenerarEnemigos{
	
	public Lakitu crearEnemigo(Sprite sprite, int x, int y) {
		return new Lakitu(sprite, x, y);
	}

}
