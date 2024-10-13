package Fabricas;

import Enemigos.Enemigo;

public interface GenerarEnemigos extends GeneradorDeEntidades{
	public Enemigo crearEnemeigo(int x, int y);
}
