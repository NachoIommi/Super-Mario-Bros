package Fabricas;

import Enemigos.BuzzyBeetle;

public class GenerarBuzzyBeetle implements GenerarEnemigos{
	
	public BuzzyBeetle crearEnemigo(int x, int y) {
		return new BuzzyBeetle(x,y);
	}
}
