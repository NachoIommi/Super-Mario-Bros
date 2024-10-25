package Fabricas;


import Enemigos.PiranhaPlant;

public class GenerarPiranhaPlant implements GenerarEnemigos{
	
	public PiranhaPlant crearEnemigo(Sprite sprite, int x, int y) {
		return new PiranhaPlant(sprite, x, y);
	}

}
