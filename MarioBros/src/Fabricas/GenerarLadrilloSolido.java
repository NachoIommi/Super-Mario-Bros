package Fabricas;

import Plataformas.LadrilloSolido;

public class GenerarLadrilloSolido implements GenerarPlataformas {
	
	public LadrilloSolido crearPlataforma(int x, int y) {
		return new LadrilloSolido();
	}
}
