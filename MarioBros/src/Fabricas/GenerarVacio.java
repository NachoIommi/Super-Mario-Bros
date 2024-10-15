package Fabricas;

import Plataformas.Vacio;

public class GenerarVacio implements GenerarPlataformas {
	
	public Vacio crearPlataforma(Sprite sprite, int x, int y) {
		return new Vacio(sprite, x, y);
	}
	
}
