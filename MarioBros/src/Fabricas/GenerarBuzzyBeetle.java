package Fabricas;

import Enemigos.BuzzyBeetle;

public class GenerarBuzzyBeetle implements GenerarEnemigos{
	
	public BuzzyBeetle crearEnemigo(Sprite sprite, int x, int y) {
		return new BuzzyBeetle(sprite, x, y);
	}
	
}
