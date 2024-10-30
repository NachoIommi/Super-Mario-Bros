package Fabricas;

import Enemigos.Enemigo;
import Enemigos.PiranhaPlant;
import Plataformas.Plataforma;
import Plataformas.Tuberia;
import PowerUps.PowerUps;

public class GenerarTuberia implements GenerarPlataformas{
	

	public Plataforma crearPlataforma(Sprite sprite, int x, int y) {
		return new Tuberia(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, PowerUps p, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo e) {
		return new Tuberia(s, x, y,(PiranhaPlant) e);
	}

	
}
