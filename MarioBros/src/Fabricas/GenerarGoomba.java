package Fabricas;

import Enemigos.Goomba;

public class GenerarGoomba implements GenerarEnemigos{
	
	public Goomba crearEnemigo(int x, int y) {
		return new Goomba();
	}
}
