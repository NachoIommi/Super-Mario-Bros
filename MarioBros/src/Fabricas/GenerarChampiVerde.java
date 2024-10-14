package Fabricas;

import PowerUps.ChampiVerde;

public class GenerarChampiVerde implements GenerarPowerUps{
	
	public ChampiVerde crearPowerUp(int x, int y) {
		return new ChampiVerde();
	}
}
