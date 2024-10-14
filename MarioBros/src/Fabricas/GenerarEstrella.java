package Fabricas;

import PowerUps.Estrella;

public class GenerarEstrella implements GenerarPowerUps{
	
	public Estrella crearPowerUp(int x, int y) {
		return new Estrella(x,y);
	}
}
