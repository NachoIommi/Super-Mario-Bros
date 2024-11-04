package Fabricas;

import Logica.Nivel;
import PowerUps.FlorDeFuego;

public class GenerarFlorDeFuego implements GenerarPowerUps{
	
	public FlorDeFuego crearPowerUp(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new FlorDeFuego(sprite, x, y, nivelActual);
	}

}
