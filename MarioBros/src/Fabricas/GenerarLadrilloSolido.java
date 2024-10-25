package Fabricas;

import Plataformas.LadrilloSolido;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public class GenerarLadrilloSolido implements GenerarPlataformas {
	
	public LadrilloSolido crearPlataforma(Sprite sprite, int x, int y) {
		return new LadrilloSolido(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, PowerUps p, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
