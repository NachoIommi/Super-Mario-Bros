package Fabricas;

import PowerUps.FlorDeFuego;

public class GenerarFlorDeFuego implements GenerarPowerUps{
	
	public FlorDeFuego crearPowerUp(int x, int y) {
		return new FlorDeFuego(x,y);
	}
}
