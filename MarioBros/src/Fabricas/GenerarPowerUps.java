package Fabricas;

import Logica.Nivel;
import PowerUps.PowerUp;

public interface GenerarPowerUps extends GeneradorDeEntidades{
	
	public PowerUp crearPowerUp(Sprite sprite, int x, int y, Nivel nivelActual);
	
}
