package Fabricas;

import Enemigos.Goomba;

public class GenerarGoomba implements GenerarEnemigos{
	
	protected Sprite sprite;
	
	public Goomba crearEnemigo(Sprite sprite, int x, int y) {
		this.sprite = sprite;
		Goomba goomba = new Goomba(sprite, x, y);
		return goomba;
	}
}
