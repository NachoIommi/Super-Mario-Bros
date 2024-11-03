package Fabricas;

import Enemigos.*;
import Logica.Nivel;
import Personaje.Personaje;

public interface GenerarEnemigos extends GeneradorDeEntidades{
	
	public Enemigo crearEnemigo(Sprite sprite, int x, int y, Nivel nivelActual);
	public Enemigo crearEnemigo(Sprite sprite, int x, int y, Personaje p, Nivel nivelActual);
	
	
}

