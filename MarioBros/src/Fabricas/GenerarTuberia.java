package Fabricas;

import Enemigos.PiranhaPlant;
import Plataformas.Plataforma;
import Plataformas.Tuberia;

public class GenerarTuberia implements GenerarPlataformas{
	
	public Tuberia crearPlataforma(int x, int y,PiranhaPlant p) {
		return new Tuberia(x,y,p);
	}

	
	public Plataforma crearPlataforma(Sprite sprite, int x, int y) {
		return new Tuberia(sprite, x, y);
	}

	
}
