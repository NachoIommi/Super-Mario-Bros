package Fabricas;

import Enemigos.Enemigo;
import Enemigos.Goomba;
import Logica.Nivel;
import Personaje.Personaje;

public class GenerarGoomba implements GenerarEnemigos{
	
	public Goomba crearEnemigo(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new Goomba(sprite, x, y, nivelActual);
	}

	public Enemigo crearEnemigo(Sprite sprite, int x, int y, Personaje p, Nivel nivelActual) {
		return null;
	}
	
}
