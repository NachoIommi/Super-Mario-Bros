package Fabricas;

import Enemigos.Enemigo;
import Logica.Nivel;
import Plataformas.BloqueDePregunta;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class GenerarBloqueDePreguntas implements GenerarPlataformas{
	
	public BloqueDePregunta crearPlataforma(Sprite sprite, int x, int y , PowerUp p,int i, Nivel nivelActual){
		return new BloqueDePregunta(sprite, x, y,p,i, nivelActual);
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, Nivel nivelActual) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo p, Nivel nivelActual) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
