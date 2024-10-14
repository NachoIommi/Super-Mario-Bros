package Fabricas;

import Personaje.Personaje;

public class GenerarPersonaje implements GeneradorDeEntidades{
	
	protected Sprite spritePersonaje;
	
	public Personaje crearPersonaje(Sprite s,int x, int y) {
		spritePersonaje = s;
		Personaje personaje = new Personaje(spritePersonaje,x,y);
		return personaje;
	}
}
