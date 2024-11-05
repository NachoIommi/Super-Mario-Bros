package Fabricas;

import Enemigos.Enemigo;
import Logica.Nivel;
import Plataformas.Plataforma;
import Plataformas.Vacio;
import PowerUps.PowerUp;

public class GenerarVacio implements GenerarPlataformas {
	
	public Vacio crearPlataforma(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new Vacio(sprite, x, y, nivelActual);
	}

	public Plataforma crearPlataforma(Sprite s, int x, int y, PowerUp p, int i, Nivel nivelActual) {
		return null;
	}

	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo p, Nivel nivelActual) {
		return null;
	}
	
}
