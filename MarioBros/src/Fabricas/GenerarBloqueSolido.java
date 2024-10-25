package Fabricas;

import Enemigos.PiranhaPlant;
import Plataformas.BloqueSolido;
import Plataformas.Plataforma;

public class GenerarBloqueSolido implements GenerarPlataformas {
	
	public BloqueSolido crearPlataforma(Sprite sprite, int x, int y) {
		return new BloqueSolido(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite tuberia, int posX, int posY, PiranhaPlant p) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
