package Fabricas;

import Enemigos.PiranhaPlant;
import Logica.Entidad;
import Plataformas.Plataforma;
import Plataformas.Tuberia;

public class GenerarTuberia implements GenerarPlataformas{
	
	public Plataforma crearPlataforma(Sprite sprite, int x, int y,PiranhaPlant p) {
		return new Tuberia(sprite, x, y, p);
	}

	public Plataforma crearPlataforma(Sprite s, int x, int y) {
		return new Tuberia(s,x,y);
	}


}
