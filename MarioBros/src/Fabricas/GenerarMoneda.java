package Fabricas;

import PowerUps.Moneda;

public class GenerarMoneda implements GenerarPowerUps{
	
	public Moneda crearPowerUp(Sprite sprite, int x, int y) {
		return new Moneda(sprite, x, y);
	}

}
