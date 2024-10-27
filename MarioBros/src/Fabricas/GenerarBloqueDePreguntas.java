package Fabricas;

import Enemigos.Enemigo;
import Plataformas.BloqueDePregunta;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public class GenerarBloqueDePreguntas implements GenerarPlataformas{
	
	public BloqueDePregunta crearPlataforma(Sprite sprite, int x, int y , PowerUps p,int i){
		return new BloqueDePregunta(sprite, x, y,p,i);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo e,int reloj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
