package Fabricas;

import PowerUps.PowerUp;
import Logica.Nivel;
import PowerUps.Estrella;

public class GenerarEstrella implements GenerarPowerUps{

	public PowerUp crearPowerUp(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new Estrella(sprite, x, y, nivelActual);
	}
	
	public Estrella crearPowerUps(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new Estrella(sprite, x, y, nivelActual);
	}
	
	

}
