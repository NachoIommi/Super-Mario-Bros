package Fabricas;

import Personaje.Personaje;

public class GenerarPersonaje implements GeneradorDeEntidades{

	public Personaje crearPersonaje(Sprite sprite,int x, int y) {
		return new Personaje(sprite,x,y);
	}
	
}
