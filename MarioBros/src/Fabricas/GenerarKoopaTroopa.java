package Fabricas;

import Enemigos.Enemigo;
import Enemigos.KoopaTroopa;
import Logica.Nivel;
import Personaje.Personaje;

public class GenerarKoopaTroopa implements GenerarEnemigos{
	
	public KoopaTroopa crearEnemigo(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new KoopaTroopa(sprite, x, y, nivelActual);
	}

	public Enemigo crearEnemigo(Sprite sprite, int x, int y, Personaje p, Nivel nivelActual) {
		return null;
	}

}
