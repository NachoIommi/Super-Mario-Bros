package Fabricas;

import Enemigos.Enemigo;
import Plataformas.Plataforma;
import Plataformas.Vacio;
import PowerUps.PowerUps;

public class GenerarVacio implements GenerarPlataformas {
	
	public Vacio crearPlataforma(Sprite sprite, int x, int y) {
		return new Vacio(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, PowerUps p, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo p) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
