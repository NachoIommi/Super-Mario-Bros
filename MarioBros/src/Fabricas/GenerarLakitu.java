package Fabricas;

import Enemigos.Lakitu;
import Personaje.Personaje;

public class GenerarLakitu implements GenerarEnemigos{
	
	public Lakitu crearEnemigo(Sprite sprite, int x, int y) {
		return new Lakitu(sprite, x, y);
	}
	
	public Lakitu crearEnemigo(Sprite sprite, int x, int y, Personaje p) {
		return new Lakitu(sprite, x, y, p);
	}

}
