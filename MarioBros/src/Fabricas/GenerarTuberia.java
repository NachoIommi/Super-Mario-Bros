package Fabricas;

import Enemigos.Enemigo;
import Enemigos.PiranhaPlant;
import Logica.Nivel;
import Plataformas.Plataforma;
import Plataformas.Tuberia;
import PowerUps.PowerUp;

public class GenerarTuberia implements GenerarPlataformas{
	

	public Plataforma crearPlataforma(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new Tuberia(sprite, x, y, nivelActual);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, PowerUp p, int i, Nivel nivelActual) {
		// TODO Auto-generated method stub
		return null;
	}

	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo e, Nivel nivelActual) {
		return new Tuberia(s, x, y,(PiranhaPlant) e, nivelActual);
	}

	
}
