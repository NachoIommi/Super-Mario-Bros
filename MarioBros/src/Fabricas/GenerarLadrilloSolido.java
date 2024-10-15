package Fabricas;

import Plataformas.LadrilloSolido;

public class GenerarLadrilloSolido implements GenerarPlataformas {
	
	public LadrilloSolido crearPlataforma(Sprite sprite, int x, int y) {
		return new LadrilloSolido(sprite, x, y);
	}
}
