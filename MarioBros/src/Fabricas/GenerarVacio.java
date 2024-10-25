package Fabricas;

import Enemigos.PiranhaPlant;
import Plataformas.Plataforma;
import Plataformas.Vacio;

public class GenerarVacio implements GenerarPlataformas {
	
	public Vacio crearPlataforma(Sprite sprite, int x, int y) {
		return new Vacio(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite tuberia, int posX, int posY, PiranhaPlant p) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
