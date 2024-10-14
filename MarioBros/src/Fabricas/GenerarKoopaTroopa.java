package Fabricas;

import Enemigos.KoopaTroopa;

public class GenerarKoopaTroopa implements GenerarEnemigos{
	
	public KoopaTroopa crearEnemigo(int x, int y) {
		return new KoopaTroopa(x,y);
	}

}
