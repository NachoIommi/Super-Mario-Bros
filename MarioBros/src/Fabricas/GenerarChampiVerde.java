package Fabricas;

import Logica.Nivel;
import PowerUps.ChampiVerde;

public class GenerarChampiVerde implements GenerarPowerUps{
	
	public ChampiVerde crearPowerUp(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new ChampiVerde(sprite, x, y, nivelActual);
	}
	
}
