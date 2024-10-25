package Fabricas;

import Enemigos.KoopaTroopa;

public class GenerarKoopaTroopa implements GenerarEnemigos{
	
	public KoopaTroopa crearEnemigo(Sprite sprite, int x, int y) {
		return new KoopaTroopa(sprite, x, y);
	}

}
