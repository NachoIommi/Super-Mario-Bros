package Fabricas;

import Enemigos.Goomba;
import Enemigos.PiranhaPlant;

public class GenerarGoomba implements GenerarEnemigos{
	
	public Goomba crearEnemigo(Sprite sprite, int x, int y) {
		return new Goomba(sprite, x, y);
	}

	@Override
	public PiranhaPlant crearPiranha(Sprite sprite, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
