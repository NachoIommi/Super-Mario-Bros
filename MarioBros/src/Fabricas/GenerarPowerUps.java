package Fabricas;

import PowerUps.PowerUp;

public interface GenerarPowerUps extends GeneradorDeEntidades{
	
	public PowerUp crearPowerUp(Sprite sprite, int x, int y);
	
}
