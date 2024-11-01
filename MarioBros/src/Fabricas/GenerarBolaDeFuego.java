package Fabricas;

import Logica.BolaDeFuego;

public class GenerarBolaDeFuego implements GeneradorDeEntidades{
	
	public BolaDeFuego crearBolaDeFuego(Sprite sprite, int x, int y) {
		return new BolaDeFuego(sprite, x, y);
	}
	
}
