package Fabricas;

import Plataformas.BloqueDePregunta;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public class GenerarBloqueDePreguntas implements GenerarPlataformas{
	
	public BloqueDePregunta crearPlataforma(Sprite sprite, int x, int y , PowerUps p){
		return new BloqueDePregunta(sprite, x, y,p);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
