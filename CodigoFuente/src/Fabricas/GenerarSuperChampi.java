package Fabricas;

import Logica.Nivel;
import PowerUps.SuperChampi;

public class GenerarSuperChampi implements GenerarPowerUps{
	
	public SuperChampi crearPowerUp(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new SuperChampi(sprite, x, y, nivelActual);
	}
	
}
