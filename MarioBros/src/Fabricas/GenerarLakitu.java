package Fabricas;

import Enemigos.Lakitu;

public class GenerarLakitu implements GenerarEnemigos{
	
	public Lakitu crearEnemigo(int x, int y) {
		return new Lakitu();
	}

}
