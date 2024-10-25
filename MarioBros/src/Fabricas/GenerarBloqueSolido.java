package Fabricas;

import Plataformas.BloqueSolido;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public class GenerarBloqueSolido implements GenerarPlataformas {
	
	public BloqueSolido crearPlataforma(Sprite sprite, int x, int y) {
		return new BloqueSolido(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, PowerUps p, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
