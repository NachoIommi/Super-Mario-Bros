package Fabricas;

import PowerUps.Moneda;

public class GenerarMoneda implements GenerarPowerUps{
	
	public Moneda crearPowerUp(int x, int y) {
		return new Moneda(x,y);
	}

}
