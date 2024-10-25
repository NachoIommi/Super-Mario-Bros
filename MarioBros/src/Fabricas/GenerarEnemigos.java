package Fabricas;

import Enemigos.*;

public interface GenerarEnemigos extends GeneradorDeEntidades{
	
	public Enemigo crearEnemigo(Sprite sprite, int x, int y);
	public PiranhaPlant crearPiranha(Sprite sprite, int x, int y);
	
}
