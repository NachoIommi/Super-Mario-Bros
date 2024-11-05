package Fabricas;

import Enemigos.Enemigo;
import Logica.Nivel;
import Plataformas.LadrilloSolido;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class GenerarLadrilloSolido implements GenerarPlataformas {
	
	public LadrilloSolido crearPlataforma(Sprite sprite, int x, int y, Nivel nivelActual) {
		return new LadrilloSolido(sprite, x, y, nivelActual);
	}

	public Plataforma crearPlataforma(Sprite s, int x, int y, PowerUp p, int i, Nivel nivelActual) {
		return null;
	}

	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo p, Nivel nivelActual) {
		return null;
	}
	
}
