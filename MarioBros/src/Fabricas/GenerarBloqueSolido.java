package Fabricas;

import Plataformas.BloqueSolido;

public class GenerarBloqueSolido implements GenerarPlataformas {
	
	public BloqueSolido crearPlataforma(Sprite sprite, int x, int y) {
		return new BloqueSolido(sprite, x, y);
	}
	
}
