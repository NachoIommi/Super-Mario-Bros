package Fabricas;

import Enemigos.KoopaTroopa;
import Enemigos.PiranhaPlant;

public class GenerarKoopaTroopa implements GenerarEnemigos{
	
	public KoopaTroopa crearEnemigo(Sprite sprite, int x, int y) {
		return new KoopaTroopa(sprite, x, y);
	}

	@Override
	public PiranhaPlant crearPiranha(Sprite sprite, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
