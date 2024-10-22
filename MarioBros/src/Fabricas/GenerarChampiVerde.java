package Fabricas;

import PowerUps.ChampiVerde;

public class GenerarChampiVerde implements GenerarPowerUps{
	
	public ChampiVerde crearPowerUp(Sprite sprite, int x, int y) {
		return new ChampiVerde(sprite, x, y);
	}
	
}
