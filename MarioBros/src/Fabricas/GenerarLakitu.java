package Fabricas;

import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;

public class GenerarLakitu implements GenerarEnemigos{
	
	public Lakitu crearEnemigo(Sprite sprite, int x, int y) {
		return new Lakitu(sprite, x, y);
	}

	@Override
	public PiranhaPlant crearPiranha(Sprite sprite, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
