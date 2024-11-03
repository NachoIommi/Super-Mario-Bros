package Fabricas;

import Enemigos.Enemigo;
import Plataformas.BloqueSolido;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class GenerarBloqueSolido implements GenerarPlataformas {
	
	public BloqueSolido crearPlataforma(Sprite sprite, int x, int y) {
		return new BloqueSolido(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, PowerUp p, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo p) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
