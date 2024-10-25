package Fabricas;

import Enemigos.PiranhaPlant;
import Plataformas.LadrilloSolido;
import Plataformas.Plataforma;

public class GenerarLadrilloSolido implements GenerarPlataformas {
	
	public LadrilloSolido crearPlataforma(Sprite sprite, int x, int y) {
		return new LadrilloSolido(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite tuberia, int posX, int posY, PiranhaPlant p) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
