package Fabricas;


import Enemigos.Enemigo;
import Enemigos.PiranhaPlant;
import Logica.Nivel;
import Personaje.Personaje;

public class GenerarPiranhaPlant implements GenerarEnemigos{
	
	public PiranhaPlant crearEnemigo(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new PiranhaPlant(sprite, x, y, nivelActual);
	}

	public Enemigo crearEnemigo(Sprite sprite, int x, int y, Personaje p, Nivel nivelActual) {
		return null;
	}

}
