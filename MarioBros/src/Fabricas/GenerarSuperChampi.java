package Fabricas;

import PowerUps.SuperChampi;

public class GenerarSuperChampi implements GenerarPowerUps{
	
	public SuperChampi crearPowerUp(Sprite sprite, int x, int y) {
		return new SuperChampi(sprite, x, y);
	}
}
