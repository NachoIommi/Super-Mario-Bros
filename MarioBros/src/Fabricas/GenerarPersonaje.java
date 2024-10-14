package Fabricas;

import Personaje.Personaje;

public class GenerarPersonaje implements GeneradorDeEntidades{
	
	protected GenerarSprite generarSprite;
	
	public GenerarPersonaje() {
		this.generarSprite = new GenerarSpriteOriginal();
	}
	
	public Personaje crearPersonaje(int x, int y) {
		Sprite spritePersonaje = generarSprite.getPersonaje();
		Personaje personaje = new Personaje(spritePersonaje,x,y);
		return personaje;
	}
}
