package Fabricas;

import PowerUps.Estrella;

public class GenerarEstrella implements GenerarPowerUps{
	
	public Estrella crearPowerUp(Sprite sprite, int x, int y) {
		return new Estrella(sprite, x, y);
	}

}
