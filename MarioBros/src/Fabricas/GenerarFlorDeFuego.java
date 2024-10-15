package Fabricas;

import PowerUps.FlorDeFuego;

public class GenerarFlorDeFuego implements GenerarPowerUps{
	
	public FlorDeFuego crearPowerUp(Sprite sprite, int x, int y) {
		return new FlorDeFuego(sprite, x, y);
	}
}
