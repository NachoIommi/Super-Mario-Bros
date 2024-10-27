package Fabricas;

import Enemigos.*;
import Personaje.Personaje;

public interface GenerarEnemigos extends GeneradorDeEntidades{
	
	public Enemigo crearEnemigo(Sprite sprite, int x, int y);
	//public Enemigo crearEnemigo(Sprite sprite, int x, int y, Personaje p);
	
	
}

