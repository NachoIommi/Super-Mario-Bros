package Fabricas;

import Enemigos.BuzzyBeetle;
import Enemigos.Enemigo;
import Logica.Nivel;
import Personaje.Personaje;

public class GenerarBuzzyBeetle implements GenerarEnemigos{
	
	public BuzzyBeetle crearEnemigo(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new BuzzyBeetle(sprite, x, y, nivelActual);
	}

	@Override
	public Enemigo crearEnemigo(Sprite sprite, int x, int y, Personaje p, Nivel nivelActual) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
