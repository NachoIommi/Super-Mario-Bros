package Fabricas;

import Enemigos.BuzzyBeetle;
import Enemigos.PiranhaPlant;

public class GenerarBuzzyBeetle implements GenerarEnemigos{
	
	public BuzzyBeetle crearEnemigo(Sprite sprite, int x, int y) {
		return new BuzzyBeetle(sprite, x, y);
	}

	@Override
	public PiranhaPlant crearPiranha(Sprite sprite, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
