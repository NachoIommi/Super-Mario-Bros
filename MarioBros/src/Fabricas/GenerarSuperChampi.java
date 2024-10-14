package Fabricas;

import PowerUps.SuperChampi;

public class GenerarSuperChampi implements GenerarPowerUps{
	
	public SuperChampi crearPowerUp(int x, int y) {
		return new SuperChampi(x,y);
	}
}
