package Fabricas;

import Plataformas.BloqueSolido;

public class GenerarBloqueSolido implements GenerarPlataformas {
	
	public BloqueSolido crearPlataforma(int x,int y) {
		return new BloqueSolido(x, y);
	}
}
