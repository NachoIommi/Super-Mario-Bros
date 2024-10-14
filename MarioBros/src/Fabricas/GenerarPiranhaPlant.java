package Fabricas;


import Enemigos.PiranhaPlant;

public class GenerarPiranhaPlant implements GenerarEnemigos{
	
	public PiranhaPlant crearEnemigo(int x, int y) {
		return new PiranhaPlant(x,y);
	}

}
