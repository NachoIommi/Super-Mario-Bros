package Fabricas;

import Logica.BolaDeFuego;
import Logica.Nivel;

public class GenerarBolaDeFuego implements GeneradorDeEntidades{
	
	public BolaDeFuego crearBolaDeFuego(Sprite sprite, int x, int y, Nivel nivelActual,int direc) {
		return new BolaDeFuego(sprite, x, y, nivelActual,direc);
	}
	
}
