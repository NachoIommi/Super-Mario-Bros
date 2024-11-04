package Fabricas;

import Logica.Nivel;
import PowerUps.Moneda;

public class GenerarMoneda implements GenerarPowerUps{
	
	public Moneda crearPowerUp(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new Moneda(sprite, x, y, nivelActual);
	}

}
