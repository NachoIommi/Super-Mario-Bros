package Fabricas;

import Personaje.BolaDeFuego;

public class GenerarBolaDeFuego implements GeneradorDeEntidades{
	
	public BolaDeFuego crearBolaDeFuego(int x,int y) {
		return new BolaDeFuego(x,y);
	}
}
