package Fabricas;

import Logica.Nivel;
import Personaje.Personaje;

public class GenerarPersonaje implements GeneradorDeEntidades{

	public Personaje crearPersonaje(Sprite sprite,int x, int y, Nivel nivelActual) {
		return new Personaje(sprite, x, y, nivelActual);
	}
	
}
