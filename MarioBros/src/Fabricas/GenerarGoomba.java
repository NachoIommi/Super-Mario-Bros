package Fabricas;

import Enemigos.Goomba;

public class GenerarGoomba implements GenerarEnemigos{
	
	public Goomba crearEnemigo(Sprite sprite, int x, int y) {
		return new Goomba(sprite, x, y);
	}
	
}
