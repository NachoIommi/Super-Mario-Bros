package Fabricas;

import Plataformas.Vacio;

public class GenerarVacio implements GenerarPlataformas {
	
	public Vacio crearPlataforma(int x, int y) {
		return new Vacio(x,y);
	}
}
