package Fabricas;

import Enemigos.Lakitu;
import Logica.Nivel;
import Personaje.Personaje;

public class GenerarLakitu implements GenerarEnemigos{
	
	public Lakitu crearEnemigo(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new Lakitu(sprite, x, y, nivelActual);
	}
	
	public Lakitu crearEnemigo(Sprite sprite, int x, int y, Personaje p, Nivel nivelActual) {
		return new Lakitu(sprite, x, y, p, nivelActual);
	}

}
