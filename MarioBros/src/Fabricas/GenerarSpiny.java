package Fabricas;

import Enemigos.*;
import Logica.Nivel;
import Personaje.Personaje;

public class GenerarSpiny implements GenerarEnemigos {
	
	public Spiny crearEnemigo(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new Spiny(sprite, x, y, nivelActual);
	}

	@Override
	public Enemigo crearEnemigo(Sprite sprite, int x, int y, Personaje p, Nivel nivelActual) {
		// TODO Auto-generated method stub
		return null;
	}

}
