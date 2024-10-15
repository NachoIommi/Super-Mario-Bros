package Fabricas;

import PowerUps.PowerUps;

public interface GenerarPowerUps extends GeneradorDeEntidades{
	
	public PowerUps crearPowerUp(Sprite sprite, int x, int y);
}
